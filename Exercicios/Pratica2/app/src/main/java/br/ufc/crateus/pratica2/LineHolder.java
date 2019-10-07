package br.ufc.crateus.pratica2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView tv1;
    public TextView tv2;
    public TextView tv3;
    public TextView tvResult;

    public LineHolder(View itemView) {
        super(itemView);
        tv1 = (TextView) itemView.findViewById(R.id.tv1);
        tv2 = (TextView) itemView.findViewById(R.id.tv2);
        tv3 = (TextView) itemView.findViewById(R.id.tv3);
        tvResult = (TextView) itemView.findViewById(R.id.tvResult);
    }
}
