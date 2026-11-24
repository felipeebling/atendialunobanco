package com.example.appdeunojo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaPerfil extends AppCompatActivity {

    private TextView tvPerfilNome, tvPerfilEmail, tvPerfilIdentificacao;
    private Button btnVoltarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvPerfilNome = findViewById(R.id.tvPerfilNome);
        tvPerfilEmail = findViewById(R.id.tvPerfilEmail);
        tvPerfilIdentificacao = findViewById(R.id.tvPerfilIdentificacao);
        btnVoltarPerfil = findViewById(R.id.btnVoltarPerfil);

        Professores pf = null;
        if (getIntent().getSerializableExtra("professor") != null) {
            pf = (Professores) getIntent().getSerializableExtra("professor");
        }

        if (pf != null) {
            tvPerfilNome.setText("Nome: " + (pf.getNome() != null ? pf.getNome() : ""));
            tvPerfilEmail.setText("Email: " + (pf.getEmail() != null ? pf.getEmail() : ""));
            tvPerfilIdentificacao.setText("Identificação: " + (pf.getIdentificacaoInstitucional() != null ? pf.getIdentificacaoInstitucional() : ""));
        }

        btnVoltarPerfil.setOnClickListener(v -> finish());
    }
}
