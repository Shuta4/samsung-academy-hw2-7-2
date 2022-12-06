package dev.shuta4.loginactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RegisterActivityContract extends ActivityResultContract<Integer, Pair<String, String>> {

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, Integer i) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public Pair<String, String> parseResult(int resultCode, @Nullable Intent intent) {
        if (resultCode != Activity.RESULT_OK) return null;
        assert intent != null;

        return new Pair<>(
                intent.getStringExtra("username"),
                intent.getStringExtra("password"));
    }
}
