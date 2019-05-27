package com.liamcarr.TarotQL.resolvers.Query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.liamcarr.TarotQL.entity.User
import com.liamcarr.TarotQL.repository.UserRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserQueryResolver(val userRepository: UserRepository,
                        private val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun users(): List<User> {
        return userRepository.findAll()
    }

    fun user(username: String): Optional<User>? {
        return userRepository.findByUsername(username)
    }
}