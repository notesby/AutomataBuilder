package com.justforfun.automatabuilder.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.databinding.*;

/**
 * Created by hectormoreno on 11/19/17.
 */

public class BindingViewHolder extends RecyclerView.ViewHolder {
    ViewDataBinding binding;

    public BindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ViewDataBinding getBinding()
    {
        return binding;
    }
}
