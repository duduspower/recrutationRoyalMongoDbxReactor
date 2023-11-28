package com.recrutation.task.infrastructure;

import java.time.LocalDateTime;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@Document("task")
record TaskEntity(
    @Id String uniqueId,
    String title,
    String description,
    LocalDateTime creationDate,
    String status) {}
