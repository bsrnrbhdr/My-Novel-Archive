package com.example.MNA.ServiceInterfaces;

import com.example.MNA.Model.Foo;

import java.util.Optional;

public interface IFooService {
    Optional<Foo> findById(Long id);

    Foo save(Foo foo);

    Iterable<Foo> findAll();

}