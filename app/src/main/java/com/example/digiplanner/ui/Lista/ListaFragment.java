package com.example.digiplanner.ui.Lista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EdgeEffect;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.digiplanner.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ListaFragment extends Fragment {

    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9,editText10,editText11,editText12,editText13,editText14, editText15,editText16,editText17;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUsuario;
    FloatingActionButton floatingActionButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        //ID
        editText1 = view.findViewById(R.id.edittext_1);
        editText2 = view.findViewById(R.id.edittext_2);
        editText3 = view.findViewById(R.id.edittext_3);
        editText4 = view.findViewById(R.id.edittext_4);
        editText5 = view.findViewById(R.id.edittext_5);
        editText6 = view.findViewById(R.id.edittext_6);
        editText7 = view.findViewById(R.id.edittext_7);
        editText8 = view.findViewById(R.id.edittext_8);
        editText9 = view.findViewById(R.id.edittext_9);
        editText10 = view.findViewById(R.id.edittext_10);
        editText11 = view.findViewById(R.id.edittext_11);
        editText12 = view.findViewById(R.id.edittext_12);
        editText13 = view.findViewById(R.id.edittext_13);
        editText14 = view.findViewById(R.id.edittext_14);
        editText15 = view.findViewById(R.id.edittext_15);
        editText16 = view.findViewById(R.id.edittext_16);
        editText17 = view.findViewById(R.id.edittext_17);

        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox5 = view.findViewById(R.id.checkBox5);
        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox7 = view.findViewById(R.id.checkBox7);
        checkBox8 = view.findViewById(R.id.checkBox8);
        checkBox9 = view.findViewById(R.id.checkBox9);
        checkBox10 = view.findViewById(R.id.checkBox10);
        checkBox11 = view.findViewById(R.id.checkBox11);
        checkBox12 = view.findViewById(R.id.checkBox12);
        checkBox13 = view.findViewById(R.id.checkBox13);
        checkBox14 = view.findViewById(R.id.checkBox14);
        checkBox15 = view.findViewById(R.id.checkBox15);
        checkBox16 = view.findViewById(R.id.checkBox16);
        checkBox17 = view.findViewById(R.id.checkBox17);

        floatingActionButton = view.findViewById(R.id.floatingActionButton);

        //BBDD
        firebaseUsuario = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit1 = editText1.getText().toString().trim();
                String edit2 = editText2.getText().toString().trim();
                String edit3 = editText3.getText().toString().trim();
                String edit4 = editText4.getText().toString().trim();
                String edit5 = editText5.getText().toString().trim();
                String edit6 = editText6.getText().toString().trim();
                String edit7 = editText7.getText().toString().trim();
                String edit8 = editText8.getText().toString().trim();
                String edit9 = editText9.getText().toString().trim();
                String edit10 = editText10.getText().toString().trim();
                String edit11 = editText11.getText().toString().trim();
                String edit12 = editText12.getText().toString().trim();
                String edit13 = editText13.getText().toString().trim();
                String edit14 = editText14.getText().toString().trim();
                String edit15 = editText15.getText().toString().trim();
                String edit16 = editText16.getText().toString().trim();
                String edit17 = editText17.getText().toString().trim();

                Map<String,Object> map = new HashMap<>();
                map.put("tarea1",edit1);
                map.put("tarea2",edit2);
                map.put("tarea3",edit3);
                map.put("tarea4",edit4);
                map.put("tarea5",edit5);
                map.put("tarea6",edit6);
                map.put("tarea7",edit7);
                map.put("tarea8",edit8);
                map.put("tarea9",edit9);
                map.put("tarea10",edit10);
                map.put("tarea11",edit11);
                map.put("tarea12",edit12);
                map.put("tarea13",edit13);
                map.put("tarea14",edit14);
                map.put("tarea15",edit15);
                map.put("tarea16",edit16);
                map.put("tarea17",edit17);




                firebaseFirestore.collection("listaTareas").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        });

        return view;
    }



}