package com.fieb.aula.usuariosenha.api;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSqlSever {

    public static Connection conectar(Context context) {
        //Objeto de conexao
        Connection conn = null;
        try {
//            Adicionar Política de criacao de thread
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

          /* new Thread(new Runnable() {
               @Override
               public void run() {

               }
           }).start();*/


//        Verificar se o driver de Conexao está importada no projeto
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            //Obtenha o IP de seu computador e insira abaixo
            /*conn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.x.x;"+
                    "databaseName=bdConfeitaria;user=sa;password=xxxxx;");
*/
//            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://bdConfeitaria.mssql.somee.com;" +
//                    "databaseName=bdConfeitaria;user=leomar_SQLLogin_1;password=o6k2w94pzc;");

            //Conexão de Teste NESSA PARTE QUE VAI CONECTAR NO BANCO DO SOMEE DO ENZO
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://LEISURE.mssql.somee.com;" +
                    "databaseName=LEISURE;user=daansmyth_SQLLogin_1;password=@leisure123456;");


        } catch (android.database.SQLException e) { // SQLException
            e.getMessage();
            Toast.makeText(context, "Servidor Indisponível", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

