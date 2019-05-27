package com.liamcarr.TarotQL.repository

import com.liamcarr.TarotQL.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : MongoRepository<User, String> {
    fun findByUsername(username: String): Optional<User>?
}