public class PilotoCandidato {
    private String nombre;
    private String nacionalidad;
    private int puntosObtenidos;
    private PilotoCandidato siguiente;
    private PilotoCandidato anterior;
    
    public PilotoCandidato(String nombre, String nacionalidad, int puntosObtenidos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.puntosObtenidos = puntosObtenidos;
        this.siguiente = null;
        this.anterior = null;
    }
    
    // Getters y Setters
    public String getNombre() {  
        return nombre; }
    public void setNombre(String nombre) {
         this.nombre = nombre; }
    
    public String getNacionalidad() {
         return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { 
        this.nacionalidad = nacionalidad; }
    
    public int getPuntosObtenidos() {
         return puntosObtenidos; }
    public void setPuntosObtenidos(int puntosObtenidos) { 
        this.puntosObtenidos = puntosObtenidos; }
    
    public PilotoCandidato getSiguiente() { 
        return siguiente; }
    public void setSiguiente(PilotoCandidato siguiente) { 
        this.siguiente = siguiente; }
    
    public PilotoCandidato getAnterior() { 
        return anterior; }
    public void setAnterior(PilotoCandidato anterior) { 
        this.anterior = anterior; }
    
    @Override
    public String toString() {
        return "Candidato: " + nombre + " (" + nacionalidad + ") - Puntos: " + puntosObtenidos;
    }
}
