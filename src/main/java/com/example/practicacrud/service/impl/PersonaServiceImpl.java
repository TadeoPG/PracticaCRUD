package com.example.practicacrud.service.impl;

import com.example.practicacrud.model.Person;
import com.example.practicacrud.repository.IGenericRepo;
import com.example.practicacrud.repository.IPersonRepo;
import com.example.practicacrud.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl extends CRUDImpl<Person, Integer> implements IPersonService {


    private final IPersonRepo repo;

    @Override
    public List<Person> findByNameStartsWithA(String letter) throws Exception {
        return repo.findByNameStartsWith(letter);
    }

    @Override
    protected IGenericRepo<Person, Integer> getRepo() {
        return repo;
    }
}
