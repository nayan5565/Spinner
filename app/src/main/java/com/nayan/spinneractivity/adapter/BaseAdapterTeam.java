package com.nayan.spinneractivity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nayan.spinneractivity.R;
import com.nayan.spinneractivity.model.MTeam;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/21/2017.
 */
public class BaseAdapterTeam extends BaseAdapter {
    Context context;
    //    int flags[];
    ArrayList<MTeam> teamArrayList;
    LayoutInflater inflter;
    MTeam mTeam;

    public BaseAdapterTeam(Context applicationContext, ArrayList<MTeam> teamArrayList) {
        this.context = applicationContext;
//        this.flags = flags;
        this.teamArrayList = teamArrayList;
        mTeam = new MTeam();
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return teamArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        mTeam = teamArrayList.get(i);
        view = inflter.inflate(R.layout.team_row, null);
//        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        final TextView names = (TextView) view.findViewById(R.id.TxtTeam);
        names.setText(mTeam.getTeam());
        names.setTextColor(Color.BLACK);
        names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + mTeam.getTeam(), Toast.LENGTH_SHORT).show();
                Log.e("adapter"," name "+mTeam.getTeam());
                Log.e("adapter"," pos "+i);
            }
        });
//        icon.setImageResource(flags[i]);
//        names.setText(countryNames[i]);
        return view;
    }
}
