package com.example.vishal.tutor_edhusk.Adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vishal.tutor_edhusk.Model.student_data;
import com.example.vishal.tutor_edhusk.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by vishal on 19/06/17.
 */

public class FoldingListAdapter extends ArrayAdapter<student_data> {

    ArrayList<student_data> student_list;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;


    public FoldingListAdapter(Context context, int resource, ArrayList<student_data> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        student_data data = getItem(position);

        FoldingCell cell = (FoldingCell) convertView;

        ViewHolder viewHolder;

        if (cell == null){
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell,parent,false);
            viewHolder.Name = (TextView) cell.findViewById(R.id.name);
            viewHolder.Location = (TextView) cell.findViewById(R.id.address);
           viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);


        }
        else {

            viewHolder = (ViewHolder) cell.getTag();

        }

        //noinspection ConstantConditions
        viewHolder.Name.setText(data.getName());
        viewHolder.Location.setText(data.getLocation());
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
        TextView Type;
        TextView Travel;
        TextView Location;
        TextView Gender;
        TextView Name;
        TextView contentRequestBtn;
        TextView Contact;
        TextView Email;
        TextView Plot;
        TextView Age;
        TextView Street;
        TextView Landmark;
        TextView Comment;
        TextView subjects;
        TextView days;
        TextView slots;
    }

}
