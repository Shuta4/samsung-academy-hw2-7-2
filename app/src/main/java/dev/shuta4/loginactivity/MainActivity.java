package dev.shuta4.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dev.shuta4.loginactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "pass123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.login.setOnClickListener(view -> {
            String enteredUsername = binding.username.getText().toString();
            String enteredPassword = binding.password.getText().toString();
            if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
                binding.result.setText(R.string.correct);
                binding.result.setTextColor(getResources().getColor(R.color.green));
            } else {
                binding.result.setText(R.string.fail);
                binding.result.setTextColor(getResources().getColor(R.color.red));
            }
            binding.username.setText("");
            binding.password.setText("");
        });
    }
}