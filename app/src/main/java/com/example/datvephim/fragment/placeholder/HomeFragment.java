package com.example.datvephim.fragment.placeholder;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;


import com.example.datvephim.Database.ListMovieItem;
import com.example.datvephim.Database.Movie;
import com.example.datvephim.adapter.MovieAdapter;
import com.example.datvephim.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HomeFragment extends Fragment {
    Movie movie;
    MovieAdapter movieAdap;
    ListMovieItem listMovieItem = new ListMovieItem();
    ListView lvMovie;
    ArrayList<Movie> arrayMV;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking, container, false);

        //SetRecords();
        GetList(view);
        return view;
    }
//    public void SetRecords(){
//        ArrayList<Movie> dt = new ArrayList<>(listMovieItem.getlist());
//        movieAdap = new MovieAdapter(getActivity(), dt);
//        lvMovie.setAdapter(movieAdap);
//    }






    SimpleAdapter ad;
    public void GetList(View view) {
        ListView ltv = (ListView) view.findViewById(R.id.List_movie);
        List<Map<String, String>> MydtList = null;
        ListMovieItem MyData = new ListMovieItem();
        MydtList = MyData.getlist();
        String[] Fromw = {"MoviePosterMini", "MovieNameMini", "MovieTimeMini", "NgayChieuMini"};
        int[] Tow = {R.id.MoviePosterMini, R.id.MovieNameMini, R.id.MovieTimeMini, R.id.NgayChieuMini};
        ad = new SimpleAdapter(view.getContext(), MydtList, R.layout.mini_movie_layout, Fromw, Tow);
        ltv.setAdapter(ad);
        ltv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.content_frame, new FinishPostFragment()).commit();
            }
        });
    }



    public static class FinishPostFragment extends Fragment {
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.movie_layout, container, false);

            return v;
        }
    }
}