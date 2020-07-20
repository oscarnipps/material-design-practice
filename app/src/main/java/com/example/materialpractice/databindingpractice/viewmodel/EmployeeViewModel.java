package com.example.materialpractice.databindingpractice.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.materialpractice.databindingpractice.repo.EmployeeRepository;
import com.example.materialpractice.databindingpractice.model.Employee;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {
    List<Employee> employeeList;
    EmployeeRepository employeeRepository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository(application);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.getEmployeeList();
    }
}
