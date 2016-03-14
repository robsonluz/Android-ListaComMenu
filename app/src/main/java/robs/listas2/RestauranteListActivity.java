package robs.listas2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RestauranteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_list);

        ListView listView = (ListView) findViewById(R.id.listView);

        String[] restaurantes = new String[]{
                "Restaurante 1","Restaurante 2","Restaurante 3",
                "Restaurante 4","Restaurante 5","Restaurante 6",
                "Restaurante 7","Restaurante 8","Restaurante 9",
                "Restaurante 7","Restaurante 8","Restaurante 9",
                "Restaurante 7","Restaurante 8","Restaurante 9",
                "Restaurante 7","Restaurante 8","Restaurante 9",
                "Restaurante 7","Restaurante 8","Restaurante 9",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.row_layout,
                R.id.label,
                restaurantes
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClickListener(parent, view, position, id);
            }
        });

    }

    private void onItemClickListener(AdapterView<?> parent, View view, int position, long id) {
        String restaurante = (String) parent.getAdapter().getItem(position);
        Toast.makeText(this, "Restaurante selecionado: " + restaurante, Toast.LENGTH_SHORT).show();
    }

}
