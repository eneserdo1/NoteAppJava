package com.eneserdogan.noteappjava.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainViewmodel extends ViewModel {

    FirebaseAuth auth;
    MutableLiveData<Boolean> progressState;

    public void LoginUser(String mail, String password, final Context context){

        auth=FirebaseAuth.getInstance();
        progressState=new MutableLiveData<>();
        progressState.postValue(true);

        auth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(context,"Giriş Başarılı",Toast.LENGTH_LONG).show();
                    progressState.postValue(false);
                }else {
                    Toast.makeText(context,"Giriş Başarısız",Toast.LENGTH_LONG).show();
                    progressState.postValue(false);
                }

            }
        });

    }
}
