package com.example.smarttasks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CadastroActivity extends AppCompatActivity {

    EditText etTitulo, etDescricao, etData, etPrioridade;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTitulo = findViewById(R.id.etTitulo);
        etDescricao = findViewById(R.id.etDescricao);
        etData = findViewById(R.id.etData);
        etPrioridade = findViewById(R.id.etPrioridade);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(v -> {
            String titulo = etTitulo.getText().toString();
            String descricao = etDescricao.getText().toString();
            String data = etData.getText().toString();
            String prioridadeTexto = etPrioridade.getText().toString();

            // Verifica se os campos não estão vazios
            if (titulo.isEmpty() || descricao.isEmpty() || data.isEmpty() || prioridadeTexto.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validação da data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // Não aceitar datas como 32/13/2025

            try {
                sdf.parse(data); // tenta converter

                // Se a data for válida, salva a tarefa
                int prioridade = Integer.parseInt(prioridadeTexto);
                Tarefa novaTarefa = new Tarefa(titulo, descricao, data, prioridade);
                TarefaRepository.adicionarTarefa(novaTarefa);

                Toast.makeText(this, "Tarefa cadastrada!", Toast.LENGTH_SHORT).show();
                finish();

            } catch (ParseException e) {
                // Data inválida -> mostrar aviso
                Toast.makeText(this, "Data inválida! Use o formato dd/MM/yyyy.", Toast.LENGTH_LONG).show();
            }
        });



    }
}
