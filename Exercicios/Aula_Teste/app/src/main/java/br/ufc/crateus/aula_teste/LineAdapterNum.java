package br.ufc.crateus.aula_teste;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class LineAdapterNum extends RecyclerView.Adapter<LineHolderNum> {

    private List<Numero> numeros;

    public LineAdapterNum(List<Numero> numeros) {
        this.numeros = numeros;
    }

    @NonNull
    @Override
    public LineHolderNum onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LineHolderNum(LayoutInflater.from(parent.getContext()).inflate(R.layout.customrecyclernum, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolderNum holder, int position) {
        holder.num.setText(numeros.get(position).getNum());
    }

    public void insertItem(Numero numero) {
        numeros.add(numero);
        notifyItemInserted(getItemCount());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
