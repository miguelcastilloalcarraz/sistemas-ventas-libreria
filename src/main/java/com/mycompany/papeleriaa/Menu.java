package com.mycompany.papeleriaa;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner tecla = new Scanner(System.in);
    
    public static void mostrar() {
        ArrayList<Venta> ventas = DatosVentas.cargarVentas();
        int opcion;
        
        do {
            System.out.println("\n=== SISTEMA DE LIBRERÍA ===");
            System.out.println("1. Buscar por producto");
            System.out.println("2. Buscar por cliente (nombre/DNI)");
            System.out.println("3. Ver todas las ventas");
            System.out.println("4. Ventas por vendedor");
            System.out.println("5. Ventas por metodo de pago");
            System.out.println("6. Filtrar por categoria");
            System.out.println("7. Rankings (Top 5)");
            System.out.println("8. Reportes de ventas");
            System.out.println("9. Ver detalle completo de venta");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            
            opcion = tecla.nextInt();
            tecla.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String prod = tecla.nextLine();
                    for (Venta v : ventas) {
                        if (v.getProducto().toLowerCase().contains(prod.toLowerCase())) {
                            System.out.println(v.getIdVenta() + " | " + v.getProducto() + 
                                             " | " + v.getCantidad() + " und | S/ " + v.getTotal());
                        }
                    }
                    break;
                    
                case 2:
                    System.out.print("Nombre o DNI del cliente: ");
                    String busqueda = tecla.nextLine();
                    for (Venta v : ventas) {
                        String clienteCompleto = v.getNombreCliente() + " " + v.getApellidoCliente();
                        if (clienteCompleto.toLowerCase().contains(busqueda.toLowerCase()) || 
                            v.getDni().contains(busqueda)) {
                            System.out.println(v.getIdVenta() + " | " + clienteCompleto + 
                                             " | " + v.getProducto() + " | S/ " + v.getTotal());
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("\n=== TODAS LAS VENTAS ===");
                    for (Venta v : ventas) {
                        System.out.println(v.getIdVenta() + " | " + v.getFecha() + " | " +
                                         v.getNombreCliente() + " " + v.getApellidoCliente() + " | " +
                                         v.getProducto() + " | S/ " + v.getTotal() + " | " +
                                         v.getMetodoPago() + " | " + v.getVendedor());
                    }
                    break;
                    
                case 4:
                    System.out.println("\n=== VENTAS POR VENDEDOR ===");
                    ArrayList<String> vendedores = new ArrayList<>();
                    for (Venta v : ventas) {
                        if (!vendedores.contains(v.getVendedor())) {
                            vendedores.add(v.getVendedor());
                        }
                    }
                    for (String ven : vendedores) {
                        double total = 0;
                        int cantidad = 0;
                        for (Venta v : ventas) {
                            if (v.getVendedor().equalsIgnoreCase(ven)) {
                                total += v.getTotal();
                                cantidad++;
                            }
                        }
                        System.out.println(ven + ": " + cantidad + " ventas - S/ " + total);
                    }
                    break;
                    
                case 5:
                    System.out.println("\n=== VENTAS POR METODO DE PAGO ===");
                    ArrayList<String> metodos = new ArrayList<>();
                    for (Venta v : ventas) {
                        if (!metodos.contains(v.getMetodoPago())) {
                            metodos.add(v.getMetodoPago());
                        }
                    }
                    for (String metodo : metodos) {
                        double total = 0;
                        int cantidad = 0;
                        for (Venta v : ventas) {
                            if (v.getMetodoPago().equalsIgnoreCase(metodo)) {
                                total += v.getTotal();
                                cantidad++;
                            }
                        }
                        System.out.println(metodo + ": " + cantidad + " ventas - S/ " + total);
                    }
                    break;
                    
                case 6:
                    System.out.print("Categoria: ");
                    String cat = tecla.nextLine();
                    System.out.println("\n=== " + cat.toUpperCase() + " ===");
                    for (Venta v : ventas) {
                        if (v.getCategoria().equalsIgnoreCase(cat)) {
                            System.out.println(v.getProducto() + " | " + 
                                             v.getCantidad() + " und | S/ " + v.getTotal());
                        }
                    }
                    break;
                    
                case 7:
                    System.out.println("\n=== RANKINGS ===");
                    System.out.println("1. Top 5 productos mas vendidos");
                    System.out.println("2. Top 5 mayores montos");
                    System.out.print("Elija: ");
                    int sub = tecla.nextInt();
                    tecla.nextLine();
                    
                    if (sub == 1) {
                        ventas.sort((a, b) -> b.getCantidad() - a.getCantidad());
                        System.out.println("\n--- TOP 5 PRODUCTOS ---");
                        for (int i = 0; i < 5 && i < ventas.size(); i++) {
                            Venta v = ventas.get(i);
                            System.out.println((i+1) + ". " + v.getProducto() + 
                                             " (" + v.getCantidad() + " und) - S/ " + v.getTotal());
                        }
                    } else if (sub == 2) {
                        ventas.sort((a, b) -> Double.compare(b.getTotal(), a.getTotal()));
                        System.out.println("\n--- TOP 5 MONTOS ---");
                        for (int i = 0; i < 5 && i < ventas.size(); i++) {
                            Venta v = ventas.get(i);
                            System.out.println((i+1) + ". " + v.getProducto() + 
                                             " - S/ " + v.getTotal() + " (" + v.getCliente() + ")");
                        }
                    }
                    break;
                    
                case 8:
                    System.out.println("\n=== REPORTES ===");
                    double totalVentas = 0;
                    int totalItems = 0;
                    double totalIGV = 0;
                    
                    for (Venta v : ventas) {
                        totalVentas += v.getTotal();
                        totalItems += v.getCantidad();
                        totalIGV += v.getIgv();
                    }
                    
                    System.out.println("Total ventas: S/ " + totalVentas);
                    System.out.println("Total IGV (18%): S/ " + totalIGV);
                    System.out.println("Unidades vendidas: " + totalItems);
                    System.out.println("Numero de transacciones: " + ventas.size());
                    System.out.println("Promedio por venta: S/ " + (totalVentas/ventas.size()));
                    break;
                    
                case 9:
                    System.out.print("Ingrese ID de venta: ");
                    int id = tecla.nextInt();
                    tecla.nextLine();
                    
                    for (Venta v : ventas) {
                        if (v.getIdVenta() == id) {
                            System.out.println("\n=== DETALLE COMPLETO ===");
                            System.out.println("ID Venta: " + v.getIdVenta());
                            System.out.println("Fecha: " + v.getFecha());
                            System.out.println("Cliente: " + v.getCliente());
                            System.out.println("DNI: " + v.getDni());
                            System.out.println("Telefono: " + v.getTelefono());
                            System.out.println("Producto: " + v.getProducto());
                            System.out.println("Categoria: " + v.getCategoria());
                            System.out.println("Cantidad: " + v.getCantidad());
                            System.out.println("Precio unitario: S/ " + v.getPrecio());
                            System.out.println("Subtotal: S/ " + v.getSubtotal());
                            System.out.println("IGV (18%): S/ " + v.getIgv());
                            System.out.println("Total: S/ " + v.getTotal());
                            System.out.println("Metodo de pago: " + v.getMetodoPago());
                            System.out.println("Vendedor: " + v.getVendedor());
                        }
                    }
                    break;
                    
                case 0:
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }
}