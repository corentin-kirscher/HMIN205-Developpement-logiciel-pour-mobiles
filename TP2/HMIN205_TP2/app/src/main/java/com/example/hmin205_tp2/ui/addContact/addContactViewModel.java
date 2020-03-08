package com.example.hmin205_tp2.ui.addContact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class addContactViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public addContactViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is an AddContact fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
