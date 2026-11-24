package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaHome extends AppCompatActivity {
    private Button btnUsuarios, btnPerfil, btnNovoAgendamento, btnAcompanhamentos, btnCancelarProximo;
    private TextView tvsaudacao, tipo, descricao;
    private TextView tvDashAgendados, tvDashRealizados, tvDashCancelados;
    private Professores pf = new Professores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getIntent().getSerializableExtra("professor") != null) {
            pf = (Professores) getIntent().getSerializableExtra("professor");
        }

        tipo = findViewById(R.id.txtTipo);
        descricao = findViewById(R.id.txtInfos);
        tvsaudacao = findViewById(R.id.tvSaudacao);

        tvDashAgendados = findViewById(R.id.tvDashAgendados);
        tvDashRealizados = findViewById(R.id.tvDashRealizados);
        tvDashCancelados = findViewById(R.id.tvDashCancelados);

        btnUsuarios = findViewById(R.id.btnUsuarios);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnNovoAgendamento = findViewById(R.id.btnNovoAgendamento);
        btnAcompanhamentos = findViewById(R.id.btnAcompanhamentos);
        btnCancelarProximo = findViewById(R.id.btnCancelarProximo);

        if (pf.getNome() != null) {
            String sau = "Seja Bem vindo " + pf.getNome();
            tvsaudacao.setText(sau);
        }

        AtendimentosController ac = new AtendimentosController(this);
        Atendimentos proximo = ac.ProximoAtendimento(pf);

        if (proximo != null) {
            tipo.setText(proximo.getTipo());
            String info = "Aluno: " + proximo.getNomeAluno() + "\nData: " + proximo.getDataPrevista() + " às " + proximo.getHoraPrevista()
                    + "No " + proximo.getLocalLink();
            descricao.setText(info);
        } else {
            tipo.setText("Sem atendimentos");
            descricao.setText("Nenhum atendimento agendado.");
        }

        btnUsuarios.setOnClickListener(v -> startActivity(new Intent(this, TelaGerenciarUsuarios.class)));
        btnPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(this, TelaPerfil.class);
            intent.putExtra("professor", pf);
            startActivity(intent);
        });
        btnNovoAgendamento.setOnClickListener(v -> startActivity(new Intent(this, TelaNovoAtendimento.class)));
        btnAcompanhamentos.setOnClickListener(v -> startActivity(new Intent(this, TelaHistoricoAtendimentos.class)));
        btnCancelarProximo.setOnClickListener(v -> startActivity(new Intent(this, TelaCancelarAtendimento.class)));
    }
}
