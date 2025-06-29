package enums

enum class Gender(val displayedName: String) {
    MALE(displayedName = "Male"),
    FEMALE(displayedName = "Female"),
    OTHER(displayedName = "Other");

    companion object {
        fun getRandom(): Gender = entries.toTypedArray().random()
    }
}