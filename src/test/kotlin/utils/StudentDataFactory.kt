package utils

object StudentDataFactory {
    private val names = listOf("John", "Alice", "Michael", "Sara", "Dmitry", "Aigerim")
    private val lastNames = listOf("Smith", "Ivanov", "Kim", "Zhang", "Doe", "Muralev")
    private val subjects = listOf("Math", "Biology", "History", "English", "Physics")
    private val hobbies = listOf("Reading", "Sports", "Music", "Drawing")
    private val photos = listOf("avatar1.png", "avatar2.jpg", "student_photo.png")
    private val states = listOf("California", "Texas", "Florida", "Almaty", "Astana")
    private val citiesByState = mapOf(
        "California" to listOf("Los Angeles", "San Diego"),
        "Texas" to listOf("Dallas", "Austin"),
        "Florida" to listOf("Miami", "Orlando"),
        "Almaty" to listOf("Almaty"),
        "Astana" to listOf("Astana")
    )

    fun create(): StudentData {
        val firstName: String  = names.random()
        val lastName: String  = lastNames.random()
        val gender: Gender  = Gender.getRandom()
        val phone = "+7${(9000000000..9999999999).random()}"
        val email = "${firstName.lowercase()}.${lastName.lowercase()}@example.com"
        val address = "Street ${('A'..'Z').random()}-${(1..100).random()}"
        val dayOfBirth: String  = (1..28).random().toString().padStart(2, '0')
        val monthOfBirth: String  = listOf(
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        ).random()
        val yearOfBirth: String = (1980..2010).random().toString()
        val subject: String  = subjects.random()
        val hobby: String  = hobbies.random()
        val photo: String  = photos.random()
        val state: String  = states.random()
        val city: String  = citiesByState[state]?.random().toString()

        return StudentData(
            firstName, lastName, gender, phone, email, address,
            dayOfBirth, monthOfBirth, yearOfBirth, subject, hobby, photo, state, city
        )
    }
}