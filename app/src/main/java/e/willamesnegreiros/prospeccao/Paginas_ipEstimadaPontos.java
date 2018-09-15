package e.willamesnegreiros.prospeccao;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import e.willamesnegreiros.prospeccao.fragmentos.Devolvidas_ipEstimada;
import e.willamesnegreiros.prospeccao.fragmentos.Finalizadas_ipEstimada;
import e.willamesnegreiros.prospeccao.fragmentos.IpMedidaPontosFragment;
import e.willamesnegreiros.prospeccao.fragmentos.Novo_ipEstimada;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class Paginas_ipEstimadaPontos extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;


    //Constructor to the class
    public Paginas_ipEstimadaPontos(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                IpMedidaPontosFragment novo_ipEstimadaPonto = new IpMedidaPontosFragment();
                return novo_ipEstimadaPonto;
            case 1:
                Finalizadas_ipEstimada finalizadas_ipEstimada = new Finalizadas_ipEstimada();
                return finalizadas_ipEstimada;
            case 2:
                Devolvidas_ipEstimada devolvidas_ipEstimada = new Devolvidas_ipEstimada();
                return devolvidas_ipEstimada;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}