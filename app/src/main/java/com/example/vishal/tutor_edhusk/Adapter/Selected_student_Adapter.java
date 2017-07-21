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
import com.example.vishal.tutor_edhusk.Model.Selected_student;
import com.example.vishal.tutor_edhusk.Model.contacted_data;
import com.example.vishal.tutor_edhusk.R;

import java.util.ArrayList;

/**
 * Created by vishalverma on 21/07/17.
 */

    public class Selected_student_Adapter extends RecyclerView.Adapter<Selected_student_Adapter.Selected_ViewHolder> {

    ArrayList<Selected_student> data;

    public Selected_student_Adapter(ArrayList<Selected_student> list) {
        this.data = list;
    }


    @Override
    public Selected_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_cardview,parent,false);

        Selected_student_Adapter.Selected_ViewHolder viewHolder =  new Selected_student_Adapter.Selected_ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Selected_ViewHolder holder, int position) {


        TextView name_contacted = holder.name_selected;
        TextView address_contacted = holder.address_selected;


        holder.name_selected.setText(data.get(position).getName());
        holder.address_selected.setText(data.get(position).getAddress());
        holder.standard_selected.setText(data.get(position).getStandard());

        holder.subject_selected.setText(data.get(position).getSubjects());

        holder.price_selected.setText(data.get(position).getPrice_Range());
        holder.status_selected.setText(data.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class Selected_ViewHolder  extends RecyclerView.ViewHolder{

        protected TextView name_selected;
        protected TextView address_selected;
        protected TextView standard_selected;
        protected TextView subject_selected;
        protected TextView price_selected;
        protected TextView status_selected;






        public Selected_ViewHolder(final View itemView) {
            super(itemView);
            this.name_selected = (TextView) itemView.findViewById(R.id.name_selected);
            this.address_selected = (TextView) itemView.findViewById(R.id.address_selected);
            this.standard_selected =  (TextView) itemView.findViewById(R.id.standard_name_selected);
            this.subject_selected =  (TextView) itemView.findViewById(R.id.subject_name_selected);
            this.price_selected =  (TextView) itemView.findViewById(R.id.price_range_selected);
            this.status_selected =  (TextView) itemView.findViewById(R.id.status_selected);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"position" + " "+ name_selected.getText().toString(),Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(v.getContext(),my_application_detail.class);
                    i.putExtra("name", name_selected.getText().toString());
                    v.getContext().startActivity(i);

                }
            });


        }
    }

}
