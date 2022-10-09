package com.renantorres.simuladorconcurso

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/signup")
class SignUpController(private val repository: UserRepository) {

  private val logger: Logger = LoggerFactory.getLogger(javaClass)

  //@RequestMapping("/signup", method = [RequestMethod.GET])
  @GetMapping
  fun form(model: Model): String {
    logger.info("form()...")
    model.addAttribute("user", User())
    return "signup" //o spring já busca a página com este nome dentro de templates(signup.html)
  }

  @PostMapping
  fun saveUser(user: User, confirmPassword: String, model:Model): String {
    logger.info("save()...")

    if(user.password != confirmPassword) {
      val errorMessage = "Senhas não conferem..."
      logger.error(errorMessage)
      model.addAttribute("messageError", errorMessage)
      return "signup"
    }
      repository.save(user).also { logger.info("$user") }
      return "redirect:/login"
    }
}