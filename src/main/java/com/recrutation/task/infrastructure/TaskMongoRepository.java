package com.recrutation.task.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

interface TaskMongoRepository extends MongoRepository<TaskEntity, String> {}
