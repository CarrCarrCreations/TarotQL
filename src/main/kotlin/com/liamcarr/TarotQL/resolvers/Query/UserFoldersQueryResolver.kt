package com.liamcarr.TarotQL.resolvers.Query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.liamcarr.TarotQL.entity.UserFolders
import com.liamcarr.TarotQL.repository.UserFoldersRepository
import org.springframework.stereotype.Component

@Component
class UserFoldersQueryResolver(val userFoldersRepository: UserFoldersRepository) : GraphQLQueryResolver {
    fun userFolders(): MutableList<UserFolders> {
        return userFoldersRepository.findAll()
    }
}