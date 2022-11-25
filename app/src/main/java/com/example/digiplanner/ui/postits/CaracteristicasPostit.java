package com.example.digiplanner.ui.postits;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.digiplanner.R;
import com.example.digiplanner.databinding.FragmentHomeBinding;

public class CaracteristicasPostit extends Fragment {

    private FragmentHomeBinding fragmentH;
    GridView grid;
    Context context;
    String[] numero = {"1","2","3","4","5","6","7"};


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        return view;
    }
}
