package br.ufc.crateus.aula_teste;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LineAdapterUsuario extends RecyclerView.Adapter<LineHolderUsuario> {

    private List<Usuario> usuarios;

    public LineAdapterUsuario(ArrayList<Usuario> usuarios) {

    }

    @NonNull
    @Override
    public LineHolderUsuario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LineHolderUsuario(LayoutInflater.from(parent.getContext()).inflate(R.layout.customrecyclerusuario, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolderUsuario holder, int position) {
        holder.tvId.setText(usuarios.get(position).getId());
        holder.tvNome.setText(usuarios.get(position).getNome());
        holder.tvUsername.setText(usuarios.get(position).getUsername());
        holder.tvEmail.setText(usuarios.get(position).getEmail());
        holder.tvProfissao.setText(usuarios.get(position).getProfissao());
        holder.tvData.setText(usuarios.get(position).getData());

    }

    public void insertItem(Usuario usuario){
        usuarios.add(usuario);
        notifyItemInserted(getItemCount());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
