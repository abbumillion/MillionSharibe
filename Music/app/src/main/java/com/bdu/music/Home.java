package com.bdu.music;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    View view;
    RecyclerView recyclerView;
    Context apctx;
    NewsAdapter newsAdapter;
    List list;
    public Home(Context apcnt) {
        // Required empty public constructor
        this.apctx=apcnt;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView= view.findViewById(R.id.news_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list=new ArrayList();
        String de="        list.add(new News(\"june 24 2020\",\"Allen walker\",\"Atalanta Georgia\",\"Science\",\"Section 3.2: Introduction To Graph Theory\\n\" +\n" +
                "                \"Graph Theory is the study of graphs, which are mathematical structures used to model pairwise relations between objects.\\n\" +\n" +
                "                \"Did you know, almost all the problems of planet Earth can be converted into problems of Roads and Cities, and solved? Graph Theory was invented many years ago, even before the invention of computer. Leonhard Euler wrote a paper on the Seven Bridges of Königsberg which is regarded as the ﬁrst paper of Graph Theory. Since then, people have come to realize that if we can convert any problem to this City-Road problem, we can solve it easily by Graph Theory.\\n\" +\n" +
                "                \"Graph Theory has many applications.One of the most common application is to ﬁnd the shortest distance between one city to another. We all know that to reach your PC, this web-page had to travel many routers from the server. Graph Theory helps it to ﬁnd out the routers that needed to be crossed. During war, which street needs to be bombarded to disconnect the capital city from others, that too can be found out using Graph Theory.\\n\" +\n" +
                "                \"GoalKicker.com – Algorithms Notes for Professionals 12\\n\" +\n" +
                "                \"Let us ﬁrst learn some basic deﬁnitions on Graph Theory.\\n\" +\n" +
                "                \"Graph:\\n\" +\n" +
                "                \"Let's say, we have 6 cities. We mark them as 1, 2, 3, 4, 5, 6. Now we connect the cities that have roads between each other.\\n\" +\n" +
                "                \"This is a simple graph where some cities are shown with the roads that are connecting them. In Graph Theory, we call each of these cities Node or Vertex and the roads are called Edge. Graph is simply a connection of these nodes and edges.\\n\" +\n" +
                "                \"A node can represent a lot of things. In some graphs, nodes represent cities, some represent airports, some represent a square in a chessboard. Edge represents the relation between each nodes. That relation can be the time to go from one airport to another, the moves of a knight from one square to all the other squares etc.\\n\" +\n" +
                "                \"GoalKicker.com – Algorithms Notes for Professionals 13\\n\" +\n" +
                "                \"                                             Path of Knight in a Chessboard\\n\" +\n" +
                "                \"In simple words, a Node represents any object and Edge represents the relation between two objects.\\n\" +\n" +
                "                \"Adjacent Node:\\n\" +\n" +
                "                \"If a node A shares an edge with node B, then B is considered to be adjacent to A. In other words, if two nodes are directly connected, they are called adjacent nodes. One node can have multiple adjacent nodes.\\n\" +\n" +
                "                \"Directed and Undirected Graph:\\n\" +\n" +
                "                \"In directed graphs, the edges have direction signs on one side, that means the edges are Unidirectional. On the other hand, the edges of undirected graphs have direction signs on both sides, that means they are Bidirectional. Usually undirected graphs are represented with no signs on the either sides of the edges.\\n\" +\n" +
                "                \"Let's assume there is a party going on. The people in the party are represented by nodes and there is an edge between two people if they shake hands. Then this graph is undirected because any person A shake hands with person B if and only if B also shakes hands with A. In contrast, if the edges from a person A to another person B corresponds to A's admiring B, then this graph is directed, because admiration is not necessarily reciprocated. The former type of graph is called an undirected graph and the edges are called undirected edges while the latter type of graph is called a directed graph and the edges are called directed edges\"))";
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        list.add(new News("june 24 2020","Allen walker","Atalanta Georgia","Science",de));
        newsAdapter=new NewsAdapter(list,getContext(),apctx);
        recyclerView.setAdapter(newsAdapter);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }

}
