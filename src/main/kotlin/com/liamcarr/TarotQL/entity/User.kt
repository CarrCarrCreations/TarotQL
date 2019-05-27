package com.liamcarr.TarotQL.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(var username: String = "",
                var password: String = "") {
    @Id
    var id: String = ""
}