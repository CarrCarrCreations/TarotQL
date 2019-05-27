package com.liamcarr.TarotQL.repository

import com.liamcarr.TarotQL.entity.UserFolders
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserFoldersRepository : MongoRepository<UserFolders, String> {
    fun findByUserId(userId: String): Optional<UserFolders>
}