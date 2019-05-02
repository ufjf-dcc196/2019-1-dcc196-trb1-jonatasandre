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

import java.util.ArrayList;
import java.util.List;

public class PlanejamentosActivity extends AppCompatActivity {
    public static final int REQUEST_NOVO_PLANEJAMENTO = 100;
    public static final int REQUEST_DISCIPLINAS = 200;

    public List<Planejamento> planejamentosList = new ArrayList<Planejamento>();
    PlanejamentosAdapter pAdapter;

    private void criaDadosInicias(){
        Planejamento p = new Planejamento(2017, 1, 20, 20, 20, 40);
        Disciplina d1 = new Disciplina("Disciplina 1",20,"Línguas");
        Disciplina d2 = new Disciplina("Disciplina 2",30,"Exatas");
        Disciplina d3 = new Disciplina("Disciplina 3",40,"Humanidades");
        Disciplina d4 = new Disciplina("Disciplina 3",50,"Saúde");
        p.addDisciplina(d1);
        p.addDisciplina(d2);
        p.addDisciplina(d3);
        p.addDisciplina(d4);
        Planejamento p2 = new Planejamento(2017, 2, 10, 30, 40, 20);
        Disciplina d5 = new Disciplina("Disciplina 5",10,"Línguas");
        Disciplina d6 = new Disciplina("Disciplina 6",20,"Exatas");
        Disciplina d7 = new Disciplina("Disciplina 7",30,"Humanidades");
        Disciplina d8 = new Disciplina("Disciplina 8",40,"Saúde");
        p2.addDisciplina(d5);
        p2.addDisciplina(d6);
        p2.addDisciplina(d7);
        p2.addDisciplina(d8);
        planejamentosList.add(p);
        planejamentosList.add(p2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);
        criaDadosInicias();

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
                Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                intent.putExtra("planejamento", planejamentosList.get(position));
                intent.putExtra("index", position);

                startActivityForResult(intent, REQUEST_DISCIPLINAS);
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
                case REQUEST_DISCIPLINAS:
                    int t = data.getIntExtra("index", -1);
                    if (t != -1) {
                        planejamentosList.set(t, (Planejamento) data.getParcelableExtra("planejamento"));
                        pAdapter.notifyDataSetChanged();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
