package br.ufjf.dcc196.quemacademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NovaDisciplinaCursadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina_cursada);

        final EditText nome = findViewById(R.id.editNomeNew);
        final EditText horas = findViewById(R.id.editHorasNew);
        final Spinner area = findViewById(R.id.editAreaNew);
        final List<String> listaAreas = new ArrayList<String>(){{
            add("Línguas");
            add("Exatas");
            add("Saúde ");
            add("Humanidades");
        }};
        area.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,listaAreas));
        Button btnSaveNewDisciplina = findViewById(R.id.btnSaveNewDisciplina);

        btnSaveNewDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                Disciplina disciplina = new Disciplina(nome.getText().toString(),
                        Integer.parseInt(horas.getText().toString()),
                        area.getSelectedItem().toString());

                resultado.putExtra("novaDisciplina", disciplina);
                setResult(RESULT_OK, resultado);
                finish();
            }
        });
    }
}
