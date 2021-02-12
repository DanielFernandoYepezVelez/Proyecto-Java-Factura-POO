package com.electron;

import com.electron.SolicitarDatos.Electrodomesticos;
import com.electron.clases.Electrodomestico;
import com.electron.clases.Nevera;
import com.electron.clases.Televisor;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        /** Clase Para Solicitar Datos */
        Electrodomesticos.solicitarDatos();
        /** ---------------------------------------------------------------------------------------- */

        /** Total Electrodomésticos Ingresados */
        List<Electrodomestico> electrodo = new LinkedList<>();

        electrodo.add(new Electrodomestico(Electrodomesticos.getNombreElectro(), Electrodomesticos.getCantidadElectro(),
                                         Electrodomesticos.getCategoriaElectro(), Electrodomesticos.getPrecedenciaElectro()));
        /** ---------------------------------------------------------------------------------------- */

        /** Total Televisores Existentes En Todos Los Electrodomésticos Ingresados */
        List<Televisor> televisor = new LinkedList<>();

        Integer cantidadTV = 0;
        List<String> nombreTV = new LinkedList<>();
        List<String> categoriaTV = new LinkedList<>();
        List<String> precedenciaTV = new LinkedList<>();
        List<Integer> pantallaTV = new LinkedList<>();
        List<String> tdtTV = new LinkedList<>();

        for (int i = 0; i < Electrodomesticos.getCantidadElectro(); i++) {
            String name = Electrodomesticos.getNombreElectro().get(i);

            if (name.startsWith("tv") || name.startsWith("TV") || name.startsWith("tele") || name.startsWith("TELE")) {
                nombreTV.add(Electrodomesticos.getNombreElectro().get(i));
                categoriaTV.add(Electrodomesticos.getCategoriaElectro().get(i));
                precedenciaTV.add(Electrodomesticos.getPrecedenciaElectro().get(i));
                cantidadTV += 1;

                System.out.println("\nIngrese El Tamaño De La Pantalla (20 - 30 - 40) Del Televisor #: " + (i + 1) + ": ");
                pantallaTV.add(teclado.nextInt());

                System.out.println("¿El Televisor #" + (i+1) + " Tiene TDT? (Si ó No): ");
                tdtTV.add(teclado.next());
            }
        }

        televisor.add(new Televisor(nombreTV, cantidadTV, categoriaTV, precedenciaTV, pantallaTV, tdtTV));
        /** ---------------------------------------------------------------------------------------- */

        /** Total Neveras Existentes En Todos Los Electrodomésticos Ingresados */
        List<Nevera> nevera = new LinkedList<>();

        Integer cantidadNV = 0;
        List<String> nombreNV = new LinkedList<>();
        List<String> categoriaNV = new LinkedList<>();
        List<String> precedenciaNV = new LinkedList<>();
        List<Integer> capacidadNV  = new LinkedList<>();

        for (int i = 0; i < Electrodomesticos.getCantidadElectro(); i++) {
            String name = Electrodomesticos.getNombreElectro().get(i);

            if (name.startsWith("nev") || name.startsWith("NEV") || name.startsWith("neve") || name.startsWith("NEVE")) {
                nombreNV.add(Electrodomesticos.getNombreElectro().get(i));
                categoriaNV.add(Electrodomesticos.getCategoriaElectro().get(i));
                precedenciaNV.add(Electrodomesticos.getPrecedenciaElectro().get(i));
                cantidadNV += 1;

                System.out.println("\nIngrese La Capacidad De La Nevera: ");
                capacidadNV.add(teclado.nextInt());
            }
        }

        nevera.add(new Nevera(nombreNV, cantidadNV, categoriaNV, precedenciaNV, capacidadNV));
        /** ---------------------------------------------------------------------------------------- */

        /** Mostrando La Factura Final */
        System.out.println("\n===================== FACTURA ELECTRODOMÉSTICOS ========================");

        electrodo.forEach(elect -> {
            elect.definirPrecioPrecedencia();
            elect.definirPrecioCategoria();
            elect.precioFinalTotalizado();
            System.out.println(elect.toString());
        });

        televisor.forEach(tv -> {
            tv.definirPrecioPrecedencia();
            tv.definirPrecioCategoria();
            tv.precioFinalTotalizado();
            System.out.println(tv.toString());
        });

        nevera.forEach(nv -> {;
            System.out.println(nv.toString());
        });
        /** ---------------------------------------------------------------------------------------- */
    }
}
