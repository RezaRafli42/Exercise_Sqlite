package com.example.exersqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton klik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        klik = findViewById(R.id.add);

        klik.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                pindah();
            }
        });
    }

    public void pindah() {
        Intent intent = new Intent(MainActivity.this, tambah_data.class);
        startActivity(intent);
    }
}
