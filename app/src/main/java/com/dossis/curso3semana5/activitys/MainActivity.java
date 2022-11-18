package com.dossis.curso3semana5.activitys;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.dossis.curso3semana5.R;
import com.dossis.curso3semana5.adapter.PageAdapter;
import com.dossis.curso3semana5.fragments.PerfilFragment;
import com.dossis.curso3semana5.fragments.RecyclerviewFragment;
import com.google.android.material.tabs.TabLayout;
import com.dossis.curso3semana5.database.*;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertarMascotasFake(this);

        if (toolbar == null) {
            setActionBar(this, false);
        }

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

    }

    public void insertarMascotasFake(Context context) {
        TablaMascotas tablaMascotas = new TablaMascotas();
        tablaMascotas.insertMascota(context, 1, "Rufo", R.drawable.perro1);
        tablaMascotas.insertMascota(context, 2, "Chicho", R.drawable.perro2);
        tablaMascotas.insertMascota(context, 3, "Luisma", R.drawable.perro3);
        tablaMascotas.insertMascota(context, 4, "Baraja", R.drawable.perro4);
        tablaMascotas.insertMascota(context, 5, "Rajoy", R.drawable.perro5);
        tablaMascotas.insertMascota(context, 6, "Mourinho", R.drawable.perro6);
        tablaMascotas.insertMascota(context, 7, "Ojopipa", R.drawable.perro7);
        tablaMascotas.insertMascota(context, 8, "Carahuevo", R.drawable.perro8);

    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.star);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog);
    }

}