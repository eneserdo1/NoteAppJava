package com.eneserdogan.noteappjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eneserdogan.noteappjava.R;
import com.eneserdogan.noteappjava.viewmodel.MainViewmodel;

public class MainActivity extends AppCompatActivity {
    private MainViewmodel viewmodel;
    private Button signinButton;
    private EditText mailEt, passwordEt;
    private TextView signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewmodel = ViewModelProviders.of(this).get(MainViewmodel.class);
        signinButton = findViewById(R.id.login_button_signin);
        mailEt = findViewById(R.id.login_email);
        passwordEt = findViewById(R.id.login_password);
        signUpText = findViewById(R.id.login_textview_signUp);

        ButtonListener();
    }

    private void ButtonListener() {
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = mailEt.getText().toString();
                String password = passwordEt.getText().toString();

                if (isEmpty(mail) || isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Gerekli Alanları Doldurunuz", Toast.LENGTH_LONG).show();
                } else {
                    viewmodel.LoginUser(mail, password, getApplicationContext());
                }

            }
        });

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public Boolean isEmpty(String text) {
        return text.equals("");
    }
}