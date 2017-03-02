
/**
 * Write a description of class Acceso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Acceso
{
    // instance variables - replace the example below with your own

    private int anno;
    
    private int mes;
    
    private int dia;
    
    private int hora;
    
    private int minutos;
    
    /**
     * Constructor for objects of class Acceso
     */
    public Acceso(int anno, int mes, int dia, int hora, int minutos)
    {
        // initialise instance variables
        this.anno = anno;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }
    
    public int getHoraDeAcceso()
    {
        int horaDeAcceso = hora;
        //String horaDeAcceso = "Se ha conectado el " + dia + "/" + mes + "/" + anno +" a las " + hora + ":" + minutos;
        return horaDeAcceso;
    }
    
}








