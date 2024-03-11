package com.example.employeerelex.service;

import com.example.employeerelex.dto.EmployeeCreateDto;
import com.example.employeerelex.entity.EmployeeEntity;
import com.example.employeerelex.entity.Role;
import com.example.employeerelex.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    /*@Override
    public EmployeeEntity createEmployee(EmployeeCreateDto employeeEntity) {
        EmployeeEntity employee = EmployeeEntity.builder()
                .userName(employeeEntity.getUserName())
                .password(employeeEntity.getPassword())
                .email(employeeEntity.getEmail())
                .role(Role.ADMIN)
                .build();

        return employeeRepository.save(employee);
    }*/

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        EmployeeEntity employee = employeeRepository.findByEmployeeId(employeeId).orElse(null);

        employeeRepository.delete(employee);
    }

    @Override
    public void getAdmin(
            Long employeeId
    ) {
        EmployeeEntity employee = getByEmployeeId(employeeId);
        employee.setRole(Role.ADMIN);
        employeeRepository.save(employee);
    }

    /**
     * получение пользователя по имени пользователя
     * @return пользователь
     */
    public EmployeeEntity getByUsername(String username) {
        return employeeRepository.findByUserName(username).orElse(null);
    }

    /**
     * получение пользователя по идентификационному номеру
     * @return пользователь
     */
    public EmployeeEntity getByEmployeeId(Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).orElse(null);
    }
}
