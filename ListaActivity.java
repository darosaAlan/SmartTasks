package com.example.smarttasks;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TarefaAdapter adapter;
    List<Tarefa> tarefas;

    @Override
    protected void onResume() {
        super.onResume();
        tarefas = TarefaRepository.getTarefas();
        adapter = new TarefaAdapter(tarefas, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerView = findViewById(R.id.recyclerTarefas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
