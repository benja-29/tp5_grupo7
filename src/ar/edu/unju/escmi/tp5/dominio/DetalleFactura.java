package ar.edu.unju.escmi.tp5.dominio;

public class DetalleFactura {
    private int cantidad;
    private double precioUnitario;
    private double importe;
    private Producto producto;

    public DetalleFactura() {
    }

    public DetalleFactura(int cantidad, double precioUnitario, Producto producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
        this.importe = calcularSubtotal();
    }

    public double calcularSubtotal() {
        if (producto != null) {
            double precioConDescuento = precioUnitario * (1 - (producto.getDescuento() / 100.0));
            return cantidad * precioConDescuento;
        }
        return cantidad * precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.importe = calcularSubtotal();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.importe = calcularSubtotal();
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.importe = calcularSubtotal();
    }

    @Override
    public String toString() {
        return "Producto: " + (producto != null ? producto.getDescripcion() : "N/A") +
               ", Cantidad: " + cantidad + ", Subtotal: $" + importe;
    }
}