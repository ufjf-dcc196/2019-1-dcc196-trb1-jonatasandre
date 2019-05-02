package br.ufjf.dcc196.quemacademy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {

private List<Disciplina> items;
private OnItemClickListener listener;

public interface OnItemClickListener{
    void onItemClick(View itemView, int position);
}

    public DisciplinaAdapter(List<Disciplina> items) {
        this.items = items;
    }

    public void setOnItemClickListener(DisciplinaAdapter.OnItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public DisciplinaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.disciplina_layout,parent,false);
        DisciplinaAdapter.ViewHolder vh = new DisciplinaAdapter.ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaAdapter.ViewHolder viewHolder, int i) {
        Disciplina d = items.get(i);
        viewHolder.txtDisciplinaNome.setText(d.getNome());
        viewHolder.txtDisciplinaHoras.setText((d.getHoras()+""));
        viewHolder.txtDisciplinaArea.setText(d.getArea());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtDisciplinaNome;
        public TextView txtDisciplinaHoras;
        public TextView txtDisciplinaArea;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtDisciplinaNome = itemView.findViewById(R.id.txtDisciplinaNome);
            txtDisciplinaHoras = itemView.findViewById(R.id.txtDisciplinaHoras);
            txtDisciplinaArea = itemView.findViewById(R.id.txtDisciplinaArea);
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
