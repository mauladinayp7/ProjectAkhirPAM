package com.example.quotestokoh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quotestokoh.database.Tokoh;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button btnSignin;


    private EditText Email, Password;

    String e_mail, passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        btnSignin = findViewById(R.id.signin);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();

                e_mail = Email.getText().toString();
                passw = Password.getText().toString();

                String mail = "lala";
                String pass = "lala";

                if(e_mail.isEmpty() || passw.isEmpty()){
                    Email.setError("email tidak boleh kosong!");
                    Password.setError("password tidak boleh kosong!");
                }else{
                    if(e_mail.equals(mail) && passw.equals((pass))){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "login berhasil", Toast.LENGTH_LONG);
                        t.show();

                        Bundle bund = new Bundle();

                        bund.putString("f", e_mail.trim());
                        bund.putString("g", passw.trim());

                        Intent i=new Intent(getApplicationContext(), MenuActivity.class);

                        i.putExtras(bund);

                        startActivity(i);
                    }else if (e_mail.equals(mail)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Password salah!", Toast.LENGTH_LONG);
                        t.show();
                    }else if(passw.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email salah!", Toast.LENGTH_LONG);
                        t.show();
                    }else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "username dan password salah!", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }

}