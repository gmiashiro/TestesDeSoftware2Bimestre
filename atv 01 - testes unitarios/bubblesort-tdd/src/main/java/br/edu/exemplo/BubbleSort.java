package br.edu.exemplo;

import java.util.Arrays;

public class BubbleSort {

    private int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        Arrays.sort(this.numeros);
    }

    public int[] getNumeros() {
        return numeros;
    }
}
