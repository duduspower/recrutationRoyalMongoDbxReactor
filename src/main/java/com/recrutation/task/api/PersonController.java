package com.recrutation.task.api;

import com.recrutation.task.domain.PersonService;
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
@RequestMapping("/persons")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class PersonController {
  PersonService service;
  PersonApiMapper mapper;

  @GetMapping
  Flux<PersonResponse> findAllPersons() {
    return service.findAllPersons().map(mapper::toResponse);
  }

  @GetMapping("/{uniqueId}")
  Mono<PersonResponse> findPersonByUniqueId(@PathVariable String uniqueId) {
    return service.getByUniqueId(uniqueId).map(mapper::toResponse);
  }

  @PostMapping
  ResponseEntity<?> addPerson(@RequestBody PersonRequest request) {
    service.addPerson(mapper.toDomain(request));
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{uniqueId}")
  ResponseEntity<?> updatePerson(
      @PathVariable String uniqueId, @RequestBody PersonRequest request) {
    service.updatePerson(uniqueId, mapper.toDomain(request));
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{uniqueId}")
  ResponseEntity<?> deletePerson(@PathVariable String uniqueId) {
    service.deletePerson(uniqueId);
    return ResponseEntity.ok().build();
  }
}
