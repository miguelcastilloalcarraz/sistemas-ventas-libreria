package com.mycompany.libreria;

public class Venta {
    private int idVenta;
    private String fecha;
    private String nombreCliente;
    private String apellidoCliente;
    private String dni;
    private String telefono;
    private String producto;
    private String categoria;
    private int cantidad;
    private double precio;
    private double subtotal;
    private double igv;
    private double total;
    private String metodoPago;
    private String vendedor;

    public Venta(int idVenta, String fecha, String nombreCliente, String apellidoCliente,
                 String dni, String telefono, String producto, String categoria,
                 int cantidad, double precio, double subtotal, double igv,
                 double total, String metodoPago, String vendedor) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.dni = dni;
        this.telefono = telefono;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.metodoPago = metodoPago;
        this.vendedor = vendedor;
    }

    public int getIdVenta() { return idVenta; }
    public String getFecha() { return fecha; }
    public String getNombreCliente() { return nombreCliente; }
    public String getApellidoCliente() { return apellidoCliente; }
    public String getDni() { return dni; }
    public String getTelefono() { return telefono; }
    public String getProducto() { return producto; }
    public String getCategoria() { return categoria; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public double getSubtotal() { return subtotal; }
    public double getIgv() { return igv; }
    public double getTotal() { return total; }
    public String getMetodoPago() { return metodoPago; }
    public String getVendedor() { return vendedor; }
    public String getCliente() { return nombreCliente + " " + apellidoCliente; }
}
