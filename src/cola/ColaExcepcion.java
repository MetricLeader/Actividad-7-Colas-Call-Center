package cola;
public class ColaExcepcion extends RuntimeException {
    public ColaExcepcion(){
        super();
    }
    public ColaExcepcion(String msg){
        super(msg);
    }
}
