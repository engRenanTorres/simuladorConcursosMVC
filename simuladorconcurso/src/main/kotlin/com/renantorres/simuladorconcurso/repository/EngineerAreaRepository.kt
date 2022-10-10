package com.renantorres.simuladorconcurso.repository

import com.renantorres.simuladorconcurso.model.EngineerArea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EngineerAreaRepository: JpaRepository<EngineerArea, Long> {
}