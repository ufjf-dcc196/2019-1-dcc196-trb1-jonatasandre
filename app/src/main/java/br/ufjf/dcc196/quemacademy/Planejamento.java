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
    private int totalHorasLinguas;
    private int totalHorasExatas;
    private int totalHorasSaude;
    private int totalHorasHumanidades;
    private float percLinguas;
    private float percExatas;
    private float percSaude;
    private float percHumanidades;
    private float totalHoras;

    public Planejamento(int ano, int semestre, float linguas, float exatas, float saude, float humanidades){
        this.ano = ano;
        this.semestre = semestre;
        this.linguas = linguas;
        this.exatas = exatas;
        this.saude = saude;
        this.humanidades = humanidades;
        this.disciplinas = new ArrayList<Disciplina>();
        this.totalHorasLinguas = 0;
        this.totalHorasExatas = 0;
        this.totalHorasSaude = 0;
        this.totalHorasHumanidades = 0;
        this.percExatas = 0;
        this.percLinguas = 0;
        this.percSaude = 0;
        this.percHumanidades = 0;
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
        atualizaTotalHoras(false);
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

    public int getTotalHorasLinguas() {
        return totalHorasLinguas;
    }

    public void setTotalHorasLinguas(int totalHorasLinguas) {
        this.totalHorasLinguas = totalHorasLinguas;
    }

    public int getTotalHorasExatas() {
        return totalHorasExatas;
    }

    public void setTotalHorasExatas(int totalHorasExatas) {
        this.totalHorasExatas = totalHorasExatas;
    }

    public int getTotalHorasSaude() {
        return totalHorasSaude;
    }

    public void setTotalHorasSaude(int totalHorasSaude) {
        this.totalHorasSaude = totalHorasSaude;
    }

    public int getTotalHorasHumanidades() {
        return totalHorasHumanidades;
    }

    public void setTotalHorasHumanidades(int totalHorasHumanidades) {
        this.totalHorasHumanidades = totalHorasHumanidades;
    }

    public float getPercLinguas() {
        return percLinguas;
    }

    public void setPercLinguas(float percLinguas) {
        this.percLinguas = percLinguas;
    }

    public float getPercExatas() {
        return percExatas;
    }

    public void setPercExatas(float percExatas) {
        this.percExatas = percExatas;
    }

    public float getPercSaude() {
        return percSaude;
    }

    public void setPercSaude(float percSaude) {
        this.percSaude = percSaude;
    }

    public float getPercHumanidades() {
        return percHumanidades;
    }

    public void setPercHumanidades(float percHumanidades) {
        this.percHumanidades = percHumanidades;
    }

    public void setTotalHoras (float totalHoras){
        this.totalHoras = totalHoras;
    }

    public float getTotalHoras (){
        return this.totalHoras;
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
        atualizaTotalHoras(false);
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

    public void atualizaTotalHoras(boolean atualizar){
        this.totalHorasLinguas = 0;
        this.totalHorasExatas = 0;
        this.totalHorasSaude = 0;
        this.totalHorasHumanidades = 0;

        for (Disciplina d : disciplinas) {
            switch (d.getArea()) {
                case "Exatas":
                    this.totalHorasExatas += d.getHoras();
                    break;
                case "Línguas":
                    this.totalHorasLinguas+= d.getHoras();
                    break;
                case "Saúde":
                    this.totalHorasSaude += d.getHoras();
                    break;
                case "Humanidades":
                    this.totalHorasHumanidades += d.getHoras();
                    break;
                default:
                    break;

            }
        }
        //Float total = Float.parseFloat(totalHorasLinguas + totalHorasExatas + totalHorasSaude +totalHorasHumanidades);
        totalHoras = totalHorasLinguas + totalHorasExatas + totalHorasSaude +totalHorasHumanidades;

        this.percExatas = (totalHorasExatas / totalHoras )*100;
        this.percLinguas = (totalHorasLinguas /totalHoras)*100;
        this.percSaude = (totalHorasSaude/totalHoras)*100;
        this.percHumanidades = (totalHorasHumanidades/totalHoras)*100;

    }
}
