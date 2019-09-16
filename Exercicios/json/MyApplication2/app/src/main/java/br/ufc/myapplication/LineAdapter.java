package br.ufc.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<UserModel> mUsers;

    public LineAdapter(ArrayList users) {
        mUsers = users;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.title.setText(String.format(Locale.getDefault(), "%s",
                mUsers.get(position).getName()
        ));
        holder.title2.setText(String.format(Locale.getDefault(), "%s",
                mUsers.get(position).getEmail()
        ));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void updateList(UserModel user) {
        insertItem(user);
    }

    public void insertItem(UserModel user) {
        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }

    private void updateItem(int position) {
        UserModel userModel = mUsers.get(position);
        userModel.incrementAge();
        notifyItemChanged(position);
    }

    private void removerItem(int position) {
        UserModel userModel = mUsers.get(position);
        mUsers.remove(userModel);
        notifyDataSetChanged();
    }
}

