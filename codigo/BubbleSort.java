import java.util.Arrays;

public class BubbleSort {

    // ordena el arreglo de menor a mayor con el metodo de burbuja
    // y va mostrando como queda despues de cada pasada
    public static void bubbleSort(int[] arreglo) {
        // contadores para llevar la cuenta de lo que va pasando
        int comparaciones = 0, intercambios = 0, pasadas = 0;
        int n = arreglo.length;
        System.out.println("inicial: " + Arrays.toString(arreglo));

        // Cada vuelta de este ciclo es una pasada por la fila
        for (int pasada = 1; pasada < n; pasada++) {
            // bandera para saber si en esta pasada se movio algo
            boolean huboIntercambio = false;

            // Aqui se comparan los pares vecinos, y como en cada pasada
            // el mas grande ya quedo al final, cada vez se revisan menos
            for (int i = 0; i < n - pasada; i++) {
                comparaciones++;

                // si el de la izquierda es mayor, se cambian de lugar
                if (arreglo[i] > arreglo[i + 1]) {
                    // se guarda uno en auxiliar para no perderlo al copiar
                    int auxiliar = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = auxiliar;
                    intercambios++;
                    huboIntercambio = true;
                }
            }

            pasadas++;
            System.out.println("pasada " + pasada + ": " + Arrays.toString(arreglo));

            // si no hubo ningun cambio, la fila ya esta ordenada
            // y no hace falta seguir con las pasadas que faltan
            if (!huboIntercambio) break;
        }

        // resumen final con los totales
        System.out.println("comparaciones: " + comparaciones + ", intercambios: " + intercambios + ", pasadas: " + pasadas + "\n");
    }

    public static void main(String[] args) {
        // arreglo desordenado
        bubbleSort(new int[]{34, 12, 25, 8, 19});
        // arreglo que ya estaba ordenado
        bubbleSort(new int[]{1, 2, 3, 4, 5});
        // arreglo en orden inverso, el peor caso
        bubbleSort(new int[]{5, 4, 3, 2, 1});
    }
}