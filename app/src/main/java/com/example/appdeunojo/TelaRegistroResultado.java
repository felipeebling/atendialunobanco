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

public class TelaRegistroResultado extends AppCompatActivity {
    private Spinner spSituacaoFinal;
    private EditText etConteudoTratado, etObservacoesResultado;
    private Button btnSalvarResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_registro_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spSituacaoFinal = findViewById(R.id.spSituacaoFinal);
        etConteudoTratado = findViewById(R.id.etConteudoTratado);
        etObservacoesResultado = findViewById(R.id.etObservacoesResultado);
        btnSalvarResultado = findViewById(R.id.btnSalvarResultado);

        carregarSituacoes();

        btnSalvarResultado.setOnClickListener(v -> {
            String conteudo = etConteudoTratado.getText().toString().trim();
            String observacoes = etObservacoesResultado.getText().toString().trim();

            if (conteudo.isEmpty() || observacoes.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Registro salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void carregarSituacoes() {
        String[] situacoes = {
            "Realizado conforme o previsto",
            "Realizado parcialmente",
            "Estudante não compareceu",
            "Cancelado"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, situacoes);
        spSituacaoFinal.setAdapter(adapter);
    }
}
