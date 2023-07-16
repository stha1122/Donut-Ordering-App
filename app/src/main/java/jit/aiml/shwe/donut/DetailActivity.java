package jit.aiml.shwe.donut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import jit.aiml.shwe.donut.databinding.ActivityDetailBinding;
import jit.aiml.shwe.donut.models.OrdersModel;

public class DetailActivity extends AppCompatActivity {
        ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      final int image =getIntent().getIntExtra("image",0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
      final   String foodname = getIntent().getStringExtra("foodname");
        final String description=getIntent().getStringExtra("description");


        binding.detailImage.setImageResource(image);
        binding.priceLabel.setText(String.format("%d",price));
        binding.foodname1.setText(foodname);

        binding.detailDescription.setText(description);

        final DBHelper helper=new DBHelper(this);


        binding.insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             boolean isInserted= helper.insertOrder(
                      binding.nameBox.getText().toString(),
                      binding.phoneBox.getText().toString(),
                      price,
                     image,
                     description,
                     foodname,
                     Integer.parseInt(binding.quantity.getText().toString()));
              if(isInserted)
                  Toast.makeText(DetailActivity.this, "Data Successs", Toast.LENGTH_SHORT).show();
              else
                  Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

        });


    }
}