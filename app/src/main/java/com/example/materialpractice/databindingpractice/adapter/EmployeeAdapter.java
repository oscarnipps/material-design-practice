package com.example.materialpractice.databindingpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.EmployeeListItemBinding;
import com.example.materialpractice.databinding.EmployeeListItemBinding;
import com.example.materialpractice.databindingpractice.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private EmployeeListItemBinding employeeListItemBinding;
    Context context;
    List<Employee> employeeList;
    private LayoutInflater layoutInflater;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        employeeListItemBinding = DataBindingUtil.inflate(layoutInflater , R.layout.employee_list_item ,parent,false);

        return new EmployeeViewHolder( employeeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.employeeItemBinding.setEmployee(employeeList.get(position));
    }

    @Override
    public int getItemCount() {
        if (employeeList.size() == 0) {
            return 0;
        } else {
            return employeeList.size();
        }
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private EmployeeListItemBinding employeeItemBinding;

        private EmployeeViewHolder(@NonNull EmployeeListItemBinding binding) {
            super(binding.getRoot());
            this.employeeItemBinding = binding;

        }

    }
}
