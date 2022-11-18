package com.dossis.curso3semana5.activitys;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana5.R;
import com.dossis.curso3semana5.adapter.MascotaAdapter;
import com.dossis.curso3semana5.database.*;
import java.util.ArrayList;


public class FavoritosActivity extends BaseActivity {

    public ArrayList mascotasOrdenadas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        if (toolbar == null) {
            setActionBar(this, true);
        }

        crearArrayMascotas(this);
        asociarRecyclerView();
        inicializarAdapter();

    }


    private void crearArrayMascotas(Context context) {
        TablaMascotas tablaMascotas = new TablaMascotas();
        mascotasOrdenadas = tablaMascotas.getMascotasOrderedLikes(this);


    }

    private void asociarRecyclerView() {
        rvMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotasOrdenadas, false, false);
        rvMascotas.setAdapter(adapter);

    }
}