package com.example.materialpractice.recyclerviewpractice;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.FragmentDemoCBinding;

/**
 * recyclerview demo with images and data binding
 */
public class DemoFragmentC extends Fragment {

    private FragmentDemoCBinding binding;

    public static DemoFragmentC getInstance() {
        return new DemoFragmentC();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_demo_c,container,false);

        AdapterA adapter = new AdapterA(requireContext(), null);

        binding.recyclerViewC.setLayoutManager(new LinearLayoutManager(requireActivity()));

        binding.recyclerViewC.setAdapter(adapter);

        return binding.getRoot();
    }
}