package com.bala.crazycoins.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContestViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is contest fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}