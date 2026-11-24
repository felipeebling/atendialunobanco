package com.example.appdeunojo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conectadb extends SQLiteOpenHelper {

    String tabprof = "CREATE TABLE IF NOT EXISTS professores (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, senha TEXT, nome TEXT, identificacao_institucional TEXT);";

    String tabalu = "CREATE TABLE IF NOT EXISTS alunos (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, turma TEXT, nome TEXT);";

    String tabAtendi = "CREATE TABLE IF NOT EXISTS atendimentos (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    professor_id INT NOT NULL,\n" +
            "    aluno_id INT NOT NULL,\n" +
            "    data_prevista DATE NOT NULL,\n" +
            "    hora_prevista TIME NOT NULL,\n" +
            "    duracao INT NOT NULL,\n" +
            "    disciplina VARCHAR(100),\n" +
            "    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('DUVIDAS', 'TCC', 'PROJETOS', 'PRATICAS')),\n" +
            "    modalidade VARCHAR(15) NOT NULL CHECK (modalidade IN ('PRESENCIAL', 'ONLINE')),\n" +
            "    local_link VARCHAR(255),\n" +
            "    descricao TEXT NOT NULL,\n" +
            "    observacoes TEXT,\n" +
            "    situacao VARCHAR(25) DEFAULT 'AGENDADO' CHECK (situacao IN ('SOLICITADO', 'AGENDADO', 'REALIZADO', 'PARCIAL', 'NAO_COMPARECEU', 'NAO_REALIZADO', 'CANCELADO')),\n" +
            "    conteudo_tratado TEXT,\n" +
            "    compareceu BOOLEAN,\n" +
            "    motivo_cancelamento TEXT,\n" +
            "    encaminhamento TEXT,\n" +
            "    prazo_encaminhamento DATE,\n" +
            "    encaminhamento_concluido BOOLEAN DEFAULT FALSE,\n" +
            "    FOREIGN KEY (professor_id) REFERENCES professores(id),\n" +
            "    FOREIGN KEY (aluno_id) REFERENCES alunos(id)\n" +
            ");";

    conectadb(Context contexto) {
        super(contexto, "osdb", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabprof);
        sqLiteDatabase.execSQL(tabalu);
        sqLiteDatabase.execSQL(tabAtendi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String RECRIA = "DROP TABLE IF EXISTS atendimentos";
        String RECRIA2 = "DROP TABLE IF EXISTS professores";
        String RECRIA3 = "DROP TABLE IF EXISTS alunos";
        sqLiteDatabase.execSQL(RECRIA);
        sqLiteDatabase.execSQL(RECRIA2);
        sqLiteDatabase.execSQL(RECRIA3);
        onCreate(sqLiteDatabase);
    }
}
