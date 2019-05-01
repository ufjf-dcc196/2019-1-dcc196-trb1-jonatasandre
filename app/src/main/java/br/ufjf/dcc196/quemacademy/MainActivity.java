package br.ufjf.dcc196.quemacademy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private List<String> palavras = new ArrayList<String>(){{
        add("Um");
        add("Segundo");
        add("Três");
        add("Quatro");
        add("Quatroaaa");

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(MainActivity.this, PlanejamentosActivity.class);
                                    startActivity(intent);
                                }
                            },5000);
    }
}
