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
    }

    private void teamDisplay() {
//        Resources res = getResources();
        teamAdapter = new TeamAdapter(MainActivity.this,R.layout.team_row, teamArrayList);
        spinnerTeam.setAdapter(teamAdapter);
        spinnerTeam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String team = ((TextView) view.findViewById(R.id.TxtTeam)).getText().toString();
                String rank = ((TextView) view.findViewById(R.id.txtRank)).getText().toString();
                String OutputMsg = "Selected Company : \n\n" + team + "\n\n Rank :" + rank;
                output.setText(OutputMsg);
                pos = position;
                Log.e("adapter", " name " + team);
                Log.e("adapter", " pos " + pos);
                Toast.makeText(getApplicationContext(), OutputMsg, Toast.LENGTH_LONG).show();

                playerAdapter = new PlayerAdapter(MainActivity.this, R.layout.team_row, teamArrayList.get(pos).getPlayerArrayList());
                spinnerPlayers.setAdapter(playerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        mTeam.setRank(1);

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
        mTeam.setRank(2);
        mTeam.setTeam("Bangladesh");

        playerArrayList = new ArrayList<>();

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
        mTeam.setRank(3);
        mTeam.setTeam("India");

        playerArrayList = new ArrayList<>();

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

}

