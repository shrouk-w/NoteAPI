package com.api.noteapp.data

import jakarta.persistence.*

@Entity
@Table(name = "note")

data class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "varchar(36)")

    var id: Int,
    var title:String,
    var content:String,
    var location:String,
){
    constructor(): this(0,"","", "")
}