package com.renantorres.simuladorconcurso

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue
    var id: Long,
    val name: String,
    val lastName: String,
    val email: String,
    val password: String) {

}