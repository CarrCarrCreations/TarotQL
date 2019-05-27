package com.liamcarr.TarotQL.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.liamcarr.TarotQL.entity.User
import com.liamcarr.TarotQL.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import java.util.*


@Component
class UserMutationResolver(private val userRepository: UserRepository,
                           private val bCryptPasswordEncoder: BCryptPasswordEncoder) : GraphQLMutationResolver {

    fun newUser(username: String, password: String): User {
        val user = User(username, bCryptPasswordEncoder.encode(password))
        user.id = UUID.randomUUID().toString()
        userRepository.save(user)
        return user
    }

    fun deleteUser(id: String): Boolean {
        userRepository.deleteById(id)
        return true
    }

    fun updateUserPassword(id: String, password: String): User {
        val user = userRepository.findById(id)
        user.ifPresent {
            it.password = bCryptPasswordEncoder.encode(password)
            userRepository.save(it)
        }

        return user.get()
    }
}