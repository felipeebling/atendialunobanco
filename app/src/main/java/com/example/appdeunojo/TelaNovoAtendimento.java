package com.example.appdeunojo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class TelaNovoAtendimento extends AppCompatActivity {
    private Spinner spEstudantes, spTipoAtendimento;
    private EditText etDataHorario, etDuracao, etDisciplina, etLocalLink, etDescricao, etObservacoes;
    private Button btnSalvarAtendimento;
    private AlunosController alunosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_novo_atendimento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spEstudantes = findViewById(R.id.spEstudantes);
        spTipoAtendimento = findViewById(R.id.spTipoAtendimento);
        etDataHorario = findViewById(R.id.etDataHorario);
        etDuracao = findViewById(R.id.etDuracao);
        etDisciplina = findViewById(R.id.etDisciplina);
        etLocalLink = findViewById(R.id.etLocalLink);
        etDescricao = findViewById(R.id.etDescricao);
        etObservacoes = findViewById(R.id.etObservacoes);
        btnSalvarAtendimento = findViewById(R.id.btnSalvarAtendimento);

        alunosController = new AlunosController(this);
        carregarAlunos();
        carregarTiposAtendimento();

        btnSalvarAtendimento.setOnClickListener(v -> {
            String dataHorario = etDataHorario.getText().toString().trim();
            String duracao = etDuracao.getText().toString().trim();
            String descricao = etDescricao.getText().toString().trim();

            if (dataHorario.isEmpty() || duracao.isEmpty() || descricao.isEmpty()) {
                Toast.makeText(this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Atendimento salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void carregarAlunos() {
        List<Alunos> alunosList = alunosController.ConsultaAlunos();
        List<String> nomes = new ArrayList<>();

        if (alunosList != null) {
            for (Alunos al : alunosList) {
                nomes.add(al.getNome());
            }
        }else{

            nomes.add("Nenhum Aluno encontrado");

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
        spEstudantes.setAdapter(adapter);
    }

    private void carregarTiposAtendimento() {
        String[] tipos = {"DUVIDAS", "TCC", "PROJETOS", "PRATICAS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipos);
        spTipoAtendimento.setAdapter(adapter);
    }
}
