package com.dossis.curso3semana5.presenter;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana5.R;
import com.dossis.curso3semana5.adapter.MascotaAdapter;
import com.dossis.curso3semana5.database.*;
import com.dossis.curso3semana5.fragments.RecyclerviewFragment;
import com.dossis.curso3semana5.interfaces.IRecyclerviewFragment;
import com.dossis.curso3semana5.interfaces.IRecyclerviewFragmentPresenter;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class RecyclerviewFragmentPresenter implements IRecyclerviewFragmentPresenter {

    public ArrayList mascotasVotacion;
    Context context;
  //  RecyclerviewFragment recyclerViewFragment;
    private RecyclerView rvMascotas;



    public RecyclerviewFragmentPresenter(View v, Context context) {
       // this.recyclerViewFragment = recyclerviewFragment;
        this.context = context;

    }

    @Override
    public void crearArrayMascotas() {
        TablaMascotas tablaMascotas = new TablaMascotas();
        mascotasVotacion = tablaMascotas.getMascotasOrderedId(this.context);
    }

    @Override
    public void asociarRecyclerView(View v) {
        rvMascotas = v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotasVotacion, true, false);
        rvMascotas.setAdapter(adapter);
    }
}
