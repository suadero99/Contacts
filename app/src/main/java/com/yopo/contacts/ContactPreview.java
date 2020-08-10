package com.yopo.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactPreview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_preview);

        Bundle parameters = getIntent().getExtras();
        String name = parameters.getString(getResources().getString(R.string.pName));
        String date = parameters.getString(getResources().getString(R.string.pBirth));
        String phone = parameters.getString(getResources().getString(R.string.pPhone));
        String email = parameters.getString(getResources().getString(R.string.pEmail));
        String description = parameters.getString(getResources().getString(R.string.pDescription));

        TextView tvName = (TextView) findViewById(R.id.cpName);
        TextView tvDate = (TextView) findViewById(R.id.cpDate);
        TextView tvPhone= (TextView) findViewById(R.id.cpPhone);
        TextView tvEmail = (TextView) findViewById(R.id.cpEmail);
        TextView tvDescription = (TextView) findViewById(R.id.cpDescription);

        tvName.setText("Nombre: " + name);
        tvDate.setText("Fecha de nacimiento: " + date);
        tvPhone.setText("Teléfono: " + phone);
        tvEmail.setText("E-mail: " + email);
        tvDescription.setText("Descripción: " + description);

        final Button btBack = (Button) findViewById(R.id.btBack);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMain = new Intent(ContactPreview.this, MainActivity.class);
                startActivity(toMain);
            }
        });
    }
}