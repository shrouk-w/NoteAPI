package com.api.noteapp.data

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name = "note")
@JsonInclude(JsonInclude.Include.NON_NULL)

data class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "varchar(36)")

    var id: Int=0,
    var title:String,
    var content:String,
    var location:String="",

    @CreationTimestamp
    var created: Date = Date(),
    @UpdateTimestamp
    var updated: Date = Date()
){
    constructor(): this(0,"","", "")
}