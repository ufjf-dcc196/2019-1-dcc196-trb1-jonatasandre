package br.ufjf.dcc196.quemacademy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

class PlanejamentosAdapter extends RecyclerView.Adapter<PlanejamentosAdapter.ViewHolder> {

    private List<String> items;
    private OnPalavraClickListener listener;

    public interface OnPalavraClickListener{
        void onItemClick(View itemView, int position);
    }

    public PlanejamentosAdapter(List<String> palavras) {
        this.items = palavras;
    }

    public void setOnPalavraClickListener(OnPalavraClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //View linha = inflater.inflate(R.layout.palavra_layout,parent,false);
        //ViewHolder vh = new ViewHolder(linha);
        ViewHolder vh = null;
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String palavra = this.items.get(i);
        viewHolder.txtPalavra.setText(palavra);
        viewHolder.txtTamanho.setText((Integer.toString(palavra.length())));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtPalavra;
        public TextView txtTamanho;
        public ViewHolder(final View itemView) {
            super(itemView);
            //txtPalavra = (TextView)itemView.findViewById(R.id.txtPalavra);
            //txtTamanho = (TextView)itemView.findViewById(R.id.txtTamanho);
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
    }
}
