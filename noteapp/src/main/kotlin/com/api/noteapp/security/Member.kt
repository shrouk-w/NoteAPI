package com.api.noteapp.security

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.util.*

@Entity
@DiscriminatorValue("MEMBER")
class Member(
    id: Long,
    email: String,
    pwd : String,
    firstname: String,
    lastname: String,
    roles: String,
    enabled : Boolean,
    accountNonExpired: Boolean,
    accountNonLocked: Boolean,
    credentialsNonExpired: Boolean,
    created : Date,
    modified : Date,
) : User(
    id,
    email,
    pwd,
    firstname,
    lastname,
    roles,
    enabled,
    accountNonExpired,
    accountNonLocked,
    credentialsNonExpired,
    created,
    modified
){
    constructor() : this(-1, "","","","","",true,true,true,true, Date(), Date())
}