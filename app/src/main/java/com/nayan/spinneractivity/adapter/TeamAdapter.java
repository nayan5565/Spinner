package com.nayan.spinneractivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.nayan.spinneractivity.R;
import com.nayan.spinneractivity.model.MTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nayan on 7/21/2017.
 */
public class TeamAdapter extends ArrayAdapter<MTeam> {
    LayoutInflater flater;

    public TeamAdapter(Activity context, int resouceId,  ArrayList<MTeam> list) {

        super(context, resouceId, list);
        flater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MTeam rowItem = getItem(position);

        View rowview = flater.inflate(R.layout.team_row, null, true);

        TextView txtTeam = (TextView) rowview.findViewById(R.id.TxtTeam);
        txtTeam.setText(rowItem.getTeam());


        return rowview;
    }
}
