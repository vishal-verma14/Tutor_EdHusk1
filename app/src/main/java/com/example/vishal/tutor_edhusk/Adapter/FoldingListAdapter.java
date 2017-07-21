package com.example.vishal.tutor_edhusk.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vishal.tutor_edhusk.Model.Student_data;
import com.example.vishal.tutor_edhusk.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by vishal on 19/06/17.
 */

public class FoldingListAdapter extends ArrayAdapter<Student_data> {

    ArrayList<Student_data> student_list;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;


    public FoldingListAdapter(Context context, int resource, ArrayList<Student_data> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student_data data = getItem(position);

        FoldingCell cell = (FoldingCell) convertView;

        ViewHolder viewHolder;

        if (cell == null){
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell,parent,false);
            viewHolder.Name = (TextView) cell.findViewById(R.id.name_title);
           viewHolder.ContentName = (TextView) cell.findViewById(R.id.content_name_text);
            viewHolder.ContentAddress  =(TextView) cell.findViewById(R.id.address_content_text);
            viewHolder.Address = (TextView) cell.findViewById(R.id.address);
            viewHolder.Price_Range = (TextView) cell.findViewById(R.id.price_range);
            viewHolder.Standard =  (TextView) cell.findViewById(R.id.standard_name);
            viewHolder.ContentStandard = (TextView) cell.findViewById(R.id.class_content_text);
            viewHolder.subjects = (TextView) cell.findViewById(R.id.subject_name);
            viewHolder.Contentsubjects = (TextView) cell.findViewById(R.id.Subject_content_text);
            viewHolder.Board = (TextView) cell.findViewById(R.id.Board_content);
            viewHolder.days = (TextView) cell.findViewById(R.id.days_content);
            viewHolder.Type = (TextView) cell.findViewById(R.id.type_content);
            viewHolder.Travel = (TextView) cell.findViewById(R.id.travel_content);
            viewHolder.slots = (TextView) cell.findViewById(R.id.slots_content);
            viewHolder.Price_Range = (TextView) cell.findViewById(R.id.price_range);
            viewHolder.ContentPrice = (TextView) cell.findViewById(R.id.price_range_content);
            viewHolder.Location = (TextView) cell.findViewById(R.id.location_content);
            viewHolder.Gender = (TextView) cell.findViewById(R.id.gender_content);



            viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);


        }
        else {

            viewHolder = (ViewHolder) cell.getTag();

        }


        viewHolder.Name.setText(data.getName());
        viewHolder.ContentName.setText(data.getContentName());
        viewHolder.Location.setText(data.getLocation());
        viewHolder.subjects.setText(data.getSubjects());
        viewHolder.Contentsubjects.setText(data.getContentSubjects());

        viewHolder.Standard.setText(data.getStandard());
        viewHolder.ContentStandard.setText(data.getContentStandard());

        viewHolder.slots.setText(data.getSlots());

        viewHolder.Address.setText(data.getAddress());
        viewHolder.ContentAddress.setText(data.getContentAddress());

        viewHolder.Board.setText(data.getBoard());
        viewHolder.Type.setText(data.getType());
        viewHolder.days.setText(data.getDays());
        viewHolder.Travel.setText(data.getTravel());
        viewHolder.Gender.setText(data.getGender());

        viewHolder.Price_Range.setText(data.getPrice_Range());
        viewHolder.ContentPrice.setText(data.getContentPrice_Range());




        viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);

        return cell;

    }

    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }



    private static class ViewHolder {

        TextView Board;
        TextView Type;
        TextView Travel;
        TextView Location;
        TextView Gender;
        TextView Name;
        TextView ContentName;
        TextView ContentAddress;

        TextView Standard;
        TextView ContentStandard;

        TextView Address;
        TextView id;
        TextView Created_At;
        TextView Price_Range;
        TextView ContentPrice;
        TextView Lat;
        TextView Long;
        TextView subjects;
        TextView Contentsubjects;

        TextView days;
        TextView slots;


        TextView contentRequestBtn;
    }

}
