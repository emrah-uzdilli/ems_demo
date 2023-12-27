package com.emrah.emsdemo.RestAPI;
import com.emrah.emsdemo.Bal.IEmployeeLoginService;
import com.emrah.emsdemo.Bal.IEmployeeService;
import com.emrah.emsdemo.Dal.EmployeeDTO;
import com.emrah.emsdemo.Dal.LoginDal;
import com.emrah.emsdemo.Responce.LoginMessage;
import com.emrah.emsdemo.entities.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    IEmployeeService employeeService;
    IEmployeeLoginService employeeLoginService;

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


    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        String id = employeeLoginService.addEmployee(employeeDTO);
        return id;

    }
    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDal loginDTO) {

            LoginMessage loginMesage = employeeLoginService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginMesage);

    }
}
