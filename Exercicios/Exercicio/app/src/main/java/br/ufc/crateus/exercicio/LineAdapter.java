package br.ufc.crateus.exercicio;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {
    private final List<Tempo> tempos;

    public LineAdapter(ArrayList tempo) {
        tempos = (List<Tempo>) tempo;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.title.setText(String.format(Locale.getDefault(), "%s", tempos.get(position).getData()
        ));
    }

    @Override
    public int getItemCount() {
        return tempos != null ? tempos.size() : 0;
    }

    public void insertItem(Tempo tempo) {
        tempos.add(tempo);
        notifyItemInserted(getItemCount());
    }
}
