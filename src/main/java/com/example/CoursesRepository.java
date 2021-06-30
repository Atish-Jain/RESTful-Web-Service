package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

//Jpa Repository for perfroming CRUD operations in DB
public interface CoursesRepository extends JpaRepository<Courses,Integer>{

}
