package com.nayan.spinneractivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nayan.spinneractivity.R;
import com.nayan.spinneractivity.model.MTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nayan on 7/21/2017.
 */
public class TeamAdapter extends ArrayAdapter<MTeam> {
    private Activity activity;
    private ArrayList data;
    public Resources res;
    MTeam tempValues = null;
    LayoutInflater inflater;

    /*************
     * CustomAdapter Constructor
     *****************/
    public TeamAdapter(
            Activity activitySpinner,
            int textViewResourceId,
            ArrayList objects,
            Resources resLocal
    ) {
        super(activitySpinner, textViewResourceId, objects);

        /********** Take passed values **********/
        activity = activitySpinner;
        data = objects;
        res = resLocal;

        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        View row = inflater.inflate(R.layout.team_row, parent, false);

        /***** Get each Model object from Arraylist ********/
        tempValues = null;
        tempValues = (MTeam) data.get(position);

        TextView team = (TextView) row.findViewById(R.id.TxtTeam);
        team.setText(tempValues.getTeam());

//        if (position == 0) {
//
//            // Default selected Spinner item
//            team.setText("Please select company");
//        } else {
//            // Set values for spinner each row
//            team.setText(tempValues.getTeam());
//
//        }

        return row;
    }
}
