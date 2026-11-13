package com.mycompany.libreria;

import java.util.ArrayList;

public class FiltroCategoria {
    public static void buscarPorCategoria(ArrayList<Venta> ventas, String categoriaBuscada) {
        System.out.println("\n--- Ventas de la categoria: " + categoriaBuscada.toUpperCase() + " ---");
        boolean encontrado = false;

        for (Venta v : ventas) {
            if (v.getCategoria().equalsIgnoreCase(categoriaBuscada.trim())) {
                System.out.println(v);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron ventas en esa categoria.");
        }
    }
}
