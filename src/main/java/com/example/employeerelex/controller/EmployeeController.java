package com.example.employeerelex.controller;

import com.example.employeerelex.dto.EmployeeDto;
import com.example.employeerelex.dto.IdDto;
import com.example.employeerelex.entity.EmployeeEntity;
import com.example.employeerelex.service.AuthenticationService;
import com.example.employeerelex.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    private final AuthenticationService authenticationService;

    /**
     * создание нового сотрудника
     * @param employeeEntity данные, необходимые для создания нового сотрудника(
     *                       имя сотрудника,
     *                       почта сотрудника,
     *                       пароль)
     * @return созданный сотрудник
     */
    @PostMapping("/create-employee")
    public EmployeeEntity createEmployee(
            @RequestBody EmployeeDto employeeEntity
    ) {
        return authenticationService.createEmployee(employeeEntity);
    }

    /**
     * удаление сотрудника из базы данных
     * @param idDto данные, необходимые для поиска сотрудника (идентификационный номер)
     */
    @DeleteMapping("/delete-employee")
    public void deleteEmployee(
            @RequestBody IdDto idDto
            ) {
        employeeService.deleteEmployee(idDto.getEmployeeId());
    }

    /**
     * выдача прав администратора сотруднику
     * @param idDto данные, необходимые для поиска сотрудника (идентификационный номер)
     */
    @PutMapping("/update-role")
    public void updateRole(
            @RequestBody IdDto idDto
    ) {
        employeeService.updateRole(idDto);
    }
}
