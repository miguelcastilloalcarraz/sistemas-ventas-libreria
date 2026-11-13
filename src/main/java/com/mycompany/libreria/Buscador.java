package com.mycompany.libreria;

import java.util.ArrayList;

public class Buscador {
    public static Venta buscarPorProducto(ArrayList<Venta> ventas, String nombreProducto) {
        nombreProducto = nombreProducto.trim();
        for (Venta v : ventas) {
            if (v.getProducto().equalsIgnoreCase(nombreProducto)) {
                return v;
            }
        }
        return null;
    }
}
