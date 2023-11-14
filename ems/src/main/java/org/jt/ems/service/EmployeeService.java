package org.jt.ems.service;

import org.jt.ems.config.EmployeeRepository;
import org.jt.ems.model.Employee;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (employee.isPresent()) {
            return employee.get();
        }

        return null;
    }

    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
