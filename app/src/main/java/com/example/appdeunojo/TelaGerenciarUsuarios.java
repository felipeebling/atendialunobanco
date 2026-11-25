package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class TelaGerenciarUsuarios extends AppCompatActivity {
    private EditText etNomeAluno, etEmailAluno, etTurmaAluno;
    private Button btnCadastrarAluno,btSalvarAluno;
    private ListView lvUsuarios;
    private AlunosController alunosController;

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

        etNomeAluno = findViewById(R.id.etNomeAluno);
        etEmailAluno = findViewById(R.id.etEmailAluno);
        etTurmaAluno = findViewById(R.id.etTurmaAluno);
        btnCadastrarAluno = findViewById(R.id.btnCadastrarAluno);
        btSalvarAluno = findViewById(R.id.btnSalvaAlteracao);
        lvUsuarios = findViewById(R.id.lvUsuarios);

        alunosController = new AlunosController(this);

        btnCadastrarAluno.setOnClickListener(v -> cadastrarAluno());

        carregarUsuarios();

        lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            btSalvarAluno.setVisibility(View.VISIBLE);
            String aluno =  parent.getItemAtPosition(position).toString();
            String alu[] = aluno.split("\n");
                etNomeAluno.setText(alu[1]);
                etTurmaAluno.setText(alu[2]);
                etEmailAluno.setText(alu[3]);

                btSalvarAluno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Alunos al = new Alunos(etEmailAluno.getText().toString()
                                , etNomeAluno.getText().toString(),etTurmaAluno.getText().toString()
                        );
                        al.setId( Integer.parseInt( alu[0] )) ;
                        if(alunosController.atualizaAluno(al) ){
                            alAlterado();

                        }else{
                            naoAlteado();
                        }
                    }
                });

            }
        });
    }

    private void cadastrarAluno() {
        String nome = etNomeAluno.getText().toString().trim();
        String email = etEmailAluno.getText().toString().trim();
        String turma = etTurmaAluno.getText().toString().trim();

        if (nome.isEmpty() || email.isEmpty() || turma.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

        }

        Alunos aluno = new Alunos(email, nome, turma);
        if (alunosController.insereAluno(aluno)) {
            Toast.makeText(this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            etNomeAluno.setText("");
            etEmailAluno.setText("");
            etTurmaAluno.setText("");
            carregarUsuarios();
        } else {
            Toast.makeText(this, "Erro ao cadastrar aluno", Toast.LENGTH_SHORT).show();
        }
    }

    private void carregarUsuarios() {

        List<Alunos> alunosList = alunosController.ConsultaAlunos();
        List<String> nomes = new ArrayList<>();
        if (alunosList != null) {
            for (Alunos al : alunosList) {
                nomes.add( al.getId()+"\n" +al.getNome() + "\n" + al.getTurma() + "\n" + al.getEmail() + "\n" );
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);
        lvUsuarios.setAdapter(adapter);
    }

    private void alAlterado(){
        Toast.makeText(this, "Aluno Alterado", Toast.LENGTH_SHORT).show();

        this.recreate();


    }
    private void naoAlteado(){
        Toast.makeText(this, "ERRO ", Toast.LENGTH_SHORT).show();
    }



}
