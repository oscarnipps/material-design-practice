package com.example.materialpractice.databindingpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityEmployeeBinding;
import com.example.materialpractice.databindingpractice.adapter.EmployeeAdapter;
import com.example.materialpractice.databindingpractice.viewmodel.EmployeeViewModel;

/* uses data binding with a recycler view, view model and a repository*/
public class EmployeeActivity extends AppCompatActivity {

    ActivityEmployeeBinding activityEmployeeBinding;
    EmployeeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get view model instance
        EmployeeViewModel employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        //bind activity
        activityEmployeeBinding = DataBindingUtil.setContentView(this , R.layout.activity_employee);
        //get recycler view
        RecyclerView employeeListRecyclerview = activityEmployeeBinding.employeeListRecyclerview;
        //get employee data
        mAdapter = new EmployeeAdapter(this , employeeViewModel.getEmployeeList());
        employeeListRecyclerview.setAdapter(mAdapter);
        employeeListRecyclerview.setLayoutManager(new LinearLayoutManager(this));


    }
}
