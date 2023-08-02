package com.example.practicacrud.service.impl;

import com.example.practicacrud.repository.IGenericRepo;
import com.example.practicacrud.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("ID NOT FOUND");
        });
    }

    @Override
    public T create(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("ID NOT FOUND");
        });
        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new IllegalArgumentException("ID NOT FOUND"));
        getRepo().deleteById(id);
    }
}
