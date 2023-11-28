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
class PersonServiceImpl implements PersonService {
  PersonRepository repository;

  @Override
  public Flux<Person> findAllPersons() {
    return repository.findAllPersons();
  }

  @Override
  public Mono<Person> getByUniqueId(String uniqueId) {
    return repository.findByUniqueId(uniqueId);
  }

  @Override
  public void addPerson(Person person) {
    repository.addPerson(person);
  }

  @Override
  public void updatePerson(String uniqueId, Person person) {
    repository.updatePerson(uniqueId, person);
  }

  @Override
  public void deletePerson(String uniqueId) {
    repository.deletePerson(uniqueId);
  }
}
