package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaRecuperarSenha extends AppCompatActivity {
    private EditText etEmailRecuperacao, etConfirmaEmail;
    private Button btnSolicitarRecuperacao, btnVoltarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_recuperar_senha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etEmailRecuperacao = findViewById(R.id.etEmailRecuperacao);
        etConfirmaEmail = findViewById(R.id.etConfirmaEmail);
        btnSolicitarRecuperacao = findViewById(R.id.btnSolicitarRecuperacao);
        btnVoltarLogin = findViewById(R.id.btnVoltarLogin);

        btnSolicitarRecuperacao.setOnClickListener(v -> {
            String email = etEmailRecuperacao.getText().toString().trim();
            String confirma = etConfirmaEmail.getText().toString().trim();

            if (email.isEmpty() || confirma.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!email.equals(confirma)) {
                Toast.makeText(this, "Os e-mails não conferem", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Se existir uma conta vinculada ao e-mail, as orientações serão enviadas.", Toast.LENGTH_LONG).show();
            finish();
        });

        btnVoltarLogin.setOnClickListener(v -> {
            finish();
        });
    }
}
