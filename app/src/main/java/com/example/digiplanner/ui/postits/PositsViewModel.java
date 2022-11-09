package com.example.digiplanner.ui.postits;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PositsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PositsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("POST");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
