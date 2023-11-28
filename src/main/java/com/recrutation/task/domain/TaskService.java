package com.recrutation.task.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {

  Flux<Task> findAllTasks();

  Mono<Task> getTaskByUniqueId(String uniqueId);

  void addTask(Task task);

  void updateTask(String uniqueId, Task task);

  void deleteByUniqueId(String uniqueId);
}
