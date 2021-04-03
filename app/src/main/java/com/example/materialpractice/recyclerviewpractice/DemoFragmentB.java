package com.example.materialpractice.recyclerviewpractice;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.FragmentDemoBBinding;
import com.example.materialpractice.databinding.ItemBBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * recycler view demo with checkbox and edit text
 */
public class DemoFragmentB extends Fragment implements AdapterB.AdapterItemInterface{

    public static final String TAG = DemoFragmentB.class.getSimpleName();
    private FragmentDemoBBinding binding;
    private AdapterB adapter;
    private AdapterB.AdapterItemInterface adapterItemInterface = DemoFragmentB.this;
    private Map<Integer,Product> savedProductsMap = new HashMap<>();
    private List<Product> products = new ArrayList<>();
    private int counts;
    private int facings;
    private String retailPrice;

    public static DemoFragmentB getInstance() {
        return new DemoFragmentB();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_demo_b,container,false);

        products = DataLoader.getProducts();

        savedProductsMap = DataLoader.getAddedProducts(0,1,3,4,6,7,8);

        binding.mapSize.setOnClickListener(v-> {
            String size = "items in map : " + savedProductsMap.size();
            binding.mapSize.setText(size);
        });

        Log.d(TAG, "current map item size : " + savedProductsMap.size());

        adapter = new AdapterB(requireActivity(), products,adapterItemInterface , savedProductsMap);

        binding.recyclerViewB.setLayoutManager(new LinearLayoutManager(requireActivity()));

        binding.recyclerViewB.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onShelfItemCountChanged(Product product, String countValue) {
        if (countValue.equals("") || countValue.isEmpty()) {
            return;
        }

        counts = Integer.parseInt(countValue);

        product.setCases(counts);

        if (savedProductsMap.containsKey(product.getId())) {

            savedProductsMap.put(product.getId(),product);
        }
    }

    @Override
    public void onShelfItemRetailPriceChanged(Product product, String priceValue) {
        if (priceValue.equals("") || priceValue.isEmpty()) {
            return;
        }

        retailPrice = priceValue;

        product.setRetailPrice(retailPrice);

        if (savedProductsMap.containsKey(product.getId())) {

            savedProductsMap.put(product.getId(),product);
        }
    }

    @Override
    public void onShelfItemFacingChanged(Product product, String facingValue) {
        if (facingValue.equals("") || facingValue.isEmpty()) {
            return;
        }

        facings = Integer.parseInt(facingValue);

        product.setFacing(facings);

        if (savedProductsMap.containsKey(product.getId())) {

            savedProductsMap.put(product.getId(),product);
        }
    }

    @Override
    public void onAdapterItemChecked(Product product, boolean isChecked) {
        Log.d(TAG, product.getProductName() + " checked " + isChecked);

        if (isChecked) {
            Log.d(TAG, "added " + product.getProductName() +  " to map ");

            savedProductsMap.put(product.getId(),product);

            binding.recyclerViewB.post(() -> adapter.setItems(products, savedProductsMap));

            return;
        }

        Log.d(TAG, "removed " + product.getProductName() +  " from map ");

        savedProductsMap.remove(product.getId());

        binding.recyclerViewB.post(() -> adapter.setItems(products, savedProductsMap));
    }
}