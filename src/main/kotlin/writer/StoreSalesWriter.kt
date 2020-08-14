package writer

import domain.StoreSales
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.util.Bytes
import java.time.ZoneOffset

class StoreSalesWriter {

    companion object {
        fun put(storeSales: StoreSales): Put {

            // This code is intentionally left ugly

            val rowKey = Bytes.toBytes("${storeSales.item.sk.reversed()}#${storeSales.ticketNumber}")

            // TODO move column name Bytes.toBytes() to constants
            val put = Put(rowKey)
                    .setTimestamp(storeSales.soldAt.toEpochSecond(ZoneOffset.UTC) * 1000)
                    .addColumn(tSS, Bytes.toBytes("customer_sk"), Bytes.toBytes(storeSales.customer.sk.reversed()))
                    .addColumn(tSS, Bytes.toBytes("store_sk"), Bytes.toBytes(storeSales.store.sk.reversed()))
                    .addColumn(tSS, Bytes.toBytes("quantity"), Bytes.toBytes(storeSales.quantity.toString()))
                    .addColumn(tSS, Bytes.toBytes("quantity"), Bytes.toBytes(storeSales.quantity.toString()))
                    .addColumn(tSS, Bytes.toBytes("wholesale_cost"), Bytes.toBytes(storeSales.wholeSaleCost.toString()))
                    .addColumn(tSS, Bytes.toBytes("list_price"), Bytes.toBytes(storeSales.listPrice.toString()))
                    .addColumn(tSS, Bytes.toBytes("sales_price"), Bytes.toBytes(storeSales.salesPrice.toString()))
                    .addColumn(tSS, Bytes.toBytes("net_paid"), Bytes.toBytes(storeSales.netPaid.toString()))
                    .addColumn(tSS, Bytes.toBytes("net_paid_inc_tax"), Bytes.toBytes(storeSales.netPaidIncTax.toString()))
                    .addColumn(tSS, Bytes.toBytes("net_profit"), Bytes.toBytes(storeSales.netProfit.toString()))

            if (storeSales.extDiscountAmt != null) put.addColumn(tSS, Bytes.toBytes("ext_discount"), Bytes.toBytes(storeSales.extDiscountAmt.toString()))
            if (storeSales.extSalesPrice != null) put.addColumn(tSS, Bytes.toBytes("ext_sales_price"), Bytes.toBytes(storeSales.extSalesPrice.toString()))
            if (storeSales.extWholeSaleCost != null) put.addColumn(tSS, Bytes.toBytes("ext_wholesale_cost"), Bytes.toBytes(storeSales.extWholeSaleCost.toString()))
            if (storeSales.extListPrice != null) put.addColumn(tSS, Bytes.toBytes("ext_list_price"), Bytes.toBytes(storeSales.extListPrice.toString()))
            if (storeSales.extTax != null) put.addColumn(tSS, Bytes.toBytes("ext_tax"), Bytes.toBytes(storeSales.extTax.toString()))
            if (storeSales.couponAmt != null) put.addColumn(tSS, Bytes.toBytes("coupon_amt"), Bytes.toBytes(storeSales.couponAmt.toString()))

            put.addColumn(tI, Bytes.toBytes("item_sk"), Bytes.toBytes(storeSales.item.sk))
            put.addColumn(tI, Bytes.toBytes("item_id"), Bytes.toBytes(storeSales.item.id))
            if (storeSales.item.recStart != null) put.addColumn(tI, Bytes.toBytes("rec_start_date"), Bytes.toBytes(storeSales.item.recStart.toString()))
            if (storeSales.item.recEnd != null) put.addColumn(tI, Bytes.toBytes("rec_end_date"), Bytes.toBytes(storeSales.item.recEnd.toString()))
            put.addColumn(tI, Bytes.toBytes("item_desc"), Bytes.toBytes(storeSales.item.desc))
            put.addColumn(tI, Bytes.toBytes("current_price"), Bytes.toBytes(storeSales.item.currentPrice.toString()))
            put.addColumn(tI, Bytes.toBytes("wholesale_cost"), Bytes.toBytes(storeSales.item.wholeSaleCost.toString()))
            put.addColumn(tI, Bytes.toBytes("brand_id"), Bytes.toBytes(storeSales.item.brandId.toString()))
            put.addColumn(tI, Bytes.toBytes("brand"), Bytes.toBytes(storeSales.item.brand))
            put.addColumn(tI, Bytes.toBytes("class_id"), Bytes.toBytes(storeSales.item.classId.toString()))
            put.addColumn(tI, Bytes.toBytes("class"), Bytes.toBytes(storeSales.item.class_))
            put.addColumn(tI, Bytes.toBytes("category_id"), Bytes.toBytes(storeSales.item.categoryId.toString()))
            put.addColumn(tI, Bytes.toBytes("category"), Bytes.toBytes(storeSales.item.category))
            put.addColumn(tI, Bytes.toBytes("manufact_id"), Bytes.toBytes(storeSales.item.manufactId.toString()))
            put.addColumn(tI, Bytes.toBytes("manufact"), Bytes.toBytes(storeSales.item.manufact))
            put.addColumn(tI, Bytes.toBytes("size"), Bytes.toBytes(storeSales.item.size))
            if (storeSales.item.formulation != null) put.addColumn(tI, Bytes.toBytes("formulation"), Bytes.toBytes(storeSales.item.formulation))
            put.addColumn(tI, Bytes.toBytes("color"), Bytes.toBytes(storeSales.item.color))
            put.addColumn(tI, Bytes.toBytes("units"), Bytes.toBytes(storeSales.item.units))
            put.addColumn(tI, Bytes.toBytes("container"), Bytes.toBytes(storeSales.item.container))
            put.addColumn(tI, Bytes.toBytes("manager_id"), Bytes.toBytes(storeSales.item.managerId.toString()))
            put.addColumn(tI, Bytes.toBytes("product_name"), Bytes.toBytes(storeSales.item.productName))

            put.addColumn(tCD, Bytes.toBytes("demo_sk"), Bytes.toBytes(storeSales.customer.customerDemographics.sk))
            put.addColumn(tCD, Bytes.toBytes("gender"), Bytes.toBytes(storeSales.customer.customerDemographics.gender))
            put.addColumn(tCD, Bytes.toBytes("marital_status"), Bytes.toBytes(storeSales.customer.customerDemographics.maritalStatus))
            put.addColumn(tCD, Bytes.toBytes("education_status"), Bytes.toBytes(storeSales.customer.customerDemographics.educationStatus))
            put.addColumn(tCD, Bytes.toBytes("purchase_estimate"), Bytes.toBytes(storeSales.customer.customerDemographics.purchaseEstimate.toString()))
            put.addColumn(tCD, Bytes.toBytes("credit_rating"), Bytes.toBytes(storeSales.customer.customerDemographics.creditRating))
            put.addColumn(tCD, Bytes.toBytes("dep_count"), Bytes.toBytes(storeSales.customer.customerDemographics.depCnt.toString()))
            put.addColumn(tCD, Bytes.toBytes("dep_employed_count"), Bytes.toBytes(storeSales.customer.customerDemographics.depEmployedCnt.toString()))
            put.addColumn(tCD, Bytes.toBytes("dep_college_count"), Bytes.toBytes(storeSales.customer.customerDemographics.depCollegeCnt.toString()))

            put.addColumn(tHD, Bytes.toBytes("demo_sk"), Bytes.toBytes(storeSales.customer.householdDemographics.sk))
            put.addColumn(tHD, Bytes.toBytes("buy_potential"), Bytes.toBytes(storeSales.customer.householdDemographics.buyPotential))
            put.addColumn(tHD, Bytes.toBytes("dep_count"), Bytes.toBytes(storeSales.customer.householdDemographics.depCnt.toString()))
            put.addColumn(tHD, Bytes.toBytes("vehicle_count"), Bytes.toBytes(storeSales.customer.householdDemographics.vehicleCnt.toString()))

            put.addColumn(tIB, Bytes.toBytes("income_band_sk"), Bytes.toBytes(storeSales.customer.householdDemographics.incomeBand.sk))
            put.addColumn(tIB, Bytes.toBytes("lower_bound"), Bytes.toBytes(storeSales.customer.householdDemographics.incomeBand.lowerBound.toString()))
            put.addColumn(tIB, Bytes.toBytes("upper_bound"), Bytes.toBytes(storeSales.customer.householdDemographics.incomeBand.upperBound.toString()))

            return put
        }

        private val tSS = Bytes.toBytes("ss")
        private val tI = Bytes.toBytes("i")
        private val tCD = Bytes.toBytes("cd")
        private val tHD = Bytes.toBytes("hd")
        private val tIB = Bytes.toBytes("ib")
    }
}