package writer

import domain.Customer
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.util.Bytes

class CustomerWriter {

    companion object {

        fun put(customer: Customer): Put {
            val put = Put(Bytes.toBytes(customer.sk.reversed()))

            // TODO move column name Bytes.toBytes() to constants
            put.addColumn(tC, Bytes.toBytes("customer_id"), Bytes.toBytes(customer.id))
            put.addColumn(tC, Bytes.toBytes("first_shipto_date"), Bytes.toBytes(customer.firstShipDate.toString()))
            put.addColumn(tC, Bytes.toBytes("first_stales_date"), Bytes.toBytes(customer.firstSalesDate.toString()))
            put.addColumn(tC, Bytes.toBytes("salutation"), Bytes.toBytes(customer.salutation))
            put.addColumn(tC, Bytes.toBytes("first_name"), Bytes.toBytes(customer.firstName))
            put.addColumn(tC, Bytes.toBytes("last_name"), Bytes.toBytes(customer.lastName))
            put.addColumn(tC, Bytes.toBytes("preferred_cust_flag"), Bytes.toBytes(customer.preferredCustFlag))
            put.addColumn(tC, Bytes.toBytes("birth_date"), Bytes.toBytes(customer.birthDate.toString()))
            put.addColumn(tC, Bytes.toBytes("birth_country"), Bytes.toBytes(customer.birthCountry))
            put.addColumn(tC, Bytes.toBytes("login"), Bytes.toBytes(customer.login))
            put.addColumn(tC, Bytes.toBytes("email_address"), Bytes.toBytes(customer.emailAddress))
            put.addColumn(tC, Bytes.toBytes("last_review_date"), Bytes.toBytes(customer.lastReviewDate.toString()))
            put.addColumn(tCA, Bytes.toBytes("address_sk"), Bytes.toBytes(customer.customerAddress.sk))
            put.addColumn(tCA, Bytes.toBytes("address_id"), Bytes.toBytes(customer.customerAddress.id))
            put.addColumn(tCA, Bytes.toBytes("street_number"), Bytes.toBytes(customer.customerAddress.streetNumber))
            put.addColumn(tCA, Bytes.toBytes("street_name"), Bytes.toBytes(customer.customerAddress.streetName))
            put.addColumn(tCA, Bytes.toBytes("street_type"), Bytes.toBytes(customer.customerAddress.streetType))
            if (customer.customerAddress.suiteNumber != null) put.addColumn(tCA, Bytes.toBytes("suite_number"), Bytes.toBytes(customer.customerAddress.suiteNumber))
            put.addColumn(tCA, Bytes.toBytes("city"), Bytes.toBytes(customer.customerAddress.city))
            if (customer.customerAddress.county != null) put.addColumn(tCA, Bytes.toBytes("county"), Bytes.toBytes(customer.customerAddress.county))
            if (customer.customerAddress.state != null) put.addColumn(tCA, Bytes.toBytes("state"), Bytes.toBytes(customer.customerAddress.state))
            put.addColumn(tCA, Bytes.toBytes("zip"), Bytes.toBytes(customer.customerAddress.zip))
            put.addColumn(tCA, Bytes.toBytes("country"), Bytes.toBytes(customer.customerAddress.country))
            put.addColumn(tCA, Bytes.toBytes("gmt_offset"), Bytes.toBytes(customer.customerAddress.gmtOffset.toString()))
            put.addColumn(tCA, Bytes.toBytes("location_type"), Bytes.toBytes(customer.customerAddress.locationType))

            return put
        }

        private val tC = Bytes.toBytes("c")
        private val tCA = Bytes.toBytes("ca")
    }
}