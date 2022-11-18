package com.dossis.curso3semana5.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.dossis.curso3semana5.R;

public class BaseActivity extends AppCompatActivity {


    public Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void setActionBar(Activity activity, boolean BotonUp) {

        toolbar = findViewById(R.id.miActionBar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(BotonUp);
        }
        ImageView imgFavoritos = findViewById(R.id.imgFavoritos);
        imgFavoritos.setOnClickListener(v -> {
            Intent intentFavoritos = new Intent(activity, FavoritosActivity.class);
            startActivity(intentFavoritos);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuContacto:
                Intent intentContacto = new Intent(this, ContactoActivity.class);
                startActivity(intentContacto);
                break;
            case R.id.menuAcercaDe:
                Intent intentAcercaDe = new Intent(this, AcercaDeActivity.class);
                startActivity(intentAcercaDe);
                break;
        }
        ;
        return super.onOptionsItemSelected(item);
    }
}
