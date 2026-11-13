package com.mycompany.papeleriaa;  // Cambiado

import java.util.ArrayList;
import java.util.Comparator;

public class Ranking {
    
    public static void mostrarTopProductosVendidos(ArrayList<Venta> ventas) {
        System.out.println("\n--- Top 5 Productos con más Unidades Vendidas ---");
        System.out.printf("| %-20s | %-10s |\n", "Producto", "Cantidad");
        System.out.println("----------------------------------------");
        
        ventas.stream()
                .sorted(Comparator.comparingInt(Venta::getCantidad).reversed())
                .limit(5)
                .forEach(v -> System.out.printf("| %-20s | %-10d |\n", v.getProducto(), v.getCantidad()));
    }
    
    public static void mostrarMayoresVentas(ArrayList<Venta> ventas) {
        System.out.println("\n--- Top 5 Ventas de Mayor Valor (S/.) ---");
        System.out.printf("| %-20s | %-10s |\n", "Producto", "Total S/.");
        System.out.println("----------------------------------------");
        
        ventas.stream()
                .sorted(Comparator.comparingDouble(Venta::getTotal).reversed())
                .limit(5)
                .forEach(v -> System.out.printf("| %-20s | %-10.2f |\n", v.getProducto(), v.getTotal()));
    }
}