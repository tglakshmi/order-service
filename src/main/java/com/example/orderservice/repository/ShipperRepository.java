package com.example.orderservice.repository;

import com.example.orderservice.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper,Long> {
}
