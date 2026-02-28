package com.Vcube.Asserts.SB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vcube.Asserts.SB.modal.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}
