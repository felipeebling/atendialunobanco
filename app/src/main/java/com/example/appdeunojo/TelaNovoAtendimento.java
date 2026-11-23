package com.example.appdeunojo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaNovoAtendimento extends AppCompatActivity {
    private EditText etEstudantes, etDataHorario, etDisciplina, etLinkMeet, etDescricao;
    private Button btnSalvarAtendimento;

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

        etEstudantes = findViewById(R.id.etEstudantes);
        etDataHorario = findViewById(R.id.etDataHorario);
        etDisciplina = findViewById(R.id.etDisciplina);
        etLinkMeet = findViewById(R.id.etLinkMeet);
        etDescricao = findViewById(R.id.etDescricao);
        btnSalvarAtendimento = findViewById(R.id.btnSalvarAtendimento);

        btnSalvarAtendimento.setOnClickListener(v -> {
            String estudantes = etEstudantes.getText().toString().trim();
            String dataHorario = etDataHorario.getText().toString().trim();
            String descricao = etDescricao.getText().toString().trim();

            if (estudantes.isEmpty() || dataHorario.isEmpty() || descricao.isEmpty()) {
                Toast.makeText(this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Atendimento salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
