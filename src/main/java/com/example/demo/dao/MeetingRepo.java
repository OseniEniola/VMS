package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Meeting;

public interface MeetingRepo extends JpaRepository<Meeting, Integer> {

}
