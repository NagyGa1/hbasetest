package domain

data class HouseholdDemographics(
    val sk: String,
    val incomeBand: IncomeBand,
    val buyPotential: String,
    val depCnt: Int,
    val vehicleCnt: Int
) {
}