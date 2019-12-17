package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VisitorsMeeting;

public interface VisitorMeetingRepo extends JpaRepository<VisitorsMeeting, Integer> {

}
