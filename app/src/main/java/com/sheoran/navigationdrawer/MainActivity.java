package com.sheoran.navigationdrawer;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
 DrawerLayout drawerLayout;
ImageView menu;

LinearLayout home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.my_drawer_layout);
menu = findViewById(R.id.menu);
home= findViewById(R.id.homes);
menu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openDrawer(drawerLayout);
    }
});

home.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        redirectActivity(MainActivity.this, HomeActivity.class);
    }
});

    }
    public static  void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static  void closeDrawer(DrawerLayout drawerLayout){
       if( drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static  void redirectActivity(Activity activity, Class SecondActivity){
        Intent intent = new Intent(activity,SecondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();

        closeDrawer(drawerLayout);
    }
}