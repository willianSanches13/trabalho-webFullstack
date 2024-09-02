package org.example.services;

import javassist.NotFoundException;

import java.util.List;

public interface GenericService <T, ID> {

    T save(T entity);
    T update(T entity) throws NotFoundException;
    void delete(ID id) throws NotFoundException;
    T findById(ID id) throws NotFoundException;
    List<T> findAll();
}
