package com.example.demo.user

import com.example.demo.role.Role
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var username: String,
        var email: String,
        var password: String,
        var accountNonExpired: Boolean = true,
        var accountNonLocked: Boolean = true,
        var credentialsNonExpired: Boolean = true,
        var enabled: Boolean = true,
        @OneToMany
        var roles: Set<Role> = HashSet()

)