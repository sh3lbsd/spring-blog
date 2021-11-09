package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {


    static List<Coffee> findByRoast(String roast) {
        return null;
    }

}
