package com.nayan.spinneractivity.model;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/21/2017.
 */
public class MTeam {
    private int id;
    private String team;
    private ArrayList<MPlayer> playerArrayList;

    public ArrayList<MPlayer> getPlayerArrayList() {
        return playerArrayList;
    }

    public void setPlayerArrayList(ArrayList<MPlayer> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
