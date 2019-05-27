package com.liamcarr.TarotQL.repository

import com.liamcarr.TarotQL.entity.Reading
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReadingRepository : MongoRepository<Reading, String> {
}