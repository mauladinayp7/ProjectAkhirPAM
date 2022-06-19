package com.example.quotestokoh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quotestokoh.database.DBController;
import com.example.quotestokoh.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class edit_tokoh extends AppCompatActivity {

    private TextInputEditText tNama,tQuotes;
    private Button saveBtn;
    String nm,qts,id;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tokoh_baru);

        tNama = findViewById(R.id.edNama);
        tQuotes = findViewById(R.id.edQuotes);
        saveBtn = findViewById(R.id.saveBtn);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        qts = getIntent().getStringExtra("qts");


        setTitle("Edit Data");
        tNama.setText(nm);
        tQuotes.setText(qts);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tNama.getText().toString().equals("") || tQuotes.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Data belum lengkap!",Toast.LENGTH_LONG).show();
                }else{
                    nm = tNama.getText().toString();
                    qts = tQuotes.getText().toString();
                    HashMap<String,String> val = new HashMap<>();
                    val.put("id",id);
                    val.put("nama",nm);
                    val.put("qts",qts);
                    controller.UpdateData(val);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent i = new Intent(edit_tokoh.this,MenuActivity.class);
        startActivity(i);
        finish();
    }
}
