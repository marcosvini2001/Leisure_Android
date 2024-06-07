package com.fieb.aula.usuariosenha.controller;

import android.content.Context;

import com.fieb.aula.usuariosenha.api.Auxiliares;
import com.fieb.aula.usuariosenha.api.ConexaoSqlSever;
import com.fieb.aula.usuariosenha.model.ImovelModel;
import com.fieb.aula.usuariosenha.model.PedidoModel;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ImovelController {

    Context meuContexto;

    public ArrayList<ImovelModel> consultaImovel(Context context, String id) {
        ArrayList<ImovelModel> list = new ArrayList<>();

        Context meuContexto = context;


        try {

            Statement stm = ConexaoSqlSever.conectar(meuContexto).createStatement();

            ResultSet rs = stm.executeQuery("SELECT id, preco, area, descricao, cidade, bairro, cep, num_residencia, qtde_quarto, qtde_banheiro, qtde_vaga_garagem, iptu, sustentabilidade, nome_imagem FROM imovel WHERE id = " + id);

//            ResultSet rs = stm.executeQuery("Select id,preco,descricao,cidade,bairro,cep, num_residencia,qtde_quarto,qtde_banheiro,qtde_vaga_garagem,area,sustentabilidade,nome_imagem from imovel where id="+id);

            //ContentValues dados = new ContentValues();

            /*String valores = rs.getString(2)+
                    rs.getString(3)+
                    rs.getString(4);*/

            while (rs.next()) {
                ImovelModel imovelModel  = new ImovelModel();

                imovelModel.setId(rs.getString(1));
                imovelModel.setPreco(Auxiliares.formatarNumero(rs.getString(2)));
                imovelModel.setArea("Área: "+rs.getString(3) +" m²");
                imovelModel.setDescricao("Descrição: "+rs.getString(4));
                imovelModel.setNome_imagem(rs.getString(14));

                imovelModel.setCidade("Cidade: "+rs.getString(5));
                imovelModel.setBairro("Bairro: "+rs.getString(6));
                imovelModel.setCep("Cep: "+rs.getString(7));
                imovelModel.setNum_residencia("Nº: "+rs.getString(8));
                imovelModel.setQtde_quarto("Qtde Quartos: "+rs.getString(9));
                imovelModel.setQtde_banheiro("Qtde Banheiro: "+rs.getString(10));
                imovelModel.setQtde_vaga_garagem("Vaga Garagem: "+rs.getString(11));
                imovelModel.setIptu("IPTU: R$ "+rs.getString(12));
                imovelModel.setSustentabilidade("Sustentabilidade: "+rs.getString(13));

                list.add(imovelModel);
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
