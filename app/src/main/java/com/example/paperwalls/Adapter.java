package com.example.paperwalls;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomHolder>
{

    int [] images;
    int [] ss;
    Context context;

    public Adapter(int[] images,int[] ss, Context context) {
        this.images = images;
        this.ss=ss;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(R.layout.images_list,parent,false);

        return new CustomHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position)
    {
        final int image= images[position];
        holder.imageView.setImageResource(image);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent intent=new Intent(context,MainActivity.class);

                intent.putExtra("image",image);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class CustomHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        LinearLayout linearLayout;
        public CustomHolder(@NonNull View itemView)

        {
            super(itemView);


            imageView=(ImageView) itemView.findViewById(R.id.images);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linear);

        }
    }
}