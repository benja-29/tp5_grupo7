package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precioUnitario;
    private double descuento;

    public Producto() {
    }

    public Producto(int codigo, String descripcion, double precioUnitario, double descuento) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Descripción: " + descripcion + 
               ", Precio: $" + precioUnitario + ", Descuento: " + descuento + "%";
    }
}