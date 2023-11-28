package com.recrutation.task.infrastructure;

import com.recrutation.task.domain.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface PersonEntityMapper {
  Person toDomain(PersonEntity entity);
  PersonEntity toEntity(Person domain);
}
