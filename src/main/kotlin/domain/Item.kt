package domain

import java.math.BigDecimal
import java.time.LocalDate

data class Item(
    val sk: String,
    val id: String,
    val recStart: LocalDate?,
    val recEnd: LocalDate?,
    val desc: String,
    val currentPrice: BigDecimal,
    val wholeSaleCost: BigDecimal,
    val brandId: Int,
    val brand: String,
    val classId: Int,
    val class_: String,
    val categoryId: Int,
    val category: String,
    val manufactId: Int,
    val manufact: String,
    val size: String,
    val formulation: String?,
    val color: String,
    val units: String,
    val container: String,
    val managerId: Int,
    val productName: String
) {
    init {
        check(sk.isNotBlank())
        check(id.length == 16)
        check(desc.length <= 200)
        check(brand.length <= 50)
        check(class_.length <= 50)
        check(category.length <= 50)
        check(manufact.length <= 50)
        check(size.length <= 20)
        // stopping enforcing here
    }

    companion object {

        /**
         * Available items.
         */
        val TEMPLATES = listOf(
            Item(
                sk = "TOBEREPLACED",
                id = "0000000000000000",
                recStart = null, recEnd = null,
                desc = "Napkins",
                currentPrice = BigDecimal("12.50"),
                wholeSaleCost = BigDecimal("10.00"),
                brandId = 1, brand = "Kleenex",
                classId = 1, class_ = "Class1",
                categoryId = 1, category = "Papers",
                manufactId = 1, manufact = "Kleenex",
                size = "Large", formulation = "Nice", color = "White", units = "23", container = "Box",
                managerId = 1, productName = "KX Nappers"
            ),
            Item(
                sk = "TOBEREPLACED",
                id = "0000000000000000",
                recStart = LocalDate.of(2000, 1, 1), recEnd = LocalDate.of(2025, 12, 31),
                desc = "Mega Multi",
                currentPrice = BigDecimal("22.50"),
                wholeSaleCost = BigDecimal("20.00"),
                brandId = 2, brand = "Holistic Way",
                classId = 2, class_ = "Class2",
                categoryId = 2, category = "Vitamins",
                manufactId = 2, manufact = "Health Solutions",
                size = "", formulation = "Not so nice", color = "Brownish", units = "30", container = "Box",
                managerId = 2, productName = "Mega Multi Once A Day"
            ),
            Item(
                sk = "TOBEREPLACED",
                id = "0000000000000000",
                recStart = LocalDate.of(2000, 1, 1), recEnd = LocalDate.of(2025, 12, 31),
                desc = "Notepad",
                currentPrice = BigDecimal("4.50"),
                wholeSaleCost = BigDecimal("2.50"),
                brandId = 2, brand = "Bestform",
                classId = 2, class_ = "Class3",
                categoryId = 2, category = "Notepads",
                manufactId = 2, manufact = "A'zone Corporation",
                size = "", formulation = null, color = "White", units = "1", container = "Self",
                managerId = 2, productName = "Bestform recycled woodfree paper"
            )
        )
    }

}