package e.willamesnegreiros.prospeccao;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import e.willamesnegreiros.prospeccao.fragmentos.Devolvidas_prospeccao;
import e.willamesnegreiros.prospeccao.fragmentos.Finalizadas_prospeccao;
import e.willamesnegreiros.prospeccao.fragmentos.Novo_prospeccao;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class Paginas_prospeccao extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;


    //Constructor to the class
    public Paginas_prospeccao(FragmentManager fm, int tabCount) {
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
                Novo_prospeccao novo_prospeccao = new Novo_prospeccao();
                return novo_prospeccao;
            case 1:
                Finalizadas_prospeccao finalizadas_prospeccao = new Finalizadas_prospeccao();
                return finalizadas_prospeccao;
            case 2:
                Devolvidas_prospeccao devolvidas_prospeccao = new Devolvidas_prospeccao();
                return devolvidas_prospeccao;
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