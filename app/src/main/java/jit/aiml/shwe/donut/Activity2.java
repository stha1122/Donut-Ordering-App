package jit.aiml.shwe.donut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import jit.aiml.shwe.donut.Adapters.MainAdapter;
import jit.aiml.shwe.donut.databinding.Activity2Binding;
import jit.aiml.shwe.donut.models.MainModels;

public class Activity2 extends AppCompatActivity {
    Activity2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= Activity2Binding.inflate(getLayoutInflater());



        setContentView(binding.getRoot());
       final ArrayList<MainModels> list = new ArrayList<>();
        list.add(new MainModels(R.drawable.chocolate,"Choco Pop Donut", "105", "Pop up your mood with this donut combination of colourful sprinklers and a flavour of chocolate!"));
        list.add(new MainModels(R.drawable.oreo,"Oreo Crumble Donuts", "85", "Ring donut dunked in white chocolate and topped with oreo cookie crush."));
        list.add(new MainModels(R.drawable.strawberry,"Very Very Strawberry", "90", "Strawberry Flavoured donut with multi coloured sugar confetti! !"));
        list.add(new MainModels(R.drawable.blueberry,"Blueberry Donuts", "120", " light, fluffy, smooth and just sweet soft similar to danish pastry"));
        list.add(new MainModels(R.drawable.vanilla,"Vanilla Donut", "105", "A plain ring doughnut dipped in and coated with white ganache,topped with colourful sprinkles"));
        list.add(new MainModels(R.drawable.redvelvet,"Red Velvet Donuts", "105", "donuts topped with cream cheese frosting! "));
            DBHelper helper=new DBHelper(this);

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(Activity2.this,OrdersActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}