package com.recrutation.task.api;

import com.recrutation.task.domain.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface TaskApiMapper {
  Task toDomain(TaskRequest request);

  TaskResponse toResponse(Task domain);
}
