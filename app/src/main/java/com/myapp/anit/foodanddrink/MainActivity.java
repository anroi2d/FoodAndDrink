package com.myapp.anit.foodanddrink;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnFood, btnDrink, btnExit;
    TextView tvFood,tvDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    private void init() {
        tvFood = (TextView) findViewById(R.id.tv_food);
        tvDrink= (TextView) findViewById(R.id.tv_drink);
        btnDrink = (Button) findViewById(R.id.btnDrink);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnFood = (Button) findViewById(R.id.btnFood);
        btnFood.setOnClickListener(this);
        btnDrink.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFood:
                FoodIntent();
                break;
            case R.id.btnDrink:
                DrinkIntent();
                break;
            case R.id.btnExit:
                finish();
                break;
        }
    }

    private void DrinkIntent() {
        Intent intent = new Intent(this, DrinkActivity.class);
        startActivityForResult(intent, 2);
    }

    private void FoodIntent() {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

            String f = data.getStringExtra("food");
            String d = data.getStringExtra("drink");
            if(resultCode==1){
                String an = tvFood.getText()+f+"\n";
                tvFood.setText(an);
            }
            if(resultCode==2){
                String uong = tvDrink.getText()+d+"\n";
                tvDrink.setText(uong);
            }



        super.onActivityResult(requestCode, resultCode, data);
    }
}
