package robs.listas2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import robs.listas2.model.Noticia;

public class NoticiaDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_detalhe);


        Noticia noticia = (Noticia) getIntent().getExtras().get("noticia");

        TextView txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        TextView txtTexto = (TextView) findViewById(R.id.txtTexto);

        txtTitulo.setText(noticia.getTitulo());
        txtTexto.setText(noticia.getTexto());

    }
}
