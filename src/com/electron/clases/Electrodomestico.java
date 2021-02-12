package com.electron.clases;

import java.util.List;

public class Electrodomestico {
    private Integer cantidad;
    private List<String> nombre;
    private List<String> precedencia;
    private List<String> categoriaConsumo;

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

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<String> getNombre() {
        return nombre;
    }

    public void setNombre(List<String> nombre) {
        this.nombre = nombre;
    }

    public List<String> getPrecedencia() {
        return precedencia;
    }

    public void setPrecedencia(List<String> precedencia) {
        this.precedencia = precedencia;
    }

    public List<String> getCategoriaConsumo() {
        return categoriaConsumo;
    }

    public void setCategoriaConsumo(List<String> categoriaConsumo) {
        this.categoriaConsumo = categoriaConsumo;
    }

    public Double getPrecioPrecedencia() {
        return precioPrecedencia;
    }

    public void setPrecioPrecedencia(Double precioPrecedencia) {
        this.precioPrecedencia = precioPrecedencia;
    }

    public Double getPrecioCategoria() {
        return precioCategoria;
    }

    public void setPrecioCategoria(Double precioCategoria) {
        this.precioCategoria = precioCategoria;
    }

    public Double getPrecioTotalizado() {
        return precioTotalizado;
    }

    public void setPrecioTotalizado(Double precioTotalizado) {
        this.precioTotalizado = precioTotalizado;
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
        return "********** TODOS Los Electrodomésticos **********" +
                "\ncantidad = " + cantidad +
                "\nnombres = " + nombre +
                "\nprecedencias = " + precedencia +
                "\ncategoriasConsumo = " + categoriaConsumo +
                "\nprecioPrecedenciaTotal = " + precioPrecedencia +
                "\nprecioCategoriaTotal = " + precioCategoria +
                "\nprecioTotalizado = " + precioTotalizado;
    }
}