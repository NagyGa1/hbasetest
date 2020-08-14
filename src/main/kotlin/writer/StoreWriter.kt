package writer

import domain.Store
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.util.Bytes

class StoreWriter {

    companion object {

        fun put(store: Store): Put {
            val put = Put(Bytes.toBytes(store.sk.reversed()))

            // TODO move column name Bytes.toBytes() to constants
            put.addColumn(tS, Bytes.toBytes("store_id"), Bytes.toBytes(store.id))
            if (store.recStart != null) put.addColumn(tS, Bytes.toBytes("rec_start_date"), Bytes.toBytes(store.recStart.toString()))
            if (store.recEnd != null) put.addColumn(tS, Bytes.toBytes("rec_end_date"), Bytes.toBytes(store.recEnd.toString()))
            if (store.closedDate != null) put.addColumn(tS, Bytes.toBytes("closed_date"), Bytes.toBytes(store.closedDate.toString()))
            if (store.storeName != null) put.addColumn(tS, Bytes.toBytes("store_name"), Bytes.toBytes(store.storeName))
            if (store.noOfEmployees != null) put.addColumn(tS, Bytes.toBytes("number_employees"), Bytes.toBytes(store.noOfEmployees.toString()))
            if (store.floorSpace != null) put.addColumn(tS, Bytes.toBytes("floor_space"), Bytes.toBytes(store.floorSpace.toString()))
            if (store.hours != null) put.addColumn(tS, Bytes.toBytes("hours"), Bytes.toBytes(store.hours))
            if (store.manager != null) put.addColumn(tS, Bytes.toBytes("manager"), Bytes.toBytes(store.manager))
            if (store.marketId != null) put.addColumn(tS, Bytes.toBytes("market_id"), Bytes.toBytes(store.marketId.toString()))
            if (store.geographyClass != null) put.addColumn(tS, Bytes.toBytes("geography_class"), Bytes.toBytes(store.geographyClass))
            if (store.marketDesc != null) put.addColumn(tS, Bytes.toBytes("market_desc"), Bytes.toBytes(store.marketDesc))
            if (store.marketManager != null) put.addColumn(tS, Bytes.toBytes("market_manager"), Bytes.toBytes(store.marketManager))
            if (store.divisionId != null) put.addColumn(tS, Bytes.toBytes("division_id"), Bytes.toBytes(store.divisionId.toString()))
            if (store.divisionName != null) put.addColumn(tS, Bytes.toBytes("division_name"), Bytes.toBytes(store.divisionName))
            if (store.companyId != null) put.addColumn(tS, Bytes.toBytes("company_id"), Bytes.toBytes(store.companyId.toString()))
            if (store.companyName != null) put.addColumn(tS, Bytes.toBytes("company_name"), Bytes.toBytes(store.companyName))
            if (store.streetNumber != null) put.addColumn(tS, Bytes.toBytes("street_number"), Bytes.toBytes(store.streetNumber))
            if (store.streetName != null) put.addColumn(tS, Bytes.toBytes("street_name"), Bytes.toBytes(store.streetName))
            if (store.streetType != null) put.addColumn(tS, Bytes.toBytes("street_type"), Bytes.toBytes(store.streetType))
            if (store.suiteNumner != null) put.addColumn(tS, Bytes.toBytes("suite_number"), Bytes.toBytes(store.suiteNumner))
            if (store.city != null) put.addColumn(tS, Bytes.toBytes("city"), Bytes.toBytes(store.city))
            if (store.county != null) put.addColumn(tS, Bytes.toBytes("county"), Bytes.toBytes(store.county))
            if (store.state != null) put.addColumn(tS, Bytes.toBytes("state"), Bytes.toBytes(store.state))
            if (store.zip != null) put.addColumn(tS, Bytes.toBytes("zip"), Bytes.toBytes(store.zip))
            if (store.country != null) put.addColumn(tS, Bytes.toBytes("country"), Bytes.toBytes(store.country))
            if (store.gmtOffset != null) put.addColumn(tS, Bytes.toBytes("gmt_offset"), Bytes.toBytes(store.gmtOffset.toString()))
            if (store.taxPercentage != null) put.addColumn(tS, Bytes.toBytes("tax_percentage"), Bytes.toBytes(store.taxPercentage.toString()))

            return put
        }

        private val tS = Bytes.toBytes("s")

    }

}