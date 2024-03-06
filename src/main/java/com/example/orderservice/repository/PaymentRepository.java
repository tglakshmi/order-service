package com.example.orderservice.repository;

import com.example.orderservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment,Long> {
}
