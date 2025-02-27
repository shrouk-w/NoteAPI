package com.api.noteapp.repository

import com.api.noteapp.security.User

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
    fun findOneByEmail(email: String) : User?
}