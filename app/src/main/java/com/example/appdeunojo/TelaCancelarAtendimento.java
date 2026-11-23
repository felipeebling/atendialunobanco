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

public class TelaCancelarAtendimento extends AppCompatActivity {
    private EditText etMotivoCancelamento;
    private Button btnConfirmarCancelamento, btnManterAtendimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cancelar_atendimento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etMotivoCancelamento = findViewById(R.id.etMotivoCancelamento);
        btnConfirmarCancelamento = findViewById(R.id.btnConfirmarCancelamento);
        btnManterAtendimento = findViewById(R.id.btnManterAtendimento);

        btnConfirmarCancelamento.setOnClickListener(v -> {
            String motivo = etMotivoCancelamento.getText().toString().trim();
            if (motivo.isEmpty()) {
                Toast.makeText(this, "Informe o motivo do cancelamento!", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Atendimento cancelado com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        });

        btnManterAtendimento.setOnClickListener(v -> finish());
    }
}
