package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ekle extends AppCompatActivity {

    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        btnsave = findViewById(R.id.buttonSave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText bileşenlerini tanımla
                EditText editTextShort = findViewById(R.id.editTextShort);
                EditText editTextExpansion = findViewById(R.id.editTextExpansion);

// Verileri al
                String alan1 = editTextShort.getText().toString().trim();
                String alan2 = editTextExpansion.getText().toString().trim();

// Firebase veritabanı referansı oluştur
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();

// Yeni bir veri öğesi oluştur ve Firebase veritabanına kaydet
                String newKey = myRef.push().getKey();
                myRef.child(newKey).child("Alan1").setValue(alan1);
                myRef.child(newKey).child("Alan2").setValue(alan2);

// Kaydedildiğine dair bir mesaj göster
                Toast.makeText(getApplicationContext(), "Veri kaydedildi", Toast.LENGTH_SHORT).show();
            }
        });


    }
}