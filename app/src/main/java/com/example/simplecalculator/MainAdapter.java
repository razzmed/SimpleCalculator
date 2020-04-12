package com.example.simplecalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<String> data;

    public MainAdapter() {
        data = new ArrayList<>();
    }
    public void upDate(ArrayList <String> results){
        data = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.textView.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
