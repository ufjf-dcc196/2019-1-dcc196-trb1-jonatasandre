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

public class DisciplinasCursadasActivity extends AppCompatActivity {
    public static final int REQUEST_NOVA_DISCIPLINA = 300;
    public static final int REQUEST_DETALHE_PLANEJAMENTO = 400;
    Planejamento planejamento;
    Intent retorno;
    int index;


    DisciplinaAdapter dAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);
        RecyclerView rv = findViewById(R.id.rvDisciplinas);

        Button btnDetalhePlanejamento = findViewById(R.id.btnDetalhePlanejamento);
        btnDetalhePlanejamento.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                intent.putExtra("planejamento", planejamento);
                startActivityForResult(intent,REQUEST_DETALHE_PLANEJAMENTO);
            }
        });

        Button btnNovaDisciplina = findViewById(R.id.btnNovaDisciplina);
        btnNovaDisciplina.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(DisciplinasCursadasActivity.this, NovaDisciplinaCursadaActivity.class);
                startActivityForResult(intent,REQUEST_NOVA_DISCIPLINA);
            }
        });



        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            planejamento = bundle.getParcelable("planejamento");
            index = bundle.getInt("index");
            List<Disciplina> disciplinas = planejamento.getDisciplinas();

            dAdapter  = new DisciplinaAdapter(disciplinas);
            rv.setAdapter(dAdapter);
            rv.setLayoutManager(new LinearLayoutManager(this));

            if (disciplinas.isEmpty()) {
                Toast.makeText(DisciplinasCursadasActivity.this, "Não há disciplinas cadastradas", Toast.LENGTH_SHORT).show();
            }

            retorno = new Intent();
            retorno.putExtra("index",index);

        } else {
            finish();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            switch (requestCode) {
                case REQUEST_NOVA_DISCIPLINA:
                    Disciplina novaDisciplina = data.getParcelableExtra("novaDisciplina");
                    planejamento.addDisciplina(novaDisciplina);
                    retorno.putExtra("planejamento", planejamento);
                    setResult(RESULT_CANCELED, retorno );
                    dAdapter.notifyDataSetChanged();
                    break;
                case REQUEST_DETALHE_PLANEJAMENTO:
                    planejamento = data.getParcelableExtra("planejamentoEditado");
                    retorno.putExtra("planejamento", planejamento);
                    setResult(RESULT_CANCELED, retorno);
                    dAdapter.notifyDataSetChanged();
                default:
                    break;
            }
        }
    }
}
