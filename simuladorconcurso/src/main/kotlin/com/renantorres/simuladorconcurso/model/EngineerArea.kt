package com.renantorres.simuladorconcurso.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EngineerArea(
  @Id
  @GeneratedValue
    var id: Long =0,
    var name: String
) {
}