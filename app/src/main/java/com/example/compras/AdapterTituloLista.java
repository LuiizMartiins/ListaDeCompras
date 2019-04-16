package com.example.compras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class AdapterTituloLista extends BaseAdapter {

    private Context context;
    private List<NovaLista> lista;
    private LayoutInflater inflater;

    public AdapterTituloLista(Context context, List<NovaLista> lista) {
        this.context = context;
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {
            convertView = inflater.inflate
                    (R.layout.layout_titulo_lista, null);
            item = new Suporte();
            item.tvIdTitulo = (TextView)
                    convertView.findViewById(R.id.tvIdTituloLista);
            item.tvTitulo = (TextView)
                    convertView.findViewById(R.id.tvTituloLista);

            convertView.setTag(item);
        } else {
            item = (Suporte) convertView.getTag();
        }

        NovaLista Titulo = lista.get(position);
        item.tvIdTitulo.setText(String.valueOf(Titulo.getId()));
        item.tvTitulo.setText(Titulo.getTitulo());


        return convertView;
    }

    private class Suporte {
        TextView tvIdTitulo, tvTitulo;
    }
}



