package br.ufc.crateus.aula_teste;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolderNum extends RecyclerView.ViewHolder {

    public TextView num;

    public LineHolderNum(View numView){
        super(numView);
        num = (TextView) numView.findViewById(R.id.tvNum);
    }
}
