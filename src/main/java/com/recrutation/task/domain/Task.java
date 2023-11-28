package com.recrutation.task.domain;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record Task(
    String uniqueId, String title, String description, LocalDateTime creationDate, Status status) {}
