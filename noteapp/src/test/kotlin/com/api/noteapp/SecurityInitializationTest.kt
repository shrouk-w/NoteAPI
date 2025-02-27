package com.api.noteapp

import com.api.noteapp.security.Admin
import com.api.noteapp.security.Member
import com.api.noteapp.security.UserDTO
import com.api.noteapp.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [NoteappApplication::class])
class SecurityInitializationTest {
    @Autowired
    private lateinit var userService: UserService

    private val password ="12345"
    private val adminEmail = "admin@test.com"
    private val memberEmail = "member@test.com"

    @Test
    fun initAdmin(){
        try{
            val admin = userService.loadUserByUsername(adminEmail)
            if(admin is Admin)
                println("admin account id: ${admin.id} already exists")
            else
                Assertions.fail("this is not an admin account")
        }
        catch(e : RuntimeException){
            val toSave = UserDTO(
                adminEmail,
                password,
                "admin",
                "admin"
            )
            val saved = userService.saveAdmin(toSave)
            println("admin account has been created id: ${saved.id}")
        }
    }

    @Test
    fun initMember(){
        try{
            val member = userService.loadUserByUsername(memberEmail)
            if(member is Member)
                println("member account id: ${member.id} already exists")
            else
                Assertions.fail("this is not a member account")
        }
        catch(e : RuntimeException){
            val toSave = UserDTO(
                memberEmail,
                password,
                "member",
                "member"
            )
            val saved = userService.saveMember(toSave)
            println("member account has been created id: ${saved.id}")
        }
    }

}


