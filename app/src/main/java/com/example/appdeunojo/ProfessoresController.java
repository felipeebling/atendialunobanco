package com.example.appdeunojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProfessoresController implements Serializable {

    private SQLiteDatabase db;
    private conectadb banco;


    public ProfessoresController(Context contexto) {
        this.banco = new conectadb(contexto);
    }
    public boolean insereProfessor(Professores pr) {
        String INSERE = "INSERT INTO professores (email, senha, nome, identificacao_institucional) values ('"
                + pr.getEmail() + "','" + pr.getSenha() + "','" + pr.getNome() + "','" + pr.getIdentificacaoInstitucional() + "' )";
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(INSERE);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Professores PFlogin(String email, String senha){
        String verifica = "Select id, nome, email, senha, identificacao_institucional from professores where email = '" + email + "' and senha = '" + senha + "'";
        Professores pf = new Professores();
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(verifica, null);
            if (c.moveToFirst()) {
                do {
                    pf.setId(c.getInt(0));
                    pf.setNome(c.getString(1));
                    pf.setEmail(c.getString(2));
                    pf.setSenha(c.getString(3));
                    pf.setIdentificacaoInstitucional(c.getString(4));
                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return pf;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void apagaProf(Professores pf) {
        String APAGA = "DELETE FROM professores WHERE id =" + pf.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(APAGA);
            db.close();
        } catch (Exception ex) {
        }
    }

    public boolean atualizaProf(Professores pf) {
        String ATUALIZA_USUARIO = "UPDATE professores SET email = '" + pf.getEmail() + "', " +
                "senha ='" + pf.getSenha() + "', nome = '" + pf.getNome() + "', " +
                "identificacao_institucional = '" + pf.getIdentificacaoInstitucional() + "' WHERE id = " + pf.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(ATUALIZA_USUARIO);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<Professores> ConsultaProfessores() {
        ArrayList<Professores> listaProf = new ArrayList<Professores>();

        String CONSULTA_USUARIO = "SELECT id, nome, email, senha, identificacao_institucional FROM professores ORDER BY nome";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(CONSULTA_USUARIO, null);

            if (c != null && c.moveToFirst()) {
                do {
                    Professores pr = new Professores(
                            c.getString(1), c.getString(4), c.getString(2), c.getString(3));
                    pr.setId(c.getInt(0));
                    listaProf.add(pr);
                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaProf;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<String> Consulta_usuario(String cod) {
        List<String> listaDeUsuarios = new ArrayList<>();
        String CONSULTA_USUARIO = "SELECT id_usr,login,senha FROM usuario WHERE id_usr = "
                + cod + " ORDER BY login";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(CONSULTA_USUARIO, null);
            if (c.moveToFirst()) {
                do {
                    String linha = "id :" + c.getString(0) + "\nLogin :"
                            + c.getString(1) + "\nSenha :" + c.getString(2);
                    listaDeUsuarios.add(linha);
                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaDeUsuarios;
        } catch (Exception ex) {
            return null;
        }
    }



}
