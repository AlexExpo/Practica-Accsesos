import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * Write a description of class AnalizadorAccesosAServidor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnalizadorAccesosAServidor
{
    // instance variables - replace the example below with your own
    
    private  ArrayList<Acceso> horasDeAcceso;
    
    /**
     * Constructor for objects of class AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor()
    {
        // initialise instance variables
        horasDeAcceso = new ArrayList<Acceso>();
    }

    public void analizarArchivoDeLog(String archivoALeer)
    {
        try {
            File archivo = new File(archivoALeer + ".log");
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String datosDeAcceso = sc.nextLine();
                System.out.println(datosDeAcceso);
                String horaDeAcceso[] = datosDeAcceso.split(" ");
                Acceso accesoActual = new Acceso(Integer.parseInt(horaDeAcceso[0]), Integer.parseInt(horaDeAcceso[1])
                                                  , Integer.parseInt(horaDeAcceso[2]), Integer.parseInt(horaDeAcceso[3])
                                                  , Integer.parseInt(horaDeAcceso[4]));
                horasDeAcceso.add(accesoActual);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerHoraMasAccesos()
    {
        int horaDeMasAcceso = -1;
        int coincidencias = 0;
        boolean buscando = true;
        while (horasDeAcceso.size() != 0 && buscando) {
            for (Acceso acceso : horasDeAcceso) {
                int contadorDeCoincidencias = 0;
                for (Acceso accesoAComparar : horasDeAcceso) {
                    if (acceso.getHoraDeAcceso() ==  accesoAComparar.getHoraDeAcceso()) {
                        contadorDeCoincidencias++;
                    }
                    if (contadorDeCoincidencias >= coincidencias) {
                        coincidencias = contadorDeCoincidencias;
                        if (contadorDeCoincidencias == coincidencias) {
                            if (acceso.getHoraDeAcceso() > horaDeMasAcceso) {
                                horaDeMasAcceso = acceso.getHoraDeAcceso();
                            }
                        }
                        else {
                            horaDeMasAcceso = acceso.getHoraDeAcceso();
                        }
                    }
                }
            }
            buscando = false;
        }
        return horaDeMasAcceso;
    }
}





