package com.qrx.self_crud.dao;

import com.qrx.self_crud.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "E-1"));
        departments.put(102, new Department(102, "E-2"));
        departments.put(103, new Department(103, "E-3"));
        departments.put(104, new Department(104, "E-4"));
        departments.put(105, new Department(105, "E-5"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }
}
