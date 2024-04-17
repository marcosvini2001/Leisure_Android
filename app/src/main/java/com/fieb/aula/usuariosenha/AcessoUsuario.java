package com.fieb.aula.usuariosenha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AcessoUsuario extends AppCompatActivity {

//    String permissao = "Sem Permissão", nomeUsuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesso_usuario);

//        TextView tvUsuario = findViewById(R.id.tvUsuario);
//        Bundle extra = getIntent().getExtras();
//        if (extra != null) {
//
//            nomeUsuario = extra.getString("chave");
//
//            if (nomeUsuario.equals("eu@gmail.com")) {
//                permissao = "Administrador";
//            } else if (nomeUsuario.equals("eu2@gmail.com")) {
//                permissao = "guest";
//            }
//        }
//        tvUsuario.setText("Bem vindo,\n" + nomeUsuario + "\nVocê é " + permissao);
    }
}