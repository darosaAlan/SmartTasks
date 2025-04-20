package com.example.smarttasks;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalheActivity extends AppCompatActivity {

    TextView tvTitulo, tvDescricao, tvData, tvPrioridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvData = findViewById(R.id.tvData);
        tvPrioridade = findViewById(R.id.tvPrioridade);

        Tarefa tarefa = getIntent().getParcelableExtra("tarefa");

        if (tarefa != null) {
            tvTitulo.setText("Título: " + tarefa.getTitulo());
            tvDescricao.setText("Descrição: " + tarefa.getDescricao());
            tvData.setText("Data: " + tarefa.getData());
            tvPrioridade.setText("Prioridade: " + tarefa.getPrioridade());
        }
    }
}
