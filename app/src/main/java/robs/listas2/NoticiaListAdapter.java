package robs.listas2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import robs.listas2.model.Noticia;

/**
 * Created by robson on 02/03/16.
 */
public class NoticiaListAdapter extends ArrayAdapter<Noticia>{
    private Context context;

    public NoticiaListAdapter(Context context) {
        super(context, R.layout.row_layout);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        Noticia noticia = this.getItem(position);

        View rowView = inflater.inflate(R.layout.row_layout, parent, false);

        TextView label = (TextView) rowView.findViewById(R.id.label);
        label.setText(noticia.getTitulo());

        ImageView icon = (ImageView) rowView.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.noticia);

        return rowView;
    }
}

