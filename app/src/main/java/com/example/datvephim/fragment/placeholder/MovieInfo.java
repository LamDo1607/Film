package com.example.datvephim.fragment.placeholder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.datvephim.Database.JDBCController;
import com.example.datvephim.Database.ListMovieItem;
import com.example.datvephim.Database.Movie;
import com.example.datvephim.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieInfo extends Fragment {
    private JDBCController jdbcController = new JDBCController();
    Movie movie;
    Connection connect;
    String connectResult = "";
    boolean isSuccess = false;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_layout, container, false);
        GetData(view);

        return view;
    }

    public void  GetData(View view) {
        ImageView poster =  view.findViewById(R.id.MoviePoster);
        TextView tenPhim =  view.findViewById(R.id.MovieName);
        TextView thoiLuong = view.findViewById(R.id.MovieTime);
        TextView ngayChieu = view.findViewById(R.id.NgayCongChieu);
        TextView ngonNgu = view.findViewById(R.id.Language);
        TextView noiDung = view.findViewById(R.id.NoiDung);
        TextView daoDien = view.findViewById(R.id.DaoDien);
        TextView dienVien = view.findViewById(R.id.DienVien);
        try {
            connect = jdbcController.ConnnectionData();
            if (connect != null) {
                String query = "select * from Phim id = 1";
                Statement st = connect.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                while (resultSet.next()){
                    poster.setImageResource(movie.setAnh(resultSet.getByte("Banner")));
                    tenPhim.setText(movie.setTenPhim(resultSet.getString("ten_phim")));
                    thoiLuong.setText(movie.setThoiLuong(resultSet.getString("thoi_luong")));
                    ngayChieu.setText(movie.setNgayCongChieu(resultSet.getString("ngay_cong_chieu")));
                    ngonNgu.setText(movie.setNgonNgu(resultSet.getString("NgonNgu")));
                    noiDung.setText(movie.setNoiDung(resultSet.getString("noi_dung")));
                    daoDien.setText(movie.setDaoDien(resultSet.getString("dao_dien")));
                    dienVien.setText(movie.setDienVien(resultSet.getString("dien_vien")));
                }
                connectResult ="Success";
                isSuccess = true;
                connect.close();
            }
            else{
                connectResult ="Failed";
                isSuccess = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
