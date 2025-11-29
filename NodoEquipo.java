public class NodoEquipo {
    private Equipo equipo;
    private NodoEquipo siguiente;
    
    public NodoEquipo(Equipo equipo) {
        this.equipo = equipo;
        this.siguiente = null;
    }
    
    // Getters y Setters
    public Equipo getEquipo() { 
        return equipo; }
    public void setEquipo(Equipo equipo) { 
        this.equipo = equipo; }
    
    public NodoEquipo getSiguiente() { 
        return siguiente; }
    public void setSiguiente(NodoEquipo siguiente) {
         this.siguiente = siguiente; }
}
