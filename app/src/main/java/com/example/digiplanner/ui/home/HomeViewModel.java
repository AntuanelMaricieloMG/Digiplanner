package com.example.digiplanner.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    // LiveData solo actualiza observadores de componentes cuando estado de ciclo de vida activo.
    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("HOME");
    }

    public LiveData<String> getText() {
        return mText;
    }
}