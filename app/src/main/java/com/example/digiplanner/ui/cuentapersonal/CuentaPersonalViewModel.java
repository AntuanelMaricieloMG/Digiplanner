package com.example.digiplanner.ui.cuentapersonal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CuentaPersonalViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CuentaPersonalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cuenta");
    }

    public LiveData<String> getText() {
        return mText;
    }
}