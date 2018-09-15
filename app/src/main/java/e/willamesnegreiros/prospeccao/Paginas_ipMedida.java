package e.willamesnegreiros.prospeccao;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import e.willamesnegreiros.prospeccao.fragmentos.Devolvidas_ipMedida;
import e.willamesnegreiros.prospeccao.fragmentos.Finalizadas_ipMedida;
import e.willamesnegreiros.prospeccao.fragmentos.Novo_ipMedida;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class Paginas_ipMedida extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;


    //Constructor to the class
    public Paginas_ipMedida(FragmentManager fm, int tabCount) {
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
                Novo_ipMedida novo_ipMedida = new Novo_ipMedida();
                return novo_ipMedida;
            case 1:
                Finalizadas_ipMedida finalizadas_ipMedida = new Finalizadas_ipMedida();
                return finalizadas_ipMedida;
            case 2:
                Devolvidas_ipMedida devolvidas_ipMedida = new Devolvidas_ipMedida();
                return devolvidas_ipMedida;
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