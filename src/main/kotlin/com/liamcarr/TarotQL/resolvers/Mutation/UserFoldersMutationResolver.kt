package com.liamcarr.TarotQL.resolvers.Mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.liamcarr.TarotQL.entity.UserFolders
import com.liamcarr.TarotQL.repository.UserFoldersRepository
import org.springframework.stereotype.Component

@Component
class UserFoldersMutationResolver(private val userFoldersRepository: UserFoldersRepository) : GraphQLMutationResolver {
    fun newUserFolders(userId: String): UserFolders {
        val userFolders = UserFolders(userId)
        userFoldersRepository.save(userFolders)
        return userFolders
    }
}