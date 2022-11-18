package com.dossis.curso3semana5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana5.R;
import com.dossis.curso3semana5.interfaces.IRecyclerviewFragment;
import com.dossis.curso3semana5.interfaces.IRecyclerviewFragmentPresenter;
import com.dossis.curso3semana5.presenter.RecyclerviewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerviewFragment extends Fragment  {
     IRecyclerviewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        presenter = new RecyclerviewFragmentPresenter(  v,this.getContext());
        presenter.crearArrayMascotas();
        presenter.asociarRecyclerView(v);
        presenter.inicializarAdapter();

        return v;
    }

}
