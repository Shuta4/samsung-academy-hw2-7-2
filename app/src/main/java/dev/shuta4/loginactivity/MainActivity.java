package dev.shuta4.loginactivity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Objects;

import dev.shuta4.loginactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    private ActivityMainBinding binding;
    private final HashMap<String, String> users = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<Integer> registerActivityLauncher = registerForActivityResult(
                new RegisterActivityContract(), result -> {
            if (result == null) {
                Log.e(TAG, "Received null from register activity.");
            } else {
                users.put(result.first, result.second);
                binding.userpass.username.setText(result.first);
                binding.userpass.password.setText("");
            }
        });

        binding.login.setOnClickListener(view -> {
            String enteredUsername = binding.userpass.username.getText().toString();
            String enteredPassword = binding.userpass.password.getText().toString();
            if (users.containsKey(enteredUsername) &&
                    Objects.equals(users.getOrDefault(enteredUsername, ""), enteredPassword)) {
                binding.result.setText(R.string.correct);
                binding.result.setTextColor(getResources().getColor(R.color.green));
            } else {
                registerActivityLauncher.launch(0);
                binding.result.setText("");
            }
            binding.userpass.username.setText("");
            binding.userpass.password.setText("");
        });
    }


}