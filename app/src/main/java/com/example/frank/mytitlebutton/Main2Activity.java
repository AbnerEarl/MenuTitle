package com.example.frank.mytitlebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private MyToolBar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try{
            getActionBar().hide();
        }catch (Exception e){

        }


        this.toolBar = (MyToolBar) this.findViewById(R.id.mytoolbar1);
        toolBar.setOnToolBarClickListener(new MyToolBar.OnToolBarClickListener() {

            @Override
            public void rightClick() {
                Toast.makeText(Main2Activity.this,"没有更多了！", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void leftClick() {
                //Toast.makeText(Main2Activity.this,"", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
