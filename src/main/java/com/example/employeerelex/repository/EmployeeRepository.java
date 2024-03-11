package com.example.employeerelex.repository;

import com.example.employeerelex.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmployeeId(Long employeeId);

    Optional<EmployeeEntity> findByUserName(String userName);
}
