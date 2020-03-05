package com.example.a3rdtimesthecharm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int countJB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAdd(View view)
    {
        countJB++;
        updateCount();
        //Toast.makeText(this, "yes MA'AM,", Toast.LENGTH_SHORT).show();
    }

    public void onClickSubtract(View view)
    {
        countJB--;
        updateCount();
    }

    public void openDialogue(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm reset Count?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick (DialogInterface dialogInterface, int i)
            {
                Toast.makeText(MainActivity.this, "yep", Toast.LENGTH_LONG).show();
                countJB = 0;
                updateCount();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                //keep this empty so the reset and pressing no does nothing
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //brain method

    private void updateCount()
    {
        TextView countTextview = (TextView) findViewById(R.id.countTV);
        countTextview.setText("You've said Yessir: " + countJB + " times");
    }

}
