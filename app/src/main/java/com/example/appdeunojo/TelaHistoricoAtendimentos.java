package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class TelaHistoricoAtendimentos extends AppCompatActivity {
    private EditText etPesquisarHistorico, etFiltroData;
    private Spinner spFiltroSituacao;
    private ListView lvHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_historico);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etPesquisarHistorico = findViewById(R.id.etPesquisarHistorico);
        etFiltroData = findViewById(R.id.etFiltroData);
        spFiltroSituacao = findViewById(R.id.spFiltroSituacao);
        lvHistorico = findViewById(R.id.lvHistorico);

        carregarFiltros();

        List<String> amostra = new ArrayList<>();
        amostra.add("Ana Souza · Banco de Dados\nRealizado · 05/11 · 14h\nConsultar resultado ›");
        amostra.add("Felipe Ebling · TCC I\nAgendado · 14/11 · 10h\nConsultar detalhes ›");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, amostra);
        lvHistorico.setAdapter(adapter);

        lvHistorico.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, TelaDetalhesAtendimento.class);
            startActivity(intent);
        });
    }

    private void carregarFiltros() {
        String[] situacoes = {"Todas", "Agendado", "Realizado", "Cancelado"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, situacoes);
        spFiltroSituacao.setAdapter(adapter);
    }
}
