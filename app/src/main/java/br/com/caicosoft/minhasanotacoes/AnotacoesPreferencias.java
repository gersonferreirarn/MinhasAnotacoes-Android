package br.com.caicosoft.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferencias {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String NOME_ARQUIVO = "anotacao.preferencia";
    private static final String CHAVE_NOME = "nome";

    public AnotacoesPreferencias(Context c) {
        this.context = c; // quado iniciar a classe, tem que passar o contexto
        sharedPreferences = context.getSharedPreferences(NOME_ARQUIVO, 0); // RECUPERA zero diz que apenas o app tem acesso ao arquivo
        editor = sharedPreferences.edit(); // SALVA
    }

    public void salvarAnotacoes(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String recuperarAnotacoes(){
        return sharedPreferences.getString(CHAVE_NOME, "");
    }

}
