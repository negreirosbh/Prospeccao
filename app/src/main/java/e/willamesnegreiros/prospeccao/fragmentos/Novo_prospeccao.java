package e.willamesnegreiros.prospeccao.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import e.willamesnegreiros.prospeccao.R;
import e.willamesnegreiros.prospeccao.helper.ProspeccaoDAO;
import e.willamesnegreiros.prospeccao.model.Prospeccao;

public class Novo_prospeccao extends Fragment {

    public Prospeccao prospeccao = new Prospeccao(  );
    public ProspeccaoDAO prospeccaoDAO;
    public Button btnSalvar;
    private AutoCompleteTextView cidade;
    private EditText nc;
    private EditText nf;
    private Spinner fases;
    private EditText disjuntor;
    private EditText leitura;
    private EditText disco;
    private EditText voltas;
    private EditText kdMedid;
    private Spinner classe;
    private Spinner atividade;
    private EditText coordenadaX;
    private EditText coordenadaY;
    private Spinner acao;
    private EditText observacao;

    private String[] cidades;

    private Long long_nc;
    private Long long_nf;
    private Integer intDisco;
    private Integer intVoltas;
    private Long long_coordenadaX;
    private Long long_coordenadaY;
    private View view;

    private String strAux1;
    private String strAux2;

    private boolean existeRegistro = false;
    private String[] args;


    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes


        view = inflater.inflate(R.layout.novo_prospeccao, container, false);
        btnSalvar = view.findViewById(R.id.btnSalvar_prospecao);
        cidade = view.findViewById(R.id.txtCidade_prospecao);
        nc = view.findViewById(R.id.txtUC_prospecao);
        nf = view.findViewById(R.id.txtNF_prospecao);
        fases = view.findViewById(R.id.spiFases_prospecao);
        disjuntor = view.findViewById( R.id.txtDisjuntor_prospecao);
        leitura = view.findViewById( R.id.txtLeitura_prospecao);
        disco = view.findViewById( R.id.txtTempLed_prospecao);
        voltas = view.findViewById( R.id.txtVoltas_prospecao);
        kdMedid = view.findViewById( R.id.txtKDMedidor_prospecao);
        classe = view.findViewById( R.id.spiClasse_prospecao);
        atividade = view.findViewById( R.id.spiAtividade_prospecao);
        coordenadaX = view.findViewById( R.id.txtCoordX_prospecao);
        coordenadaY = view.findViewById( R.id.txtCoordY_prospecao);
        acao = view.findViewById( R.id.spiAcao_prospecao);
        observacao = view.findViewById( R.id.txtOBS_prospecao);




        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prospeccao = new Prospeccao();
                prospeccao.setCidade( cidade.getText().toString() );

                if( nc.getText().toString().isEmpty() ||  nc.getText().toString() == "")
                {
                    long_nc = 0L;
                }
                else
                {
                    long_nc = Long.parseLong( nc.getText().toString() );
                }

                if( nf.getText().toString().isEmpty() ||  nf.getText().toString() == "")
                {
                    long_nf = 0l;
                }
                else
                {
                    long_nf = Long.parseLong( nf.getText().toString() );
                }
                prospeccao.setNc(long_nc);
                prospeccao.setNf(long_nf);
                prospeccao.setFases( fases.getSelectedItem().toString() );
                prospeccao.setDisjuntor( disjuntor.getText().toString() );
                prospeccao.setLeitura( leitura.getText().toString());


                if( disco.getText().toString().isEmpty() ||  disco.getText().toString() == "")
                {
                    intDisco = 0;
                }
                else
                {
                    intDisco = Integer.parseInt( disco.getText().toString() );
                }

                if( voltas.getText().toString().isEmpty() ||  voltas.getText().toString() == "")
                {
                    intVoltas = 0;
                }
                else
                {
                    intVoltas = Integer.parseInt( voltas.getText().toString() );
                }



                prospeccao.setDisco( intDisco );
                prospeccao.setVoltas( intVoltas );
                prospeccao.setKdMedid( kdMedid.getText().toString() );
                prospeccao.setClasse( classe.getSelectedItem().toString() );
                prospeccao.setAtividade( atividade.getSelectedItem().toString() );

                if( coordenadaX.getText().toString().isEmpty() ||  coordenadaX.getText().toString() == "")
                {
                    long_coordenadaX = 0l;
                }
                else
                {
                    long_coordenadaX = Long.parseLong( coordenadaX.getText().toString() );
                }

                if( coordenadaY.getText().toString().isEmpty() ||  coordenadaY.getText().toString() == "")
                {
                    long_coordenadaY = 0l;
                }
                else
                {
                    long_coordenadaY = Long.parseLong( coordenadaY.getText().toString() );
                }


                prospeccao.setCoordenadaX( long_coordenadaX );
                prospeccao.setCoordenadaY( long_coordenadaY );
                prospeccao.setAcao( acao.getSelectedItem().toString() );
                prospeccao.setObservacao( observacao.getText().toString());


                prospeccaoDAO = new ProspeccaoDAO(view.getContext());

                if(existeRegistro)
                {
                    if(prospeccaoDAO.atualizar(prospeccao, args))
                    {
                        limparTela();
                        Log.i("Atualizar", "Atualizado com sucesso");
                        Toast.makeText(
                                getActivity(),
                                "NC " + prospeccao.getNc().toString() + " Atualizado com sucesso",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                    existeRegistro = false;

                }
                else
                {
                    if(prospeccaoDAO.salvar(prospeccao))
                    {
                        limparTela();
                        Log.i("Salvar", "Salvo com sucesso");
                        Toast.makeText(
                                getActivity(),
                                "NC " + prospeccao.getNc().toString() + " Salvo com sucesso",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }



                //cidade.setText("fortaleza");
                //Log.i("cidade", cidade.getText().toString());
            }
        });
        cidades = view.getResources().getStringArray(R.array.cidades_arrays);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_expandable_list_item_1, cidades);
        cidade.setAdapter(adapter);

        //nc.setText( getArguments().getString( "strNc" ) );
        prospeccao = (Prospeccao) getArguments().getSerializable( "prospeccao" );


        realizarConsuta();


        cidade.setText( prospeccao.getCidade().toString() );
        nc.setText( prospeccao.getNc().toString() );
        nf.setText( prospeccao.getNc().toString() );

        strAux1 = prospeccao.getFases().toString();
        for(int i = 0; i < fases.getCount(); i++)
        {
            if(prospeccao.getFases().toString() == "")
            {
                break;
            }
            fases.setSelection( i );

            strAux2 = fases.getSelectedItem().toString();
            if(strAux1.equals( strAux2 ))
            {
                break;
            }

        }

        disjuntor.setText( prospeccao.getDisjuntor().toString() );
        leitura.setText( prospeccao.getLeitura().toString() );
        disco.setText( prospeccao.getDisco().toString() );
        voltas.setText( prospeccao.getVoltas().toString() );
        kdMedid.setText( prospeccao.getKdMedid().toString() );

        strAux1 = prospeccao.getClasse().toString();
        for(int i = 0; i < classe.getCount(); i++)
        {
            if(prospeccao.getClasse().toString() == "")
            {
                break;
            }
            classe.setSelection( i );

            strAux2 = classe.getSelectedItem().toString();
            if(strAux1.equals( strAux2 ))
            {
                break;
            }

        }

        strAux1 = prospeccao.getAtividade().toString();
        for(int i = 0; i < atividade.getCount(); i++)
        {
            if(prospeccao.getAtividade().toString() == "")
            {
                break;
            }
            atividade.setSelection( i );

            strAux2 = atividade.getSelectedItem().toString();
            if(strAux1.equals( strAux2 ))
            {
                break;
            }

        }

        coordenadaX.setText( prospeccao.getCoordenadaX().toString() );
        coordenadaY.setText( prospeccao.getCoordenadaY().toString() );

        strAux1 = prospeccao.getAcao().toString();
        for(int i = 0; i < acao.getCount(); i++)
        {
            if(prospeccao.getAcao().toString() == "")
            {
                break;
            }
            acao.setSelection( i );

            strAux2 = acao.getSelectedItem().toString();
            if(strAux1.equals( strAux2 ))
            {
                break;
            }

        }

        observacao.setText( prospeccao.getObservacao().toString() );

        if(prospeccao.getNc() == 0)
        {
            limparTela();
        }

        return view;
    }


    public void limparTela()
    {
        cidade.setText("");
        nc.setText("");
        nf.setText("");
        fases.setSelection( 0 );
        disjuntor.setText( "" );
        leitura.setText( "" );
        disco.setText( "" );
        voltas.setText( "" );
        kdMedid.setText( "" );
        classe.setSelection( 0 );
        atividade.setSelection( 0 );
        coordenadaX.setText( "" );
        coordenadaY.setText( "" );
        acao.setSelection( 0 );
        observacao.setText( "" );

    }

    public  void realizarConsuta()
    {
        if(prospeccao.getNc() > 0 && prospeccao.getDt() != "" && prospeccao.getHora() != "")
        {
            existeRegistro = true;
            prospeccaoDAO = new ProspeccaoDAO(view.getContext());
            args = new String[]{prospeccao.getNc().toString(), prospeccao.getDt(), prospeccao.getHora()};
            prospeccao = prospeccaoDAO.consulta( args );
        }

    }
}
