package dev.shuta4.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import dev.shuta4.loginactivity.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.register.setOnClickListener(view -> {
            String username = binding.userpass.username.getText().toString();
            String password = binding.userpass.password.getText().toString();
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        R.string.enter_username_and_password, Toast.LENGTH_LONG).show();
                return;
            }

            Intent result = new Intent();
            result.putExtra("username", username);
            result.putExtra("password", password);
            setResult(RESULT_OK, result);
            finish();
        });
    }
}