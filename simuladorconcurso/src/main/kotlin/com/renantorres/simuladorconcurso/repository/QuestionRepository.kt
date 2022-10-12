package com.renantorres.simuladorconcurso.repository

import com.renantorres.simuladorconcurso.model.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository: JpaRepository<Question, Long> {
}