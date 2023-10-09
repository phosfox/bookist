package com.example.demo.book

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BookController(
        val repository: BookRepository
) {
    @GetMapping("/books")
    fun view(model: Model, response: HttpServletResponse): String {
        val book = Book()
        book.id = 1
        book.isbn = "isbn"
        model.addAttribute("book", book)
        return "books"
    }
}