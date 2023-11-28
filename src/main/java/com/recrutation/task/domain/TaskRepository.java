package com.recrutation.task.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskRepository {
  Flux<Task> findAllTasks();

  Mono<Task> findTaskByUniqueId(String uniqueId);

  void addTask(Task task);

  void updateTask(String uniqueId, Task task);

  void deleteByUniqueId(String uniqueId);
}
