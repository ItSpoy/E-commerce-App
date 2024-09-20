package com.example.project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.project.Activity.DetailActivity;
import com.example.project.Helper.ChangeNumberItemsListener;
import com.example.project.Helper.ManagmentCart;
import com.example.project.databinding.ViewholderCartBinding;
import com.example.project.databinding.ViewholderPopListBinding;
import com.example.project.domain.PopularDomain;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context ;
    ViewholderCartBinding binding;
    ChangeNumberItemsListener changeNumberItemsListener;
    ManagmentCart managmentCart ;

    public CartAdapter(ArrayList<PopularDomain> items, ChangeNumberItemsListener changeNumberItemsListener) {
        this.items = items;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        context= parent.getContext();
        managmentCart=new ManagmentCart(context);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.EachFeeItem.setText("$"+items.get(position).getPrice());
        binding.TotalFeeItem.setText("$"+Math.round(items.get(position).getNumberInCart()*items.get(position).getPrice()));
        binding.NumberItemTxt.setText(String.valueOf(items.get(position).getNumberInCart()));


        int drawableResourced=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(binding.pic);


      binding.PlusCartBtn.setOnClickListener(v -> managmentCart.plusNumberItem(items, position, () -> {
          notifyDataSetChanged();
          changeNumberItemsListener.change();
      }));
      binding.MinusCartbtn.setOnClickListener(v -> managmentCart.minusNumberItem(items, position, () -> {
          notifyDataSetChanged();
          changeNumberItemsListener.change();
      }));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderCartBinding binding) {
            super(binding.getRoot());
        }
    }
}
