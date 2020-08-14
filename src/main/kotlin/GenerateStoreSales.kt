import domain.*
import org.apache.hadoop.hbase.TableName
import org.apache.hadoop.hbase.client.Connection
import writer.CustomerWriter
import writer.StoreSalesWriter
import writer.StoreWriter
import java.math.BigDecimal
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class GenerateStoreSales(
    val conn: Connection
) {

    private val random = Random(253)

    fun generate() {
        val tCustomer = conn.getTable(tCTableName)
        val tStore = conn.getTable(tSTableName)
        val tStoreSales = conn.getTable(tSSTableName)

        Store.ALL.forEach { tStore.put(StoreWriter.put(it)) }
        println("Wrote ${Store.ALL.size} stores.")

        val startDate = LocalDate.of(2015, 1, 1)
        val endDate = LocalDate.of(2020, 6, 30)
        val intervalLenDays = 30L
        var currentDateInterval = startDate..startDate.plusDays(intervalLenDays)
        var currentIntervalSales = 10000
        val intervalSalesIncrement = 500
        val intervalSalesRandomness = 2000
        var totalGeneratedSalesCnt = 0

        while (currentDateInterval.endInclusive < endDate) {
            print("Generating %d sales for %s...".format(currentIntervalSales, currentDateInterval))

            val started = Instant.now()
            repeat(currentIntervalSales) {
                val soldAt = currentDateInterval.start.plusDays(random.nextInt(intervalLenDays.toInt()).toLong())
                    .atTime(random.nextInt(24), random.nextInt(60))
                val sale = randomSales(soldAt)
                tStoreSales.put(StoreSalesWriter.put(sale))
                tCustomer.put(CustomerWriter.put(sale.customer))
            }
            val duration = Duration.between(started, Instant.now())
            println(
                "%.1f sales / sec, %s".format(
                    (currentIntervalSales.toDouble() / duration.toMillis()) * 1000.0,
                    duration
                )
            )

            totalGeneratedSalesCnt += currentIntervalSales
            currentIntervalSales += intervalSalesIncrement + (random.nextGaussian() * intervalSalesRandomness).toInt()
            currentDateInterval =
                currentDateInterval.start.plusDays(intervalLenDays)..currentDateInterval.endInclusive.plusDays(
                    intervalLenDays
                )
        }

        tCustomer.close()
        tStore.close()
        tStoreSales.close()

        println("Done, generated $totalGeneratedSalesCnt sales + customers.")
    }

    private var itemNo = 0
    private var customerNo = 0
    private var ticketNo = 423534
    private val taxRate = BigDecimal("1.10")

    private fun randomSales(soldAt: LocalDateTime): StoreSales {
        val itN = ++itemNo
        val ticketN = ++ticketNo
        val item = Item.TEMPLATES[random.nextInt(Item.TEMPLATES.size)].copy(
            sk = itN.toString(),
            id = itN.toString().padStart(16, '0')
        )

        val promotion = if (random.nextDouble() < 0.45) Promotion.ALL[random.nextInt(Promotion.ALL.size)] else null
        val q = maxOf((random.nextGaussian() * 10.0).toInt(), 1)
        val wholeSaleCost = item.wholeSaleCost * q.toBigDecimal()
        val netPaid = item.currentPrice * q.toBigDecimal()

        val customerN = ++customerNo
        val customer = Customer.TEMPLATES[random.nextInt(Customer.TEMPLATES.size)].copy(
            sk = customerN.toString(),
            id = customerN.toString().padStart(16, '0')
        )

        return StoreSales(
            soldAt,
            item, customer, Store.ALL[random.nextInt(Store.ALL.size)], promotion,
            ticketNumber = ticketN.toString(),
            quantity = q,
            wholeSaleCost = wholeSaleCost,
            listPrice = item.currentPrice,
            salesPrice = item.currentPrice,
            extDiscountAmt = null,
            extSalesPrice = null,
            extWholeSaleCost = null,
            extListPrice = null,
            extTax = null,
            couponAmt = null,
            netPaid = netPaid,
            netPaidIncTax = netPaid * taxRate,
            netProfit = netPaid - wholeSaleCost
        )
    }

    companion object {
        val tCTableName = TableName.valueOf("customer")
        val tSTableName = TableName.valueOf("store")
        val tSSTableName = TableName.valueOf("store_sales")
    }

}