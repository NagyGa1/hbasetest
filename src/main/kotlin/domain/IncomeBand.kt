package domain

data class IncomeBand(
    val sk: String,
    val lowerBound: Int,
    val upperBound: Int
) {
    init {
        check(sk.isNotBlank())
    }
}