package br.com.gbrsistemas.estoque.entidade;

public class Usuario {

    private int idUsuario;
    private String username; // = EMAIL - LOGIN
    private String password; // = SENHA
    private String nomeCompleto;
    private String telefone;
    private Role role;

    public Usuario(){

    }

    public Usuario(String username, String password, String nomeCompleto, String telefone, Role role) {
        this.username = username;
        this.password = password;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.role = role;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", telefone='" + telefone + '\'' +
                ", role=" + role +
                '}';
    }


}
