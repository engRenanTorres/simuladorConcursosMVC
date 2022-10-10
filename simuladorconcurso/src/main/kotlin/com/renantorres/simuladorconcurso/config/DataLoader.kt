package com.renantorres.simuladorconcurso.config

import com.renantorres.simuladorconcurso.model.User
import com.renantorres.simuladorconcurso.model.UserPermission
import com.renantorres.simuladorconcurso.repository.EngineerAreaRepository
import com.renantorres.simuladorconcurso.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader(
  private val userRepository: UserRepository,
  private val areaRepository: EngineerAreaRepository
  ): CommandLineRunner {

  private val logger = LoggerFactory.getLogger(javaClass)

  override fun run(vararg args: String?) {

    if (userRepository.count() == 0L ){ //L diz que o número será um long
      val userAdmin = User(
        name = "Administrador",
        lastName = "adm",
        email = "admin@admin.com",
        password = "admin",
        permission = UserPermission.ADMIN
      )
      userRepository.save(userAdmin)
    }

//    if (areaRepository.count() == 0L ){
//
//    }
  }
}