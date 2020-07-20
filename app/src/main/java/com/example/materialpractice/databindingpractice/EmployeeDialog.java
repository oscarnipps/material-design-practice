package com.example.materialpractice.databindingpractice;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.EmployeeDialogBinding;

public class EmployeeDialog extends DialogFragment {

    DialogListener mListener;
    EmployeeDialogBinding mBinding;

    interface DialogListener{
        void onDialogButtonClicked(String departmentName);
    }

    public static EmployeeDialog getInstance() {
        return new EmployeeDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater , R.layout.employee_dialog,container,false);
        mBinding.dialogAddStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departmentName = mBinding.departmentNameEditText.getText().toString();
                mListener.onDialogButtonClicked(departmentName);
                dismiss();
            }
        });
        return mBinding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        try {
            mListener = (DialogListener) context;
        } catch (ClassCastException e) {
        }
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int heigth = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setLayout(width,heigth);
    }
}
