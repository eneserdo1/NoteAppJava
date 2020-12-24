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

public class SignUpViewmodel extends ViewModel {
    private FirebaseAuth auth;
    MutableLiveData<Boolean> progressState= new MutableLiveData<>();

    public void createUser(String name, String password, final Context context) {
        auth = FirebaseAuth.getInstance();
        progressState.setValue(true);

        auth.createUserWithEmailAndPassword(name, password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(context, "Kayıt Başarılı", Toast.LENGTH_LONG).show();
                            progressState.setValue(false);
                        }else {
                            Toast.makeText(context, "Kayıt Başarısız", Toast.LENGTH_LONG).show();
                            progressState.setValue(false);
                        }

                    }
                }
        );
    }
}
