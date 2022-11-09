package com.example.digiplanner.ui.anadir;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnadirViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AnadirViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("AÑADIR");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
