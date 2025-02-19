package com.api.noteapp.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @GetMapping(
        value = ["/obtain"],
        produces = arrayOf("application/json"),
    )
    fun getNotes() : String {
        return "trwa ballsowanie danych"
    }

}