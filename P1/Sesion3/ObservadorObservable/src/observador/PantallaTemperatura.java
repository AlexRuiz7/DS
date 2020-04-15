package observador;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import observable.Temperatura;

/**
 *
 * @author alex
 */
public class PantallaTemperatura extends ObservadorTemperatura implements Runnable {
    
    public Thread hebra;
    
    /**
     * Constructor
     * @param t 
     */
    public PantallaTemperatura(Temperatura t) {
        super(t);
        initComponents();
        hebra = new Thread(this, "Pantalla temp.");
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                update(miObservable, null);
                Thread.sleep(3001);
            } catch (InterruptedException ex) {
                Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "PantallaTemperatura: " + miTemperatura;
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        this.etiqueta_temp.setText(this.miTemperatura+"ºC");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etiqueta_temp = new javax.swing.JLabel();

        jLabel1.setText("Temperatura en Granada:");
        add(jLabel1);

        etiqueta_temp.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_temp.setText("--.--ºC");
        etiqueta_temp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiqueta_temp.setOpaque(true);
        etiqueta_temp.setPreferredSize(new java.awt.Dimension(100, 20));
        add(etiqueta_temp);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiqueta_temp;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}