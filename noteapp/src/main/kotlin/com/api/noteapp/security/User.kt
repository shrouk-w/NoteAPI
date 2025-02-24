package com.api.noteapp.security

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*


@Entity
@Table(name = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)

open class User (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long = -1,
    @Column(unique = true, nullable = false)
    @NotNull
    @Email
    var email: String = "",
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    var pwd : String = "",
    @NotBlank
    var firstname : String = "",
    @NotBlank
    var lastname : String = "",
    var roles: String = "",
    var enabled: Boolean = true,
    var accountNonExpired: Boolean = true,
    var accountNonLocked: Boolean = true,
    var credentialsNonExpired: Boolean = true,
    @CreationTimestamp
    var created: Date = Date(),
    @UpdateTimestamp
    var modified: Date = Date()
    ) : UserDetails {

        constructor() : this(-1,"","","","","",true,true,true,true, Date(), Date())


    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        roles
            .split(",")
            .forEach { authorities.add(SimpleGrantedAuthority(it.trim())) }
        return authorities
    }
    override fun isEnabled() = enabled

    override fun getPassword() = pwd

    override fun getUsername() = email

    override fun isCredentialsNonExpired() = credentialsNonExpired

    override fun isAccountNonExpired() = accountNonExpired

    override fun isAccountNonLocked() = accountNonLocked

}