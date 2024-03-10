package com.example.employeerelex.service;

import com.example.employeerelex.dto.EmployeeDto;
import com.example.employeerelex.entity.EmployeeEntity;
import com.example.employeerelex.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employee = EmployeeEntity.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .build();

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        EmployeeEntity employee = employeeRepository.findByEmployeeId(employeeId);

        employeeRepository.delete(employee);
    }
}
