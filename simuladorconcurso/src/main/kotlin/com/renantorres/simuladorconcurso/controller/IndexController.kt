package com.renantorres.simuladorconcurso.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class IndexController {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    @GetMapping
    fun index(): String{
        logger.info("index()...")
        return "index"
    }
}