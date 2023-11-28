package com.recrutation.task.infrastructure;

import com.recrutation.task.domain.Person;
import com.recrutation.task.domain.PersonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class PersonRepositoryImpl implements PersonRepository {
  PersonMongoRepository mongoRepository;
  PersonEntityMapper mapper;

  @Override
  public Flux<Person> findAllPersons() {
    return Flux.fromStream(mongoRepository.findAll().stream().map(mapper::toDomain));
  }

  @Override
  public Mono<Person> findByUniqueId(String uniqueId) {
    return mongoRepository
        .findById(uniqueId)
        .map(mapper::toDomain)
        .map(Mono::just)
        .orElseGet(Mono::empty);
  }

  @Override
  public void addPerson(Person person) {
    mongoRepository.save(mapper.toEntity(person));
  }

  @Override
  public void updatePerson(String uniqueId, Person person) {
    mongoRepository.deleteById(uniqueId);
    addPerson(person);
  }

  @Override
  public void deletePerson(String uniqueId) {
    mongoRepository.deleteById(uniqueId);
  }
}
