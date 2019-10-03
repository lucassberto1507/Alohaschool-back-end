package br.com.gbrsistemas.estoque.entidade;

public class Role {

    private int idRole;
    private String tipo;

    public Role() {
    }

    public Role(String tipo) {
        this.tipo = tipo;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
