package com.api.noteapp.service

import com.api.noteapp.repository.UserRepository
import com.api.noteapp.security.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserService: UserDetailsService {

    @Autowired
    lateinit var repository: UserRepository

    val encoder = BCryptPasswordEncoder(11)

    override fun loadUserByUsername(email: String): User? {
        return repository.findOneByEmail(email) ?: throw UsernameNotFoundException("User with email $email does not exist")
    }

    fun saveMember(user: UserDTO): User {
        val member = Member()
        member.email = user.email
        member.firstname = user.firstname
        member.lastname = user.lastname
        member.pwd = encoder.encode(user.password)
        member.roles = "MEMBER"
        return repository.save(member)
    }

    fun saveAdmin(user: UserDTO): User {
        val admin = Admin()
        admin.email = user.email
        admin.firstname = user.firstname
        admin.lastname = user.lastname
        admin.pwd = encoder.encode(user.password)
        admin.roles = "ADMIN"
        return repository.save(admin)
    }

    fun updateUser(toSave: User): User? {
        val user = repository.findOneByEmail(toSave.email)
        user?.let {
            if(!toSave.pwd.isEmpty()) {
                user.pwd = encoder.encode(toSave.password)
            }
            user.firstname = toSave.firstname
            user.lastname = toSave.lastname
            user.accountNonExpired = toSave.accountNonExpired
            user.accountNonLocked = toSave.accountNonLocked
            user.credentialsNonExpired = toSave.credentialsNonExpired
            user.modified = Date()
            return repository.save(user)
        }
        return null
    }

    fun getUsers() = repository.findAll().map{
        it ->
        UserDetailsDTO(
            it.id,
            it.email,
            it.firstname,
            it.lastname,
            it.roles,
            it.enabled,
            it.accountNonExpired,
            it.accountNonLocked,
            it.credentialsNonExpired,
            it.created,
            it.modified
        )
    }

    fun deleteUser(id: Long) = repository.deleteById(id.toString())
}