package com.kfd.e_felling;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    EditText editText_username, editText_password;
    Button login_click;
    String userName, password;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.editText_username)
    EditText editTextUsername;
    @BindView(R.id.username)
    TextInputLayout username;
    @BindView(R.id.editText_password)
    EditText editTextPassword;
    @BindView(R.id.password)
    TextInputLayout password;
    @BindView(R.id.login_click)
    Button loginClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        initViews();
        initListener();
    }

    private void initListener() {
        login_click.setOnClickListener(this);
    }

    private void initViews() {

        editText_username = findViewById(R.id.editText_username);
        editText_password = findViewById(R.id.editText_password);
        login_click = findViewById(R.id.login_click);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_click:

                if (validate()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                break;

        }
    }

    private boolean validate() {
        userName = editText_username.getText().toString();
        password = editText_password.getText().toString();
        if (userName.isEmpty()) {
            Toast.makeText(this, "Please Enter username", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
