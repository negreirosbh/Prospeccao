package e.willamesnegreiros.prospeccao.fragmentos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import e.willamesnegreiros.prospeccao.MainActivity;
import e.willamesnegreiros.prospeccao.R;
import e.willamesnegreiros.prospeccao.RecyclerItemClickListener;
import e.willamesnegreiros.prospeccao.adapter.Adapter;
import e.willamesnegreiros.prospeccao.helper.ProspeccaoDAO;
import e.willamesnegreiros.prospeccao.model.Prospeccao;

public class Finalizadas_prospeccao extends Fragment {

    private RecyclerView recyclerView;
    //private List<Filme> listaFilmes = new ArrayList<>();
    private List<Prospeccao> listaProspeccao = new ArrayList<>();
    private ProspeccaoDAO prospeccaoDAO;
    private View view = null;
    private Adapter adapterLista;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        view = inflater.inflate(R.layout.finalizadas_prospeccao, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        //Listagem
        //this.criarFilmes();
        this.criarProspeccao();

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration( view.getContext(), LinearLayout.VERTICAL ) );

/*
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        view.getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {

                            }

                            @Override
                            public void onLongItemClick(final View viewF, int position) {
                                //Recupera prospeccao para deletar

                                final Prospeccao prospecSelecionada = listaProspeccao.get( position );


                                AlertDialog.Builder dialog = new AlertDialog.Builder(viewF.getContext());

                                //Configura título e mensagem
                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir o relatório da NC: " + prospecSelecionada.getNc().toString() + " ?" );

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        prospeccaoDAO = new ProspeccaoDAO(viewF.getContext());
                                        if ( prospeccaoDAO.deletar(prospecSelecionada) ){

                                            Toast.makeText(viewF.getContext(),
                                                    "Sucesso ao excluir tarefa!",
                                                    Toast.LENGTH_SHORT).show();
                                            setUserVisibleHint(true);

                                        }else {
                                            Toast.makeText(viewF.getContext(),
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

                            //((MainActivity)getActivity()).changePagerItem( 0 );
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
*/



        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser){

            atualizarLista();
        }


    }

    public void atualizarLista()
    {
        this.criarProspeccao();

        //Configurar adapter
        adapterLista = new Adapter( listaProspeccao, view.getContext(), getActivity(), this.view );
        //recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapterLista );
        recyclerView.requestLayout();
    }


    public void criarProspeccao(){

        //Prospeccao prospeccao = new Prospeccao((long) 1, "Fortaleza", "25/09/2018", "18:00");
        //listaProspeccao.add(prospeccao);

        prospeccaoDAO = new ProspeccaoDAO(view.getContext());
        listaProspeccao = prospeccaoDAO.listar();



    }


}
