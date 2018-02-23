package com.example.admin.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button b1,b2,b3,b4,b5,b6,b7,b8,b9,reset;
    private int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        reset=(Button)findViewById(R.id.btnreset);
        turn=1;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b1.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b1.setText("O");
                    }
                }
                endGame();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b2.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b2.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b2.setText("O");
                    }
                 }
                 endGame();
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b3.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b3.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b3.setText("O");
                    }
                }
           endGame();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b4.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b4.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b4.setText("O");
                    }
                }
               endGame();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b5.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b5.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b5.setText("O");
                    }
                }
            endGame();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b6.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b6.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b6.setText("O");
                    }
                }
               endGame();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b7.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b7.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b7.setText("O");
                    }
                }
                endGame();

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b8.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b8.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b8.setText("O");
                    }
                }
             endGame();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b9.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b9.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b9.setText("O");
                    }
                }
              endGame();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");
            }
        });
    }

    public void endGame() {
        String a, b, c, d, e, f, g, h, i;
        boolean end = false;

        a = b1.getText().toString();
        b = b2.getText().toString();
        c = b3.getText().toString();
        d = b4.getText().toString();
        e = b5.getText().toString();
        f = b6.getText().toString();
        g = b7.getText().toString();
        h = b8.getText().toString();
        i = b9.getText().toString();

        if (a.equals("X") && b.equals("X") && c.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
           // reset.callOnClick();
            end = false;

        }
        if (a.equals("X") && e.equals("X") && i.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
          // reset.callOnClick();
            end = false;

        }
        if (a.equals("X") && d.equals("X") && g.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (b.equals("X") && e.equals("X") && h.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (c.equals("X") && f.equals("X") && i.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
           // reset.callOnClick();
            end = false;
        }
        if (c.equals("X") && e.equals("X") && g.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (d.equals("X") && e.equals("X") && f.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (g.equals("X") && h.equals("X") && i.equals("X")) {
            Toast.makeText(getApplicationContext(), "The winner is Player X", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
             end = false;
        }
        if (a.equals("O") && b.equals("O") && c.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (a.equals("O") && e.equals("O") && i.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;


        }
        if (a.equals("O") && d.equals("O") && g.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (b.equals("O") && e.equals("O") && h.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (c.equals("O") && f.equals("O") && i.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (c.equals("O") && e.equals("O") && g.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
            //reset.callOnClick();
            end = false;

        }
        if (d.equals("O") && e.equals("O") && f.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
           // reset.callOnClick();
            end = false;

        }
        if (g.equals("O") && h.equals("O") && i.equals("O")) {
            Toast.makeText(getApplicationContext(), "The winner is Player O", Toast.LENGTH_LONG).show();
           // reset.callOnClick();
            end = false;

        }

        if (end) {
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        Button exit=(Button)findViewById(R.id.btnexit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit_click();
            }
        });


    }

    public void exit_click()
    {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage("Do you really want to exit");
        dlgAlert.setTitle("Exit");
        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);
            }
        });

        dlgAlert.create().show();
    }

}
