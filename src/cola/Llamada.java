package cola;
public class Llamada {
    private int id;
    private String cliente;
    public enum Tipo{normal, prioritaria};
    private Tipo tipo;
    private double duracion;
    
    public Llamada(int id, String cliente, Tipo tipo, double duracion){
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.duracion = duracion;
    }
    public String getCliente(){
        return cliente;
    }
    
    public Tipo getTipo(){
        return tipo;
    }
    
    public double getDuracion(){
        return duracion;
    }
    
    public int obtenerPuntuacion(){
        int Aleatorio = (int) (1+(9*(Math.random())));
        return Aleatorio;
    }
    @Override
    public String toString(){
        String s = "Nombre cliente: "+cliente+"| Duracion: "+duracion+"\n";
        return s;
    }
}