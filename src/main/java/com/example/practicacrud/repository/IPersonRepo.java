package com.example.practicacrud.repository;

import com.example.practicacrud.model.Person;

import java.util.List;

public interface IPersonRepo extends IGenericRepo<Person, Integer> {

    List<Person> findByNameStartsWith(String letter);

}
