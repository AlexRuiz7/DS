import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Carrera extends Thread {
    /* Decalaración de atributos */
    private ArrayList<Bicicleta> bicicletas;
    double porcentage_abandono;
    private final int duracion = 6; // DEV - cambiar a 60
    Tipo tipo = null;

    
    /**
     * Constructor por defecto
     * 
     * @param bicicletas
     */
    public Carrera(ArrayList<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }
        

    /**
     * Método principal de la hebra
     * 
     */
    @Override
    public void run() {
        comenzarCarrera();

        int abandonos = (int) (bicicletas.size() * porcentage_abandono);
        
        Random rand = new Random();
        for(int i=0; i<abandonos; i++) {
            bicicletas.remove(rand.nextInt(bicicletas.size()));
        }
                
        try {
            Thread.sleep(duracion*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finalizarCarrera();
    }

    
    /**
     * 
     */
    private void comenzarCarrera() {
        System.out.println(this.toString() + "ha comenzado");
        for(Bicicleta bici : bicicletas)
            System.out.println( bici.toString() );
    }

    
    /**
     * 
     */
    private void finalizarCarrera() {
        System.out.println(this.toString() + "ha finalizado");
        for(Bicicleta bici : bicicletas)
           System.out.println( bici.toString() );
    }

    
    /**
     * To String
     * @return 
     */
    @Override
    public String toString() {
        return "Carrera de " + tipo + " ";
    }

}