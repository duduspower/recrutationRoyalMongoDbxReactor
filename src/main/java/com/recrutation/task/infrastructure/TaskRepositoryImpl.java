package com.recrutation.task.infrastructure;

import com.recrutation.task.domain.Task;
import com.recrutation.task.domain.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class TaskRepositoryImpl implements TaskRepository {
  TaskMongoRepository mongoRepository;
  TaskEntityMapper mapper;

  @Override
  public Flux<Task> findAllTasks() {
    return Flux.fromStream(mongoRepository.findAll().stream().map(mapper::toDomain));
  }

  @Override
  public Mono<Task> findTaskByUniqueId(String uniqueId) {
    return Mono.from(
        mongoRepository
            .findById(uniqueId)
            .map(mapper::toDomain)
            .map(Mono::just)
            .orElseGet(Mono::empty));
  }

  @Override
  public void addTask(Task task) {
    var toSave = task.toBuilder().creationDate(LocalDateTime.now()).build();
    mongoRepository.save(mapper.toEntity(toSave));
  }

  @Override
  public void updateTask(String uniqueId, Task task) {
    mongoRepository.deleteById(uniqueId);
    addTask(task);
  }

  @Override
  public void deleteByUniqueId(String uniqueId) {
    mongoRepository.deleteById(uniqueId);
  }
}
