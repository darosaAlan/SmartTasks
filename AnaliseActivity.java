package com.example.smarttasks;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AnaliseActivity extends AppCompatActivity {

    private ListView listaUrgencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise);

        listaUrgencia = findViewById(R.id.listaUrgencia);

        // Recebendo a lista de tarefas
        ArrayList<Tarefa> listaTarefas = getIntent().getParcelableArrayListExtra("listaTarefas");

        if (listaTarefas != null && !listaTarefas.isEmpty()) {
            ArrayList<String> tarefasComUrgencia = new ArrayList<>();

            for (Tarefa tarefa : listaTarefas) {
                String item = tarefa.getTitulo() + " - Urgência: " + tarefa.getNivelUrgencia();
                tarefasComUrgencia.add(item);
            }

            // Adaptador para exibir na ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    tarefasComUrgencia
            );

            listaUrgencia.setAdapter(adapter);
        }
    }
}
