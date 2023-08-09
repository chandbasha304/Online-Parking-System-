package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserBookings;

public interface UserBookingsImpl extends JpaRepository<UserBookings, Integer> {

}
