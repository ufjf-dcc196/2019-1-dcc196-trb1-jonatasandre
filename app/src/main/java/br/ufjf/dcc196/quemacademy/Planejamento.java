package br.ufjf.dcc196.quemacademy;

import android.os.Parcel;
import android.os.Parcelable;

public class Planejamento implements Parcelable {
    private int ano;
    private int semestre;
    private float linguas;
    private float exatas;
    private float saude;
    private float humanidades;

    public Planejamento(int ano, int semestre, float linguas, float exatas, float saude, float humanidades){
        this.ano = ano;
        this.semestre = semestre;
        this.linguas = linguas;
        this.exatas = exatas;
        this.saude = saude;
        this.humanidades = humanidades;
    }

    protected Planejamento(Parcel in) {
        ano = in.readInt();
        semestre = in.readInt();
        linguas = in.readFloat();
        exatas = in.readFloat();
        saude = in.readFloat();
        humanidades = in.readFloat();
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
    }
}
