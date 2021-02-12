package com.electron.clases;

import java.util.List;

public class Nevera extends Electrodomestico {
    private Integer capacidad;

    public Nevera(List<String> nombre, Integer cantidad, List<String> categoriaConsumo, List<String> precedencia) {
        super(nombre, cantidad, categoriaConsumo, precedencia);
    }
}
