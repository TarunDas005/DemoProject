package com.example.jannat.arraylistexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    ArrayList<String> names=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    Spinner spinner1,spinner2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        spinner1= (Spinner) findViewById(R.id.spinner1);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        ArrayList<String> names=new ArrayList<String>();
        names.add("A");
        names.add("B");
        names.add("C");
        map.put("Aronno", names);
        names=new ArrayList<String>();
        names.add("P");
        names.add("Q");
        names.add("R");
        map.put("Jannat", names);

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            //System.out.print(entry.getKey()+" | ");
            Log.d("ShowName",entry.getKey());
            for(String name : entry.getValue()){
                Log.d("ShowName",name);
            }
            //System.out.println();
        }
        ArrayList<String> namesForSpinner=new ArrayList<String>();
        for(Map.Entry<String,ArrayList<String>> entry:map.entrySet()){
            String name=entry.getKey();
            namesForSpinner.add(name);
        }

        adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,namesForSpinner);

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ArrayList<String> namesForSpinner2 = new ArrayList<String>();
                        String name= (String) spinner1.getItemAtPosition(position);
                        //Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                        for(Map.Entry<String,ArrayList<String>> entry:map.entrySet()){
                            String keyName=entry.getKey();
                            if(keyName.equals(name)){
                                for(String value : entry.getValue()){
                                    namesForSpinner2.add(value);
                                }
                                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,namesForSpinner2);
                                //arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinner2.setAdapter(arrayAdapter);

                            }
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
