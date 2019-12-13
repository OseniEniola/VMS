package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EmpMeeting;

public interface EmpMeetingRepo extends JpaRepository<EmpMeeting, Integer> {

}
