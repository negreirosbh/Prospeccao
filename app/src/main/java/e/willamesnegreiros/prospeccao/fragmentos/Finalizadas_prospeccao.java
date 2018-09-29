package e.willamesnegreiros.prospeccao.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import e.willamesnegreiros.prospeccao.R;
import e.willamesnegreiros.prospeccao.RecyclerItemClickListener;
import e.willamesnegreiros.prospeccao.adapter.Adapter;
import e.willamesnegreiros.prospeccao.model.Filme;
import e.willamesnegreiros.prospeccao.model.Prospeccao;

public class Finalizadas_prospeccao extends Fragment {

    private RecyclerView recyclerView;
    //private List<Filme> listaFilmes = new ArrayList<>();
    private List<Prospeccao> listaProspeccao = new ArrayList<>();

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View view = inflater.inflate(R.layout.finalizadas_prospeccao, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);




        //Listagem
        //this.criarFilmes();
        this.criarProspeccao();

        //Configurar adapter
        Adapter adapterLista = new Adapter( listaProspeccao );

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapterLista );

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {

                           @Override
                            public void onItemClick(View view, int position) {
                                Prospeccao prospeccao = listaProspeccao.get( position );
                                Toast.makeText(
                                        getActivity(),
                                        "Item pressionado: " + prospeccao.getNc(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Prospeccao prospeccao = listaProspeccao.get( position );
                                Toast.makeText(
                                        getActivity(),
                                        "Click longo: "  + prospeccao.getNc(),
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        return view;
    }
/*
    public void criarFilmes(){

        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");

        listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civíl", "Aventura/Ficção", "2016");
        listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        listaFilmes.add(filme);

    }
*/
    public void criarProspeccao(){

        Prospeccao prospeccao = new Prospeccao((long) 1, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);
        //linearLayout.setBackgroundColor(getResources().getColor(R.color.colorlinha1));

        prospeccao = new Prospeccao((long) 2, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);
        //linearLayout.setBackgroundColor(getResources().getColor(R.color.colorlinha2));

        prospeccao = new Prospeccao((long) 3, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);
        //linearLayout.setBackgroundColor(getResources().getColor(R.color.colorlinha1));

        prospeccao = new Prospeccao((long) 4, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);
        //linearLayout.setBackgroundColor(getResources().getColor(R.color.colorlinha2));

        prospeccao = new Prospeccao((long) 5, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);
        //linearLayout.setBackgroundColor(getResources().getColor(R.color.colorlinha1));

        prospeccao = new Prospeccao((long) 6, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 7, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 8, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 9, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 10, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 11, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 12, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 13, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 14, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 14, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 15, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 16, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 17, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 18, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 19, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 20, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);

        prospeccao = new Prospeccao((long) 21, "Fortaleza", "25/09/2018", "18:00");
        listaProspeccao.add(prospeccao);


    }
}
