package com.suroid.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by surbhi on 09/09/18.
 */

public class FirstActivity extends AppCompatActivity{

    @InjectView(R.id.txtNewGame)
    TextView txtNewGame;
    @InjectView(R.id.txtScoreCard)
    TextView txtScoreCard;
    @InjectView(R.id.txtHelp)
    TextView txtHelp;
    @InjectView(R.id.txtAbout)
    TextView txtAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ButterKnife.inject(this);

    }

}
