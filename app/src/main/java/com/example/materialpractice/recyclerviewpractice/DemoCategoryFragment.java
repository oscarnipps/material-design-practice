package com.example.materialpractice.recyclerviewpractice;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.FragmentRecyclerViewDemoCategoryBinding;

public class DemoCategoryFragment extends Fragment {

    public DemoCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentRecyclerViewDemoCategoryBinding binding =
                DataBindingUtil.inflate(inflater,R.layout.fragment_recycler_view_demo_category,container,false);


        return binding.getRoot();
    }

}