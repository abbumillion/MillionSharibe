package com.bdu.music;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewholder> {
        List list;
        Context context;
        Context context1;
        News news;


        public NewsAdapter(List list,Context context,Context appcont)
        {
            this.list=list;
            this.context=context;
            this.context1=appcont;
        }
        @NonNull
        @Override
        public NewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=  LayoutInflater.from(context).inflate(R.layout.single_news,parent,false);
            return new NewsViewholder(view);
        }

        public List getList() {
            return list;
        }

        public void setList(List list) {
            this.list = list;
        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        @Override
        public void onBindViewHolder(@NonNull NewsViewholder holder, int position) {
             news=(News) list.get(position);
            holder.date.setText(news.getDate());
            holder.location.setText(news.getLocation());
            holder.report.setText(news.getReporter());
        }

        @Override
        public int getItemCount()
        {
            return list.size();
        }
        class  NewsViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView type;
            TextView date;
            TextView location;
            TextView report;

            public NewsViewholder(@NonNull View itemView)  {
                super(itemView);
                date=itemView.findViewById(R.id.date);
                location=itemView.findViewById(R.id.location);
                report=itemView.findViewById(R.id.reporter);
                itemView.setClickable(true);
                itemView.setOnClickListener(this);

                // myAlertBuilder.show();


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
                //myAlertBuilder.show();
                News news=(News) list.get(getLayoutPosition());
                final Intent intent = new Intent(context1, NewsDetail.class);
                String []values={news.getDate(),news.getReporter(),news.getLocation()};
                intent.putExtra("news",values);
                context.startActivity(intent);
            }
        }}

