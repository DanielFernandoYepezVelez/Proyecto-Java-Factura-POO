package com.electron.SolicitarDatos;

import java.util.*;

public class Electrodomesticos {
    private static Integer cantidadElectro;
    private static List<String> nombreElectro = new LinkedList<>();
    private static List<String> categoriaElectro = new LinkedList<>();
    private static List<String> precedenciaElectro = new LinkedList<>();

    public static Integer getCantidadElectro() {
        return cantidadElectro;
    }

    public static void setCantidadElectro(Integer cantidadElectro) {
        Electrodomesticos.cantidadElectro = cantidadElectro;
    }

    public static List<String> getNombreElectro() {
        return nombreElectro;
    }

    public static void setNombreElectro(List<String> nombreElectro) {
        Electrodomesticos.nombreElectro = nombreElectro;
    }

    public static List<String> getCategoriaElectro() {
        return categoriaElectro;
    }

    public static void setCategoriaElectro(List<String> categoriaElectro) {
        Electrodomesticos.categoriaElectro = categoriaElectro;
    }

    public static List<String> getPrecedenciaElectro() {
        return precedenciaElectro;
    }

    public static void setPrecedenciaElectro(List<String> precedenciaElectro) {
        Electrodomesticos.precedenciaElectro = precedenciaElectro;
    }

    public static void solicitarDatos() {
        Integer i = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese La Cantidad Total De Electrodomésticos Vendidos: ");

        try {
            cantidadElectro = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("El Valor Ingresado No Es Válido, Deben Ser Valores Númericos. " + e + "\n");
            solicitarDatos();
        }

        do {
            System.out.println("Ingrese El Nombre Del Electrodoméstico(Televisor ó Nevera u Otro) #" + (i+1) + ": ");
            nombreElectro.add(teclado.next());

            System.out.println("Ingrese La Categoria Del Electrodoméstico(A ó B ó C) #" + (i+1) + ": ");
            categoriaElectro.add(teclado.next());

            System.out.println("Ingrese Lugar De Origen Del Electrodoméstico(Importado O Nacional) #" + (i+1) + ": ");
            precedenciaElectro.add(teclado.next());

            i += 1;
            System.out.println("");
        } while (i < cantidadElectro);
    }
}
