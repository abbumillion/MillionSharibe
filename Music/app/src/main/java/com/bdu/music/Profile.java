package com.bdu.music;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {

 View view;
 TextView username;
 TextView password;
 Button logout;
 TextView email;
 Context context;
    public Profile(Context context) {
        // Required empty public constructor
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        email=view.findViewById(R.id.pemail);
        password=view.findViewById(R.id.ppassword);
        logout=view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,LoginActivity.class);
                startActivity(intent);
            }
        });
        return  view;
    }
    public void Logout(Context context)
    {
        Intent intent=new Intent(getContext(),LoginActivity.class);
        startActivity(intent);
    }

}
