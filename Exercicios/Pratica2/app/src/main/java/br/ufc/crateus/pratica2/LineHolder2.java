package br.ufc.crateus.pratica2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LineHolder2 extends RecyclerView.ViewHolder{
    public TextView tvNome;
    public TextView tvEmail;
    public LineHolder2(@NonNull View itemView) {
        super(itemView);
        tvNome = (TextView) itemView.findViewById(R.id.tvNome);
        tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
    }
}
