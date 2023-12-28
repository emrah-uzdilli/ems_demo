package com.emrah.emsdemo.Dal;

import com.emrah.emsdemo.entities.Employee;

import java.util.List;

public interface IEmployeeDal {

    List<Employee> getAll();
    void add(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
    Employee getById(int id);


}
