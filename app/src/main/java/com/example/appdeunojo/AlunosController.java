package com.example.appdeunojo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlunosController implements Serializable {

    private SQLiteDatabase db;
    private conectadb banco;

    public AlunosController(Context contexto) {
        this.banco = new conectadb(contexto);
    }

    public boolean insereAluno(Alunos al) {
        String INSERE = "INSERT INTO alunos (email, turma, nome) VALUES ('"
                + al.getEmail() + "','" + al.getTurma() + "','" + al.getNome() + "' )";
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(INSERE);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void apagaAluno(Alunos al) {
        String APAGA = "DELETE FROM alunos WHERE id =" + al.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(APAGA);
            db.close();
        } catch (Exception ex) {
        }
    }

    public void atualizaAluno(Alunos al) {
        String atualiza = "UPDATE alunos SET email = '" + al.getEmail() + "', " +
                "turma = '" + al.getTurma() + "', nome = '" + al.getNome() + "'" + " WHERE id = " + al.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(atualiza);
            db.close();
        } catch (Exception ex) {
        }
    }

    public List<Alunos> ConsultaAlunos() {
        ArrayList<Alunos> lista = new ArrayList<Alunos>();
        String CONSULTA = "SELECT id, nome, email, turma FROM alunos ORDER BY nome";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(CONSULTA, null);

            if (c != null && c.moveToFirst()) {
                do {
                    Alunos al = new Alunos();
                    al.setId(c.getInt(0));
                    al.setNome(c.getString(1));
                    al.setEmail(c.getString(2));
                    al.setTurma(c.getString(3));

                    lista.add(al);
                } while (c.moveToNext());
            }
            if (c != null) {
                c.close();
            }
            bd.close();
            return lista;
        } catch (Exception ex) {
            return null;
        }
    }
}
