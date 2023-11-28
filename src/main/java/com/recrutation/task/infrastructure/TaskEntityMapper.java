package com.recrutation.task.infrastructure;

import com.recrutation.task.domain.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface TaskEntityMapper {
  Task toDomain(TaskEntity entity);

  TaskEntity toEntity(Task domain);
}
