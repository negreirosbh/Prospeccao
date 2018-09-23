package e.willamesnegreiros.prospeccao.fragmentos;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import e.willamesnegreiros.prospeccao.R;

public class AdpterLista extends RecyclerView.Adapter<AdpterLista.MyViewHolder>
{
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.nc.setText("4567853");
        holder.cidade.setText("fortaleza");
        holder.data.setText("15/09/2018");
        holder.hora.setText("18:00");

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public Button btnEditar;
        public Button btnDevolver;
        public TextView nc;
        public TextView cidade;
        public TextView data;
        public TextView hora;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            nc = itemView.findViewById(R.id.txt_item_nc);
            cidade = itemView.findViewById(R.id.txt_item_cidade);
            data = itemView.findViewById(R.id.txt_item_data);
            hora = itemView.findViewById(R.id.txt_item_hora);
        }
    }

}
