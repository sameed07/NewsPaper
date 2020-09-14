package com.example.newspaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<NewsViewHolder>  {

      public Context mContext;
      public  List<NewsData> myNewsList;
    public ArrayList<NewsData> arrayListFiltered;
    public List<NewsData> myOriginalResult;

    public MyAdapter(Context mContext, List<NewsData> myNewsList) {
        this.mContext = mContext;
        this.myNewsList = myNewsList;
        arrayListFiltered = new ArrayList<>();
        myOriginalResult = myNewsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int i) {
        View mView = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.recycler_row_itme,ViewGroup,false);

        return new NewsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder newsViewHolder, int i) {

        newsViewHolder.imageView.setImageResource(myNewsList.get(i).getItmeImage());
        newsViewHolder.mName.setText(myNewsList.get(i).getItmeName());
        newsViewHolder.mDescription.setText(myNewsList.get(i).getItmeDescription());
        newsViewHolder.mView.setText(myNewsList.get(i).getItmeView());

        newsViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,DetailActivity.class);

                intent.putExtra("image",myNewsList.get(newsViewHolder.getAdapterPosition()).getItmeImage());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return myNewsList.size(); }


    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                System.out.println("qwwerty12354555555555342525252 " + charString);
                if (charString.isEmpty()) {
                   // myNewsList = myOriginalResult;
                    System.out.println("qwwerty12354555555555342525252 Empty " + charString);

                    arrayListFiltered = (ArrayList<NewsData>) myOriginalResult;
                } else {
                    ArrayList<NewsData> filteredList = new ArrayList<>();
//                    System.out.println("qwwerty12354555555555342525252 Arraylist " + myNewsList.get(0).getItmeName());

                    for (NewsData row : myNewsList) {
                        System.out.println("qwwerty12354555555555342525252 Loop" + charString);

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getItmeName().toLowerCase().contains(charString.toLowerCase()) || row.getItmeName().contains(charSequence)) {
                            filteredList.add(row);
                            System.out.println("qwwerty12354555555555342525252 Loop Selected " + row.getItmeName());
                        }
                    }

                    arrayListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = arrayListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            myNewsList = new ArrayList<>();

                myNewsList = (ArrayList<NewsData>) filterResults.values;
                if(myNewsList == null || myNewsList.size() == 0){
                    myNewsList = myOriginalResult;
                    System.out.println("qwwerty12354555555555342525252 Publish Re");
                }
              //  System.out.println("qwwerty12354555555555342525252 Publish Res " + arrayListFiltered.get(0).getItmeName());
                notifyDataSetChanged();
            }
        };
    }
}
class NewsViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView  mName,mDescription,mView;
    CardView  mCardView;

    public NewsViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.ivImage);
        mName =  itemView.findViewById(R.id.tvTittel);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mView = itemView.findViewById(R.id.tvView);
        mCardView = itemView. findViewById(R.id.mycardview);
    }


}
