package domain

import java.math.BigDecimal
import java.time.LocalDate

data class Customer(
    val sk: String,
    val id: String,
    val customerDemographics: CustomerDemographics,
    val householdDemographics: HouseholdDemographics,
    val customerAddress: CustomerAddress,
    val firstShipDate: LocalDate,
    val firstSalesDate: LocalDate,
    val salutation: String,
    val firstName: String,
    val lastName: String,
    val preferredCustFlag: String,
    val birthDate: LocalDate,
    val birthCountry: String,
    val login: String,
    val emailAddress: String,
    val lastReviewDate: LocalDate
) {
    init {
        check(sk.isNotBlank())
        check(id.length == 16)
        check(salutation.length <= 10) // enforcing varchar, ignoring char specs
        check(firstName.length <= 20)
        check(lastName.length <= 30)
        check(preferredCustFlag == "Y" || preferredCustFlag == "N")
        check(birthCountry.length <= 20)
        check(login.length <= 13)
        check(emailAddress.length <= 50)
    }

    companion object {
        val TEMPLATES = listOf(
            Customer("TOBEREPLACED", "0000000000000000",
                CustomerDemographics("CD1", "M", "M", "BSc", 5000, "C-", depCnt = 2, depEmployedCnt = 0, depCollegeCnt = 0),
                HouseholdDemographics("HD1", IncomeBand("IB1", 0, 25000), buyPotential = "Low", depCnt = 2, vehicleCnt = 1),
                CustomerAddress("CA1", "CA00000000000001", "52", "Joo Chiat Rd", "Road", null, "Singapore", null, null, "1241", "Singapore", BigDecimal("8.00"), "Flat"),
                firstShipDate = LocalDate.of(2001, 1, 2), firstSalesDate = LocalDate.of(2001, 1, 2),
                salutation = "Mr", firstName = "John", lastName = "Doe", preferredCustFlag = "N",
                birthDate = LocalDate.of(1971, 1, 1), birthCountry = "France", login = "JD1230234", emailAddress = "jd@gmail.com",
                lastReviewDate = LocalDate.of(2019, 6, 1)
            ),
            Customer("TOBEREPLACED", "0000000000000000",
                CustomerDemographics("CD2", "F", "M", "PhD", 15000, "B-", depCnt = 2, depEmployedCnt = 0, depCollegeCnt = 0),
                HouseholdDemographics("HD2", IncomeBand("IB1", 0, 25000), buyPotential = "Medium", depCnt = 2, vehicleCnt = 1),
                CustomerAddress("CA1", "CA00000000000001", "52", "Joo Chiat Rd", "Road", null, "Singapore", null, null, "1241", "Singapore", BigDecimal("8.00"), "Flat"),
                firstShipDate = LocalDate.of(2001, 1, 2), firstSalesDate = LocalDate.of(2001, 1, 2),
                salutation = "Mrs", firstName = "John", lastName = "Doe The Second", preferredCustFlag = "N",
                birthDate = LocalDate.of(1971, 1, 1), birthCountry = "France", login = "MrsD1230234", emailAddress = "jd2@gmail.com",
                lastReviewDate = LocalDate.of(2019, 6, 1)
            ),
            Customer("TOBEREPLACED", "0000000000000000",
                CustomerDemographics("CD3", "M", "S", "PhD", 55000, "A+", depCnt = 0, depEmployedCnt = 20, depCollegeCnt = 10),
                HouseholdDemographics("HD3", IncomeBand("IB5", 100000, 2500000), buyPotential = "High", depCnt = 0, vehicleCnt = 0),
                CustomerAddress("CA3", "CA00000000000003", "811", "Bukit Batok Rd", "Road", null, "Singapore", null, null, "4212", "Singapore", BigDecimal("8.00"), "Condo"),
                firstShipDate = LocalDate.of(2018, 1, 2), firstSalesDate = LocalDate.of(2018, 1, 2),
                salutation = "Mr", firstName = "Jonathan", lastName = "Doe The Third", preferredCustFlag = "Y",
                birthDate = LocalDate.of(1961, 1, 1), birthCountry = "Dutch Antilles", login = "JD3", emailAddress = "jd3@gmail.com",
                lastReviewDate = LocalDate.of(2019, 8, 1)
            )
        )
    }
}