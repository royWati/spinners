package com.zalego2018dec.spinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    class xmlVariables{
        Spinner spinner;
    }

    class storedVariables{
        String selectedCountry;

        // this is a simple array for countries in east africa
        String[] countries ={"Kenya","Uganda","Tanzania","Burundi"};
    }

    xmlVariables xml = new xmlVariables();
    storedVariables store = new storedVariables();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xml.spinner = findViewById(R.id.spinner);

        // constructing a spinner adapter
        /* the adapter requires 3 this :
            context -> MainActivity.this
            layout -> we use the one provided by android i.e
                         android.R.layout.simple_spinner_dropdown_item
            data -> use the one provided by the array in storedVariables
         */
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                store.countries
                );
        xml.spinner.setAdapter(adapter);

        // implementing click event

        events();
    }

    public void events(){
        xml.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // we use int i which has the position to read our array

                store.selectedCountry = store.countries[i];

                Toast.makeText(getApplicationContext(),store.selectedCountry,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
