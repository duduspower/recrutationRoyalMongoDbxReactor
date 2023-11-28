package com.recrutation.task.domain;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record Person(String uniqueId, String name, List<String> taskUniqueIds) {}
