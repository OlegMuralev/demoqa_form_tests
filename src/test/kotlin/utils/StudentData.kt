package utils

import enums.Gender
import enums.Hobby

data class StudentData(
    var firstName: String,
    var lastName: String,
    var gender: Gender,
    var phone: String,
    var email: String,
    var address: String,
    var dayOfBirth: String,
    var monthOfBirth: String,
    var yearOfBirth: String,
    var subject: String,
    var hobby: List<Hobby>,
    var photo: String,
    var state: String,
    var city: String
)
