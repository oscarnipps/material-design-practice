package com.example.materialpractice.recyclerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.AdapterItemBinding;
import com.example.materialpractice.databindingpractice.Employee;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private AdapterItemBinding mBinding;
    private Context mContext;
    public AdapterItemInterface mInterfaceListener;
    private List<Employee> mItems;
    private int expandedPosition = -1;
    private int previousExpandedPosition = -1;

    public ItemAdapter(Context mContext, List<Employee> mItems) {
        this.mContext = mContext;
        //this.mInterfaceListener = mInterfaceListener;
        this.mItems = mItems;
    }

    public interface AdapterItemInterface {
        void onAdapterItemClicked(AdapterItemBinding binding);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_item, parent, false);
        return new ItemViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        //populate the items here but for demo sake do nothing , since the views would be using pre-defined
        //data

        final boolean isExpanded = position == expandedPosition;

        holder.itemBinding.detailsPanel.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemBinding.getRoot().setActivated(isExpanded);

        if (isExpanded) previousExpandedPosition = position;

        holder.itemBinding.scheduleArrowUp.setOnClickListener(v -> {
            expandedPosition = isExpanded ? -1 : position;
            notifyItemChanged(previousExpandedPosition);
            notifyItemChanged(position);
            /*mInterfaceListener.onAdapterItemClicked(holder.itemBinding);*/
        });
    }

    @Override
    public int getItemCount() {
        //return actual size here if not null but for demo sake , use a defined number
        //since there'd be no actual list backing up the data and the item layout would be using static values
        return 7;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        AdapterItemBinding itemBinding;


        public ItemViewHolder(@NonNull AdapterItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
            /*itemBinding.scheduleArrowUp.setOnClickListener(v -> mInterfaceListener.onAdapterItemClicked(itemBinding));*/
        }
    }
}
