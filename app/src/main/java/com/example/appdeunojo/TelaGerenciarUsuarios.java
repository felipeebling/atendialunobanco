package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class TelaGerenciarUsuarios extends AppCompatActivity {
    private Button btnCadastrarNovoUsuario;
    private EditText etBuscarUsuario;
    private ListView lvUsuarios;
    private usuariocontrole usuarioControle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_gerenciar_usuarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCadastrarNovoUsuario = findViewById(R.id.btnCadastrarNovoUsuario);
        etBuscarUsuario = findViewById(R.id.etBuscarUsuario);
        lvUsuarios = findViewById(R.id.lvUsuarios);
        usuarioControle = new usuariocontrole(this);

        btnCadastrarNovoUsuario.setOnClickListener(v -> {
            startActivity(new Intent(this, TelaCadastro.class));
        });

        carregarUsuarios();
    }

    private void carregarUsuarios() {
        List<String> usuarios = usuarioControle.Consulta_todos_usuarios();
        if (usuarios != null && !usuarios.isEmpty()) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
            lvUsuarios.setAdapter(adapter);
        }
    }
}
