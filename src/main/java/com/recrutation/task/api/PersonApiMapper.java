package com.recrutation.task.api;

import com.recrutation.task.domain.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface PersonApiMapper {

  Person toDomain(PersonRequest request);
  PersonResponse toResponse(Person domain);

}
