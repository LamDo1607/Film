package com.example.datvephim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datvephim.Database.Movie;
import com.example.datvephim.R;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Movie> mvList;

    public MovieAdapter(Context context, int layout, List<Movie> mvList) {
        this.context = context;
        this.mvList = mvList;
    }

    public class Holder{
        TextView MoviewName;
        TextView MovieTime;
        TextView NgayChieu;
        TextView Language;
        TextView NoiDung;
        TextView DaoDien;
        TextView DienVien;
        ImageView MoviePoster;
    }

    @Override
    public int getCount() {
        return mvList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        Movie dtmovie = getItem(position);
//        Holder viewHolder;
//        if(convertView == null){
//            viewHolder = new Holder();
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            convertView = inflater.inflate(R.layout.booking ,parent, false);
//            viewHolder.MoviewName = convertView.findViewById(R.id.MovieNameMini);
//            viewHolder.MovieTime = convertView.findViewById(R.id.MovieTimeMini);
//            viewHolder.NgayChieu = convertView.findViewById(R.id.NgayChieuMini);
//            viewHolder.MoviePoster = convertView.findViewById(R.id.MoviePosterMini);
//            convertView.setTag(viewHolder);
//        }else {
//            viewHolder = (Holder) convertView.getTag();
//        }
//        viewHolder.MoviewName.setText(dtmovie.getTenPhim());
//        viewHolder.MovieTime.setText(dtmovie.getThoiLuong());
//        viewHolder.NgayChieu.setText(dtmovie.getNgayCongChieu());
//        viewHolder.MoviePoster.setImageResource(dtmovie.getAnh());

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, parent);
        TextView Name = convertView.findViewById(R.id.MovieTimeMini);
        TextView Time = convertView.findViewById(R.id.MovieTimeMini);
        TextView Ngay = convertView.findViewById(R.id.NgayChieuMini);
        //ImageView Poster = convertView.findViewById(R.id.MoviePosterMini);

        Movie movie = mvList.get(position);
        Name.setText(movie.getTenPhim());
        Time.setText(movie.getThoiLuong());
        Ngay.setText(movie.getNgayCongChieu());
        //Poster.setImageResource(movie.getAnh());
        return convertView;
    }
}
