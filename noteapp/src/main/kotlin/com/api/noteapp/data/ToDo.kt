package com.api.noteapp.data

import jakarta.persistence.*

@Entity
@Table(name="todo")
data class ToDo(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "varchar(36)")
    var id: Int,
    var title : String,
    var content : String,
    var schedule : Long,
    var location : String,
)
{
    constructor() : this(0,"","",-1,"")
}