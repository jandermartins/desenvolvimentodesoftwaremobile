package com.example.myapplication;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public LineHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.textView);
        moreButton = (ImageButton) itemView.findViewById(R.id.imageButton3);
        deleteButton = (ImageButton) itemView.findViewById(R.id.imageButton4);
    }
}
