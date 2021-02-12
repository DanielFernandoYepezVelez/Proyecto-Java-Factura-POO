package com.electron.clases;

import java.util.List;

public class Nevera extends Electrodomestico {
    private List<Integer> capacidad;

    public Nevera(List<String> nombre, Integer cantidad, List<String> categoriaConsumo, List<String> precedencia, List<Integer> capacidad) {
        super(nombre, cantidad, categoriaConsumo, precedencia);
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "\n********** TODAS Las Neveras **********" +
                "\ncantidad = " + this.getCantidad() +
                "\nnombres = " + this.getNombre() +
                "\ncapacidad = " + this.capacidad +
                "\nprecedencias = " + this.getPrecedencia() +
                "\ncategoriasConsumo = " + this.getCategoriaConsumo() +
                "\nprecioPrecedenciaTotal = " + ".. En Construcción" +
                "\nprecioCategoriaTotal = " + ".. En Construcción" +
                "\nprecioTotalizado = " + ".. En Construcción";
    }
}
