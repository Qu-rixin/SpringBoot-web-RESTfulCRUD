package com.qrx.self_crud.controller;

import com.qrx.self_crud.dao.DepartmentDao;
import com.qrx.self_crud.dao.EmployeeDao;
import com.qrx.self_crud.entity.Department;
import com.qrx.self_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/showallemps")
    public String listAllEmployees(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        //放在请求域
        model.addAttribute("employees", employees);
        return "list_employees";
    }

    //来到添加员工列表页面
    @GetMapping("/toaddemp")
    public String toAddEmployeePage(Model model) {
        //查出所有部门并显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "add_employees";
    }

    //员工添加
    @PostMapping("/addemp")
    public String addEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
        return "redirect:/showallemps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/showallemps/{id}")
    public String toEditEmployeePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "add_employees";
    }

    //员工修改
    @PutMapping("/addemp")
    public String updateEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
        return "redirect:/showallemps";
    }

    //员工删除
    @DeleteMapping("/showallemps/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployee(id);
        return "redirect:/showallemps";
    }
}
