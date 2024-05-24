package com.fieb.aula.usuariosenha.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fieb.aula.usuariosenha.controller.LoginController;
import com.fieb.aula.usuariosenha.model.LoginModel;
import com.fieb.aula.usuariosenha.R;
import com.fieb.aula.usuariosenha.api.Auxiliares;

//import fieb.aula.confeitaria.R;
//import fieb.aula.confeitaria.api.Auxiliares;
//import fieb.aula.confeitaria.controller.LoginController;
//import fieb.aula.confeitaria.model.LoginModel;

public class CadastrarEmailSenha extends AppCompatActivity {

    Button btnCadastrarUsuario;
    EditText edtEmail, edtConfirmaSenha, edtSenha, edtNome, edtCpf, edtTel;

    //Instancia o usuário para obter os dados por get/set
    LoginModel loginModel;

    //Instancia o Controller para acesso aos dados
    LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_email_senha);

        inicializaComponentes();

        btnCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(edtEmail.getText().toString())) {
                    edtEmail.setError("Obrigatório *");
                    edtEmail.requestFocus();
                } else if (TextUtils.isEmpty(edtSenha.getText().toString())) {
                    edtSenha.setError("Obrigatório *");
                    edtSenha.requestFocus();
                } else if (TextUtils.isEmpty(edtConfirmaSenha.getText().toString())) {
                    edtConfirmaSenha.setError("Obrigatório *");
                    edtConfirmaSenha.requestFocus();
                } else if (TextUtils.isEmpty(edtNome.getText().toString())) {
                    edtNome.setError("Obrigatório *");
                    edtNome.requestFocus();
                } else if (TextUtils.isEmpty(edtCpf.getText().toString())) {
                    edtCpf.setError("Obrigatório *");
                    edtCpf.requestFocus();
                } else if (TextUtils.isEmpty(edtTel.getText().toString())) {
                    edtTel.setError("Obrigatório *");
                    edtTel.requestFocus();
                } else if (!(edtSenha.getText().toString().equals(edtConfirmaSenha.getText().toString()))) {
                    Auxiliares.alertCustom(getApplicationContext(), "As senhas devem ser Iguais");
                    edtConfirmaSenha.requestFocus();
                } else if (!Auxiliares.validEmail(edtEmail.getText().toString().trim())) {
                    Auxiliares.alertCustom(getApplicationContext(), "Formato do e-mail incorreto");
                    edtEmail.requestFocus();
                } else {
                    loginModel = new LoginModel();
                    loginModel.setEmail(edtEmail.getText().toString());
                    loginModel.setSenha(edtSenha.getText().toString());
                    loginModel.setCpf(edtCpf.getText().toString());
                    loginModel.setNome(edtNome.getText().toString());
                    loginModel.setTelefone(edtTel.getText().toString());

                    loginController = new LoginController();

                    //Se validar retorna valor 0 ou menor, então não cadastrou o e-mail/senha
                    int validar = loginController.cadastrarLogin(loginModel, getApplicationContext());
                    if (validar > 0) {
                        Auxiliares.alert(getApplicationContext(), "Cadastro realizado com Sucesso!");
                        finish();
                    } else {
                        Auxiliares.alert(getApplicationContext(), "Error no Cadastro!");
                    }
                }
            }
        });
    }

    private void inicializaComponentes() {

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfirmaSenha = findViewById(R.id.edtConfirmaSenha);
        edtCpf = findViewById(R.id.edtCpf);
        edtTel = findViewById(R.id.edtTel);
        edtNome = findViewById(R.id.edtNome);

        edtEmail.setText("");
        edtSenha.setText("");
        edtConfirmaSenha.setText("");
        edtCpf.setText("");
        edtTel.setText("");
        edtNome.setText("");


        btnCadastrarUsuario = findViewById(R.id.btnCadastrarUsuario);

        setTitle("Novo Cadastro");
        edtNome.requestFocus();
    }

    public void fecharCadastro(View view) {
        finish();
    }
}