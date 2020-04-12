package com.example.simplecalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoButton extends AppCompatActivity {

    private TextView total2;
    private Button share;
    MainAdapter adapter;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_button);

        list = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.open_calculator);
        total2 = findViewById(R.id.vh_text_view);
        share = findViewById(R.id.open_share);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoButton.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list != null) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, list.toString());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            list.add(0, data.getStringExtra("result"));
            Log.e("ololo", "onActivityResult: " + data.getStringExtra("result"));
            adapter.upDate(list);
            adapter.notifyDataSetChanged();
        }
    }
}
