package com.nayan.spinneractivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nayan.spinneractivity.R;
import com.nayan.spinneractivity.model.MTeam;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/21/2017.
 */
public class TeamAdapter extends ArrayAdapter<MTeam> {
    private Activity activity;
    private ArrayList<MTeam> teamArrayList;
    //    public Resources res;
    MTeam mTeam;
    LayoutInflater inflater;
    int rowLayout;

    /*************
     * CustomAdapter Constructor
     *****************/
    public TeamAdapter(Activity activitySpinner, int rowLayout, ArrayList<MTeam> objects) {
        super(activitySpinner, rowLayout, objects);

        /********** Take passed values **********/
        activity = activitySpinner;
        teamArrayList = objects;
//        res = resLocal;
        this.rowLayout = rowLayout;
        mTeam = new MTeam();

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

    // This funtion called for each row ( Called teamArrayList.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        View row = inflater.inflate(rowLayout, parent, false);

        /***** Get each Model object from Arraylist ********/

        mTeam = teamArrayList.get(position);

        TextView team = (TextView) row.findViewById(R.id.TxtTeam);
        TextView rank = (TextView) row.findViewById(R.id.txtRank);
        team.setText(mTeam.getTeam());
        rank.setText(mTeam.getRank() + "");

//        if (position == 0) {
//
//            // Default selected Spinner item
//            team.setText("Please select company");
//        } else {
//            // Set values for spinner each row
//            team.setText(mTeam.getTeam());
//
//        }

        return row;
    }
}
