package com.dossis.curso3semana5.interfaces;

import android.view.View;

public interface IRecyclerviewFragmentPresenter {
     void crearArrayMascotas() ;
    void asociarRecyclerView(View v);
    void inicializarAdapter();
}
