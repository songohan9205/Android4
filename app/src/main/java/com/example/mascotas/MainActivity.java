package com.example.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mascotas.adapter.PageAdapter;
import com.example.mascotas.fragments.ListFragment;
import com.example.mascotas.fragments.ProfileFragment;
import com.example.mascotas.menus.AcercaDe;
import com.example.mascotas.menus.Contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }
        setupViewPager();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID =item.getItemId();
        if(itemID == R.id.mContacto) {
            Intent intent = new Intent(this, Contacto.class);
            startActivity(intent);
        }
        else if (itemID == R.id.mAcerca) {
            Intent intent = new Intent(this, AcercaDe.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void favoritos(View view) {
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }

    public ArrayList<Fragment> agregarFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListFragment());
        fragments.add(new ProfileFragment());
        return fragments;
    }

    public void setupViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
    }
}