package com.liamcarr.TarotQL.controllers

import com.liamcarr.TarotQL.entity.User
import com.liamcarr.TarotQL.resolvers.Mutation.UserMutationResolver
import com.liamcarr.TarotQL.security.SecurityConstants.Companion.SIGN_UP_URL
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(private val userMutationResolver: UserMutationResolver) {

    @PostMapping(SIGN_UP_URL)
    fun signUp(@RequestBody user: User): User {
        return userMutationResolver.newUser(user.username, user.password)
    }
}