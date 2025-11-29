public class ArbolEscogidos {
    private PilotoEscogido raiz;
    
    public ArbolEscogidos() {
        this.raiz = null;
    }
    
    // Getters y Setters
    public PilotoEscogido getRaiz() { 
        return raiz; }
    public void setRaiz(PilotoEscogido raiz) { 
        this.raiz = raiz; }
    
    // Metodo para insertar en el arbol (ordenado por competencias realizadas)
    public void insertar(PilotoEscogido nuevo) {
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }
    
    private void insertarRecursivo(PilotoEscogido actual, PilotoEscogido nuevo) {
        if (nuevo.getCompetenciasRealizadas() < actual.getCompetenciasRealizadas()) {
            if (actual.getIzquierdo() == null) {
                actual.setIzquierdo(nuevo);
            } else {
                insertarRecursivo(actual.getIzquierdo(), nuevo);
            }
        } else {
            if (actual.getDerecho() == null) {
                actual.setDerecho(nuevo);
            } else {
                insertarRecursivo(actual.getDerecho(), nuevo);
            }
        }
    }
    
    // Metodo para mostrar arbol in-order
    public void mostrarArbol() {
        System.out.println(" PILOTOS ESCOGIDOS (Arbol) ");
        mostrarInOrder(raiz);
    }
    
    private void mostrarInOrder(PilotoEscogido nodo) {
        if (nodo != null) {
            mostrarInOrder(nodo.getIzquierdo());
            System.out.println(nodo);
            mostrarInOrder(nodo.getDerecho());
        }
    }
    
    // Metodo para buscar el piloto con mayor puntaje en el arbol
    public PilotoEscogido buscarMejorPiloto() {
        return buscarMejorRecursivo(raiz);
    }
    
    private PilotoEscogido buscarMejorRecursivo(PilotoEscogido nodo) {
        if (nodo == null) {
            return null;
        }
        
        PilotoEscogido mejor = nodo;
        
        PilotoEscogido mejorIzquierdo = buscarMejorRecursivo(nodo.getIzquierdo());
        if (mejorIzquierdo != null && mejorIzquierdo.getPuntosObtenidos() > mejor.getPuntosObtenidos()) {
            mejor = mejorIzquierdo;
        }
        
        PilotoEscogido mejorDerecho = buscarMejorRecursivo(nodo.getDerecho());
        if (mejorDerecho != null && mejorDerecho.getPuntosObtenidos() > mejor.getPuntosObtenidos()) {
            mejor = mejorDerecho;
        }
        
        return mejor;
    }

}

