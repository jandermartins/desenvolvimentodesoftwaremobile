package br.ufc.crateus.pratica2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<UserModel> mUsers;

    public LinearAdapter(ArrayList users) {
        mUsers = users;
    }


    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.tv1.setText(String.valueOf(mUsers.get(position).getNum1()));
        holder.tv2.setText(String.valueOf(mUsers.get(position).getNum2()));
        holder.tv3.setText(String.valueOf(mUsers.get(position).getNum3()));
        holder.tvResult.setText(String.valueOf(mUsers.get(position).getNumResult()));
    }
    public void insertItem(int num1, int num2, int num3, int result) {

        UserModel user = new UserModel(num1, num2, num3, result);
        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }
    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

}
