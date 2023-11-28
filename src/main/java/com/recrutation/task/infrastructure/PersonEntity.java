package com.recrutation.task.infrastructure;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("person")
record PersonEntity(@Id String uniqueId, String name, List<String> taskUniqueIds) {}
