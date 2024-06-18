package com.fieb.aula.usuariosenha.controller;

import android.content.Context;

import com.fieb.aula.usuariosenha.api.Auxiliares;
import com.fieb.aula.usuariosenha.api.ConexaoSqlSever;
import com.fieb.aula.usuariosenha.model.PedidoModel;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class PedidoController {

/*
    public static boolean alterarColaborador(int id, Colaborador colaborador, Context context){
        Boolean sucesso=false;
        try {
            Statement stm = Conexao.conectar(context).createStatement();
            String sql = "";
            sql = "UPDATE usuarios ";
            sql += "SET name='" + colaborador.getNome() + "',";
            sql += " cargo='" + colaborador.getCargo() + "',";
            sql += " situacao='" + colaborador.getSituacao() + "' ";
            sql += "WHERE id='" + id + "'" ;
//            sql += "WHERE id=" + colaborador.getId();
//UPDATE usuarios SET nome='My alteracao in 6', cargo='alt 6', situacao='72' WHERE id='6'
            stm.executeUpdate(sql);
            sucesso=true;
        }
        catch (Exception e){
            e.getMessage();
        }
        return sucesso;
    }
*/


/*
    public static Boolean excluirColaborador(Context context, String codigo) {
        Boolean sucesso = false;
        try {
            Statement stm = Conexao.conectar(context).createStatement();
            stm.execute("DELETE FROM usuarios WHERE id = " + codigo);
//            stm.execute("DELETE FROM usuarios WHERE id ='4' ");
//            ResultSet rs = stm.executeQuery("DELETE FROM usuarios WHERE id = " + codigo);
            sucesso = true;
        } catch (Exception e) {
            e.getMessage();
            sucesso = false;
        }
        return sucesso;
    }
*/


/*
    public static int inserirColaborador(Colaborador colaborador, Context ctx) {

        int resposta = 0;
        try {
            PreparedStatement pst = Conexao.conectar(ctx).prepareStatement(
                    "Insert Into usuarios(name,cargo,situacao) " +
                            "values (?,?,?)"
            );
            pst.setString(1, colaborador.getNome());
            pst.setString(2, colaborador.getCargo());
            pst.setInt(3, colaborador.getSituacao());
            resposta = pst.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        }

        return resposta;
    }
*/

    public boolean alterarItemDoPedido(String id, Context context){
        Boolean sucesso=false;
        try {
            Statement stm = ConexaoSqlSever.conectar(context).createStatement();
            String sql = "";
            sql = "UPDATE tbBolo ";
            sql += "SET frag=1 ";
            sql += "WHERE id=" + id ;
            stm.executeUpdate(sql);
            sucesso=true;
        }
        catch (Exception e){
            e.getMessage();
        }
        return sucesso;
    }

    public ArrayList<PedidoModel> consultaBolo(Context context) {
        ArrayList<PedidoModel> list = new ArrayList<>();



        try {

            Statement stm = ConexaoSqlSever.conectar(context).createStatement();

          //ANTIGO  ResultSet rs = stm.executeQuery("Select id,preco,area,nome_imagem from imovel");
            ResultSet rs = stm.executeQuery("Select id,preco,area,nome_imagem,caminho_imagem from imovel");

            //ContentValues dados = new ContentValues();

            /*String valores = rs.getString(2)+
                    rs.getString(3)+
                    rs.getString(4);*/

            while (rs.next()) {
                PedidoModel pedidoModel = new PedidoModel();

                pedidoModel.setId(rs.getString(1));
                pedidoModel.setPreco(Auxiliares.formatarNumero(rs.getString(2)));
                pedidoModel.setArea("Área: "+rs.getString(3) +" m²");
                pedidoModel.setNome_imagem(rs.getString(4));
                pedidoModel.setCaminho_imagem(rs.getString(5));

                list.add(pedidoModel);
                //valor = Auxiliares.formatarNumero(rvTextPreco.getText().toString());
                /*dados.put("nome",rs.getString(2));
                dados.put("cargo",rs.getString(3));
                dados.put("situacao",rs.getString(4));
*/
                //lista.add((String)dados);

                /*lista.add(rs.getString(2));
                lista.add(rs.getString(3));
                lista.add(rs.getString(4));*/


                 /*lista.add(rs.getString(2));
                 lista.add(rs.getString(3));
                 lista.add(rs.getString(4));*/
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
}