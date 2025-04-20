package com.example.smarttasks;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    private static final List<Tarefa> listaTarefas = new ArrayList<>();

    public static void adicionarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public static List<Tarefa> getTarefas() {
        return listaTarefas;
    }
}
