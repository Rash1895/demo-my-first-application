package lk.rash.demofx.service;

import lk.rash.demofx.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    boolean saveEmployee(EmployeeDto employeeDto);
    boolean deleteEmployee(int id);
    boolean updateEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto searchEmployee(int id);
}
