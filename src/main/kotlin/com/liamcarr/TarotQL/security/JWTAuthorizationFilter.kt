package com.liamcarr.TarotQL.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.liamcarr.TarotQL.security.SecurityConstants.Companion.HEADER_STRING
import com.liamcarr.TarotQL.security.SecurityConstants.Companion.SECRET
import com.liamcarr.TarotQL.security.SecurityConstants.Companion.TOKEN_PREFIX
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthorizationFilter(authenticationManager: AuthenticationManager?) : BasicAuthenticationFilter(authenticationManager) {

    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  chain: FilterChain) {
        val header = request.getHeader(HEADER_STRING)

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response)
            return
        }

        val authentication = getAuthentication(request)
        SecurityContextHolder.getContext().authentication = authentication
        chain.doFilter(request, response)
    }

    private fun getAuthentication(request: HttpServletRequest): UsernamePasswordAuthenticationToken? {
        val token = request.getHeader(HEADER_STRING)

        if (token != null) {
            // Parse the token
            val user = JWT.require(Algorithm.HMAC512(SECRET.toByteArray()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .subject

            return if (user != null)
                UsernamePasswordAuthenticationToken(user, null, mutableListOf())
            else null
        }
        return null
    }
}