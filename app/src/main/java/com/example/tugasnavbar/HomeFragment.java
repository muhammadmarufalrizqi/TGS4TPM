package com.example.tugasnavbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<HeroModel> heroModels = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View a = inflater.inflate(R.layout.fragment_home,container,false);
        super.onCreate(savedInstanceState);

        recyclerView = a.findViewById(R.id.rv_Hero);
        recyclerView.setHasFixedSize(true);
        heroModels.addAll(HeroData.getListData());

        showRecyclerList();
        return a;
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HeroAdapter heroAdapter = new HeroAdapter(getContext());
        heroAdapter.setHeroModels(heroModels);
        recyclerView.setAdapter(heroAdapter);
    }
}
