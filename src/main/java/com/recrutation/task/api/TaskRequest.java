package com.recrutation.task.api;

import com.recrutation.task.domain.Status;

record TaskRequest(String title, String description, Status status) {}
