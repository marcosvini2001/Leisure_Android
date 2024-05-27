package com.fieb.aula.usuariosenha.controller;

import android.content.Context;

import com.fieb.aula.usuariosenha.api.BCrypt;
import com.fieb.aula.usuariosenha.api.PasswordBCrypt;
import com.fieb.aula.usuariosenha.model.LoginModel;
import com.fieb.aula.usuariosenha.api.ConexaoSqlSever;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import fieb.aula.confeitaria.api.ConexaoSqlSever;
//import fieb.aula.confeitaria.model.LoginModel;

public class LoginController {

//    public static LoginModel validarLogin(Context context, String email, String senha) {
//
//        try {
//
//            PreparedStatement pst = ConexaoSqlSever.conectar(context).prepareStatement(
////                    "SELECT eMail, senha FROM tbUsuario WHERE eMail=? AND senha=?");
//                    "SELECT email, senha FROM usuario WHERE email=? AND senha=?");
//
//            //Os números abaixo são os indices da ordem dos campos da tabela
//            //Deve seguir a ordem
//            pst.setString(1,email);
//            pst.setString(2,senha);
//
//            ResultSet res = pst.executeQuery();
//
//            while (res.next()) {
//
//                LoginModel    loginModel = new LoginModel();
//
//                loginModel.setEmail(res.getString(1));
//                loginModel.setSenha(res.getString(2));
//                return loginModel;
//}
//
//        } catch (Exception e) {
//                e.getMessage();
//                }
//                return null;
//                }


    public static LoginModel validarLogin(Context context, String email, String senha) {
        try {
            PreparedStatement pst = ConexaoSqlSever.conectar(context).prepareStatement(
                    "SELECT email, senha FROM usuario WHERE email=?");

            pst.setString(1,email);

            ResultSet res = pst.executeQuery();

            while (res.next()) {
                String senhaHash = res.getString("senha");

                // Verifica se a senha fornecida corresponde ao hash armazenado
                if (BCrypt.checkpw(senha, senhaHash)) {
                    LoginModel loginModel = new LoginModel();
                    loginModel.setEmail(res.getString("email"));
                    // Não é seguro retornar a senha do usuário. Você pode retornar null ou uma string vazia, ou omitir este campo completamente.
                    loginModel.setSenha(""); // ou null
                    return loginModel;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }











//    public int cadastrarLogin(LoginModel loginModel, Context context) {
//
//        //Se a resposta for 0 ou menor de 0 então o e-mail não foi encontrado
//        int resposta = 0;
//        try {
//            PreparedStatement pst = ConexaoSqlSever.conectar(context).prepareStatement(
//                    "INSERT INTO Usuario(nome,email,senha,telefone,cpf) values (?,?,?,?,?,)"
//            );
//            pst.setString(1, loginModel.getNome());
//            pst.setString(2, loginModel.getEmail());
//            pst.setString(3, PasswordBCrypt.hashPassword(loginModel.getSenha()));
//            pst.setString(4, loginModel.getTelefone());
//            pst.setString(5, loginModel.getCpf());
//            resposta = pst.executeUpdate();
//
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//        return resposta;
//    }

    public int cadastrarLogin(LoginModel loginModel, Context context) {
        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSqlSever.conectar(context).prepareStatement(
                    "INSERT INTO Usuario(nome,email,senha,celular,cpf,perfil_principal) values (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            pst.setString(1, loginModel.getNome());
            pst.setString(2, loginModel.getEmail());
            pst.setString(3, PasswordBCrypt.hashPassword(loginModel.getSenha()));
            pst.setString(4, loginModel.getTelefone());
            pst.setString(5, loginModel.getCpf());
            pst.setString(6, "ROLE_USER");

            resposta = pst.executeUpdate();

            // Verifica se o usuário foi inserido com sucesso
            if (resposta > 0) {
                // Recupera o ID gerado para o usuário
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int idUsuario = rs.getInt(1); // Obtém o ID gerado
                    cadUsuarioFunc(idUsuario,context);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Exibe qualquer erro no console
        }

        return resposta;
    }



    public void cadUsuarioFunc(int idUsuario, Context context) {

        //Se a resposta for 0 ou menor de 0 então o e-mail não foi encontrado
        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSqlSever.conectar(context).prepareStatement(
                    "INSERT INTO usuario_perfil(id_usuario,id_perfil) values (?,?)"
            );
            pst.setInt(1, idUsuario);
            pst.setInt(2,1);
            resposta = pst.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
