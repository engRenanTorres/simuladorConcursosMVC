package com.renantorres.simuladorconcurso.controller

import com.renantorres.simuladorconcurso.model.EngineerArea
import com.renantorres.simuladorconcurso.model.Question
import com.renantorres.simuladorconcurso.model.QuestionAuthor
import com.renantorres.simuladorconcurso.model.User
import com.renantorres.simuladorconcurso.repository.BancaRepository
import com.renantorres.simuladorconcurso.repository.EngineerAreaRepository
import com.renantorres.simuladorconcurso.repository.QuestionAuthorRepository
import com.renantorres.simuladorconcurso.repository.QuestionRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.time.LocalDateTime
import java.util.*
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/question")
class QuestionController(
  private val authorRepository: QuestionAuthorRepository,
  private val questionRepository: QuestionRepository,
  private val engineerAreaRepository: EngineerAreaRepository,
  private val bancaRepository: BancaRepository
  ) {

  private val logger: Logger = LoggerFactory.getLogger(javaClass)
  val questionMessage = "questionMessage"
  @GetMapping
  fun form (model: Model): String{
    logger.info(questionMessage,"form()")
    model.addAttribute(
      "engineerAreas",
      engineerAreaRepository.findAll()
    )
    model.addAttribute(
      "bancas",
      bancaRepository.findAll()
    )
    model.addAttribute("question", Question())
    return "question"
  }
  @PostMapping
  fun save(question: Question,
           session: HttpSession,
           redirectAttributes: RedirectAttributes
  ):String {
    logger.info("save($question)")
    val currentUser:User = session.getAttribute("currentUser") as User
    val authorOptional: Optional<QuestionAuthor> = authorRepository.findByUserId(currentUser.id)
    val author = if(authorOptional.isPresent){
      authorOptional.get()
    } else {
      val author = QuestionAuthor(user = currentUser)
      authorRepository.save(author).also { logger.info("Autor salvo com sucesso!") }
    }


    question.author = author
    question.date = LocalDateTime.now()

    questionRepository.save(question)

    val successMessage = "Questão criada com sucesso!"
    logger.info(questionMessage, successMessage)
    redirectAttributes.addFlashAttribute("successMessage", successMessage)

    return "redirect:/"
  }
}