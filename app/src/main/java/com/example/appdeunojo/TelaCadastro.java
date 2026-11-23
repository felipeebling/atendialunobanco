package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaCadastro extends AppCompatActivity {
    private Button btnCadastrar;
    private EditText edNomeCompleto, edIdentificacao, edEmail, edSenha, edConfirmaSenha;
    private RadioGroup rgPerfil;
    private RadioButton rbAluno, rbProfessor;
    private CheckBox cbConferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ProfessoresController profController = new ProfessoresController(this);
        usuariocontrole userController = new usuariocontrole(this);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        edNomeCompleto = findViewById(R.id.edNomeCompleto);
        edIdentificacao = findViewById(R.id.edIdentificacao);
        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);
        edConfirmaSenha = findViewById(R.id.edConfirmaSenha);
        rgPerfil = findViewById(R.id.rgPerfil);
        rbAluno = findViewById(R.id.rbAluno);
        rbProfessor = findViewById(R.id.rbProfessor);
        cbConferencia = findViewById(R.id.cbConferencia);

        btnCadastrar.setOnClickListener(v -> {
            String nome = edNomeCompleto.getText().toString().trim();
            String identificacao = edIdentificacao.getText().toString().trim();
            String email = edEmail.getText().toString().trim();
            String senha = edSenha.getText().toString().trim();
            String confirmaSenha = edConfirmaSenha.getText().toString().trim();

            if (nome.isEmpty() || identificacao.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()) {
                Toast.makeText(TelaCadastro.this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!senha.equals(confirmaSenha)) {
                Toast.makeText(TelaCadastro.this, "As senhas não conferem!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!cbConferencia.isChecked()) {
                Toast.makeText(TelaCadastro.this, "Confirme que leu e revise seus dados!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean sucesso = false;
            if (rbProfessor.isChecked()) {
                Professores pf = new Professores(nome, identificacao, email, senha);
                sucesso = profController.insereProfessor(pf);
            } else {
                usuario user = new usuario(email, senha);
                sucesso = userController.insere_usuario(user);
            }

            if (sucesso) {
                Toast.makeText(TelaCadastro.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(TelaCadastro.this, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
