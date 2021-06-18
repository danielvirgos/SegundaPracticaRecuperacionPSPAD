package com.example.aplicacionamigosrecuperacion.view.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionamigosrecuperacion.R;
import com.example.aplicacionamigosrecuperacion.model.entity.Amigo;
import com.example.aplicacionamigosrecuperacion.model.entity.NumeroLlamadas;
import com.example.aplicacionamigosrecuperacion.viewmodel.ViewModel;

import java.util.List;

public class ListarRecyclerViewAdapter extends RecyclerView.Adapter<ListarRecyclerViewAdapter.ViewHolder>{

    List<Amigo> listaAmigos;
    Context contexto;
    ViewModel viewModel;

    public ListarRecyclerViewAdapter(List<Amigo> list, Context context) {

        this.listaAmigos = list;
        contexto = context;
        viewModel = new ViewModelProvider((ViewModelStoreOwner) contexto).get(ViewModel.class);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvamigo.setText(listaAmigos.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return listaAmigos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvamigo;
        ConstraintLayout parent_layout;
        TextView tvcontador;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvcontador = itemView.findViewById(R.id.tvContadorLlamadas);
            tvamigo = itemView.findViewById(R.id.textView);
            parent_layout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
