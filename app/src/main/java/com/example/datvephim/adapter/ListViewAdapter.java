package com.example.datvephim.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.datvephim.Database.JDBCController;
import com.example.datvephim.Database.Movie;
import com.example.datvephim.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter{

    private JDBCController jdbcController = new JDBCController();
    Connection connect;
    String connectResult="";
    boolean isSuccess = false;
    final ArrayList<Movie> list;

    public ListViewAdapter(ArrayList<Movie> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        //return list.get(position).getId();
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View movieView;

        if(convertView == null){
            movieView = View.inflate(parent.getContext(), R.layout.movie_layout, null);
        }else movieView = convertView;

        try{
            connect = jdbcController.ConnnectionData();
            if(connect != null){
                String query = "select * from Phim";
                Statement st = connect.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                while (resultSet.next()){
                    Movie mv = new Movie();
                    ((TextView) movieView.findViewById(R.id.MovieName)).setText(resultSet.getString("ten_phim"));
                    ((TextView) movieView.findViewById(R.id.MovieTime)).setText(resultSet.getString("thoi_luong"));
                    ((TextView) movieView.findViewById(R.id.NgayCongChieu)).setText(resultSet.getString("ngay_cong_chieu"));
                    ((TextView) movieView.findViewById(R.id.Language)).setText(resultSet.getString("NgonNgu"));
//                    ((TextView) movieView.findViewById(R.id.NoiDung)).setText(resultSet.getString("noi_dung"));
//                    ((TextView) movieView.findViewById(R.id.DaoDien)).setText(resultSet.getString("dao_dien"));
//                    ((TextView) movieView.findViewById(R.id.DienVien)).setText(resultSet.getString("dien_vien"));
                }
                connect.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieView;
    }
}
