package com.example.appdeunojo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaPerfil extends AppCompatActivity {

    private TextView tvPerfilNome, tvPerfilEmail, tvPerfilIdentificacao;
    private Button btnVoltarPerfil,btnEditar;
    private  Professores pf = null;
    private ProfessoresController pc = new ProfessoresController(TelaPerfil.this);

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
        btnEditar = findViewById(R.id.btnEditarPerfil);




        if (getIntent().getSerializableExtra("professor") != null) {
            pf = (Professores) getIntent().getSerializableExtra("professor");
        }

        if (pf != null) {
            tvPerfilNome.setText(pf.getNome() );
            tvPerfilEmail.setText(pf.getEmail() );
            tvPerfilIdentificacao.setText( pf.getIdentificacaoInstitucional() );
        }

        btnVoltarPerfil.setOnClickListener(v -> finish());

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String senha = pf.getSenha();
                int id = pf.getId();

                Professores pfa = new Professores(tvPerfilNome.getText().toString(),tvPerfilIdentificacao.getText().toString(),
                        tvPerfilEmail.getText().toString(),senha);
                pfa.setId(id);

                if(pc.atualizaProf(pfa))
                    atualizou();
                else
                    natualizou();

            }
        });


    }

    public void atualizou(){
        Toast.makeText(TelaPerfil.this, "Alterado", Toast.LENGTH_SHORT).show();
        this.recreate();
    }

    public void natualizou(){
        Toast.makeText(TelaPerfil.this, "Erro ao alterar", Toast.LENGTH_SHORT).show();
        this.recreate();
    }

}
