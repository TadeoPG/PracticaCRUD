package com.example.practicacrud.controler;

import com.example.practicacrud.model.Person;
import com.example.practicacrud.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

    private final IPersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> readAll() throws Exception {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> readById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(service.readById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Person> create(@RequestBody Person person) throws Exception {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable("id") Integer id) throws Exception {
        person.setIdPerson(id);
        return new ResponseEntity<>(service.update(person, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
