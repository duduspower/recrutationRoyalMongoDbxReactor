package com.recrutation.task.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
  Flux<Person> findAllPersons();

  Mono<Person> findByUniqueId(String uniqueId);

  void addPerson(Person person);

  void updatePerson(String uniqueId, Person person);

  void deletePerson(String uniqueId);
}
