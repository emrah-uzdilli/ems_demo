package com.emrah.emsdemo.Bal;

import com.emrah.emsdemo.Dal.IEmployeeDal;
import com.emrah.emsdemo.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeManager implements IEmployeeService{

    private IEmployeeDal employeeDal;

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
}
