package br.ufc.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView title2;

    public LineHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tvNome);
        title2 = (TextView) itemView.findViewById(R.id.tvEmail);
    }
}

