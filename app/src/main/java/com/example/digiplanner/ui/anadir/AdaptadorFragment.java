package com.example.digiplanner.ui.anadir;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.digiplanner.R;

public class AdaptadorFragment extends AppCompatActivity {
        Context context;
        int posicionAdaptador;


        @SuppressLint("MissingInflatedId")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Toast.makeText(context,posicionAdaptador,Toast.LENGTH_SHORT).show();
            AnadirTareaCaracteristicas postitsfragment= new AnadirTareaCaracteristicas();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.nav_host_fragment_activity_main, postitsfragment);
            ft.commit();

        }
        public void onClickPosition(int posicionAdaptador){
            this.posicionAdaptador=posicionAdaptador;
        }
}