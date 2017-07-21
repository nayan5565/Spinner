package com.nayan.spinneractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nayan.spinneractivity.adapter.BaseAdapterTeam;
import com.nayan.spinneractivity.adapter.TeamAdapter;
import com.nayan.spinneractivity.model.MPlayer;
import com.nayan.spinneractivity.model.MTeam;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private MPlayer mPlayer;
    private MTeam mTeam;
    private ArrayList<MPlayer> playerArrayList;
    private ArrayList<MTeam> teamArrayList;
    private Spinner spinnerTeam;
    private Spinner spinnerPlayers;
    private TeamAdapter teamAdapter;
    private BaseAdapterTeam baseAdapterTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        generate();
        preparedisplay();

        // Spinner element


//        // Spinner Drop down elements
//        List<String> teams = new ArrayList<String>();
//        teams.add("Australia");
//        teams.add("Bangladesh");
//        teams.add("England");
//        teams.add("Pakistan");
//        teams.add("India");
//        teams.add("Srilanka");
//        List<String> players = new ArrayList<String>();
//        players.add("Tamim");
//        players.add("Mashrafi");
//        players.add("Shakib");
//        players.add("Musfiq");
//        players.add("Mustafiz");
//        players.add("Sabbir");
//
//        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teams);
//        ArrayAdapter<String> dataAdapterPlayer = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, players);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        dataAdapterPlayer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
//        spinnerTeam.setAdapter(dataAdapter);
//        spinnerPlayers.setAdapter(dataAdapterPlayer);
    }

    private void preparedisplay() {
//        teamAdapter = new TeamAdapter(MainActivity.this,
//                R.layout.team_row, teamArrayList);
//        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        baseAdapterTeam=new BaseAdapterTeam(getApplicationContext(),teamArrayList);

        spinnerTeam.setAdapter(baseAdapterTeam);
    }

    private void init() {
        spinnerTeam = (Spinner) findViewById(R.id.spinnerTeam);
        spinnerPlayers = (Spinner) findViewById(R.id.spinnerPlayer);

        // Spinner click listener
        spinnerTeam.setOnItemSelectedListener(this);
        spinnerPlayers.setOnItemSelectedListener(this);

    }

    private void generate() {
        teamArrayList = new ArrayList<>();
        playerArrayList = new ArrayList<>();

        mTeam = new MTeam();
        mTeam.setId(1);
        mTeam.setTeam("Australia");

        mPlayer = new MPlayer();
        mPlayer.setName("Smith");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Warner");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Finch");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Strac");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Maxwell");
        playerArrayList.add(mPlayer);
        mTeam.setPlayerArrayList(playerArrayList);
        teamArrayList.add(mTeam);

        mTeam = new MTeam();
        mTeam.setId(2);
        mTeam.setTeam("Bangladesh");

        mPlayer = new MPlayer();
        mPlayer.setName("Tamim");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Musfiq");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Mashrafi");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Shakib");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Sabbir");
        playerArrayList.add(mPlayer);
        mTeam.setPlayerArrayList(playerArrayList);
        teamArrayList.add(mTeam);

        mTeam = new MTeam();
        mTeam.setId(3);
        mTeam.setTeam("India");

        mPlayer = new MPlayer();
        mPlayer.setName("Kohli");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Rohit");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Dhoni");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Shami");
        playerArrayList.add(mPlayer);

        mPlayer = new MPlayer();
        mPlayer.setName("Yuvraj");
        playerArrayList.add(mPlayer);
        mTeam.setPlayerArrayList(playerArrayList);
        teamArrayList.add(mTeam);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), teamArrayList.get(position), Toast.LENGTH_LONG).show();
//        // On selecting a spinner item
//        String item = parent.getItemAtPosition(position).toString();
//
//        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}

