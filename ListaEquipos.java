public class ListaEquipos {
    private NodoEquipo primero;
    
    public ListaEquipos() {
        this.primero = null;
    }
    
    // Getters y Setters
    public NodoEquipo getPrimero() { 
        return primero; }
    public void setPrimero(NodoEquipo primero) { 
        this.primero = primero; }
    
    // Metodo para agregar equipo
    public void agregarEquipo(Equipo equipo) {
        NodoEquipo nuevo = new NodoEquipo(equipo);
        if (primero == null) {
            primero = nuevo;
        } else {
            NodoEquipo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    // Pregunta 3: Metodo para seleccionar mejor piloto
    public PilotoEscogido seleccionarMejorPiloto() {
        PilotoEscogido mejorPiloto = null;
        NodoEquipo actual = primero;
        
        System.out.println("\n BUSCANDO MEJOR PILOTO ENTRE TODOS LOS EQUIPOS ");
        
        while (actual != null) {
            Equipo equipo = actual.getEquipo();
            PilotoEscogido mejorDelEquipo = equipo.getEscogidos().buscarMejorPiloto();
            
            if (mejorDelEquipo != null) {
                System.out.println("En equipo " + equipo.getNombre() + ": " + mejorDelEquipo.getNombre() + 
                                 " con " + mejorDelEquipo.getPuntosObtenidos() + " puntos");
                
                if (mejorPiloto == null || mejorDelEquipo.getPuntosObtenidos() > mejorPiloto.getPuntosObtenidos()) {
                    mejorPiloto = mejorDelEquipo;
                }
            }
            
            actual = actual.getSiguiente();
        }
        
        if (mejorPiloto != null) {
            System.out.println("MEJOR PILOTO ENCONTRADO: " + mejorPiloto.getNombre() + 
                             " con " + mejorPiloto.getPuntosObtenidos() + " puntos");
        } else {
            System.out.println("No hay pilotos escogidos en ningun equipo.");
        }
        
        return mejorPiloto;
    }
}
