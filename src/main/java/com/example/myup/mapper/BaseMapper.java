package com.example.myup.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<E, D> {
    D toDto(E entity);

    List<D> toDtos(List<E> entities);

    E toEntity(D dto);

    List<E> toEntities(List<D> toDtos);

    void update(@MappingTarget E entity, D dto);

}
