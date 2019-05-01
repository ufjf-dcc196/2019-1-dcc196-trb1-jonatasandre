package br.ufjf.dcc196.quemacademy;

import android.content.Intent;
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
		
		Button btnNovoPlanejamento = findViewById(R.id.btnNovoPlanejamento);
		btnNovoPlanejamento.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v){
				Intent intent = new Intent(MainActivity.this, NovoPlanejamentoActivity.class);
				startActivity(intent);
			}
		});

		/*
        final RecyclerView rv = findViewById(R.id.rvPalavras);

        PalavraAdapter pAdapter = new PalavraAdapter(this.palavras);
        pAdapter.setOnPalavraClickListener(new PalavraAdapter.OnPalavraClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(MainActivity.this, palavras.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));*/
    }
}
