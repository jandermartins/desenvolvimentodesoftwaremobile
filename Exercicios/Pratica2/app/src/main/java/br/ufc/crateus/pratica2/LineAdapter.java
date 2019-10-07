package br.ufc.crateus.pratica2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LineAdapter extends RecyclerView.Adapter<LineHolder2>  {
    private final List<UserModel2> mUsers;

    public LineAdapter(ArrayList users) {
        mUsers = users;
    }


    @Override
    public LineHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder2(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler2, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder2 holder, int position) {
        holder.tvNome.setText(mUsers.get(position).getNome());
        holder.tvEmail.setText(mUsers.get(position).getEmail());

    }
    public void insertItem(String nome, String email) {

        UserModel2 user = new UserModel2(nome, email);
        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }
    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }
}
