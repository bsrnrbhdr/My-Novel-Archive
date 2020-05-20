package com.example.MNA.ModelRepository;

import com.example.MNA.Model.Foo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFooRepository extends PagingAndSortingRepository<Foo, Long> {
}