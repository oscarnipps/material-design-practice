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

/**
 * recycler view demo with collapsible card item
 */
public class DemoFragmentA extends Fragment {

    private FragmentDemoABinding binding;

    public DemoFragmentA() {
        // Required empty public constructor
    }

    public static DemoFragmentA getInstance() {
        return new DemoFragmentA();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_demo_a,container,false);

        ItemAdapter adapter = new ItemAdapter(requireContext(), null);

        binding.recyclerViewA.setLayoutManager(new LinearLayoutManager(requireActivity()));

        binding.recyclerViewA.setAdapter(adapter);

        return binding.getRoot();
    }
}