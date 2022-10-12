package com.renantorres.simuladorconcurso.repository

import com.renantorres.simuladorconcurso.model.QuestionAuthor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionAuthorRepository: JpaRepository<QuestionAuthor, Long> {

}