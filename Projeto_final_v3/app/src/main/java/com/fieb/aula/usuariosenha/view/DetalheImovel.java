package com.fieb.aula.usuariosenha.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fieb.aula.usuariosenha.R;
import com.fieb.aula.usuariosenha.controller.ImovelController;
import com.fieb.aula.usuariosenha.model.ImovelModel;
import java.util.List;

public class DetalheImovel extends AppCompatActivity {

    String idImovel;
    Context contexto;
    ImovelController imovelController;
    List<ImovelModel> imoveis;

    public Context aContext;
    private String urlBase = "https://suntech.eco.br/api/uploads/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_imovel);

        // Inicializa o controller e o contexto
        imovelController = new ImovelController();
        contexto = this;

        // Obtém o ID do imóvel da intent
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("chave")) {
            idImovel = extras.getString("chave");

            // Consulta o imóvel no banco de dados
            imoveis = imovelController.consultaImovel(contexto, idImovel);

            // Verifica se foi encontrado algum imóvel
            if (imoveis != null && !imoveis.isEmpty()) {
                ImovelModel imovel = imoveis.get(0); // Assume que apenas um imóvel é retornado

                // Preenche os campos na tela com os dados do imóvel
                preencherDadosImovel(imovel);
            }
        }
    }

    // Método para preencher os campos da tela com os dados do imóvel
    private void preencherDadosImovel(ImovelModel imovel) {
        TextView tvPreco = findViewById(R.id.textPreco);
        TextView tvArea = findViewById(R.id.textArea);
        TextView tvDescricao = findViewById(R.id.textDescricao);
        TextView tvCidade = findViewById(R.id.textCidade);
        TextView tvBairro = findViewById(R.id.textBairro);
        TextView tvCep = findViewById(R.id.textCep);
        TextView tvNum = findViewById(R.id.textNumero);
        TextView tvQuarto = findViewById(R.id.textQuarto);
        TextView tvBanheiro = findViewById(R.id.textBanheiro);
        TextView tvVaga = findViewById(R.id.textVaga);
        TextView tvIptu = findViewById(R.id.textIptu);
        TextView tvSustentabilidade = findViewById(R.id.textSustentabilidade);
        ImageView imgFoto = findViewById(R.id.imgFoto);





        // Preencha os outros campos conforme necessário

        //int idImagem = getResources().getIdentifier("decoracao_minimalista_apartamento", "drawable", contexto.getPackageName());

//        int idImagem = getResources().getIdentifier(imovel.getNome_imagem(),"drawable",contexto.getPackageName());
//        imgFoto.setImageResource(idImagem);

        String urlImagem = imovel.getCaminho_imagem();
       // String imageUrl = urlBase+"fotoImovel"+idImovel+".png";
        Glide.with(this)
                .load(urlImagem)
                .into(imgFoto);

        // Define os valores dos campos com os dados do imóvel
        tvPreco.setText(imovel.getPreco());
        tvArea.setText(imovel.getArea());
        tvDescricao.setText(imovel.getDescricao());
        tvCidade.setText(imovel.getCidade());
        tvBairro.setText(imovel.getBairro());
        tvCep.setText(imovel.getCep());
        tvNum.setText(imovel.getNum_residencia());
        tvQuarto.setText(imovel.getQtde_quarto());
        tvIptu.setText(imovel.getIptu());
        tvBanheiro.setText(imovel.getQtde_banheiro());
        tvVaga.setText(imovel.getQtde_vaga_garagem());

        tvSustentabilidade.setText(imovel.getSustentabilidade());




        // Preencha os outros campos conforme necessário
    }
}
