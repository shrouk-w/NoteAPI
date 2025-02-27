package com.api.noteapp.security

import java.util.*

data class UserDetailsDTO(
    val id : Long,
    val email : String,
    val firstname : String,
    val lastname: String,
    var roles : String,
    var enabled : Boolean,
    var accountNonExpired : Boolean,
    var accountNonLocked : Boolean,
    var credentialsNonExpired : Boolean,
    var created: Date,
    var modified: Date
) {
}