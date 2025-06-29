package enums

enum class Hobby(val displayedName: String) {
    SPORT(displayedName = "Sports"),
    READING(displayedName = "Reading"),
    MUSIC(displayedName = "Music");

    companion object {
        fun getRandomHobbies(): List<Hobby> {
            val count = (1..entries.size).random()
            return entries.shuffled().take(count)
        }
    }
}