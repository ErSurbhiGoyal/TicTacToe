package com.suroid.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    Button b[][] = new Button[4][4];
    int check[][] = new int[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setBoard();

    }
    int i,j;
    int player=0;
    TextView txtScorePlayerA,txtScorePlayerB;
    Button newGame,reset;

    // Set up the game board.
    private void setBoard()
    {


        txtScorePlayerA = (TextView) findViewById(R.id.txtScorePlayerA);
        txtScorePlayerB = (TextView) findViewById(R.id.txtScorePlayerB);

        newGame = (Button) findViewById(R.id.btn_new_game);
        reset = (Button) findViewById(R.id.btn_reset);
        newGame.setEnabled(false);
        reset.setEnabled(false);
        newGame.setOnClickListener (new View.OnClickListener(){

            public void onClick(View v)
            {
                if(newGame.isEnabled())
                {
                    //textView.setText("Click button to start!");
                    player=0;
                    setBoard();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reset.isEnabled()){
                    player=0;
                    setBoard();
                    txtScorePlayerA.setText(String.valueOf(0));
                    txtScorePlayerB.setText(String.valueOf(0));
                }
            }
        });
        b[1][1] = (Button) findViewById(R.id.btn_one);
        b[1][2] = (Button) findViewById(R.id.btn_two);
        b[1][3] = (Button) findViewById(R.id.btn_three);
        b[2][1] = (Button) findViewById(R.id.btn_four);
        b[2][2] = (Button) findViewById(R.id.btn_five);
        b[2][3] = (Button) findViewById(R.id.btn_six);
        b[3][1] = (Button) findViewById(R.id.btn_seven);
        b[3][2] = (Button) findViewById(R.id.btn_eight);
        b[3][3] = (Button) findViewById(R.id.btn_nine);

        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++)
                check[i][j] = 2;
        }

        // add the click listeners for each button

        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++) {
                b[i][j].setOnClickListener(new MyClickListener(i, j));
                if (!b[i][j].isEnabled()) {
                    b[i][j].setText("");
                    b[i][j].setEnabled(true);
                }
            }
        }
    }

    class MyClickListener implements View.OnClickListener
    {
        int x;
        int y;


        public MyClickListener(int x, int y)
        {
            this.x = x;
            this.y = y;
        }



        public void onClick(View view)
        {
            if (b[x][y].isEnabled())
            {
                b[x][y].setEnabled(false);
                if (player == 0)
                {
                    b[x][y].setText("X");
                    check[x][y] = 0;
                    player = 1;
                    checkBoard();
                } else
                {
                    b[x][y].setText("O");
                    check[x][y] = 1;
                    player = 0;
                    checkBoard();
                }
            }
        }


        // check the board to see if someone has won


        private boolean checkBoard() {
            boolean gameOver = false;
            if (( check[1][1] == 0 && check[2][2] == 0 &&  check[3][3] == 0)
                    || ( check[1][3] == 0 && check[2][2] == 0 &&  check[3][1] == 0)
                    || ( check[1][2] == 0 &&  check[2][2] == 0 &&  check[3][2] == 0)
                    || ( check[1][3] == 0 &&  check[2][3] == 0 &&  check[3][3] == 0)
                    || ( check[1][1] == 0 &&  check[1][2] == 0 &&  check[1][3] == 0)
                    || ( check[2][1] == 0 &&  check[2][2] == 0 &&  check[2][3] == 0)
                    || ( check[3][1] == 0 &&  check[3][2] == 0 &&  check[3][3] == 0)
                    || ( check[1][1] == 0 &&  check[2][1] == 0 &&  check[3][1] == 0)) {
                txtScorePlayerA.setText(String.valueOf(Integer.parseInt(txtScorePlayerA.getText().toString()) + 1));
                Toast.makeText(MainActivity.this,"Player A wins!!!",Toast.LENGTH_SHORT).show();
                gameOver = true;
                newGame.setEnabled(true);
                reset.setEnabled(true);
            } else if (( check[1][1] == 1 && check[2][2] == 1 && check[3][3] == 1)
                    || ( check[1][3] == 1 && check[2][2] == 1 && check[3][1] == 1)
                    || ( check[1][2] == 1 && check[2][2] == 1 && check[3][2] == 1)
                    || ( check[1][3] == 1 && check[2][3] == 1 && check[3][3] == 1)
                    || ( check[1][1] == 1 && check[1][2] == 1 && check[1][3] == 1)
                    || ( check[2][1] == 1 && check[2][2] == 1 && check[2][3] == 1)
                    || ( check[3][1] == 1 && check[3][2] == 1 && check[3][3] == 1)
                    || ( check[1][1] == 1 &&  check[2][1] == 1 && check[3][1] == 1)) {
                txtScorePlayerB.setText(String.valueOf(Integer.parseInt(txtScorePlayerB.getText().toString()) + 1));
                Toast.makeText(MainActivity.this,"Player B wins!!!",Toast.LENGTH_SHORT).show();
                gameOver = true;
                newGame.setEnabled(true);
                reset.setEnabled(true);
            } else {
                boolean empty = false;
                for (i = 1; i <= 3; i++) {
                    for (j = 1; j <= 3; j++) {
                        if (check[i][j] == 2) {
                            empty = true;
                            break;
                        }
                    }
                }
                if (!empty) {
                    gameOver = true;
                    Toast.makeText(MainActivity.this,"It's a Draw",Toast.LENGTH_SHORT).show();
                    newGame.setEnabled(true);
                    reset.setEnabled(true);
                }
            }if(gameOver)

                for(i=1;i<=3;i++)
                {
                    for(j=1;j<=3;j++)
                    {
                        b[i][j].setEnabled(false);
                    }
                }

            return gameOver;
        }
    }

}
