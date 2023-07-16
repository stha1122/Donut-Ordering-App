package jit.aiml.shwe.donut.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import jit.aiml.shwe.donut.DetailActivity;
import jit.aiml.shwe.donut.R;
import jit.aiml.shwe.donut.models.MainModels;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{
ArrayList<MainModels> list;

Context context;

    public MainAdapter(ArrayList<MainModels> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);

       return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModels models = list.get(position);
        holder.foodimage.setImageResource(models.getImage());
        holder.mainName.setText(models.getName());
        holder.price.setText(models.getPrice());
        holder.description.setText(models.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",models.getImage());
                intent.putExtra("price",models.getPrice());
                intent.putExtra("description",models.getDescription());
                intent.putExtra("foodname",models.getName());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView foodimage;
        TextView mainName,price,description;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            foodimage=itemView.findViewById(R.id.imageView2);
            mainName=itemView.findViewById(R.id.foodname);
            price=itemView.findViewById(R.id.price2);
            description=itemView.findViewById(R.id.description);

        }
    }
}
