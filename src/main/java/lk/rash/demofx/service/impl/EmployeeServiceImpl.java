package lk.rash.demofx.service.impl;

import lk.rash.demofx.db.Database;
import lk.rash.demofx.dto.EmployeeDto;
import lk.rash.demofx.entity.Employee;
import lk.rash.demofx.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public boolean saveEmployee(EmployeeDto employeeDto) {
        Database.employees.add(new Employee(
                employeeDto.getIdNo(),
                employeeDto.getName(),
                employeeDto.getAdress(),
                employeeDto.getPosition()
        ));
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return Database.employees.removeIf(emp -> emp.getIdNo() == id);
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {
        for (Employee emp : Database.employees) {
            if (emp.getIdNo() == employeeDto.getIdNo()) {
                emp.setName(employeeDto.getName());
                emp.setAdress(employeeDto.getAdress());
                emp.setPosition(employeeDto.getPosition());

                System.out.println("Welcome");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> list = new ArrayList<>();
        for (Employee emp : Database.employees) {
            list.add(new EmployeeDto(emp.getIdNo(), emp.getName(), emp.getAdress(), emp.getPosition()));
        }
        return list;
    }

    @Override
    public EmployeeDto searchEmployee(int id) {
        for (Employee emp : Database.employees) {
            if (emp.getIdNo() == id) {
                return new EmployeeDto(emp.getIdNo(), emp.getName(), emp.getAdress(), emp.getPosition());
            }
        }
        return null;
    }
}
