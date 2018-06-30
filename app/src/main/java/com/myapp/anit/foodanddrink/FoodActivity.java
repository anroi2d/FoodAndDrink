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

public class FoodActivity extends AppCompatActivity {
    Spinner spinnerFood;
    Button btnChon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        spinnerFood= (Spinner) findViewById(R.id.spinFood);
        List<String> list = new ArrayList<>();
        list.add("Pizza");
        list.add("Đậu phộng");
        list.add("Tai dê nướng");
        list.add("KFC");
        list.add("Bò tái chanh");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerFood.setAdapter(adapter);

        btnChon = (Button) findViewById(R.id.btnChon);
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                intent.putExtra("food",spinnerFood.getSelectedItem().toString());
                setResult(1,intent);
                finish();
            }
        });


    }
}
