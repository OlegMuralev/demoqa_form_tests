package enums

enum class Subject(val displayedName: String) {
    ENGLISH(displayedName = "English"),
    CHEMISTRY(displayedName = "Chemistry"),
    COMPUTER_SCIENCE(displayedName = "Computer Science"),
    COMMERCE(displayedName = "Commerce");

    companion object {
        fun getRandom(): Subject = Subject.entries.toTypedArray().random()
    }
}