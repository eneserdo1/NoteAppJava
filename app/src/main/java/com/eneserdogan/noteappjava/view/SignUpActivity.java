package com.eneserdogan.noteappjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eneserdogan.noteappjava.R;
import com.eneserdogan.noteappjava.viewmodel.SignUpViewmodel;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private SignUpViewmodel viewModel;
    private Button signUpButton;
    private EditText mailEt,passwordEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        viewModel= ViewModelProviders.of(this).get(SignUpViewmodel.class);
        signUpButton=findViewById(R.id.signUp_button_signup);
        mailEt=findViewById(R.id.signUp_email);
        passwordEt=findViewById(R.id.signUp_password);

        ButtonListener();

    }

    private void ButtonListener() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=mailEt.getText().toString();
                String password = passwordEt.getText().toString();
                if (isEmpty(mail) || isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Gerekli Alanları Doldurunux",Toast.LENGTH_LONG).show();

                }else {
                    viewModel.createUser(mail,password,getApplicationContext());

                }
            }
        });

    }

    private Boolean isEmpty(String text){
        return text.equals("");
    }
}