package br.com.caicosoft.minhasanotacoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etAnotacao;

    private AnotacoesPreferencias anotacoesPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAnotacao = findViewById(R.id.etAnotacao);

        anotacoesPreferencias = new AnotacoesPreferencias(getApplicationContext()); // aqui passa o contexto para AnotacoesPreferencias

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // valida se foi digitado algo
                String textoRecuperado = etAnotacao.getText().toString();
                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Digite alguma anotação!", Snackbar.LENGTH_LONG).show();
                }else{

                    anotacoesPreferencias.salvarAnotacoes(textoRecuperado);

                    Snackbar.make(view, "Anotações Salvas!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        // recuperar anotacoes
        String anotacao = anotacoesPreferencias.recuperarAnotacoes();
        if( ! anotacao.equals("")){ // apenas altera texto caso exista conteudo
            etAnotacao.setText(anotacao);
        }

    }
}
