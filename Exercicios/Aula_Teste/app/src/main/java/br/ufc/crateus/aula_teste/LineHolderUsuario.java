package br.ufc.crateus.aula_teste;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



public class LineHolderUsuario extends RecyclerView.ViewHolder {
    public TextView tvId, tvNome, tvEmail, tvUsername, tvProfissao, tvData;

    public LineHolderUsuario(View view) {
        super(view);
        tvId = (TextView) view.findViewById(R.id.tvId);
        tvNome = (TextView) view.findViewById(R.id.tvNome);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        tvProfissao = (TextView) view.findViewById(R.id.tvProfissao);
        tvData = (TextView) view.findViewById(R.id.tvData);
    }
}
