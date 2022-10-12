package com.renantorres.simuladorconcurso.model

import javax.persistence.*

@Entity
data class Banca (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = 0,
  var name: String,
  var about: String = ""
)