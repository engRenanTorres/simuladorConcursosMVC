package com.renantorres.simuladorconcurso.controller

import com.renantorres.simuladorconcurso.model.Question
import com.renantorres.simuladorconcurso.repository.BancaRepository
import com.renantorres.simuladorconcurso.repository.EngineerAreaRepository
import com.renantorres.simuladorconcurso.repository.QuestionAuthorRepository
import com.renantorres.simuladorconcurso.repository.QuestionRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/questions-list")
class QuestionsListController(
  private val authorRepository: QuestionAuthorRepository,
  private val questionRepository: QuestionRepository,
  private val engineerAreaRepository: EngineerAreaRepository,
  private val bancaRepository: BancaRepository
) {
  private val logger: Logger = LoggerFactory.getLogger(javaClass)
  val questionMessage = "questionListMessage"
  @GetMapping
  fun list(model: Model): String {

    model.addAttribute("engineerAreas",engineerAreaRepository.findAll())
    model.addAttribute("questions", questionRepository.findAll())
    return "questionslist"
  }
}