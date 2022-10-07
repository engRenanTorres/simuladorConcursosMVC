package com.renantorres.simuladorconcurso

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/signup")
class SignUpController {
    //@RequestMapping("/signup", method = [RequestMethod.GET])
    @GetMapping
    fun form(): String {
        return "signup" //o spring já busca a página com este nome dentro de templates(signup.html)
    }

    @PostMapping
    fun saveUser(user: User, confirmPassword: String): String {
        println("save()...")
        println("name: $user e $confirmPassword")
        return "redirect:/"
    }
}