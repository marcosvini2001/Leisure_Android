package com.fieb.aula.usuariosenha.view;


import com.fieb.aula.usuariosenha.model.PedidoModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import com.fieb.aula.usuariosenha.R;
import com.fieb.aula.usuariosenha.api.Auxiliares;
import com.fieb.aula.usuariosenha.api.PedidoAdapter;
//import com.fieb.aula.usuariosenha.controller.ItensDoPedidoController;
import com.fieb.aula.usuariosenha.controller.PedidoController;
import com.fieb.aula.usuariosenha.model.PedidoModel;

public class AcessoUsuario extends AppCompatActivity {

    PedidoController pedidoController;

    List<PedidoModel> pedidos; //Linha dos dados
    RecyclerView recyclerView; //Objetos receberá os dados montados

    PedidoAdapter pedidoAdapter;

//    Button btnFecharPedido;
//    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesso_usuario);

        recyclerView = findViewById(R.id.rvPedidos);

//        btnFecharPedido=findViewById(R.id.btnFecharPedido);
//        tvTotal=findViewById(R.id.tvTotal);

        //==============LIMPEZA DOS DADOS========
        // Limpar Shared
//        Auxiliares.preferencesManagerIncluir(getApplicationContext(),"itensDaCompra","R$ 0,00");
        // Limpar dados de compra
//        ItensDoPedidoController itensDoPedidoController=new ItensDoPedidoController();
//        itensDoPedidoController.deixarTabelasValoresPadrao(getApplicationContext());
        //=======================================
        carregaLista();
    }

    public void onStart() {
        super.onStart();
        carregaLista();
    }


    private void carregaLista() {
        pedidoController = new PedidoController();

        //Obtem a lista de totos os bolos
        pedidos = pedidoController.consultaBolo(AcessoUsuario.this);

        //Adaptador RecyclerView passando a lista de bolos
        pedidoAdapter = new PedidoAdapter(pedidos,AcessoUsuario.this);

        //Add a Linha onde está no LinearLayout
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(pedidoAdapter);
    }

    public void voltarTelaPedido(View view) {
        finish();
    }

    public void finalizaPedido(View view) {

    }
}


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