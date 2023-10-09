package com.example.demo.book

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.NaturalId

@Entity
class Book(
        @Id
        @GeneratedValue
        var id: Long? = null,
        @NaturalId
        var isbn: String? = null

)