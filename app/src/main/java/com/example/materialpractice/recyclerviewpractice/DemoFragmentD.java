package com.example.materialpractice.recyclerviewpractice;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.FragmentDemoBBinding;
import com.example.materialpractice.databinding.FragmentDemoDBinding;

/**
 * recyclerview demo with diff util
 */
public class DemoFragmentD extends Fragment {

    private FragmentDemoDBinding binding;

    public static DemoFragmentD getInstance() {
        return new DemoFragmentD();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_demo_d,container,false);

        ItemAdapter adapter = new ItemAdapter(requireContext(), null);

        binding.recyclerViewD.setLayoutManager(new LinearLayoutManager(requireActivity()));

        binding.recyclerViewD.setAdapter(adapter);

        return binding.getRoot();
    }
}