package com.recrutation.task.api;

import java.util.List;

record PersonResponse(String uniqueId, String name, List<String> taskUniqueIds) {}
