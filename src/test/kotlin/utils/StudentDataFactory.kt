package utils

import enums.Gender
import enums.Hobby
import enums.Subject

object StudentDataFactory {
    private val names = listOf("John", "Alice", "Michael", "Sara", "Dmitry", "Aigerim")
    private val lastNames = listOf("Smith", "Ivanov", "Kim", "Zhang", "Doe", "Muralev")
    private val months  = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )
    private val photos = listOf("avatar1.png", "avatar2.jpg", "student_photo.png")
    private val states = listOf("NCR", "Uttar Pradesh", "Haryana", "Rajasthan")
    private val citiesByState = mapOf(
        "NCR" to listOf("Delhi", "Gurgaon", "Noida"),
        "Uttar Pradesh" to listOf("Agra", "Lucknow", "Merrut"),
        "Haryana" to listOf("Karnal", "Panipat"),
        "Rajasthan" to listOf("Jaipur", "Jaiselmer")
    )

    fun create(): StudentData {
        val firstName: String  = names.random()
        val lastName: String  = lastNames.random()
        val gender: Gender = Gender.getRandom()
        val phone = "${(9000000000..9999999999).random()}"
        val email = "${firstName.lowercase()}.${lastName.lowercase()}@example.com"
        val address = "Street ${('A'..'Z').random()}-${(1..100).random()}"
        val dayOfBirth: String  = (1..28).random().toString().padStart(2, '0')
        val monthOfBirth: String  = months.random()
        val yearOfBirth: String = (1980..2010).random().toString()
        val subject: String = Subject.getRandom().displayedName
        val hobby: List<Hobby>  = Hobby.getRandomHobbies()
        val photo: String  = photos.random()
        val state: String  = states.random()
        val city: String  = citiesByState[state]?.random().toString()

        return StudentData(
            firstName, lastName, gender, phone, email, address,
            dayOfBirth, monthOfBirth, yearOfBirth, subject, hobby, photo, state, city
        )
    }

    fun createWithInvalidEmail(): StudentData = create().copy(email = "bad-email")
}