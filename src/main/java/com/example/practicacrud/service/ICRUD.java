package com.example.practicacrud.service;

import java.util.List;

public interface ICRUD<T, ID> {

    List<T> readAll() throws Exception;

    T readById(ID id) throws Exception;

    T create(T t) throws Exception;

    T update(T t, ID id) throws Exception;

    void delete(ID id) throws Exception;
}
