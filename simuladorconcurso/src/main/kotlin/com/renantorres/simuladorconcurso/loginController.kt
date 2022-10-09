package com.renantorres.simuladorconcurso

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.Optional

@Controller
@RequestMapping("/login")
class loginController (private val repository: UserRepository) {
  private val logger: Logger = LoggerFactory.getLogger(javaClass)

  @GetMapping
  fun form(model: Model): String {
    logger.info("form()...")

    model.addAttribute("user",User())
    return "login"
  }

  @PostMapping
  fun login(user: User, model: Model): String {
    logger.info("login($user)")

    val optional = repository.findByEmail(user.email)
    if (optional.isEmpty){
      model.addAttribute("messageError","Usuário não encontrado.")
      return "login"
    }

    val userDatabase = optional.get()
    if (user.password != userDatabase.password){
      model.addAttribute("messageError","Senha inválida.")
      return "login"
    }

    return "redirect:/"
  }
}