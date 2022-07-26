package com.example.dialogtest;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.viewholder> {

    Context context_;
    private updateInterface updateInterface;
    List<DialogModel> list = new ArrayList<>();

    public DialogAdapter(Context context, List<DialogModel> dialoglist,updateInterface updateInterface) {

        this.context_ = context;
        this.list = dialoglist;
        this.updateInterface=updateInterface;
    }

    public DialogAdapter(MainActivity context, List<DialogModel> list) {
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_dialog_row, parent, false);
        viewholder viewholder = new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.rowname.setText(list.get(position).getName());
        holder.rowage.setText(list.get(position).getAge());
        holder.rowaddress.setText(list.get(position).getAddress());


        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInterface.onItemClick(list.get(position) , position);

            }

        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewholder extends RecyclerView.ViewHolder {
        TextView rowname, rowage, rowaddress;
        ImageView delete;
        Button update;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            rowname = itemView.findViewById(R.id.row_name);
            rowage = itemView.findViewById(R.id.row_age);
            rowaddress = itemView.findViewById(R.id.row_address);
            delete = itemView.findViewById(R.id.delete_img);
            update = itemView.findViewById(R.id.update_btn);

        }
    }


}

