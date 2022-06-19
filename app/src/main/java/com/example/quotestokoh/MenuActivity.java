package com.example.quotestokoh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quotestokoh.adapter.TokohAdapter;
import com.example.quotestokoh.database.DBController;
import com.example.quotestokoh.database.Tokoh;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView rv;
    private TokohAdapter adapter;
    private ArrayList<Tokoh> temanArrayList;
    private FloatingActionButton fab;
    DBController dbc = new DBController(this);

    private static final String TAG = MenuActivity.class.getSimpleName();
    private static String url_select = "https://20200140035project.praktikumtiumy.com/readdatanew.php";
    private static final String TAG_ID = "id";
    private static final String TAG_NAMA = "nama";
    private static final String TAG_QUOTES = "quotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        rv = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        readData();
        adapter = new TokohAdapter(temanArrayList);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(MenuActivity.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, TokohBaru.class);
                startActivity(i);
            }
        });

    }

    public void readData() {
        ArrayList<HashMap<String, String>> listTeman = dbc.getAllTeman();
        temanArrayList = new ArrayList<>();
//        Pindah hasil query
        for (int i = 0; i < listTeman.size(); i++) {
            Tokoh t = new Tokoh();
            t.setId(listTeman.get(i).get("id").toString());
            t.setNama(listTeman.get(i).get("nama").toString());
            t.setQts(listTeman.get(i).get("telp").toString());
//            Masukkan ke arrayList
            temanArrayList.add(t);
        }
    }
}

