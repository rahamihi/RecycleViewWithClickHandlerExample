package com.example.mamun.recycleviewwithclickhandlerexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

    private ItemClickListener itemClickListener;
    public TextView name;
    public TextView designation;

    public RecycleViewHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        designation =(TextView) itemView.findViewById(R.id.designation);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);


    }

    public void setItemClickListener(ItemClickListener itemClickListener){

        this.itemClickListener = itemClickListener;
    }



    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}


public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {
    private List<String> listname  = new ArrayList();
    private List<String> listdesignation  = new ArrayList();
    private Context context;

    public RecycleViewAdapter(List<String> listname, List<String> listdesignation,Context context) {
        this.listname = listname;
        this.listdesignation = listdesignation;
        this.context = context;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        RecycleViewHolder viewHolder = new RecycleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        holder.name.setText(listname.get(position));
        holder.designation.setText(listdesignation.get(position));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick){
                    Toast.makeText(context,"LongClick"+listname.get(position),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(context,"Click"+listname.get(position),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listname.size();
    }
}
