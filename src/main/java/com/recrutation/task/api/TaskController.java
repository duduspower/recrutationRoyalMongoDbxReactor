package com.recrutation.task.api;

import com.recrutation.task.domain.TaskService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class TaskController {
  TaskService service;
  TaskApiMapper mapper;

  @GetMapping
  Flux<TaskResponse> findAllTasks() {
    return service.findAllTasks().map(mapper::toResponse);
  }

  @GetMapping("/{uniqueId}")
  Mono<TaskResponse> findTaskByUniqueId(@PathVariable String uniqueId) {
    return service.getTaskByUniqueId(uniqueId).map(mapper::toResponse);
  }

  @PostMapping
  ResponseEntity<?> addTask(@RequestBody TaskRequest request) {
    service.addTask(mapper.toDomain(request));
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{uniqueId}")
  ResponseEntity<?> updateTask(@PathVariable String uniqueId, @RequestBody TaskRequest request) {
    service.updateTask(uniqueId, mapper.toDomain(request));
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{uniqueId}")
  ResponseEntity<?> deleteByUniqueId(@PathVariable String uniqueId) {
    service.deleteByUniqueId(uniqueId);
    return ResponseEntity.ok().build();
  }
}
