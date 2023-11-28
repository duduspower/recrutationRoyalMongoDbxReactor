package com.recrutation.task.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class TaskServiceImpl implements TaskService {
  TaskRepository repository;

  @Override
  public Flux<Task> findAllTasks() {
    return repository.findAllTasks();
  }

  @Override
  public Mono<Task> getTaskByUniqueId(String uniqueId) {
    return repository.findTaskByUniqueId(uniqueId);
  }

  @Override
  public void addTask(Task task) {
    repository.addTask(task);
  }

  @Override
  public void updateTask(String uniqueId, Task task) {
    repository.updateTask(uniqueId, task);
  }

  @Override
  public void deleteByUniqueId(String uniqueId) {
    repository.deleteByUniqueId(uniqueId);
  }
}
