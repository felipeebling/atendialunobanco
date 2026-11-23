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

public class TelaRegistroResultado extends AppCompatActivity {
    private EditText etConteudo, etAtividades;
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

        etConteudo = findViewById(R.id.etConteudo);
        etAtividades = findViewById(R.id.etAtividades);
        btnSalvarResultado = findViewById(R.id.btnSalvarResultado);

        btnSalvarResultado.setOnClickListener(v -> {
            String conteudo = etConteudo.getText().toString().trim();
            String atividades = etAtividades.getText().toString().trim();

            if (conteudo.isEmpty() || atividades.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Registro salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
