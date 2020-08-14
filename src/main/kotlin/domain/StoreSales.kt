package domain

import java.math.BigDecimal
import java.time.LocalDateTime

data class StoreSales(
    val soldAt: LocalDateTime,
    val item: Item,
    val customer: Customer,
    val store: Store,
    val promotion: Promotion?,
    val ticketNumber: String,
    val quantity: Int,
    val wholeSaleCost: BigDecimal,
    val listPrice: BigDecimal,
    val salesPrice: BigDecimal,
    val extDiscountAmt: BigDecimal?,
    val extSalesPrice: BigDecimal?,
    val extWholeSaleCost: BigDecimal?,
    val extListPrice: BigDecimal?,
    val extTax: BigDecimal?,
    val couponAmt: BigDecimal?,
    val netPaid: BigDecimal,
    val netPaidIncTax: BigDecimal,
    val netProfit: BigDecimal
) {
    init {
        check(ticketNumber.isNotBlank())
    }
}