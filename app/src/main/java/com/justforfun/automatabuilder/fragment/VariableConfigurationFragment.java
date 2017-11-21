package com.justforfun.automatabuilder.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.justforfun.automatabuilder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VariableConfigurationFragment extends Fragment {


    public VariableConfigurationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_variable_configuration, container, false);
    }

}
