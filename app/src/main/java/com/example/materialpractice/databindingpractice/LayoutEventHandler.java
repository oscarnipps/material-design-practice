package com.example.materialpractice.databindingpractice;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class LayoutEventHandler {

    Context context;

    public LayoutEventHandler(Context context) {
        this.context = context;
    }

    public void onButtonClicked(View view) {
        Toast.makeText(context, "view id  " + view.getId(), Toast.LENGTH_SHORT).show();
    }


    /*shows a dialog to set a new employee*/
    public void showEmployeeDialog() {
        FragmentActivity activity = (FragmentActivity) context;
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        EmployeeDialog dialog = EmployeeDialog.getInstance();
        dialog.show(ft, "employee_dialog_tag");
    }


}
