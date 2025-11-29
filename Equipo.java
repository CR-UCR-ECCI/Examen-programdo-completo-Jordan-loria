public class Equipo {
    private String nombre;
    private String paisOrigen;
    private ListaDobleCandidatos candidatos;
    private ArbolEscogidos escogidos;
    
    public Equipo(String nombre, String paisOrigen) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.candidatos = new ListaDobleCandidatos();
        this.escogidos = new ArbolEscogidos();
    }
    
    // Getters y Setters
    public String getNombre() { 
        return nombre; }
    public void setNombre(String nombre) { 
        this.nombre = nombre; }
    
    public String getPaisOrigen() { 
        return paisOrigen; }
    public void setPaisOrigen(String paisOrigen) { 
        this.paisOrigen = paisOrigen; }
    
    public ListaDobleCandidatos getCandidatos() { 
        return candidatos; }
    public ArbolEscogidos getEscogidos() { 
        return escogidos; }
    
    // Pregunta 2: Metodo para escoger piloto
    public void escogerPiloto() {
        if (candidatos.getUltimo() == null) {
            System.out.println("No hay candidatos disponibles para escoger.");
            return;
        }
        
        // El ultimo candidato tiene el mayor puntaje (lista ordenada ascendente)
        PilotoCandidato mejorCandidato = candidatos.getUltimo();
        
        System.out.println("Escogiendo al piloto: " + mejorCandidato.getNombre());
        
        // Crear nuevo piloto escogido
        PilotoEscogido nuevoEscogido = new PilotoEscogido(
            mejorCandidato.getNombre(),
            mejorCandidato.getNacionalidad(),
            mejorCandidato.getPuntosObtenidos(),
            1 // Inicia con 1 competencia
        );
        
        // Insertar en el arbol de escogidos
        escogidos.insertar(nuevoEscogido);
        
        // Eliminar de la lista de candidatos
        candidatos.eliminarCandidato(mejorCandidato);
        
        System.out.println("Piloto " + nuevoEscogido.getNombre() + " movido a escogidos.");
    }
    
    // Metodo para agregar candidato de prueba
    public void agregarCandidato(String nombre, String nacionalidad, int puntos) {
        PilotoCandidato nuevo = new PilotoCandidato(nombre, nacionalidad, puntos);
        candidatos.agregarCandidato(nuevo);
    }
    
    // Metodo para mostrar estado del equipo MEJORADO
    public void mostrarEstado() {
        System.out.println("\n EQUIPO: " + nombre + " (" + paisOrigen + ")");
        candidatos.mostrarCandidatos();
        escogidos.mostrarArbol(); 
       
    }
}

