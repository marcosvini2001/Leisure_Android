package com.fieb.aula.usuariosenha.api;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.bumptech.glide.Glide;
import com.fieb.aula.usuariosenha.R;
import com.fieb.aula.usuariosenha.controller.PedidoController;
import com.fieb.aula.usuariosenha.model.PedidoModel;
import com.fieb.aula.usuariosenha.view.DetalheImovel;
//import com.fieb.aula.usuariosenha.view.ItensDoPedido;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.ViewHolder> {
    @NonNull

    public List<PedidoModel> listPedido;
    public Context aContext;

    PedidoController pedidoController;

    String valor="";

    private String urlBase = "https://suntech.eco.br/api/uploads/";

    public PedidoAdapter(List<PedidoModel> pedido, Context context) {
        listPedido = pedido;
        aContext = context;
    }

    @Override
    public PedidoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View linhaView = inflater.inflate(R.layout.linhas_lista_imoveis_rs, parent, false);
        ViewHolder viewHolder = new ViewHolder(linhaView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoAdapter.ViewHolder holder, int position) {
        PedidoModel objLinha = listPedido.get(position);

//        TextView tvIdBolo = holder.rvIdBolo;
        TextView tvIdBolo = holder.rvIdImovel;
        tvIdBolo.setText(String.valueOf(objLinha.getId()));

//        ========Carrega as Imagens===========



//      Resources resources = aContext.getResources();
//      int idR = resources.getIdentifier(objLinha.getNome_imagem(), "drawable", aContext.getPackageName());
//      ImageView tvImagemBolo = holder.rvImgFoto;
//      tvImagemBolo.setImageResource(idR);

        ImageView tvImagemImovel = holder.rvImgFoto;
        String urlImagem = urlBase+"fotoImovel"+objLinha.getId()+".png";
        Glide.with(holder.itemView.getContext())
                .load(urlImagem)
                .into(tvImagemImovel);

//        =====================================

        TextView tvNomeBolo = holder.rvTextArea;
        tvNomeBolo.setText(objLinha.getArea());

        TextView tvDescricao = holder.rvTextPreco;
        tvDescricao.setText(objLinha.getPreco());

    }

    @Override
    public int getItemCount() {
        return listPedido.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView rvIdImovel;
       public ImageView rvImgFoto;
        public TextView rvTextArea;
        public TextView rvTextPreco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rvIdImovel = itemView.findViewById(R.id.rvIdImovel);
            rvImgFoto = itemView.findViewById(R.id.imgFoto);
            rvTextArea = itemView.findViewById(R.id.textArea);
            rvTextPreco = itemView.findViewById(R.id.textPreco);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(aContext, DetalheImovel.class );
            intent.putExtra("chave", rvIdImovel.getText().toString());
            intent.putExtra("contexto", "aContext");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            aContext.startActivity(intent);


            //valor = Auxiliares.formatarNumero(rvTextPreco.getText().toString());
//            caixaDialogo("I M Ó V E I S", rvTextArea.getText().toString()+ "\nPreço: "+ rvTextPreco.getText().toString());
            //caixaDialogo("I M Ó V E I S", "Área:"+rvTextArea.getText().toString()+ "\nPreço:"+ valor);
//            caixaDialogo("I M Ó V E I S", "Imagem:"+R.drawable.decoracao_casa_moderna_casa);
//            CRIAR DO POUP-UP


//            pedidoController = new PedidoController();

            //Grava no Frag o valor 1 para consultar os itens do pedido
//            pedidoController.alterarItemDoPedido(rvIdImovel.getText().toString(), aContext);
//
//            Intent intent = new Intent(aContext, ItensDoPedido.class);
//
//            //Passando o id do Bolo e o valor
//            intent.putExtra("chave", rvIdBolo.getText().toString());
//            intent.putExtra("chaveValorBolo", rvPrecoBolo.getText().toString());
//            intent.putExtra("contextPedido", "aContext");
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            aContext.startActivity(intent);
        }

    }
        public void caixaDialogo(String titulo, String info) {

            AlertDialog.Builder quemSomos = new AlertDialog.Builder(aContext);
            quemSomos.setTitle(titulo);
            quemSomos.setMessage(info);

            quemSomos.setCancelable(false);

            quemSomos.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            try {
                quemSomos.create().show();
            }catch (Exception erra){
                erra.getMessage();
            }
        }

}