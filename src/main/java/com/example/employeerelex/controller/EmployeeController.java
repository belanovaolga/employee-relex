package com.example.employeerelex.controller;

import com.example.employeerelex.dto.EmployeeCreateDto;
import com.example.employeerelex.entity.EmployeeEntity;
import com.example.employeerelex.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * создание и добавление нового сотрудника в базу данных
     * @param employeeEntity данные, необходимые для создания нового сотрудника(
     *                    имя сотрудника,
     *                    фамилия сотрудника,
     *                    почта)
     * @return созданный сотрудник
     */
    /*@PostMapping("/createEmployee")
    //@PreAuthorize("hasRole('ADMIN')")
    public EmployeeEntity createEmployee(
            @RequestBody EmployeeCreateDto employeeEntity
            ) {
        return employeeService.createEmployee(employeeEntity);
    }*/

    /**
     * удаление сотрудника из базы данных
     * @param employeeId идентификационный номер сотрудника
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployee(
            @PathVariable Long employeeId
    ) {
        employeeService.deleteEmployee(employeeId);
    }

    /**
     * выдача прав администратора сотруднику
     * @param employeeId идентификационный номер пользователя
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateRole/getAdmin/{employeeId}")
    public void getAdmin(
            @PathVariable Long employeeId
    ) {
        employeeService.getAdmin(employeeId);
    }
}
