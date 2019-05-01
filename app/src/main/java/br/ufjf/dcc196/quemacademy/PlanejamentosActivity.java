package br.ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlanejamentosActivity extends AppCompatActivity {
    public static final int REQUEST_NOVO_PLANEJAMENTO = 100;

    public List<Planejamento> planejamentosList = new ArrayList<Planejamento>() {{
        add(new Planejamento(2017, 1, 20, 20, 20, 40));
        add(new Planejamento(2017, 2, 10, 20, 30, 40));
    }};
    PlanejamentosAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);

        Button btnNovoPlanejamento = findViewById(R.id.btnNovoPlanejamento);
		btnNovoPlanejamento.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v){
				Intent intent = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
				startActivityForResult(intent,REQUEST_NOVO_PLANEJAMENTO);
			}
		});


        final RecyclerView rv = findViewById(R.id.rvPlanejamentos);

        pAdapter = new PlanejamentosAdapter(this.planejamentosList);
        pAdapter.setOnItemClickListener(new PlanejamentosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
            }
        });
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            switch (requestCode){
                case REQUEST_NOVO_PLANEJAMENTO:
                    if (resultCode == Activity.RESULT_OK) {
                        planejamentosList.add((Planejamento) data.getParcelableExtra("novoPlanejamento"));
                        pAdapter.notifyDataSetChanged();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
