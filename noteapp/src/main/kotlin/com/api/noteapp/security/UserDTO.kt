package com.api.noteapp.security

data class UserDTO(
    val email : String,
    var password : String,
    var firstname : String,
    var lastname : String
) {
}