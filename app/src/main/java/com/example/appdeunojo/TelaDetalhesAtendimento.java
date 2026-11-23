package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaDetalhesAtendimento extends AppCompatActivity {
    private Button btnEditarAtendimento, btnCancelarAtendimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_detalhes_atendimento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnEditarAtendimento = findViewById(R.id.btnEditarAtendimento);
        btnCancelarAtendimento = findViewById(R.id.btnCancelarAtendimento);

        btnEditarAtendimento.setOnClickListener(v -> Toast.makeText(this, "Modo de edição", Toast.LENGTH_SHORT).show());
        btnCancelarAtendimento.setOnClickListener(v -> startActivity(new Intent(this, TelaCancelarAtendimento.class)));
    }
}
