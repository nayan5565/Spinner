package com.nayan.spinneractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nayan.spinneractivity.adapter.PlayerAdapter;
import com.nayan.spinneractivity.adapter.TeamAdapter;
import com.nayan.spinneractivity.model.MPlayer;
import com.nayan.spinneractivity.model.MTeam;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MPlayer mPlayer;
    private MTeam mTeam;
    private ArrayList<MPlayer> playerArrayList;
    public ArrayList<MTeam> teamArrayList;
    private Spinner spinnerTeam;
    private Spinner spinnerPlayers;
    private TeamAdapter teamAdapter;
    private PlayerAdapter playerAdapter;
    private static MainActivity instance;
    public int pos;
    TextView output;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        generate();
        teamDisplay();
//        playerDisplay();

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

    private void teamDisplay() {
//        Resources res = getResources();
        teamAdapter = new TeamAdapter(MainActivity.this,
                R.layout.team_row, teamArrayList);
//        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        baseAdapterTeam=new PlayerAdapter(getApplicationContext(),teamArrayList);


        spinnerTeam.setAdapter(teamAdapter);
        spinnerTeam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String team = ((TextView) view.findViewById(R.id.TxtTeam)).getText().toString();
                String OutputMsg = "Selected Company : \n\n" + team;
                output.setText(OutputMsg);
                pos = position;
                Log.e("adapter", " name " + team);
                Log.e("adapter", " pos " + pos);
                Toast.makeText(getApplicationContext(), OutputMsg, Toast.LENGTH_LONG).show();
//                if (pos == 0) {
//                    playerArrayList = teamArrayList.get(0).getPlayerArrayList();
//                } else if (pos == 1) {
//                    playerArrayList = teamArrayList.get(1).getPlayerArrayList();
//                } else if (pos == 2) {
//                    playerArrayList = teamArrayList.get(2).getPlayerArrayList();
//                }
                playerAdapter = new PlayerAdapter(MainActivity.this, R.layout.team_row, teamArrayList.get(pos).getPlayerArrayList());
                spinnerPlayers.setAdapter(playerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        spinnerTeam.setAdapter(baseAdapterTeam);
    }

    private void playerDisplay() {
//        Log.e("adapter", " pos 2 " + pos);


    }

    private void init() {
        instance = this;
        output = (TextView) findViewById(R.id.output);
        spinnerTeam = (Spinner) findViewById(R.id.spinnerTeam);
        spinnerPlayers = (Spinner) findViewById(R.id.spinnerPlayer);

        // Spinner click listener

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

        playerArrayList=new ArrayList<>();

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

        playerArrayList=new ArrayList<>();

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


//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////        Toast.makeText(getApplicationContext(), teamArrayList.get(position), Toast.LENGTH_LONG).show();
////        // On selecting a spinner item
////        String item = parent.getItemAtPosition(position).toString();
////
////        // Showing selected spinner item
////        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//    }
//
//    public void onNothingSelected(AdapterView<?> arg0) {
//        // TODO Auto-generated method stub
//    }
}

