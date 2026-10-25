package cola;
public class CallCenterPruebas {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        
        Llamada l1 = new Llamada(1,"Juan",Llamada.Tipo.normal, 5);
        Llamada l2 = new Llamada(2,"Daniel",Llamada.Tipo.normal, 6.3);
        Llamada l3 = new Llamada(3,"Zayuri",Llamada.Tipo.prioritaria, 3.5);
        Llamada l4 = new Llamada(4,"Angel",Llamada.Tipo.normal, 8);
        Llamada l5 = new Llamada(5,"Julian",Llamada.Tipo.normal,2.4);
        
        
        System.out.println("Recibiendo llamadas");
        callCenter.recibirLlamada(l1);
        callCenter.recibirLlamada(l2);
        callCenter.recibirLlamada(l3);
        callCenter.recibirLlamada(l4);
        callCenter.recibirLlamada(l5);
        
        System.out.println("Mostrando cola: ");
        callCenter.mostrarCola();
        System.out.println("");
        System.out.println("Llamadas pendientes: "+callCenter.llamadasPendientes());
        System.out.println("Tiempo total pendiente: "+callCenter.tiempoTotalPendiente());
        
        System.out.println("Atender llamada: \n"+callCenter.atenderLlamada());
        
        System.out.println("");
        System.out.println("Mostrando cola: ");
        callCenter.mostrarCola();
        
        System.out.println("Llamada cancelada");
        callCenter.cancelarLlamada();
        
        System.out.println("");
        System.out.println("Mostrando cola");
        callCenter.mostrarCola();
        
        System.out.println("");
        System.out.println("Atendiendo todas las llamadas: ");
        callCenter.atenderTodas();
        
        System.out.println("Obtener promedio de puntuacion: "+callCenter.obtenerPromedio());
    }
}