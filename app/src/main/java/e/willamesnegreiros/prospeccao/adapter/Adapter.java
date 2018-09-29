package e.willamesnegreiros.prospeccao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.List;

import e.willamesnegreiros.prospeccao.R;
import e.willamesnegreiros.prospeccao.model.Filme;
import e.willamesnegreiros.prospeccao.model.Prospeccao;

/**
 * Created by jamiltondamasceno
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //private List<Filme> listaFilmes;
    private List<Prospeccao> listaProspeccao;


    public Adapter(List<Prospeccao> lista) {
        this.listaProspeccao = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adpter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Prospeccao prospeccao = listaProspeccao.get( position );

        holder.nc.setText(prospeccao.getNc().toString());
        holder.cidade.setText(prospeccao.getCidade());
        holder.dt.setText(prospeccao.getDt());
        holder.horas.setText(prospeccao.getHora());
        if(position % 2 == 0){
            holder.linearLayout.setBackgroundColor(holder.itemView.getResources().getColor(R.color.colorlinha1));

        }
        else
        {
            holder.linearLayout.setBackgroundColor(holder.itemView.getResources().getColor(R.color.colorlinha2));
        }
        //holder.titulo.setText( filme.getTituloFilme() );
        //holder.genero.setText( filme.getGenero() );
        //holder.ano.setText( filme.getAno() );

    }

    @Override
    public int getItemCount() {
        return listaProspeccao.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nc;
        TextView cidade;
        TextView dt;
        TextView horas;
        LinearLayout linearLayout;
        //TextView titulo;
       // TextView ano;
        //TextView genero;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            nc = itemView.findViewById(R.id.txt_item_nc);
            cidade = itemView.findViewById(R.id.txt_item_cidade);
            dt = itemView.findViewById(R.id.txt_item_data);
            horas = itemView.findViewById(R.id.txt_item_hora);
            //titulo = itemView.findViewById(R.id.textTitulo);
            //ano = itemView.findViewById(R.id.textAno);
            //genero = itemView.findViewById(R.id.textGenero);


        }
    }

}
