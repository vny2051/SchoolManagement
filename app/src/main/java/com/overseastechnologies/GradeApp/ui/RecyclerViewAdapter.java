package com.overseastechnologies.GradeApp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import GradeApp.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<BooksList>  BookData;
    private Context mcontext;

    public RecyclerViewAdapter(List<BooksList> bookData, Context mcontext) {
        BookData = bookData;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        view= inflater.inflate(R.layout.book_list_row,parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.bookName.setText(BookData.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return BookData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView  bookName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookName= itemView.findViewById(R.id.pdftitle);

        }
    }
}
