package br.com.gbrsistemas.estoque.entidade;

public class Medida {

    private int idMedida;
    private String tipo;

    public Medida() {
    }

    public Medida(String tipo) {
        this.tipo = tipo;
    }

    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Medida{" +
                "idMedida=" + idMedida +
                ", tipo='" + tipo + '\'' +
                '}';
    }


}
