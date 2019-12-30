package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Visitor;

public interface VisitorRepo extends JpaRepository<Visitor, Integer> {
	Visitor findByVid(Integer vid);
}
