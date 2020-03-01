package com.bdu.music;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {
    View view;
    RecyclerView recyclerView;
    List list;
    UserAdapter userAdapter;
    Context apc;
    public Dashboard(Context context) {
        this.apc=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen;
        view=inflater.inflate(R.layout.fragment_dashboard, container, false);
        list=new ArrayList<>();
        DatabaseHelper databaseHelper=new DatabaseHelper(getContext());
        list=databaseHelper.getAllData();
        recyclerView= view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        userAdapter=new UserAdapter(list,getContext(),apc);
        recyclerView.setAdapter(userAdapter);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }

}
