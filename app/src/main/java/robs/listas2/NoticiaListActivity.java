package robs.listas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import robs.listas2.model.Noticia;

public class NoticiaListActivity extends AppCompatActivity {
    private NoticiaListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_list);


        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new NoticiaListAdapter(this);
        adapter.add(new Noticia("Titulo 1", "Texto 1"));
        adapter.add(new Noticia("Titulo 2", "Texto 2"));
        adapter.add(new Noticia("Titulo 3", "Texto 3"));
        adapter.add(new Noticia("Titulo 4", "Texto 4"));
        adapter.add(new Noticia("Titulo 5", "Texto 5"));


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClick(parent, view, position, id);
            }
        });

        //Registra o menu de contexto para a listView de Notícias
        registerForContextMenu(listView);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.noticia_context_menu, menu);
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if(item.getItemId()==R.id.action_noticia_show) {
            Intent intent = new Intent(this, NoticiaDetalheActivity.class);
            Noticia noticia = (Noticia) adapter.getItem(info.position);
            intent.putExtra("noticia", noticia);
            startActivity(intent);
        }else if(item.getItemId()==R.id.action_noticia_edit) {
            Toast.makeText(this, "Editando a Notícia", Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);
    }


    private void onListItemClick(AdapterView<?> parent, View view, int position, long id) {
        Noticia noticia = (Noticia) parent.getAdapter().getItem(position);
        Intent intent = new Intent(this, NoticiaDetalheActivity.class);
        intent.putExtra("noticia", noticia);
        startActivity(intent);
    }
}
