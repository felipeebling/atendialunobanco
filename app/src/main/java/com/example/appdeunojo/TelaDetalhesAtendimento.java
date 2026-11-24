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
    private Button btnEditarAtendimento, btnCancelarAtendimento, btnRegistrarResultado;

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
        btnRegistrarResultado = findViewById(R.id.btnRegistrarResultado);

        btnEditarAtendimento.setOnClickListener(v -> {
            Intent intent = new Intent(this, TelaNovoAtendimento.class);
            // Aqui passamos a intenção de edição (poderá ser recuperado na TelaNovoAtendimento depois)
            intent.putExtra("modoEdicao", true);
            startActivity(intent);
        });
        
        btnRegistrarResultado.setOnClickListener(v -> startActivity(new Intent(this, TelaRegistroResultado.class)));
        btnCancelarAtendimento.setOnClickListener(v -> startActivity(new Intent(this, TelaCancelarAtendimento.class)));
    }
}
