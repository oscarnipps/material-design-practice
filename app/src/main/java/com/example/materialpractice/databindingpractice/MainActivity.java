package com.example.materialpractice.databindingpractice;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityMainBinding;
import com.example.materialpractice.util.ImageUtil;
import com.example.materialpractice.util.StringUtil;

public class MainActivity extends AppCompatActivity  implements EmployeeDialog.DialogListener {
    ActivityMainBinding mainBinding;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        employee = new Employee("james lawson", "finance", 80000);


        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LayoutEventHandler eventHandler = new LayoutEventHandler(this);
        //set the employee data to be used in the binding
        mainBinding.setEmployee(employee);
        //bind the string utility class to layout
        mainBinding.setStringUtil(new StringUtil());
        //bind the image utility class to layout
        mainBinding.setImageUtil(new ImageUtil());
        //bind the event listener class to the layout
        mainBinding.setLayoutEventHandler(eventHandler);
        //bind the image view
        mainBinding.setEmployeeImage( mainBinding.employeeImage);

    }

    /*when the dialog button is clicked*/
    @Override
    public void onDialogButtonClicked(String departmentName) {
        mainBinding.departmentValue.setText(departmentName);
    }
}
