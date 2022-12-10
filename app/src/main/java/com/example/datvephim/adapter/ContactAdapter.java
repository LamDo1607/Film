package com.example.datvephim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datvephim.Database.Movie;
import com.example.datvephim.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    List<Movie> movieList;
    Context context;
    RecyclerView recyclerView;
    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tenphim;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageHome);
            tenphim = itemView.findViewById(R.id.tenphim);
        }
    }

    public ContactAdapter (Context context, List<Movie> movieList, RecyclerView recyclerView){
        this.context = context;
        this.movieList = movieList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news, viewGroup, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        //holder.imageView.setImageResource(movie.getAnh());
        holder.tenphim.setText(movie.getTenPhim());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
        }
    }
}
