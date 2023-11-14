package org.jt.ems.controller;

import org.jt.ems.model.Employee;
import org.jt.ems.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @RequestMapping({ "/", "/home" })
    public String home(Model model) {
        var employees = employeeService.getEmployeeList();
        model.addAttribute("employees", employees);
        // return "list_emp";
        return "home";
    }

    @GetMapping("/addemp")
    public String addEmployee() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        // return "redirect:/add_emp";
        return "redirect:/home";
    }

    // @GetMapping("/reademp")
    // public String listEmployees(Model model) {
    // var employees = employeeService.getEmployeeList();
    // model.addAttribute("employees", employees);
    // return "read_emp";
    // }

    @GetMapping("/edit/{employeeId}")
    public String editEmployee(@PathVariable int employeeId, Model model) {
        var Employee = employeeService.getEmployeeById(employeeId);
        System.out.println("hii");
        model.addAttribute("employee", Employee);
        return "edit_emp";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        // return "redirect:/reademp";
        return "redirect:/home";
    }

}
