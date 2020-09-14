package com.example.newspaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<NewsData> myNewsList;
    NewsData mNewsData;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.Recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myNewsList = new ArrayList<>();


        mNewsData = new NewsData("Dawn News","Pakistani News Paper","Views.536",R.drawable.image);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("New York Times","American News Paper","Views.498",R.drawable.image2);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("Mashriq","Pakistani News Paper","Views.450",R.drawable.image3);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("Daily Mail","British News Paper","Views.430",R.drawable.image4);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("The Washington Post ","American News Paper","Views.420",R.drawable.image5);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("92 News","Pakistani News Paper","Views.400",R.drawable.image6);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("Jang News","Pakistani News Paper","Views.390",R.drawable.imgae7);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("Time Of India","Indian News Paper","Views.300",R.drawable.image8);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("The Lahoure Post","Pakistani News Paper","Views.290",R.drawable.image9);
        myNewsList.add(mNewsData);
        mNewsData = new NewsData("Ajj News","Pakistani News Paper","Views.290",R.drawable.image10);
        myNewsList.add(mNewsData);

        adapter = new MyAdapter(MainActivity.this, myNewsList);
        //MyAdapter myAdapter = new MyAdapter(MainActivity.this,myNewsList);
        mRecyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem itme = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) itme.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                adapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                if (adapter != null) {
                    System.out.println("Adapter asgsagasgasgas ");
                    //adapter.notifyDataSetChanged();
                }
                return false;

            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
