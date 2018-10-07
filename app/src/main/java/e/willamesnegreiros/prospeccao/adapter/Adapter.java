package e.willamesnegreiros.prospeccao.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import e.willamesnegreiros.prospeccao.MainActivity;
import e.willamesnegreiros.prospeccao.R;
import e.willamesnegreiros.prospeccao.fragmentos.Finalizadas_prospeccao;
import e.willamesnegreiros.prospeccao.helper.ProspeccaoDAO;
import e.willamesnegreiros.prospeccao.model.Filme;
import e.willamesnegreiros.prospeccao.model.Prospeccao;

/**
 * Created by jamiltondamasceno
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //private List<Filme> listaFilmes;
    private List<Prospeccao> listaProspeccao;
    private LayoutInflater inflater;
    private Context context;
    private ProspeccaoDAO prospeccaoDAO;
    private TableLayout viewPager;
    public  Activity activity;
    public  View parente1;



    public Adapter(List<Prospeccao> lista, Context context, Activity activity, View parente1) {
        this.listaProspeccao = lista;
        inflater = LayoutInflater.from( context );
        this.context = context;
        this.activity = activity;
        this.parente1 = parente1;
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
            holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.colorlinha1));

        }
        else
        {
            holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.colorlinha2));
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

        private TextView nc;
        private TextView cidade;
        private TextView dt;
        private TextView horas;
        //LinearLayout linearLayout;
        protected Button btnEditar;
        //TextView titulo;
       // TextView ano;
        //TextView genero;

        public MyViewHolder(final View itemView) {
            super(itemView);
            //linearLayout = itemView.findViewById(R.id.linearLayout);
            nc = itemView.findViewById(R.id.txt_item_nc);
            cidade = itemView.findViewById(R.id.txt_item_cidade);
            dt = itemView.findViewById(R.id.txt_item_data);
            horas = itemView.findViewById(R.id.txt_item_hora);

            btnEditar = itemView.findViewById( R.id.btnEditarProspeccao );
            //editar.setTag( R.integer.btn_plus_view,itemView);
            //btnEditar.setOnClickListener( this );
            btnEditar.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            v.getContext(),
                            "editar Pressionado",
                            Toast.LENGTH_SHORT
                    ).show();

                   // ((Finalizadas_prospeccao)vv.getParent()).pegarItem( 0 );
                    //((MainActivity)((Finalizadas_prospeccao)v.getParent()).getActivity()).changePagerItem( 0 );
                    //((Finalizadas_prospeccao)get).pegarItem( 0 );

                    //((Finalizadas_prospeccao)parente1.getParent()).enviarDados( Long.parseLong( nc.getText().toString()) );

                    ((MainActivity)activity).enviarDados( 0, Long.parseLong( nc.getText().toString()),
                            dt.getText().toString(), horas.getText().toString() );

                }
            } );

            //titulo = itemView.findViewById(R.id.textTitulo);
            //ano = itemView.findViewById(R.id.textAno);
            //genero = itemView.findViewById(R.id.textGenero);


            itemView.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(final View v) {
                    //Recupera prospeccao para deletar


                    //EditText aux = v.findViewById( R.id.txt_item_nc );

                    AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());

                    //Configura título e mensagem
                    dialog.setTitle("Confirmar exclusão");
                    dialog.setMessage("Deseja excluir o relatório da NC: " + nc.getText() + " ?" );

                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            prospeccaoDAO = new ProspeccaoDAO(v.getContext());
                            if ( prospeccaoDAO.deletar(new String[]{nc.getText().toString(), dt.getText().toString(), horas.getText().toString()}) ){

                                Toast.makeText(v.getContext(),
                                        "Sucesso ao excluir tarefa!",
                                        Toast.LENGTH_SHORT).show();
                                //setUserVisibleHint(true);

                                //removerLista(Long.parseLong(nc.getText().toString()));


                            }else {
                                Toast.makeText(v.getContext(),
                                        "Erro ao excluir tarefa!",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    dialog.setNegativeButton("Não", null );

                    //Exibir dialog
                    dialog.create();
                    dialog.show();
                    //atualizarLista();

                    return true;
                }
            } );
        }


    }

    public void removerLista(Long nc)
    {
        for(int i = 0; i < listaProspeccao.size(); i++)
        {
            if(listaProspeccao.get( i ).getNc() == nc)
            {
                listaProspeccao.remove( i );
                break;
            }
        }
    }

}
