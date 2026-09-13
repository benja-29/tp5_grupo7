package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numeroFactura;
    private LocalDate fecha;
    private double total;
    private Cliente cliente;
    private List<DetalleFactura> detalleFactura;

    public Factura() {
        this.detalleFactura = new ArrayList<>();
    }

    public Factura(int numeroFactura, LocalDate fecha, Cliente cliente) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalleFactura = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        if (detalle != null) {
            this.detalleFactura.add(detalle);
            this.total += detalle.getImporte();
        }
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    @Override
    public String toString() {
        return "Factura N°: " + numeroFactura + ", Fecha: " + fecha + 
               ", Cliente: " + (cliente != null ? cliente.getNombre() + " " + cliente.getApellido() : "N/A") + 
               ", Total: $" + total;
    }
}