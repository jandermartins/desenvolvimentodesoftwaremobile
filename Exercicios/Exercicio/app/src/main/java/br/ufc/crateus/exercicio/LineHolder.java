package br.ufc.crateus.exercicio;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;


    public LineHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.textView);
    }
}
