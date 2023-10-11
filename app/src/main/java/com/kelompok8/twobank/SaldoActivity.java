package com.kelompok8.twobank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SaldoActivity extends AppCompatActivity {

    private EditText amountEditText;
    private ImageView eyeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the initial selected item
        bottomNavigationView.setSelectedItemId(R.id.menu_item_1);

        // Handle item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_item_1) {
                    Intent intent = new Intent(SaldoActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_2) {
                } else if (itemId == R.id.menu_item_3) {
                    Intent intent = new Intent(SaldoActivity.this, ScanActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_4) {
                    Intent intent = new Intent(SaldoActivity.this, NotifikasiActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_5) {
                    Intent intent = new Intent(SaldoActivity.this, ProfilActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });

        amountEditText = findViewById(R.id.amountEditText);
        eyeIcon = findViewById(R.id.eyeIcon);

        eyeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ubah tampilan jumlah nominal saat tombol mata ditekan
                if (amountEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    // Jika tampilan saat ini terlihat, sembunyikan
                    amountEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    // Jika tampilan saat ini tersembunyi, tampilkan
                    amountEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
            }
        });
    }
}