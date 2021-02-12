package com.electron.clases;

import java.util.LinkedList;
import java.util.List;

public class Electrodomestico {
    private Integer cantidad;
    private List<String> nombre = new LinkedList<>();
    private List<String> precedencia = new LinkedList<>();
    private List<String> categoriaConsumo = new LinkedList<>();

    private Double precioPrecedencia;
    private Double precioCategoria;
    private Double precioTotalizado;

    public Electrodomestico(List<String> nombre, Integer cantidad, List<String> categoriaConsumo, List<String> precedencia) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precedencia = precedencia;
        this.categoriaConsumo = categoriaConsumo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public List<String> getNombre() {
        return nombre;
    }

    public List<String> getPrecedencia() {
        return precedencia;
    }

    public List<String> getCategoriaConsumo() {
        return categoriaConsumo;
    }

    public Double definirPrecioPrecedencia() {
        Integer precioNacional = 0;
        Integer precioImportado = 0;

        for (int i = 0; i < this.precedencia.size(); i++) {

            String origen = this.precedencia.get(i);

            if (origen.equalsIgnoreCase("Nacional")) {
                precioNacional += 250000;
            } else if (origen.equalsIgnoreCase("Importado")) {
                precioImportado += 350000;
            }
        }

         return this.precioPrecedencia = (double) (precioNacional + precioImportado);
    }

    public Double definirPrecioCategoria() {
        Integer precioCategoriaA = 0;
        Integer precioCategoriaB = 0;
        Integer precioCategoriaC = 0;

        for (int i = 0; i < this.categoriaConsumo.size(); i++) {

            String categoria = this.categoriaConsumo.get(i);

            if (categoria.equalsIgnoreCase("A")) {
                precioCategoriaA += 450000;

            } else if (categoria.equalsIgnoreCase("B")) {
                precioCategoriaB += 350000;

            } else if (categoria.equalsIgnoreCase("C")) {
                precioCategoriaC += 250000;
            }
        }

        return this.precioCategoria = (double) (precioCategoriaA + precioCategoriaB + precioCategoriaC);
    }

    public Double precioFinalTotalizado() {
        return this.precioTotalizado = (this.definirPrecioPrecedencia() + this.definirPrecioCategoria());
    }

    @Override
    public String toString() {
        return "TODOS Los Electrodomesticos {" +
                "cantidad=" + cantidad +
                ", nombre=" + nombre +
                ", precedencia=" + precedencia +
                ", categoriaConsumo=" + categoriaConsumo +
                ", precioPrecedencia=" + precioPrecedencia +
                ", precioCategoria=" + precioCategoria +
                ", precioTotalizado=" + precioTotalizado +
                '}';
    }
}