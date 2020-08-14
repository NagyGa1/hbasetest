package domain

data class CustomerDemographics(
    val sk: String,
    val gender: String,
    val maritalStatus: String,
    val educationStatus: String,
    val purchaseEstimate: Int,
    val creditRating: String,
    val depCnt: Int,
    val depEmployedCnt: Int,
    val depCollegeCnt: Int
) {
    init {
        check(sk.isNotBlank())
        check(gender.length == 1)
        check(maritalStatus.length == 1)
    }
}