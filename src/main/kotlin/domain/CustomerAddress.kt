package domain

import java.math.BigDecimal

data class CustomerAddress(
    val sk: String,
    val id: String,
    val streetNumber: String,
    val streetName: String,
    val streetType: String,
    val suiteNumber: String?,
    val city: String,
    val county: String?,
    val state: String?,
    val zip: String,
    val country: String,
    val gmtOffset: BigDecimal,
    val locationType: String
) {
    init {
        check(sk.isNotBlank())
        check(id.length == 16)
        // giving up enforcing the arbitrary CHAR() data types of the document here
    }
}