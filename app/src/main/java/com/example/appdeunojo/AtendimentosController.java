package com.example.appdeunojo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

public class AtendimentosController implements Serializable {
    private SQLiteDatabase db;
    private conectadb banco;

    public AtendimentosController(Context contexto) {
        this.banco = new conectadb(contexto);
    }

    public Atendimentos ProximoAtendimento(Professores pf) {


        String sql = "SELECT atendimentos.id, atendimentos.aluno_id, alunos.nome, atendimentos.data_prevista, atendimentos.hora_prevista, atendimentos.descricao, atendimentos.local_link, atendimentos.tipo " +
                "FROM atendimentos, alunos " +
                "WHERE atendimentos.aluno_id = alunos.id AND atendimentos.professor_id = " + pf.getId() + " AND atendimentos.situacao = 'AGENDADO' AND atendimentos.data_prevista >= date('now') " +
                "ORDER BY atendimentos.data_prevista ASC, atendimentos.hora_prevista ASC LIMIT 1 ; ";

        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(sql, null);

            if (c != null && c.moveToFirst()) {
                Atendimentos a = new Atendimentos();
                a.setId(c.getInt(0));
                a.setAlunoId(c.getInt(1));
                a.setNomeAluno(c.getString(2));
                a.setDataPrevista(c.getString(3));
                a.setHoraPrevista(c.getString(4));
                a.setDescricao(c.getString(5));
                a.setLocalLink(c.getString(6));
                a.setTipo(c.getString(7));
                a.setProfessorId(pf.getId());
                a.setSituacao("AGENDADO");

                c.close();
                bd.close();
                return a;
            }
            if (c != null) c.close();
            bd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insereAtendimento(Atendimentos at) {

        String slq = "INSERT INTO Atendimentos " +
                "(aluno_id,professor_id,data_prevista,hora_prevista,duracao,tipo,modalidade,descricao,situacao) "
                + "VALUES ('"+at.getAlunoId()+"','"+at.getProfessorId() +"','"+at.getDataPrevista() +"','"+at.getHoraPrevista()
                +"','"+at.getDuracao() +"','"+at.getTipo()+"','"+at.getModalidade() +"','"+at.getDescricao()+"','"+at.getSituacao() +"'); ";

        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(slq);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }


    }

    public boolean AlteraAtendimento(Atendimentos at) {

        String slq = "UPDATE Atendimentos SET " +
                "aluno_id = '" + at.getAlunoId() + "', " +
                "professor_id = '" + at.getProfessorId() + "', " +
                "data_prevista = '" + at.getDataPrevista() + "', " +
                "hora_prevista = '" + at.getHoraPrevista() + "', " +
                "duracao = '" + at.getDuracao() + "', " +
                "tipo = '" + at.getTipo() + "', " +
                "modalidade = '" + at.getModalidade() + "', " +
                "descricao = '" + at.getDescricao() + "', " +
                "situacao = '" + at.getSituacao() + "' " +
                "WHERE id = " + at.getId() + ";";

        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(slq);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean CancelarAtendimento(Atendimentos at) {
        String slq = "UPDATE Atendimentos SET situacao = 'CANCELADO' WHERE id = " + at.getId() + ";";

        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(slq);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }






}
