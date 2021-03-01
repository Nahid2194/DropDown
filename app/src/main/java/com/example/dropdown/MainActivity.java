package com.example.dropdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner mySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySpinner = findViewById(R.id.mySpinnerID);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this,R.array.countryName, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      String Text=parent.getItemAtPosition(position).toString();
      Fragment myFragment;
      if(Text.equals("First")){
          myFragment = new BdFragment();

      }else if(Text.equals("Second")){
           myFragment = new InFragment();
      }else{
           myFragment = new BlankFragment();
      }
      FragmentManager fm = getSupportFragmentManager();
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.myFragmentID,myFragment);
      ft.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Fragment myFragment = new BlankFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.myFragmentID,myFragment);
        ft.commit();
    }
    public void Button(View view) {

            Intent myintent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(myintent);


    }


}