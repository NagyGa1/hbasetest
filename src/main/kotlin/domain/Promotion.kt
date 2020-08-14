package domain

import java.math.BigDecimal
import java.time.LocalDate

data class Promotion(
    val sk: String,
    val id: String,
    val startDate: LocalDate?,
    val endDate: LocalDate?,
    val item: Item?,
    val cost: BigDecimal?,
    val responseTarget: Int?,
    val promoName: String?,
    val channelDMail: String?,
    val channelEMail: String?,
    val channelCatalog: String?,
    val channelTv: String?,
    val channelRadio: String?,
    val channelPress: String?,
    val channelEvent: String?,
    val channelDemo: String?,
    val channelDetails: String?,
    val purpose: String?,
    val discountActive: String?
) {
    init {
        check(sk.isNotBlank())
        check(id.length == 16)
    }

    companion object {
        val ALL = listOf(
            Promotion(
                sk = "P1", id = "P000000000000001", null, null, item = null,
                cost = BigDecimal("5.0"), responseTarget = 23, promoName = "The Big Sale",
                channelDMail = null, channelEMail = null, channelCatalog = null, channelTv = "Y",
                channelRadio = "Y", channelPress = "Y", channelEvent = "Y", channelDemo = null,
                channelDetails = "Some long channel description here, 100 chars max", purpose = "Sell more",
                discountActive = "Y"
            ),
            Promotion(
                sk = "P2", id = "P000000000000002", null, null, item = null,
                cost = BigDecimal("55.0"), responseTarget = 23, promoName = "All Must Go",
                channelDMail = "Y", channelEMail = "Y", channelCatalog = "Y", channelTv = null,
                channelRadio = null, channelPress = null, channelEvent = null, channelDemo = "Y",
                channelDetails = "Other long channel description here, 100 chars max", purpose = "Sell less",
                discountActive = "Y"
            )
        )
    }
}