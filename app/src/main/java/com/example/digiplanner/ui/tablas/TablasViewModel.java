package com.example.digiplanner.ui.tablas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TablasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TablasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TABLAS");
    }

    public LiveData<String> getText() {
        return mText;
    }
}