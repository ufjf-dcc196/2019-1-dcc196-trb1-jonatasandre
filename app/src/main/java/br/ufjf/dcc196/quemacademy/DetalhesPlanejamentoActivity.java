package br.ufjf.dcc196.quemacademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetalhesPlanejamentoActivity extends AppCompatActivity {

    Planejamento planejamentoAtual;
    EditText ano;
    EditText semestre;
    EditText linguas;
    EditText exatas;
    EditText saude;
    EditText humanidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_planejamento);

        ano = findViewById(R.id.editAnoDetalhe);
        semestre = findViewById(R.id.editSemestreDetalhe);
        linguas = findViewById(R.id.editLinguasDetalhe);
        exatas = findViewById(R.id.editExatasDetalhe);
        saude = findViewById(R.id.editSaudeDetalhe);
        humanidades = findViewById(R.id.editHumanidadesDetalhe);
        Button btnSaveDetalhe = findViewById(R.id.btnSaveDetalhe);
        planejamentoAtual = getIntent().getParcelableExtra("planejamento");
        preencheCamposPlanejamento();
        btnSaveDetalhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retorno = new Intent();


                planejamentoAtual.setAno(Integer.parseInt(ano.getText().toString()));
                planejamentoAtual.setSemestre(Integer.parseInt(semestre.getText().toString()));
                planejamentoAtual.setLinguas(Float.parseFloat(linguas.getText().toString()));
                planejamentoAtual.setExatas(Float.parseFloat(exatas.getText().toString()));
                planejamentoAtual.setSaude(Float.parseFloat(saude.getText().toString()));
                planejamentoAtual.setHumanidades(Float.parseFloat(humanidades.getText().toString()));

                retorno.putExtra("planejamentoEditado", planejamentoAtual);
                setResult(RESULT_OK, retorno);
                finish();
            }
        });
    }

    private void preencheCamposPlanejamento(){
        ano.setText(String.valueOf(planejamentoAtual.getAno()));
        semestre.setText(String.valueOf(planejamentoAtual.getSemestre()));
        linguas.setText(String.valueOf(planejamentoAtual.getLinguas()));
        exatas.setText(String.valueOf(planejamentoAtual.getExatas()));
        saude.setText(String.valueOf(planejamentoAtual.getSaude()));
        humanidades.setText(String.valueOf(planejamentoAtual.getHumanidades()));
    }
}
