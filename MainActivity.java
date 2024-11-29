package com.example.freefirelauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button freeFireButton = findViewById(R.id.freeFireButton);

        freeFireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchFreeFire();
            }
        });
    }

    private void launchFreeFire() {
        String packageName = "com.dts.freefireth"; // Free Fire এর প্যাকেজ নাম

        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);

        if (intent != null) {
            // ফ্রি ফায়ার ইন্সটল থাকলে সেটি চালু করবে
            startActivity(intent);
        } else {
            // ফ্রি ফায়ার ইন্সটল না থাকলে Google Play Store-এ নিয়ে যাবে
            Toast.makeText(this, "Free Fire is not installed!", Toast.LENGTH_SHORT).show();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName)));
            } catch (Exception e) {
                Toast.makeText(this, "Play Store not found!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
