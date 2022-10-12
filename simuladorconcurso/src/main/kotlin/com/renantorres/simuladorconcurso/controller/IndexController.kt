package com.renantorres.simuladorconcurso.controller

import com.renantorres.simuladorconcurso.repository.EngineerAreaRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class IndexController(
  private val engineerAreaRepository: EngineerAreaRepository
) {

  private val logger: Logger = LoggerFactory.getLogger(javaClass)

  @GetMapping
  fun index(model: Model): String {
    logger.info("index()...")
    model.addAttribute(
      "engineerAreas",
      engineerAreaRepository.findAll()
    )
    return "index"
  }
}