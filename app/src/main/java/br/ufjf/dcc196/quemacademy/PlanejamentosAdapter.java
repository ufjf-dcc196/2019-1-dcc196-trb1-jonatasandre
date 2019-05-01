package br.ufjf.dcc196.quemacademy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

class PlanejamentosAdapter extends RecyclerView.Adapter<PlanejamentosAdapter.ViewHolder> {

    private List<Planejamento> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(View itemView, int position);
    }

    public PlanejamentosAdapter(List<Planejamento> items) {
        this.items = items;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.planejamento_layout,parent,false);
        ViewHolder vh = new ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Planejamento p = items.get(i);

        viewHolder.txtAno.setText(String.valueOf(p.getAno()));
        viewHolder.txtSemestre.setText(String.valueOf(p.getSemestre()));
        viewHolder.txtLinguas.setText(String.valueOf(p.getLinguas()));
        viewHolder.txtExatas.setText(String.valueOf(p.getExatas()));
        viewHolder.txtSaude.setText(String.valueOf(p.getSaude()));
        viewHolder.txtHumanidades.setText(String.valueOf(p.getHumanidades()));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtAno;
        public TextView txtSemestre;
        public TextView txtLinguas;
        public TextView txtExatas;
        public TextView txtSaude;
        public TextView txtHumanidades;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtAno = itemView.findViewById(R.id.textAno);
            txtSemestre = itemView.findViewById(R.id.textSemestre);
            txtLinguas = itemView.findViewById(R.id.textLinguasInfo);
            txtExatas = itemView.findViewById(R.id.textExatasInfo);
            txtSaude = itemView.findViewById(R.id.textSaudeInfo);
            txtHumanidades = itemView.findViewById(R.id.textHumanidadesInfo);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(itemView,position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position !=RecyclerView.NO_POSITION){
                listener.onItemClick(v, position);
            }
        }
    }
}
