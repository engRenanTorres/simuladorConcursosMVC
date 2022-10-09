package com.renantorres.simuladorconcurso

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    var id: Long = 0,
    var name: String ="",
    var lastName: String ="",
    var email: String = "",
    var password: String = "",
    var permission: UserPermission = UserPermission.USER
    ) {

}