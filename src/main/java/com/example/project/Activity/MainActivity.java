package com.example.project.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project.Adapter.PopularAdapter;
import com.example.project.R;
import com.example.project.databinding.ActivityMainBinding;
import com.example.project.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statusBarColor();
        initRecycleview();
        bottomNavigation();
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void statusBarColor() {
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple_dark));
    }

    private void initRecycleview() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain( "T-shirt black","item_x",16,4,500,"Immerse Yourself in a World of vibrant visuals and \n"+
                "immersive sound with the monitor.\n" +
                "its cutting-edge monitor technology brings every \n " +
                "scene to life with striking clarity and rich colors \n" +
                "with seamless integration and a sleek modern \n "+
                "design, the monitor Pro is not just a monitor , but a\n"+
                "centerpiece for your entertainment space.\n "+
                "With its sleek , modern design,the monitor is\n"+
                "not just a TV , but a centerpiece for your \n"+
                "entertainment space. the ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));
        items.add(new PopularDomain( "Smart Watch","item_y",10,4.5,450,"Immerse Yourself in a World of vibrant visuals and \n"+
                "immersive sound with the monitor.\n" +
                "its cutting-edge monitor technology brings every \n " +
                "scene to life with striking clarity and rich colors \n" +
                "with seamless integration and a sleek modern \n "+
                "design, the monitor Pro is not just a monitor , but a\n"+
                "centerpiece for your entertainment space.\n "+
                "With its sleek , modern design,the monitor is\n"+
                "not just a TV , but a centerpiece for your \n"+
                "entertainment space. the ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));
        items.add(new PopularDomain( "Phone","item_3",5,4.9,800,"Immerse Yourself in a World of vibrant visuals and \n"+
                "immersive sound with the monitor.\n" +
                "its cutting-edge monitor technology brings every \n " +
                "scene to life with striking clarity and rich colors \n" +
                "with seamless integration and a sleek modern \n "+
                "design, the monitor Pro is not just a monitor , but a\n"+
                "centerpiece for your entertainment space.\n "+
                "With its sleek , modern design,the monitor is\n"+
                "not just a TV , but a centerpiece for your \n"+
                "entertainment space. the ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));
        binding.Popularview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.Popularview.setAdapter(new PopularAdapter(items));
    }
}