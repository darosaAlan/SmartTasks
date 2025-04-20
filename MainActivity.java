package com.example.smarttasks;

import static com.example.smarttasks.TarefaRepository.getTarefas;  // Acesso correto à lista

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrar, btnListar, btnCompartilhar, btnAnalise, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnListar = findViewById(R.id.btnListar);
        btnCompartilhar = findViewById(R.id.btnCompartilhar);
        btnAnalise = findViewById(R.id.btnAnalise);
        btnSobre = findViewById(R.id.btnSobre);

        // Ação do botão de Cadastro
        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        // Ação do botão de Listagem
        btnListar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(intent);
        });

        // Ação do botão de Compartilhar
        btnCompartilhar.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.notion.so/productivity"));
            startActivity(intent);
        });

        // Ação do botão de Análise Inteligente
        btnAnalise.setOnClickListener(v -> {
            // Verificando se a listaTarefas não está vazia ou null
            if (getTarefas() != null && !getTarefas().isEmpty()) {
                // Criando o Intent para abrir a AnaliseActivity
                Intent intent = new Intent(MainActivity.this, AnaliseActivity.class);

                // Passando a lista de tarefas para a próxima Activity
                intent.putParcelableArrayListExtra("listaTarefas", new ArrayList<>(getTarefas())); // Passando a lista de tarefas

                // Abrindo a nova Activity
                startActivity(intent);
            } else {
                // Caso a lista de tarefas esteja vazia ou null, exibe um Toast
                Toast.makeText(MainActivity.this, "Nenhuma tarefa para análise!", Toast.LENGTH_SHORT).show();
            }
        });

        // Ação do botão de Sobre
        btnSobre.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SobreActivity.class);
            startActivity(intent);
        });
    }
}
