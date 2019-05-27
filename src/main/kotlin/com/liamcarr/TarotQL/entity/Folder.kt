package com.liamcarr.TarotQL.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "folder")
data class Folder(
        var name: String,
        var readings: MutableList<Reading>,
        @Id val id: String = UUID.randomUUID().toString()
) {
}