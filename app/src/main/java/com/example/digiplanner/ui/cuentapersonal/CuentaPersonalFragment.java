package com.example.digiplanner.ui.cuentapersonal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.digiplanner.databinding.FragmentCuentapersonalBinding;


public class CuentaPersonalFragment extends Fragment {

    private FragmentCuentapersonalBinding fragmentC;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CuentaPersonalViewModel cuentaPersonalViewModel =
                new ViewModelProvider(this).get(CuentaPersonalViewModel.class);

        fragmentC = FragmentCuentapersonalBinding.inflate(inflater, container, false);
        View root = fragmentC.getRoot();
        //elementos del layout
        final TextView textView = fragmentC.textCuenta;
        cuentaPersonalViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentC = null;
    }
}