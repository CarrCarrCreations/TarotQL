package com.liamcarr.TarotQL.repository

import com.liamcarr.TarotQL.entity.Folder
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FolderRepository : MongoRepository<Folder, String> {
}