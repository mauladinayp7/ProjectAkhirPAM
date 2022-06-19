package com.example.quotestokoh.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotestokoh.MainActivity;
import com.example.quotestokoh.R;
import com.example.quotestokoh.database.DBController;
import com.example.quotestokoh.database.Tokoh;
import com.example.quotestokoh.edit_tokoh;
import com.example.quotestokoh.MenuActivity;
import com.example.quotestokoh.R;
import com.example.quotestokoh.database.DBController;
import com.example.quotestokoh.database.Tokoh;
import com.example.quotestokoh.database.Tokoh;

import java.util.ArrayList;
import java.util.HashMap;

public class TokohAdapter extends RecyclerView.Adapter<TokohAdapter.TemanViewHolder> {
    private ArrayList<Tokoh> listData;
    private Context control;

    public TokohAdapter(ArrayList<Tokoh> listData){this.listData = listData; }

    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        control = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.row_data_tokoh,parent,false);
        return new TemanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanViewHolder holder, int position) {
        String nm,tlp, id;

        id = listData.get(position).getId();
        nm = listData.get(position).getNama();
        tlp = listData.get(position).getQts();
        DBController db = new DBController(control);

        holder.nama.setTextColor(Color.BLUE);
        holder.nama.setTextSize(20);
        holder.nama.setText(nm);
        holder.telp.setText(tlp);

        holder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu pop = new PopupMenu(control,holder.card);
                pop.inflate(R.menu.menu);
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mnEdit:
                                Intent i = new Intent(control, edit_tokoh.class);
                                i.putExtra("id",id);
                                i.putExtra("nama",nm);
                                i.putExtra("telp",tlp);
                                control.startActivity(i);
                                break;

                            case R.id.mnDelete:
                                HashMap<String,String> val = new HashMap<>();
                                val.put("id",id);
                                db.DeleteData(val);;
                                Intent in = new Intent(control, MenuActivity.class);
                                control.startActivity(in);
                                break;
                        }
                        return true;
                    }
                });
                pop.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listData != null ? listData.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView card;
        private TextView nama,telp;
        public TemanViewHolder(View v) {
            super(v);
            card = v.findViewById(R.id.card);
            nama = v.findViewById(R.id.textNama);
            telp = v.findViewById(R.id.textTelp);
        }
    }
}