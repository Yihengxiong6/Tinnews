package com.laioffer.tinnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) // 这个是 <androidx.fragment.app.FragmentContainerView里的东西 navhost是白色的主题
                getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController(); // 控制上面不同fragmentHost的切换
        NavigationUI.setupWithNavController(navView, navController); // 具体点哪个button到哪个页面 navbar上的三个button和fragment一一对应
        // 所以bottom_nav_menu里的名字要和layout里一样
        NavigationUI.setupActionBarWithNavController(this, navController); // 显示title
    }

    @Override
    public boolean onSupportNavigateUp() { // 回车箭头
        return navController.navigateUp();

    }
}