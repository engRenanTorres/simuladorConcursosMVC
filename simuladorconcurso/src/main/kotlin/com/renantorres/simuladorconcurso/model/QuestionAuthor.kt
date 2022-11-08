package com.renantorres.simuladorconcurso.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "question_author")
data class QuestionAuthor(
  @Id
  @GeneratedValue
  var id: Long = 0,
  var about: String = "",
  @OneToOne
  var user: User = User()

)