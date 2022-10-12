package com.renantorres.simuladorconcurso.repository

import com.renantorres.simuladorconcurso.model.Banca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BancaRepository:JpaRepository<Banca,Long> {
}