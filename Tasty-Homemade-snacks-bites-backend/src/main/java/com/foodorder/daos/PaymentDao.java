package com.foodorder.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorder.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

}
