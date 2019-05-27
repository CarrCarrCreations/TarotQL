package com.liamcarr.TarotQL.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "userFolders")
data class UserFolders(
        var userId: String,
        var personalFolders: MutableList<Folder> = mutableListOf(),
        var clientFolders: MutableList<Folder> = mutableListOf(),
        @Id val id: String = UUID.randomUUID().toString()) {
}