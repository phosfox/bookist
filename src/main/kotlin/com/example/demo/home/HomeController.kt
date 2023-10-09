package com.example.demo.home

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping("/home")
    fun home(model: Model, response: HttpServletResponse): String {
        var count = 1;
        model.addAttribute("count", count)
        count += 1
        return "demo"
    }
}