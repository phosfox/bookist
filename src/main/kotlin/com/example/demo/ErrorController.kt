package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ErrorController {
    @GetMapping("/error")
    fun view(): String {
        return "error"
    }
}