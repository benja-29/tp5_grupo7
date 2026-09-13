package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private int dni;
    private boolean tienePami;

    public ClienteMinorista() {
        super();
    }

    public ClienteMinorista(String nombre, String apellido, String direccion, int dni, boolean tienePami) {
        super(nombre, apellido, direccion);
        this.dni = dni;
        this.tienePami = tienePami;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isTienePami() {
        return tienePami;
    }

    public void setTienePami(boolean tienePami) {
        this.tienePami = tienePami;
    }

    @Override
    public String toString() {
        return super.toString() + ", DNI: " + dni + ", PAMI: " + (tienePami ? "Sí" : "No");
    }
}