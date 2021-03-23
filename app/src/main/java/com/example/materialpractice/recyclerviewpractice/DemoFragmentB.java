package com.example.materialpractice.recyclerviewpractice;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.FragmentDemoABinding;
import com.example.materialpractice.databinding.FragmentDemoBBinding;

/**
 * recycler view demo with checkbox and edit text
 */
public class DemoFragmentB extends Fragment {

    private FragmentDemoBBinding binding;

    public static DemoFragmentB getInstance() {
        return new DemoFragmentB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_demo_b,container,false);

        ItemAdapter adapter = new ItemAdapter(requireContext(), null);

        binding.recyclerViewB.setLayoutManager(new LinearLayoutManager(requireActivity()));

        binding.recyclerViewB.setAdapter(adapter);

        return binding.getRoot();
    }
}