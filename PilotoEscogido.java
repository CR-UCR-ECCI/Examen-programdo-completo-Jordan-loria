public class PilotoEscogido {
    private String nombre;
    private String nacionalidad;
    private int puntosObtenidos;
    private int competenciasRealizadas;
    private PilotoEscogido izquierdo;
    private PilotoEscogido derecho;
    
    public PilotoEscogido(String nombre, String nacionalidad, int puntosObtenidos, int competenciasRealizadas) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.puntosObtenidos = puntosObtenidos;
        this.competenciasRealizadas = competenciasRealizadas;
        this.izquierdo = null;
        this.derecho = null;
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
    
    public int getCompetenciasRealizadas() { 
        return competenciasRealizadas; }
    public void setCompetenciasRealizadas(int competenciasRealizadas) { 
        this.competenciasRealizadas = competenciasRealizadas; }
    
    public PilotoEscogido getIzquierdo() { 
        return izquierdo; }
    public void setIzquierdo(PilotoEscogido izquierdo) { 
        this.izquierdo = izquierdo; }
    
    public PilotoEscogido getDerecho() { 
        return derecho; }
    public void setDerecho(PilotoEscogido derecho) { 
        this.derecho = derecho; }
    
    @Override
    public String toString() {
        return "Escogido: " + nombre + " (" + nacionalidad + ") - Puntos: " + puntosObtenidos + " - Competencias: " + competenciasRealizadas;
    }
}