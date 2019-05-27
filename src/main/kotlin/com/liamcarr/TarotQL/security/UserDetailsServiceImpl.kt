package com.liamcarr.TarotQL.security

import com.liamcarr.TarotQL.entity.User
import com.liamcarr.TarotQL.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired


import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
data class UserDetailsServiceImpl(@Autowired private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User? = userRepository.findByUsername(username!!)?.get()
        println("USER $user")

        if (user != null) {
            return org.springframework.security.core.userdetails.User(user.username, user.password, mutableListOf())
        } else throw UsernameNotFoundException(username)
    }
}