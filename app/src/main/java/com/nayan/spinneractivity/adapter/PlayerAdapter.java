package com.nayan.spinneractivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.nayan.spinneractivity.R;
import com.nayan.spinneractivity.model.MPlayer;
import java.util.ArrayList;

/**
 * Created by Nayan on 7/21/2017.
 */
public class PlayerAdapter extends ArrayAdapter<MPlayer> {
    private Activity activity;
    private ArrayList<MPlayer> playerArrayList;
    //    public Resources res;
    MPlayer mPlayer;
    LayoutInflater inflater;
    int rowLayout;

    /*************
     * CustomAdapter Constructor
     *****************/
    public PlayerAdapter(Activity activitySpinner, int rowLayout, ArrayList<MPlayer> objects) {
        super(activitySpinner, rowLayout, objects);

        /********** Take passed values **********/
        activity = activitySpinner;
        playerArrayList = objects;
//        res = resLocal;
        this.rowLayout = rowLayout;
        mPlayer = new MPlayer();

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

        mPlayer = playerArrayList.get(position);

        TextView name = (TextView) row.findViewById(R.id.TxtTeam);
        name.setText(mPlayer.getName());

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
