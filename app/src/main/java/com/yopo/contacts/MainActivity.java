package com.yopo.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etDescription;

    private DatePicker dpBirth;
    Integer day;
    Integer month;
    Integer year;
    String date;

    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dpBirth = (DatePicker) findViewById(R.id.dpBirth);

        /*SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        Date d = new Date(year, month, day);
        String strDate = dateFormatter.format(d);*/

        etName = (EditText) findViewById(R.id.etFullName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescription = (EditText) findViewById(R.id.etDescription);

        final Button btNext = (Button) findViewById(R.id.btNext);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                day = dpBirth.getDayOfMonth();
                month = dpBirth.getMonth() + 1;
                year = dpBirth.getYear();
                date = day.toString() + "/" + month.toString() + "/" + year.toString();
                
                contact = new Contact(etName.getText().toString(), date, etPhone.getText().toString(), etEmail.getText().toString(), etDescription.getText().toString());

                Intent toCP = new Intent(MainActivity.this, ContactPreview.class);
                toCP.putExtra(getResources().getString(R.string.pName), contact.getName());
                toCP.putExtra(getResources().getString(R.string.pBirth), contact.getDate());
                toCP.putExtra(getResources().getString(R.string.pPhone), contact.getPhone());
                toCP.putExtra(getResources().getString(R.string.pEmail), contact.getEmail());
                toCP.putExtra(getResources().getString(R.string.pDescription), contact.getDescription());
                startActivity(toCP);
            }
        });
    }
}