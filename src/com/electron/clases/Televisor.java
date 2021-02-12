package com.electron.clases;

import java.util.List;

public class Televisor extends Electrodomestico {
    private List<Integer> tamanio;
    private List<String> tdt;
    private Double precioTV;

    public Televisor(List<String> nombre, Integer cantidad, List<String> categoriaConsumo, List<String> precedencia,
                     List<Integer> tamanio, List<String> tdt) {
        super(nombre, cantidad, categoriaConsumo, precedencia);
        this.tamanio = tamanio;
        this.tdt = tdt;
    }

    public List<Integer> getTamanio() {
        return tamanio;
    }

    public void setTamanio(List<Integer> tamanio) {
        this.tamanio = tamanio;
    }

    public List<String> getTdt() {
        return tdt;
    }

    public void setTdt(List<String> tdt) {
        this.tdt = tdt;
    }

    public Double getPrecioTV() {
        return precioTV;
    }

    public void setPrecioTV(Double precioTV) {
        this.precioTV = precioTV;
    }

    @Override
    public Double definirPrecioPrecedencia() {
        Integer precioNacional = 0;
        Integer precioImportado = 0;

        for (int i = 0; i < this.getPrecedencia().size(); i++) {

            String origen = this.getPrecedencia().get(i);

            if (origen.equalsIgnoreCase("Nacional")) {
                precioNacional += 250000;
            } else if (origen.equalsIgnoreCase("Importado")) {
                precioImportado += 350000;
            }
        }

        return (double) (precioNacional + precioImportado);
    }

    @Override
    public Double definirPrecioCategoria() {
        Integer precioCategoriaA = 0;
        Integer precioCategoriaB = 0;
        Integer precioCategoriaC = 0;

        for (int i = 0; i < this.getCategoriaConsumo().size(); i++) {

            String categoria = this.getCategoriaConsumo().get(i);

            if (categoria.equalsIgnoreCase("A")) {
                precioCategoriaA += 450000;

            } else if (categoria.equalsIgnoreCase("B")) {
                precioCategoriaB += 350000;

            } else if (categoria.equalsIgnoreCase("C")) {
                precioCategoriaC += 250000;
            }
        }

        return (double) (precioCategoriaA + precioCategoriaB + precioCategoriaC);
    }

    @Override
    public Double precioFinalTotalizado() {
        Double precioInicial = this.definirPrecioPrecedencia() + this.definirPrecioCategoria();
        Double incrementoPorcentaje = 0.0;
        Double nuevoPrecio = 0.0;


        for (int i = 0; i < this.tamanio.size(); i++) {

            String tdt = this.tdt.get(i);
            Integer pulgadas = this.tamanio.get(i);

            if (pulgadas > 40 && tdt.equalsIgnoreCase("SI")) {
                incrementoPorcentaje = ((this.definirPrecioPrecedencia() + this.definirPrecioCategoria()) * 0.3);
                nuevoPrecio = precioInicial + incrementoPorcentaje + 250000;

            } else if (pulgadas > 40) {
                incrementoPorcentaje = ((this.definirPrecioPrecedencia() + this.definirPrecioCategoria()) * 0.3);
                nuevoPrecio = precioInicial + incrementoPorcentaje;

            } else if (tdt.equalsIgnoreCase("SI")) {
                nuevoPrecio = precioInicial + 250000;
            }
        }

        return this.precioTV = nuevoPrecio;
    }

    @Override
    public String toString() {
        return "\n********** TODOS Los Televisores **********" +
                "\ncantidad = " + this.getCantidad() +
                "\nnombres = " + this.getNombre() +
                "\nTamaño = " + this.tamanio +
                "\n¿Tiene TDT? = " + this.tdt +
                "\nprecedencias = " + this.getPrecedencia() +
                "\ncategoriasConsumo = " + this.getCategoriaConsumo() +
                "\nprecioPrecedenciaTotal = " + this.definirPrecioPrecedencia() +
                "\nprecioCategoriaTotal = " + this.definirPrecioCategoria() +
                "\nprecioTotalizado = " + this.precioFinalTotalizado();
    }
}
