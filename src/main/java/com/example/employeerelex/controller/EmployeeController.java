package com.example.employeerelex.controller;

import com.example.employeerelex.dto.EmployeeDto;
import com.example.employeerelex.entity.EmployeeEntity;
import com.example.employeerelex.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * создание и добавление нового сотрудника в базу данных
     * @param employeeDto данные, необходимые для создания нового сотрудника(
     *                    имя сотрудника,
     *                    фамилия сотрудника,
     *                    почта)
     * @return созданный сотрудник
     */
    @PostMapping("/createEmployee")
    public EmployeeEntity createEmployee(
            @RequestBody EmployeeDto employeeDto
            ) {
        return employeeService.createEmployee(employeeDto);
    }

    /**
     * удаление сотрудника из базы данных
     * @param employeeId идентификационный номер сотрудника
     */
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployee(
            @PathVariable Long employeeId
    ) {
        employeeService.deleteEmployee(employeeId);
    }
}
