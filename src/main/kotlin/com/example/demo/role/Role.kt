package com.example.demo.role

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Role(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var roleName: String)
