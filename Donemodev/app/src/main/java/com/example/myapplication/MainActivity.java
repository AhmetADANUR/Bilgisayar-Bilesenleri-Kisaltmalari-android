package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;



public class MainActivity extends AppCompatActivity {
EditText EditText;
TextView TextView;
Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button = findViewById(R.id.ara);
        EditText = findViewById(R.id.editText);
        TextView = findViewById(R.id.textView);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Firebase veritabanı referansı oluştur
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();

// Kullanıcının girdiği değer
                String userInput = EditText.getText().toString().trim();

// Veritabanındaki verileri dinle
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Veritabanındaki her bir veri öğesini işle
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            // Her bir veri öğesinden Alan1 ve Alan2 değerlerini al
                            String alan1 = snapshot.child("Alan1").getValue(String.class);
                            String alan2 = snapshot.child("Alan2").getValue(String.class);

                            // Eğer kullanıcının girdiği değer Alan1'e eşitse
                            if (userInput.equalsIgnoreCase(alan1)) {
                                // Alan2 değerini textView'a yaz
                                TextView.setText(alan2);
                                return; // Eşleşme bulunduğunda döngüyü sonlandır
                            }
                        }
                        // Eğer eşleşme bulunamazsa
                        TextView.setText("Eşleşme bulunamadı");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Veritabanı okuma işlemi iptal edildiğinde yapılacaklar
                        Log.w(TAG, "Veritabanından veri okuma işlemi iptal edildi", databaseError.toException());
                    }
                });


            }
        });
    }


}



