import java.util.*;

public class Ejemplo {

    public static Set<Integer> encontrarConjuntoIndependiente(int[][] grafo) {
        Set<Integer> conjuntoIndependiente = new HashSet<>();
        Set<Integer> nodosVisitados = new HashSet<>();

        // Crear una lista de nodos ordenados por grado descendente
        List<Integer> nodosOrdenados = new ArrayList<>();
        for (int i = 0; i < grafo.length; i++) {
            nodosOrdenados.add(i);
        }
        nodosOrdenados.sort(Comparator.comparingInt(nodo -> -gradoNodo(grafo, nodo)));

        // Recorrer todos los nodos del grafo en orden de grado descendente
        for (int nodo : nodosOrdenados) {
            // Si el nodo no ha sido visitado, agregarlo al conjunto independiente
            if (!nodosVisitados.contains(nodo)) {
                conjuntoIndependiente.add(nodo);

                // Marcar los nodos adyacentes como visitados
                for (int vecino = 0; vecino < grafo.length; vecino++) {
                    if (grafo[nodo][vecino] == 1) {
                        nodosVisitados.add(vecino);
                    }
                }
            }
        }

        return conjuntoIndependiente;
    }

    // Función auxiliar para calcular el grado de un nodo en el grafo
    private static int gradoNodo(int[][] grafo, int nodo) {
        int grado = 0;
        for (int vecino = 0; vecino < grafo.length; vecino++) {
            if (grafo[nodo][vecino] == 1) {
                grado++;
            }
        }
        return grado;
    }

    public static void main(String[] args) {
        // Ejemplo de grafo representado por una matriz de adyacencia
        int[][] grafo = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0}
        };

        // Encontrar un conjunto independiente en el grafo
        Set<Integer> conjuntoIndependiente = encontrarConjuntoIndependiente(grafo);

        // Mostrar el conjunto independiente resultante
        System.out.println("Conjunto Independiente: " + conjuntoIndependiente);
    }
}
