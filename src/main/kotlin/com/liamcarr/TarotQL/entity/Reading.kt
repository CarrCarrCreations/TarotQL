package com.liamcarr.TarotQL.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "reading")
data class Reading(
        var date: String,
        var subject: String,
        var analisis: String,
        @Id val id: String = UUID.randomUUID().toString()) {
}