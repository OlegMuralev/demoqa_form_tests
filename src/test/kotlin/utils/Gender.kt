package utils

enum class Gender(val displayedName: String) {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    companion object {
        fun getRandom(): Gender = entries.toTypedArray().random()
    }
}