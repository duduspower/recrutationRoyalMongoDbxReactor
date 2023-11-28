package com.recrutation.task.api;

import java.util.List;

record PersonRequest(String name, List<String> taskUniqueIds) {}
