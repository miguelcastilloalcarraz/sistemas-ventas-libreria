package com.mycompany.papeleriaa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DatosVentas {
    private static final String NOMBRE_ARCHIVO = "BaseDeDatosPF.csv";

    public static ArrayList<Venta> cargarVentas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            int numeroLinea = 0;
            
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                linea = linea.trim();
                if (linea.isEmpty()) continue;       
                if (numeroLinea == 1) continue;          
                String[] datos = linea.split(",");
   
                if (datos.length >= 15) {
                    try {
                        Venta venta = new Venta(
                            Integer.parseInt(datos[0].trim()),      // idVenta
                            datos[1].trim(),                         // fecha
                            datos[2].trim(),                         // nombreCliente
                            datos[3].trim(),                         // apellidoCliente
                            datos[4].trim(),                         // dni
                            datos[5].trim(),                         // telefono
                            datos[6].trim(),                         // producto
                            datos[7].trim(),                         // categoria
                            Integer.parseInt(datos[8].trim()),       // cantidad
                            Double.parseDouble(datos[9].trim()),     // precio
                            Double.parseDouble(datos[10].trim()),    // subtotal
                            Double.parseDouble(datos[11].trim()),    // igv
                            Double.parseDouble(datos[12].trim()),    // total
                            datos[13].trim(),                        // metodoPago
                            datos[14].trim()                         // vendedor
                        );
                        
                        ventas.add(venta);
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Error de formato en línea " + numeroLinea + ": " + linea);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Línea " + numeroLinea + " no tiene suficientes campos: " + linea);
                }
            }
            
            System.out.println("\n>>> SISTEMA: Se cargaron " + ventas.size() + " registros correctamente.");
            
        } catch (Exception e) {
            System.out.println("\n>>> ERROR: No se encuentra el archivo: " + NOMBRE_ARCHIVO);
            System.out.println("Asegúrate de que el archivo esté en la raíz del proyecto.");
            e.printStackTrace();
        }
        
        return ventas;
    }
}