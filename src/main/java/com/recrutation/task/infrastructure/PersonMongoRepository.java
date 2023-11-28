package com.recrutation.task.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

interface PersonMongoRepository extends MongoRepository<PersonEntity, String> {}
