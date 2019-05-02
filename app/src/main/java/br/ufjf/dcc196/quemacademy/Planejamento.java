package br.ufjf.dcc196.quemacademy;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Planejamento implements Parcelable {
    private int ano;
    private int semestre;
    private float linguas;
    private float exatas;
    private float saude;
    private float humanidades;
    private List<Disciplina> disciplinas;

    public Planejamento(int ano, int semestre, float linguas, float exatas, float saude, float humanidades){
        this.ano = ano;
        this.semestre = semestre;
        this.linguas = linguas;
        this.exatas = exatas;
        this.saude = saude;
        this.humanidades = humanidades;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    protected Planejamento(Parcel in) {
        ano = in.readInt();
        semestre = in.readInt();
        linguas = in.readFloat();
        exatas = in.readFloat();
        saude = in.readFloat();
        humanidades = in.readFloat();
        this.disciplinas = new ArrayList<Disciplina>();
        in.readList(this.disciplinas, Disciplina.class.getClassLoader());
    }

    public static final Creator<Planejamento> CREATOR = new Creator<Planejamento>() {
        @Override
        public Planejamento createFromParcel(Parcel in) {
            return new Planejamento(in);
        }

        @Override
        public Planejamento[] newArray(int size) {
            return new Planejamento[size];
        }
    };

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public float getLinguas() {
        return linguas;
    }

    public void setLinguas(float linguas) {
        this.linguas = linguas;
    }

    public float getExatas() {
        return exatas;
    }

    public void setExatas(float exatas) {
        this.exatas = exatas;
    }

    public float getSaude() {
        return saude;
    }

    public void setSaude(float saude) {
        this.saude = saude;
    }

    public float getHumanidades() {
        return humanidades;
    }

    public void setHumanidades(float humanidades) {
        this.humanidades = humanidades;
    }

    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }

    public Disciplina getDisciplina(int id){
        return this.disciplinas.get(id);
    }

    public void addDisciplina(Disciplina disciplina){
        if (this.disciplinas == null)
            this.disciplinas = new ArrayList<Disciplina>();
        this.disciplinas.add(disciplina);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ano);
        dest.writeInt(this.semestre);
        dest.writeFloat(this.linguas);
        dest.writeFloat(this.exatas);
        dest.writeFloat(this.saude);
        dest.writeFloat(this.humanidades);
        dest.writeList(this.disciplinas);
    }
}
