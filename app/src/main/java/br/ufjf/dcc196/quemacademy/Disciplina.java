package br.ufjf.dcc196.quemacademy;

import android.os.Parcel;
import android.os.Parcelable;

public class Disciplina implements Parcelable {

    private String nome;
    private int horas;
    private String area;

    public Disciplina(String nome, int horas, String area){
        this.nome=nome;
        this.horas=horas;
        this.area=area;
    }

    protected Disciplina(Parcel in) {
        nome = in.readString();
        horas = in.readInt();
        area = in.readString();
    }

    public static final Creator<Disciplina> CREATOR = new Creator<Disciplina>() {
        @Override
        public Disciplina createFromParcel(Parcel in) {
            return new Disciplina(in);
        }

        @Override
        public Disciplina[] newArray(int size) {
            return new Disciplina[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(horas);
        dest.writeString(area);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
