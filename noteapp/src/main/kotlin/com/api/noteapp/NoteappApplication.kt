package com.api.noteapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NoteappApplication


fun main(args: Array<String>) {
	runApplication<NoteappApplication>(*args)
	
}
