package com.emrah.emsdemo.RestAPI;
import com.emrah.emsdemo.Bal.IEmployeeService;
import com.emrah.emsdemo.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    IEmployeeService employeeService;


    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> get(){
        return employeeService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody Employee employee){
        employeeService.add(employee);
    }
    @PostMapping("/update")
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody Employee employee){
        employeeService.delete(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable int id){
        return employeeService.getById(id);
    }

}
