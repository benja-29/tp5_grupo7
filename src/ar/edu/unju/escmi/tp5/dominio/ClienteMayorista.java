package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private String codigoCliente;

    public ClienteMayorista() {
        super();
    }

    public ClienteMayorista(String nombre, String apellido, String direccion, String codigoCliente) {
        super(nombre, apellido, direccion);
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return super.toString() + ", Código Mayorista: " + codigoCliente;
    }
}