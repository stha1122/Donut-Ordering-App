package jit.aiml.shwe.donut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import jit.aiml.shwe.donut.Adapters.OrdersAdapter;
import jit.aiml.shwe.donut.databinding.ActivityOrdersBinding;
import jit.aiml.shwe.donut.models.OrdersModel;

public class OrdersActivity extends AppCompatActivity {
    ActivityOrdersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();




        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);
    }
}