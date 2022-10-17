package com.renantorres.simuladorconcurso.controller

import com.renantorres.simuladorconcurso.repository.EngineerAreaRepository
import com.renantorres.simuladorconcurso.repository.QuestionRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/questions-list")
class QuestionsListController(
  private val questionRepository: QuestionRepository,
  private val engineerAreaRepository: EngineerAreaRepository,
) {
  private val logger: Logger = LoggerFactory.getLogger(javaClass)
  val questionMessage = "questionListMessage"
  @GetMapping
  fun list(
    @RequestParam(name= "page", required = false, defaultValue = "0")page: Int,
    model: Model
  ): String {

    model.addAttribute("engineerAreas",engineerAreaRepository.findAll())

    val questions = questionRepository.findAll(PageRequest.of(page,1))
    val nextPage = if (page >= questions.totalElements-1) page else page + 1
    val previousPage = if (page <= 0) 0 else page - 1

    model.addAttribute("questions", questions )
    model.addAttribute("nextPage", nextPage )
    model.addAttribute("previousPage", previousPage )
    model.addAttribute("isFirst", questions.isFirst )
    model.addAttribute("isLast", questions.isLast )


    return "questionslist"
  }
  @GetMapping("/?page={page}")
  fun list2(
    @RequestParam(name= "page", required = false, defaultValue = "0")page: Int,
    model: Model
  ): String {

    model.addAttribute("engineerAreas",engineerAreaRepository.findAll())

    val questions = questionRepository.findAll(PageRequest.of(page,1))
    val nextPage = if (page >= questions.totalElements-1) page else page + 1
    val previousPage = if (page <= 0) 0 else page - 1

    model.addAttribute("questions", questions )
    model.addAttribute("nextPage", nextPage )
    model.addAttribute("previousPage", previousPage )
    model.addAttribute("isFirst", questions.isFirst )
    model.addAttribute("isLast", questions.isLast )


    return "questionslist"
  }
}