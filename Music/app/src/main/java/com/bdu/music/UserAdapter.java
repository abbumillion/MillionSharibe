package com.bdu.music;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List list;
    Context context;
    Context apcont;
    User user;


    public UserAdapter(List list,Context context,Context appcont)
    {
        this.list=list;
        this.context=context;
        this.apcont=appcont;
    }
    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=  LayoutInflater.from(context).inflate(R.layout.user_lister,parent,false);


        return new UserViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            user=(User) list.get(position);
           holder.phone.setText(user.getPhone()+user.getPassword());
           holder.email.setText(user.getEmail()+user.getSex());
           holder.username.setText(user.getUsername()+user.getFname());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
     class  UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView phone;
         TextView username;
         TextView email;
        public UserViewHolder(@NonNull View itemView)  {
            super(itemView);
            phone=itemView.findViewById(R.id.phone);
            username=itemView.findViewById(R.id.username);
            email=itemView.findViewById(R.id.email);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    list.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return  true;
                }
            });
     }
         @Override
         public void onClick(View v) {
                User user=(User) list.get(getLayoutPosition());
                final Intent intent = new Intent(apcont, DetailActivity.class);
             Toast.makeText(context,user.getFname()+user.getEmail()+user.getSex(),Toast.LENGTH_SHORT).show();

             String []values={user.getFname(),user.getEmail(),user.getSex(),user.getPhone(),user.getUsername(),user.getPassword()};
                intent.putExtra("user",values);
                context.startActivity(intent);
         }
     }}
