package com.recrutation.task.api;

import com.recrutation.task.domain.Status;
import java.time.LocalDateTime;

record TaskResponse(
    String uniqueId, String title, String description, LocalDateTime creationDate, Status status) {}
