package com.qrx.self_crud.dao;

import com.qrx.self_crud.entity.Department;
import com.qrx.self_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "wade", "wade@163.com", 1,
                new Department(101, "E-1")));
        employees.put(1002, new Employee(1002, "paul", "paul@163.com", 1,
                new Department(102, "E-2")));
        employees.put(1003, new Employee(1003, "curry", "curry@163.com", 1,
                new Department(103, "E-3")));
        employees.put(1004, new Employee(1004, "james", "james@163.com", 1,
                new Department(104, "E-4")));
        employees.put(1005, new Employee(1005, "kobe", "kobe@163.com", 1,
                new Department(105, "E-5")));
    }

    private static Integer initId = 1006;

    //增加employee
    public void saveEmployee(Employee employee) {
        if(employee.getId() == null) {
            employee.setId(initId++);
        }

        //employee中department属性为对象
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部employee
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    //根据id查询employee
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //删除employee
    public void deleteEmployee(Integer id) {
        employees.remove(id);
    }
}
