package com.example.frank.mytitlebutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyToolBar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            getActionBar().hide();
        }catch (Exception e){

        }
        this.toolBar = (MyToolBar) this.findViewById(R.id.mytoolbar);

        toolBar.setOnToolBarClickListener(new MyToolBar.OnToolBarClickListener() {

            @Override
            public void rightClick() {
                //Toast.makeText(MainActivity.this,"右边点击", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }

            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"已是首页", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
