package br.com.gbrsistemas.estoque.entidade;

public class Categoria {

    private int idCategoria;
    private String tipo;

    public Categoria() {
    }

    public Categoria(String tipo) {
        this.tipo = tipo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
