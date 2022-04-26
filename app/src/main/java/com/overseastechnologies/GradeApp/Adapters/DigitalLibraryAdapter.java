package com.overseastechnologies.GradeApp.adapters;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.overseastechnologies.GradeApp.Books;
import com.overseastechnologies.GradeApp.models.DigitalLibrary;

import java.util.List;

import GradeApp.R;

public class DigitalLibraryAdapter extends RecyclerView.Adapter<DigitalLibraryAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<DigitalLibrary> digitalLibraryList;

    public DigitalLibraryAdapter(Context ctx, List<DigitalLibrary> digitalLibraryList) {
        this.inflater = LayoutInflater.from(ctx);
        this.digitalLibraryList = digitalLibraryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_digital_library, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subject_name1.setText(digitalLibraryList.get(position).getSubject());
        holder.material_type1.setText(digitalLibraryList.get(position).getType());
        holder.material_url1.setText(digitalLibraryList.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return digitalLibraryList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject_name1, material_type1, material_url1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            subject_name1 = itemView.findViewById(R.id.subject_name1);
            material_type1 = itemView.findViewById(R.id.material_type1);
            material_url1 = itemView.findViewById(R.id.material_url1);

        }
    }
}