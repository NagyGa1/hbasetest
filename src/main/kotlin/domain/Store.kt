package domain

import java.math.BigDecimal
import java.time.LocalDate

data class Store(
    val sk: String,
    val id: String,
    val recStart: LocalDate?,
    val recEnd: LocalDate?,
    val closedDate: LocalDate?,
    val storeName: String?,
    val noOfEmployees: Int?,
    val floorSpace: Int?,
    val hours: String?,
    val manager: String?,
    val marketId: Int?,
    val geographyClass: String?,
    val marketDesc: String?,
    val marketManager: String?,
    val divisionId: Int?,
    val divisionName: String?,
    val companyId: Int?,
    val companyName: String?,
    val streetNumber: String?,
    val streetName: String?,
    val streetType: String?,
    val suiteNumner: String?,
    val city: String?,
    val county: String?,
    val state: String?,
    val zip: String?,
    val country: String?,
    val gmtOffset: BigDecimal?,
    val taxPercentage: BigDecimal?
) {
    init {
        check(sk.isNotBlank())
        check(id.length == 16)
    }

    companion object {
        val ALL = listOf(
            Store(
                sk = "S1", id = "S000000000000001",
                recStart = null, recEnd = null, closedDate = null,
                storeName = "Great MegaStore", noOfEmployees = 5, floorSpace = 10, hours = null, manager = null,
                marketId = null, geographyClass = null, marketDesc = null, marketManager = null,
                divisionId = null, divisionName = null, companyId = null, companyName = null,
                streetNumber = null, streetName = null, streetType = null, suiteNumner = null,
                city = null, county = null, state = null, zip = null, country = null,
                gmtOffset = null, taxPercentage = null
            ),
            Store(
                sk = "S2",
                id = "S000000000000002",
                recStart = null,
                recEnd = null,
                closedDate = null,
                storeName = "SuperStore",
                noOfEmployees = 25,
                floorSpace = 100,
                hours = "24/7",
                manager = "Manager John",
                marketId = 1,
                geographyClass = "GEO2",
                marketDesc = "MKT Desc",
                marketManager = "Market Manager John",
                divisionId = 2,
                divisionName = "Major League",
                companyId = 3,
                companyName = "Chip Chuan Pte Ltd",
                streetNumber = "124",
                streetName = "Banderas Street",
                streetType = "Street",
                suiteNumner = "#08-06",
                city = "Singapore",
                county = "East Coast",
                state = "East Coast",
                zip = "45123",
                country = "Singapore",
                gmtOffset = BigDecimal("8.00"),
                taxPercentage = BigDecimal("7.5")
            )
        )
    }
}