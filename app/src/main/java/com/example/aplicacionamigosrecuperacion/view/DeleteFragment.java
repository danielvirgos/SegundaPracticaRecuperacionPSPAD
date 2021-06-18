package com.example.aplicacionamigosrecuperacion.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplicacionamigosrecuperacion.R;
import com.example.aplicacionamigosrecuperacion.model.entity.Amigo;
import com.example.aplicacionamigosrecuperacion.view.recyclerviewadapter.DeleteRecyclerViewAdapter;
import com.example.aplicacionamigosrecuperacion.viewmodel.ViewModel;

import java.util.ArrayList;
import java.util.List;


public class DeleteFragment extends Fragment {

    private ViewModel viewModel;
    List<Amigo> amigos = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewDelete);
        DeleteRecyclerViewAdapter amigosRecyclerViewAdapter = new DeleteRecyclerViewAdapter(amigos, getContext(), view);
        recyclerView.setAdapter(amigosRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getLiveListaAmigos().observe(getViewLifecycleOwner(), new Observer<List<Amigo>>() {
            @Override
            public void onChanged(List<Amigo> a) {
                amigos.clear();
                amigos.addAll(a);
                amigosRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false);
    }
}