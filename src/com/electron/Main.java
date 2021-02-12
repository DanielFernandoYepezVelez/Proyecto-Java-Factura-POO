package com.electron;

import com.electron.SolicitarDatos.Datos;
import com.electron.clases.Electrodomestico;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /** Clase Para Solicitar Datos */
        Datos.solicitarDatos();

        /** Total Electrodomésticos Ingresados */
        List<Electrodomestico> electrodo = new LinkedList<>();

        electrodo.add(new Electrodomestico(Datos.getNombreElectro(), Datos.getCantidadElectro(),
                                         Datos.getCategoriaElectro(), Datos.getPrecedenciaElectro()));

        electrodo.forEach(elect -> {
            System.out.println(elect.definirPrecioPrecedencia());
            System.out.println(elect.definirPrecioCategoria());
            System.out.println(elect.precioFinalTotalizado());
            System.out.println(elect.toString());
        });
    }
}
