package com.example.datvephim.fragment.placeholder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.datvephim.Database.ListNewsItem;
import com.example.datvephim.R;

import java.util.List;
import java.util.Map;

public class BookingFragment extends Fragment {
//    ListViewAdapter lva;
//    RecyclerView rvList;
//    RecyclerView.LayoutManager layoutManager;
//    ContactAdapter contactAdapter;
//    List<Movie> movieList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news, container, false);
//        lva = new ListViewAdapter();
//        rvList = view.findViewById(R.id.HomeListMovie);
//        rvList.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(inflater.getContext(), LinearLayoutManager.HORIZONTAL, false);
        //GetListNews(view);
        return view;
    }

    //    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        GetList(view);
//        recycleview = view.findViewById(R.id.HomeListMovie);
//        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
//        recycleview.setHasFixedSize(true);
//        MyAdapter myAdapter = new MyAdapter(getContext(),movieArrayList);
//        recycleview.setAdapter(myAdapter);
//        myAdapter.notifyDataSetChanged();
//    }


    SimpleAdapter ad;
    public void GetListNews(View view){
        ListView ltv = (ListView) view.findViewById(R.id.NewsList);
        List<Map<String, String>> MydtList=null;
        ListNewsItem MyData = new ListNewsItem();
        MydtList = MyData.getlist();
        String[] Fromw= {"Anh", "TieuDe", "NoiDungNews", "NgayDang"};
        int[] Tow={R.id.anh, R.id.TieuDe, R.id.NoiDungNews, R.id.NgayDang};
        ad = new SimpleAdapter(view.getContext(), MydtList, R.layout.home_list_movie, Fromw, Tow);
        ltv.setAdapter(ad);
    }


}