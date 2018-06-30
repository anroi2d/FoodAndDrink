package com.myapp.anit.foodanddrink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity {
    Spinner spinnerDrink;
    Button btnChon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        spinnerDrink= (Spinner) findViewById(R.id.spinDrink);
        List<String> list = new ArrayList<>();
        list.add("Coca-Cola");
        list.add("Pepsi");
        list.add("Tiger");
        list.add("Rượu đế");
        list.add("Whisky");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerDrink.setAdapter(adapter);

        btnChon = (Button) findViewById(R.id.btnChon);
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinkActivity.this,MainActivity.class);
                intent.putExtra("drink",spinnerDrink.getSelectedItem().toString());
                setResult(2,intent);
                finish();
            }
        });


    }
}
