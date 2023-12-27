package com.emrah.emsdemo.Bal;

import com.emrah.emsdemo.Dal.EmployeeDTO;
import com.emrah.emsdemo.Dal.EmployeeDal;
import com.emrah.emsdemo.Dal.LoginDal;
import com.emrah.emsdemo.Responce.LoginMessage;

public interface IEmployeeLoginService {
    String addEmployee(EmployeeDTO employeeDTO);


    LoginMessage  loginEmployee(LoginDal loginDTO);
}
