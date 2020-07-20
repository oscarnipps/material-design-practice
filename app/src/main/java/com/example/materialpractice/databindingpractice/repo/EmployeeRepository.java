package com.example.materialpractice.databindingpractice.repo;

import android.content.Context;

import com.example.materialpractice.databindingpractice.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    Context context;
    private List<Employee> employeeList;

    public EmployeeRepository(Context context) {
        this.context = context;
    }


    /*method to imitate getting response from server or query result from database*/
    public List<Employee> getEmployeeList() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jason mars" , "finance" ,100000));
        employeeList.add(new Employee("Wilson davies" , "engineering" ,100000));
        employeeList.add(new Employee("Jason thomas" , "operations" ,200000));
        employeeList.add(new Employee("richard trevor mars" , "finance" ,50000));
        employeeList.add(new Employee("kennedy andrew" , "technology" ,300000));
        employeeList.add(new Employee("Jason mars" , "finance" ,150000));
        return employeeList;
    }
}
