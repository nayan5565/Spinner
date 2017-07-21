package com.nayan.spinneractivity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nayan.spinneractivity.R;
import com.nayan.spinneractivity.model.MTeam;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/21/2017.
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MTeam> teamArrayList;
    private MTeam mTeam;
    private View view;


    public TeamAdapter(Context context) {
        this.context = context;
        teamArrayList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MTeam> teamArrayList) {
        this.teamArrayList = teamArrayList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.team_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mTeam = teamArrayList.get(position);
        holder.textView.setText(mTeam.getTeam());

    }

    @Override
    public int getItemCount() {
        return teamArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.TxtTeam);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTeam = teamArrayList.get(getAdapterPosition());

                }
            });

        }
    }
}
