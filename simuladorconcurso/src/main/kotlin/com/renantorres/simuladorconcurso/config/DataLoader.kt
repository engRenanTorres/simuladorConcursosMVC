package com.renantorres.simuladorconcurso.config

import com.renantorres.simuladorconcurso.model.*
import com.renantorres.simuladorconcurso.repository.*
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
class DataLoader(
  private val userRepository: UserRepository,
  private val areaRepository: EngineerAreaRepository,
  private val bancaRepository: BancaRepository,
  private val questionRepository: QuestionRepository,
  private val questionAuthorRepository: QuestionAuthorRepository
) : CommandLineRunner {

  private val logger = LoggerFactory.getLogger(javaClass)
  override fun run(vararg args: String?) {

    insertAdmIfUserBDIsEmpty()

    insertDefaultAreasIfAreasTableIsEmpty()

    insertBanca()

    insertQuestions()


  }

  private fun insertBanca() {
    if (bancaRepository.count() == 0L) {
      listOf(
        Banca(name = "FGV"),
        Banca(name = "CESPE")
      ).also { bancaRepository.saveAll(it) }
    }
  }

  private fun insertDefaultAreasIfAreasTableIsEmpty() {
    if (areaRepository.count() == 0L) {
      listOf(
        EngineerArea(name = "Engenharia de Segurança"),
        EngineerArea(name = "Engenharia Civil")
      ).also { areaRepository.saveAll(it) }
      //areaRepository.findAll().forEach{  println(it)  }
    }
  }

  private fun insertAdmIfUserBDIsEmpty() {
    if (userRepository.count() == 0L) { //L diz que o número será um long
      val userAdmin = User(
        name = "Administrador",
        lastName = "adm",
        email = "admin@admin.com",
        password = "admin",
        permission = UserPermission.ADMIN
      )
      userRepository.save(userAdmin)
    }
  }

  private fun insertQuestions(){
    if (questionRepository.count() == 0L) {
      val adminUser = userRepository.findAll()[0]
      val banca = bancaRepository.findAll()[0]
      val cargo = areaRepository.findAll()[0]

      val adminQuestionAuthor = QuestionAuthor(user = adminUser)
      questionAuthorRepository.save(adminQuestionAuthor)
      listOf(
        Question(
          enunciado="Quem sou eu?",
          alternativa="Renan",
          banca= banca,
          cargo=cargo,
          date = LocalDateTime.now(),
          author = adminQuestionAuthor
        ),
        Question(
          enunciado="Quem és tu?",
          alternativa="Geripapado",
          banca= banca,
          cargo=cargo,
          date = LocalDateTime.now(),
          author = adminQuestionAuthor
        )
      ).also { questionRepository.saveAll(it) }
    }
  }
}