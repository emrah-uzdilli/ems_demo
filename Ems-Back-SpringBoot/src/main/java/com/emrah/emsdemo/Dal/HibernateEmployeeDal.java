package com.emrah.emsdemo.Dal;

import com.emrah.emsdemo.entities.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateEmployeeDal implements IEmployeeDal{
    EntityManager entityManager;

    @Autowired

    public HibernateEmployeeDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
        return employees;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void add(Employee employee) {
        Session session =entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }
    @SuppressWarnings("deprecation")
    @Override
    public void update(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void delete(Employee employee) {
        Session session =entityManager.unwrap(Session.class);
        Employee employeToDelete=session.get(Employee.class,employee.getId());
        session.delete(employeToDelete);
    }

    @Override
    public Employee getById(int id) {
        Session session =entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);
        return employee;
    }
}
