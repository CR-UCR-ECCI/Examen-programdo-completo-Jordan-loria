public class ListaDobleCandidatos {
    private PilotoCandidato primero;
    private PilotoCandidato ultimo;
    
    public ListaDobleCandidatos() {
        this.primero = null;
        this.ultimo = null;
    }
    
    // Getters y Setters
    public PilotoCandidato getPrimero() {  
        return primero; }
    public void setPrimero(PilotoCandidato primero) { 
        this.primero = primero; }
    
    public PilotoCandidato getUltimo() { 
        return ultimo; }
    public void setUltimo(PilotoCandidato ultimo) { 
        this.ultimo = ultimo; }
    
    // Metodo para agregar candidato manteniendo orden ascendente por puntaje
    public void agregarCandidato(PilotoCandidato nuevo) {
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            PilotoCandidato actual = primero;
            PilotoCandidato anterior = null;
            
            // Buscar posición correcta (orden ascendente por puntaje)
            while (actual != null && actual.getPuntosObtenidos() < nuevo.getPuntosObtenidos()) {
                anterior = actual;
                actual = actual.getSiguiente();
            }
            
            if (anterior == null) {
                // Insertar al inicio
                nuevo.setSiguiente(primero);
                primero.setAnterior(nuevo);
                primero = nuevo;
            } else if (actual == null) {
                // Insertar al final
                ultimo.setSiguiente(nuevo);
                nuevo.setAnterior(ultimo);
                ultimo = nuevo;
            } else {
                // Insertar en medio
                anterior.setSiguiente(nuevo);
                nuevo.setAnterior(anterior);
                nuevo.setSiguiente(actual);
                actual.setAnterior(nuevo);
            }
        }
    }
    
    // Metodo para mostrar candidatos
    public void mostrarCandidatos() {
        PilotoCandidato actual = primero;
        System.out.println("---- CANDIDATOS ---");
        while (actual != null) {
            System.out.println(actual);
            actual = actual.getSiguiente();
        }
    }
    
    // Metodo para eliminar candidato
    public void eliminarCandidato(PilotoCandidato candidato) {
        if (candidato.getAnterior() != null) {
            candidato.getAnterior().setSiguiente(candidato.getSiguiente());
        } else {
            primero = candidato.getSiguiente();
        }
        
        if (candidato.getSiguiente() != null) {
            candidato.getSiguiente().setAnterior(candidato.getAnterior());
        } else {
            ultimo = candidato.getAnterior();
        }
    }
}
