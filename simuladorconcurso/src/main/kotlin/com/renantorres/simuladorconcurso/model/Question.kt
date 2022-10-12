package com.renantorres.simuladorconcurso.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Question(
  @Id
  @GeneratedValue
  var id:Long = 0,
  @ManyToOne
  var banca: Banca = Banca(name="fgv"),
  var nivel: String = "",
  @ManyToOne
  var cargo: EngineerArea = EngineerArea(),
  var concurso:String = "",
  var ano: Int = 2020,
  var assunto:String  = "",
  var enunciado: String ="",
  var alternativa: String ="",
  var resposta:String = "",
  var observacao: String = "",
  var date: LocalDateTime = LocalDateTime.now(),
  @ManyToOne
  var author: QuestionAuthor = QuestionAuthor()
)
{

}
