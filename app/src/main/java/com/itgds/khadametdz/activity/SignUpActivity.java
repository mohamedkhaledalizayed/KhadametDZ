package com.itgds.khadametdz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.itgds.khadametdz.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signIn(View view) {
        startActivity(new Intent(this, SignInActivity.class));
    }

    public void signUp(View view) {
    }
}
