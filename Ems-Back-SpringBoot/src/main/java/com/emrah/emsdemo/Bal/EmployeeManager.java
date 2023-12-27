package com.emrah.emsdemo.Bal;

import com.emrah.emsdemo.Dal.EmployeeDTO;
import com.emrah.emsdemo.Dal.IEmployeeDal;
import com.emrah.emsdemo.Dal.LoginDal;
import com.emrah.emsdemo.Repositories.EmployeeRepo;
import com.emrah.emsdemo.Responce.LoginMessage;
import com.emrah.emsdemo.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements IEmployeeService,IEmployeeLoginService{

    private IEmployeeDal employeeDal;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public EmployeeManager(IEmployeeDal employeeDal) {
        super();
        this.employeeDal = employeeDal;
    }


    @Override
    @Transactional
    public List<Employee> getAll() {
        return this.employeeDal.getAll();
    }

    @Override
    @Transactional
    public void add(Employee employee) {
    this.employeeDal.add(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
    this.employeeDal.update(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
    this.employeeDal.delete(employee);
    }

    @Override
    @Transactional
    public Employee getById(int id) {
        return this.employeeDal.getById(id);
    }


    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);

        return employee.getFirst_Name();
    }
    EmployeeDTO employeeDTO;
    @Override
    public LoginMessage  loginEmployee(LoginDal loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }


    }
}
