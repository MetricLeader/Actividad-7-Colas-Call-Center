package cola;
import java.util.LinkedList;
public class CallCenter {
    private Cola<Llamada> colaLlamada;
    private double tiempoTotal;
    private LinkedList<Integer> puntuaciones;
     
    public CallCenter(){
        this.colaLlamada = new Cola<>();
        this.tiempoTotal = 0;
        this.puntuaciones = new LinkedList<>();
    }
    
    public void recibirLlamada(Llamada llamada){
        if (llamada.getTipo() == Llamada.Tipo.prioritaria ){
            colaLlamada.enqueuePrioritario(llamada);
        } else {
            colaLlamada.enqueue(llamada);
        }
    }
    public Llamada atenderLlamada(){
        Llamada llamada = colaLlamada.dequeue();
        tiempoTotal += llamada.getDuracion();
        puntuaciones.add(llamada.obtenerPuntuacion());
        return llamada;
    }
    public void cancelarLlamada(){
        if(!colaLlamada.empty()){
            colaLlamada.dequeue();
        } else{
            System.out.println("No hay llamada");
        }
    }
    public void mostrarCola(){
        System.out.println(colaLlamada.toString());
    }
    public double tiempoTotalPendiente(){
    double tiempoPendiente = 0;
    Cola<Llamada> copia = new Cola<>();
    
    while(!colaLlamada.empty()){
        Llamada l = colaLlamada.dequeue();
        tiempoPendiente += l.getDuracion();
        copia.enqueue(l);
    }
    while(!copia.empty()){
        colaLlamada.enqueue(copia.dequeue());
    }
        return tiempoPendiente;
    }
    public int llamadasPendientes(){
        return colaLlamada.size();
    }
    public void atenderTodas(){
        while(!colaLlamada.empty()){
            Llamada llamada = colaLlamada.dequeue();
            int puntuacion = llamada.obtenerPuntuacion();
            tiempoTotal += llamada.getDuracion();
            puntuaciones.add(puntuacion);
            System.out.println("Cliente: "+llamada.getCliente()+"| Duracion: "+llamada.getDuracion()+"| Puntuacion: "+puntuacion);
        }
    }
    public int obtenerPromedio(){
        int suma = 0;
        if(puntuaciones.isEmpty()) return 0;
        for(int i = 0;i < puntuaciones.size(); i++){
            suma += puntuaciones.get(i);
        }
        int promedio = suma/puntuaciones.size();
        return promedio;
    }
}