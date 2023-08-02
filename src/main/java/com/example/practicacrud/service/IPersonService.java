package com.example.practicacrud.service;

import com.example.practicacrud.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonService extends ICRUD<Person, Integer> {

    List<Person> findByNameStartsWithA(String letter) throws Exception;
}
