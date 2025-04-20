package com.example.smarttasks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.ViewHolder> {

    private final List<Tarefa> tarefas;
    private final Context context;

    public TarefaAdapter(List<Tarefa> tarefas, Context context) {
        this.tarefas = tarefas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tarefa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarefa tarefa = tarefas.get(position);
        holder.tvTitulo.setText(tarefa.getTitulo());
        holder.tvData.setText("Data: " + tarefa.getData());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalheActivity.class);
            intent.putExtra("tarefa", tarefa);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTituloItem);
            tvData = itemView.findViewById(R.id.tvDataItem);
        }
    }
}
