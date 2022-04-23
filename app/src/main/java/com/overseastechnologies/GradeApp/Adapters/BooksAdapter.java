package com.overseastechnologies.GradeApp.Adapters;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.overseastechnologies.GradeApp.Books;

import java.util.List;

import GradeApp.R;
import GradeApp.databinding.LayoutBooksBinding;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Books> booksList;

    public BooksAdapter(Context ctx, List<Books> booksList) {
        this.inflater = LayoutInflater.from(ctx);
        this.booksList = booksList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_books, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bId1.setText(booksList.get(position).getId().toString());
        holder.bName1.setText(booksList.get(position).getName());
        holder.bUrl1.setText(booksList.get(position).getPdfLink().toString());


    }


    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView bId, bName, bUrl;
        TextView bId1, bName1, bUrl1;
        ImageView bImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bId = itemView.findViewById(R.id.book_id);
            bName = itemView.findViewById(R.id.book_name);
            bUrl = itemView.findViewById(R.id.book_url);
            bImg = itemView.findViewById(R.id.pdfphoto);


            bId1 = itemView.findViewById(R.id.book_id1);
            bName1 = itemView.findViewById(R.id.book_name1);
            bUrl1 = itemView.findViewById(R.id.book_url1);

            bUrl1.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }
}
