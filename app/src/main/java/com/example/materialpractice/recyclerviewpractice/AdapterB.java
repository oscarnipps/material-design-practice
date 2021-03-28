package com.example.materialpractice.recyclerviewpractice;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ItemBBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterB extends RecyclerView.Adapter<AdapterB.ItemViewHolder> {
    public static final String TAG = AdapterB.class.getSimpleName();
    private ItemBBinding mBinding;
    private Context mContext;
    public AdapterItemInterface mListener;
    private List<Product> mItems;
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();
    private Map<Integer, Product> map;


    public AdapterB(Context context, List<Product> mItems, AdapterItemInterface adapterItemInterface, Map<Integer, Product> savedProductsMap) {
        this.mContext = context;
        this.mListener = adapterItemInterface;
        this.mItems = mItems;
        this.map = savedProductsMap;
    }

    public void setItems(List<Product> products, Map<Integer, Product> savedProductsMap) {
        map.putAll(savedProductsMap);
        mItems = products;
        notifyDataSetChanged();
    }

    public interface AdapterItemInterface {

        void onShelfItemCountChanged(Product product, String countValue);

        void onShelfItemRetailPriceChanged(Product product, String priceValue);

        void onShelfItemFacingChanged(Product product, String facingValue);

        void onAdapterItemChecked(Product product, boolean isChecked);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_b, parent, false);
        return new ItemViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Product currentProduct = mItems.get(position);

        Product currentMapItem = map.get(currentProduct.getId());

        holder.itemBinding.productName.setText(currentProduct.getProductName());

        holder.itemBinding.position.setText(String.valueOf(position));

        if (!itemStateArray.get(mItems.get(position).getId(), false)) {
            holder.itemBinding.available.setChecked(false);
        } else {
            holder.itemBinding.available.setChecked(true);
        }

        holder.itemBinding.available.setOnClickListener(v -> {
            if (!itemStateArray.get(currentProduct.getId(), false)) {

                holder.itemBinding.available.setChecked(true);

                itemStateArray.put(currentProduct.getId(), true);

                map.put(currentProduct.getId(), currentProduct);

                mListener.onAdapterItemChecked(currentProduct, true);

            } else {
                holder.itemBinding.available.setChecked(false);

                itemStateArray.put(currentProduct.getId(), false);

                map.remove(currentProduct.getId());

                mListener.onAdapterItemChecked(currentProduct, false);
            }
        });


        if (currentMapItem != null && currentMapItem.getId() == currentProduct.getId()) {
            holder.itemBinding.available.setChecked(true);
            itemStateArray.put(currentProduct.getId(),true);
            holder.itemBinding.retailPriceTextVal.setText(String.valueOf(currentMapItem.getRetailPrice()));
            holder.itemBinding.facingTextVal.setText(String.valueOf(currentMapItem.getFacing()));
            holder.itemBinding.unitTextVal.setText(String.valueOf(currentMapItem.getCases()));
            return;
        }

        holder.itemBinding.retailPriceTextVal.setText(String.valueOf(currentProduct.getRetailPrice()));
        holder.itemBinding.facingTextVal.setText(String.valueOf(currentProduct.getFacing()));
        holder.itemBinding.unitTextVal.setText(String.valueOf(currentProduct.getCases()));

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemBBinding itemBinding;

        public ItemViewHolder(@NonNull ItemBBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;

            itemBinding.retailPriceTextVal.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable value) {
                    mListener.onShelfItemRetailPriceChanged(mItems.get(getAdapterPosition()), value.toString());
                }
            });

            itemBinding.unitTextVal.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable value) {
                    mListener.onShelfItemCountChanged(mItems.get(getAdapterPosition()), value.toString());
                }
            });

            itemBinding.facingTextVal.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable value) {
                    mListener.onShelfItemFacingChanged(mItems.get(getAdapterPosition()), value.toString());
                }
            });
        }
    }
}
