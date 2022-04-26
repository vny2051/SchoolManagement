package com.overseastechnologies.GradeApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.overseastechnologies.GradeApp.models.Liveclass;

import java.util.List;

import GradeApp.R;

public class LiveClassAdapter extends RecyclerView.Adapter<LiveClassAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Liveclass> liveClass;


    public  LiveClassAdapter(Context ctx ,List<Liveclass> liveClass){

        this.inflater=LayoutInflater.from(ctx);
        this.liveClass=liveClass;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_liveclass_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subject.setText(liveClass.get(position).getSubjectName());
   // picasso.get().load
    }

    @Override
    public int getItemCount() {
        return  liveClass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView subject;
        ImageView linkcover;



        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            subject =itemView.findViewById(R.id.subject);
            linkcover=itemView.findViewById(R.id.link_cover);
        }
    }
}
