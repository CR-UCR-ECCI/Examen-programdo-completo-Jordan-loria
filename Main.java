public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE COMPETENCIA AUTOMOVILISTICA ===");
        
        // Crear 3 equipos 
        Equipo toyota = new Equipo("Toyota", "Japon");
        Equipo ferrari = new Equipo("Ferrari", "Italia");
        Equipo redBull = new Equipo("Red Bull", "Austria");
        
        // Agregar 5 pilotos candidatos por equipo 
        System.out.println("\n---- AGREGANDO 5 CANDIDATOS POR EQUIPO ----");
        
        // Toyota - 5 candidatos
        toyota.agregarCandidato("MIGUEL", "España", 95);
        toyota.agregarCandidato("RICARDO", "Monaco", 85);
        toyota.agregarCandidato("HAMILTON", "Reino Unido", 110);
        toyota.agregarCandidato("ALBERTO", "Brasil", 70);
        toyota.agregarCandidato("RODRIGO", "Chile", 65);
        
        // Ferrari - 5 candidatos
        ferrari.agregarCandidato("EDGAR", "Colombia", 75);
        ferrari.agregarCandidato("ADRIAN", "Mexico", 90);
        ferrari.agregarCandidato("KATYA", "Rusia", 88);
        ferrari.agregarCandidato("JOSE", "Portugal", 82);
        ferrari.agregarCandidato("MAURICIO", "Argentina", 68);
        
        // Red Bull - 5 candidatos
        redBull.agregarCandidato("ALEXANDER", "Costa Rica", 120);
        redBull.agregarCandidato("RODRIGO", "Argentina", 80);
        redBull.agregarCandidato("LUIS", "Peru", 78);
        redBull.agregarCandidato("CARLOS", "Ecuador", 85);
        redBull.agregarCandidato("ANDRES", "Venezuela", 72);
        
        // Mostrar estado inicial
        System.out.println("\n---- ESTADO INICIAL DE EQUIPOS ----");
        toyota.mostrarEstado();
        ferrari.mostrarEstado();
        redBull.mostrarEstado();
        
        // Proceso que agregue 3 pilotos candidatos a la lista de escogidos
        System.out.println("\n---- PROCESO DE SELECCION: AGREGANDO 3 PILOTOS A ESCOGIDOS ----");
        
        // Primer piloto escogido
        System.out.println("\n Primera selección:");
        toyota.escogerPiloto(); // Deberia escoger a HAMILTON (110 puntos)
        
        // Segundo piloto escogido  
        System.out.println("\n Segunda selección:");
        ferrari.escogerPiloto(); // Deberia escoger a ADRIAN (90 puntos)
        
        // Tercer piloto escogido
        System.out.println("\n Tercera seleccion:");
        redBull.escogerPiloto(); // Deberia escoger a ALEXANDER (120 puntos)
        
        // Mostrar estado despues de las 3 selecciones
        System.out.println("\n---- ESTADO DESPUES DE 3 SELECCIONES ----");
        toyota.mostrarEstado();
        ferrari.mostrarEstado();
        redBull.mostrarEstado();
        
        // Proceso que escoja el mejor piloto dos veces
        System.out.println("\n---- BUSCANDO AL MEJOR PILOTO (PRIMERA VEZ) ----");
        
        ListaEquipos listaEquipos = new ListaEquipos();
        listaEquipos.agregarEquipo(toyota);
        listaEquipos.agregarEquipo(ferrari);
        listaEquipos.agregarEquipo(redBull);
        
        PilotoEscogido mejorPiloto1 = listaEquipos.seleccionarMejorPiloto();
        
        if (mejorPiloto1 != null) {
            System.out.println("\n PRIMER MEJOR PILOTO ENCONTRADO:");
            System.out.println("Nombre: " + mejorPiloto1.getNombre());
            System.out.println("Nacionalidad: " + mejorPiloto1.getNacionalidad());
            System.out.println("Puntos: " + mejorPiloto1.getPuntosObtenidos());
            System.out.println("Competencias: " + mejorPiloto1.getCompetenciasRealizadas());
        }
        
        // Escoger otro piloto para cambiar el panorama
        System.out.println("\n---- AGREGANDO UN PILOTO MAS PARA SEGUNDA EVALUACIÓN ----");
        redBull.escogerPiloto(); // Ahora escoge a CARLOS (85 puntos)
        
        System.out.println("\n---- BUSCANDO AL MEJOR PILOTO (SEGUNDA VEZ) ----");
        PilotoEscogido mejorPiloto2 = listaEquipos.seleccionarMejorPiloto();
        
        if (mejorPiloto2 != null) {
            System.out.println("\n SEGUNDO MEJOR PILOTO ENCONTRADO:");
            System.out.println("Nombre: " + mejorPiloto2.getNombre());
            System.out.println("Nacionalidad: " + mejorPiloto2.getNacionalidad());
            System.out.println("Puntos: " + mejorPiloto2.getPuntosObtenidos());
            System.out.println("Competencias: " + mejorPiloto2.getCompetenciasRealizadas());
        }
        
        // Mostrar estado final
        System.out.println("\n---- ESTADO FINAL DE TODOS LOS EQUIPOS ----");
        toyota.mostrarEstado();
        ferrari.mostrarEstado();
        redBull.mostrarEstado();

        // Pregunta 4: Problema de tareas
        System.out.println("\n=== PROBLEMA DE FIN DE SEMESTRE - TAREAS ACADEMICAS ===");
      
        int N = 4;
        int E = 5;
        int[] costos = {3, 2, 4, 1};
        int[] puntajes = {10, 5, 8, 4};
        
        // Mostrar tareas disponibles
        System.out.println("Tareas disponibles:");
        for (int i = 0; i < N; i++) {
            System.out.println("Tarea " + i + ": Energia=" + costos[i] + ", Puntaje=" + puntajes[i]);
        }
        
        SolucionTareas solucion = new SolucionTareas();
        int[] resultado = solucion.resolverTareas(N, E, costos, puntajes);
        solucion.mostrarSolucion(costos, puntajes);
        
        System.out.println("\n=== PROGRAMA FINALIZADO EXITOSAMENTE ===");
    }
}