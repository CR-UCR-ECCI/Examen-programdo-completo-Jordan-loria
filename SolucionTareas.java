public class SolucionTareas {
    private int[] mejorCombinacion;
    private int maxPuntaje;
    
    public SolucionTareas() {
        this.mejorCombinacion = null;
        this.maxPuntaje = 0;
    }
    
    public int[] resolverTareas(int N, int E, int[] costos, int[] puntajes) {
        mejorCombinacion = new int[N];
        int[] solucionActual = new int[N];
        maxPuntaje = 0;
        
        System.out.println("\n RESOLVIENDO PROBLEMA DE TAREAS ");
        System.out.println("Energia disponible: " + E);
        System.out.println("Tareas disponibles: " + N);
        
        backtracking(0, 0, 0, N, E, costos, puntajes, solucionActual);
        
        return mejorCombinacion;
    }
    
    private void backtracking(int indice, int energiaActual, int puntajeActual, 
                            int N, int E, int[] costos, int[] puntajes, int[] solucionActual) {
        
        // Caso base: hemos considerado todas las tareas
        if (indice == N) {
            if (puntajeActual > maxPuntaje) {
                maxPuntaje = puntajeActual;
                // Copiar la solucion actual a la mejor solución
                for (int i = 0; i < N; i++) {
                    mejorCombinacion[i] = solucionActual[i];
                }
            }
            return;
        }
        
        // Opcion 1: No seleccionar la tarea actual
        solucionActual[indice] = 0;
        backtracking(indice + 1, energiaActual, puntajeActual, N, E, costos, puntajes, solucionActual);
        
        // Opcion 2: Seleccionar la tarea actual (si no excede la energia)
        if (energiaActual + costos[indice] <= E) {
            solucionActual[indice] = 1;
            backtracking(indice + 1, energiaActual + costos[indice], 
                        puntajeActual + puntajes[indice], N, E, costos, puntajes, solucionActual);
            solucionActual[indice] = 0; // Backtrack
        }
    }
    
    public int getMaxPuntaje() {
        return maxPuntaje;
    }
    
    public void mostrarSolucion(int[] costos, int[] puntajes) {
        if (mejorCombinacion == null) {
            System.out.println("No se ha resuelto el problema aún.");
            return;
        }
        
        System.out.println("\n=== SOLUCION OPTIMA ===");
        System.out.println("Puntaje maximo obtenido: " + maxPuntaje);
        System.out.print("Tareas seleccionadas: ");
        
        int energiaTotal = 0;
        int puntajeTotal = 0;
        
        for (int i = 0; i < mejorCombinacion.length; i++) {
            if (mejorCombinacion[i] == 1) {
                System.out.print("Tarea " + i + " ");
                energiaTotal += costos[i];
                puntajeTotal += puntajes[i];
            }
        }
        
        System.out.println("\nEnergia consumida: " + energiaTotal);
        System.out.println("Puntaje total: " + puntajeTotal);
        
        // Mostrar detalle de tareas seleccionadas
        System.out.println("\nDetalle de tareas seleccionadas:");
        for (int i = 0; i < mejorCombinacion.length; i++) {
            if (mejorCombinacion[i] == 1) {
                System.out.println("Tarea " + i + ": Energia=" + costos[i] + ", Puntaje=" + puntajes[i]);
            }
        }
    }
}