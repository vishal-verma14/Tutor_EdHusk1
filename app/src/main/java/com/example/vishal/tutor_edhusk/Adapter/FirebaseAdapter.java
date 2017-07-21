package com.example.vishal.tutor_edhusk.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishal.tutor_edhusk.Contacted_student.my_application_detail;
import com.example.vishal.tutor_edhusk.Model.contacted_data;
import com.example.vishal.tutor_edhusk.R;

import java.util.ArrayList;

/**
 * Created by vishal on 25/06/17.
 */

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.ViewHolder> {

    ArrayList<contacted_data> data;

    public FirebaseAdapter(ArrayList<contacted_data> list) {
        this.data = list;
    }


    @Override
    public FirebaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.contacted_card,parent,false);

        ViewHolder viewHolder =  new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FirebaseAdapter.ViewHolder holder, int position) {

        TextView name_contacted = holder.name_app;
        TextView address_contacted = holder.address_app;


        holder.name_app.setText(data.get(position).getName());
        holder.address_app.setText(data.get(position).getAddress());
        Log.d("addressFA",data.get(position).getAddress());
        holder.standard_app.setText(data.get(position).getStandard());
        Log.d("standardFA",data.get(position).getStandard());

        holder.subject_app.setText(data.get(position).getSubjects());

        holder.price_app.setText(data.get(position).getPrice_Range());
        holder.status_app.setText(data.get(position).getStatus());




    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{

        protected TextView name_app;
        protected TextView address_app;
        protected TextView standard_app;
        protected TextView subject_app;
        protected TextView price_app;
        protected TextView status_app;






        public ViewHolder(final View itemView) {
            super(itemView);
            this.name_app = (TextView) itemView.findViewById(R.id.name_app);
            this.address_app = (TextView) itemView.findViewById(R.id.address_app);
            this.standard_app =  (TextView) itemView.findViewById(R.id.standard_name_app);
            this.subject_app =  (TextView) itemView.findViewById(R.id.subject_name_app);
            this.price_app =  (TextView) itemView.findViewById(R.id.price_range_app);
            this.status_app =  (TextView) itemView.findViewById(R.id.status_app);







        }
    }
}
