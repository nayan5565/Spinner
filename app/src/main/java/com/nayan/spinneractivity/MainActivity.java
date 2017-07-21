package com.nayan.spinneractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        Spinner spinnerTeam = (Spinner) findViewById(R.id.spinnerTeam);
        Spinner spinnerPlayers = (Spinner) findViewById(R.id.spinnerPlayer);

        // Spinner click listener
        spinnerTeam.setOnItemSelectedListener(this);
        spinnerPlayers.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> teams = new ArrayList<String>();
        teams.add("Australia");
        teams.add("Bangladesh");
        teams.add("England");
        teams.add("Pakistan");
        teams.add("India");
        teams.add("Srilanka");
        List<String> players = new ArrayList<String>();
        players.add("Tamim");
        players.add("Mashrafi");
        players.add("Shakib");
        players.add("Musfiq");
        players.add("Mustafiz");
        players.add("Sabbir");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teams);
        ArrayAdapter<String> dataAdapterPlayer = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, players);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterPlayer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnerTeam.setAdapter(dataAdapter);
        spinnerPlayers.setAdapter(dataAdapterPlayer);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}

