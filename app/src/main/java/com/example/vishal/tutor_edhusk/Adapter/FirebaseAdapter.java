package com.example.vishal.tutor_edhusk.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishal.tutor_edhusk.Contacted_student.my_application_detail;
import com.example.vishal.tutor_edhusk.R;

import java.util.ArrayList;

/**
 * Created by vishal on 25/06/17.
 */

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.ViewHolder> {

    ArrayList<String> list;

    public FirebaseAdapter(ArrayList<String> list, Context context) {
        this.list = list;
    }


    @Override
    public FirebaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_application_cardview,parent,false);

        ViewHolder viewHolder =  new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FirebaseAdapter.ViewHolder holder, int position) {

        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{

        protected TextView textView;

        public ViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.name_app);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"position" + " "+ textView.getText().toString(),Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(v.getContext(),my_application_detail.class);
                    i.putExtra("name", textView.getText().toString());
                    v.getContext().startActivity(i);

                }
            });


        }
    }
}
