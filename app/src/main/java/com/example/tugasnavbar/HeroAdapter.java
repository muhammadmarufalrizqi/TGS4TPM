package com.example.tugasnavbar;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
   private ArrayList<HeroModel> heroModels;
   private Context context;

   public HeroAdapter(Context context) {this.context = context;}

   @NonNull
   @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_item,parent,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(getHeroModels().get(position).getHeroImages()).into(holder.ivHero);
        holder.tv_Heronama.setText(getHeroModels().get(position).heroNames);


        holder.layoutheroitem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,HeroDetail.class);
                intent.putExtra("nama",getHeroModels().get(position).getHeroNames());
                intent.putExtra("deskripsi",getHeroModels().get(position).getHeroDetails());
                intent.putExtra("gambar",getHeroModels().get(position).getHeroImages());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getHeroModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private ImageView ivHero;
       private TextView tv_Heronama, tv_HeroDetail;
       private LinearLayout layoutheroitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHero = itemView.findViewById(R.id.ivHero);
            tv_Heronama = itemView.findViewById(R.id.tv_Heronama);
           // tv_HeroDetail = itemView.findViewById(R.id.tv_Herodetail);
            layoutheroitem = itemView.findViewById(R.id.layoutheroitem);
        }
    }

    public ArrayList<HeroModel> getHeroModels() {
       return  heroModels;
    }

    public void setHeroModels(ArrayList<HeroModel> heroModels)
    {
        this.heroModels = heroModels;
    }
}
