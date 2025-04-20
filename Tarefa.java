package com.example.smarttasks;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarefa implements Parcelable {

    private String titulo;
    private String descricao;
    private String data;
    private int prioridade;

    // Construtor
    public Tarefa(String titulo, String descricao, String data, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public int getPrioridade() {
        return prioridade;
    }

    // Método de análise inteligente
    public String getNivelUrgencia() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Exibir a data que está sendo processada
            Log.d("Tarefa", "Processando data: " + this.data);

            Date dataTarefa = sdf.parse(this.data);
            Date hoje = new Date();

            long diffMillis = dataTarefa.getTime() - hoje.getTime();
            long diasRestantes = diffMillis / (1000 * 60 * 60 * 24);

            if (diasRestantes <= 2 || prioridade >= 4) {
                return "URGENTE";
            } else if (diasRestantes <= 5 || prioridade >= 3) {
                return "MÉDIA";
            } else {
                return "BAIXA";
            }

        } catch (ParseException e) {
            // Log detalhado para verificar o erro
            Log.e("Tarefa", "Erro ao processar a data: " + this.data, e);
            return "INDEFINIDA";  // Retorna INDEFINIDA se houver erro
        }
    }


    // Parcelable - permite passar objetos entre telas
    protected Tarefa(Parcel in) {
        titulo = in.readString();
        descricao = in.readString();
        data = in.readString();
        prioridade = in.readInt();
    }

    public static final Creator<Tarefa> CREATOR = new Creator<Tarefa>() {
        @Override
        public Tarefa createFromParcel(Parcel in) {
            return new Tarefa(in);
        }

        @Override
        public Tarefa[] newArray(int size) {
            return new Tarefa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(descricao);
        parcel.writeString(data);
        parcel.writeInt(prioridade);
    }
}
