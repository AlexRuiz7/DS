package GUI;

import java.util.Observable;

/**
 *
 * @author pablorobles
 */
public class CuentaRevolucionesSteelSeries extends ObservadorMotor {

    
    public CuentaRevolucionesSteelSeries() {
        initComponents();
    }

    
    @Override
    public void update(Observable o, Object arg) {        
        //etiqueta_rpm.setText( String.format("%d", miObservable.getRPM()) );
        this.displayRPM.setValue(miObservable.getRPM());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayRPM = new eu.hansolo.steelseries.gauges.DisplaySingle();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cuentarrevoluciones"));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        displayRPM.setUnitString("RPM");
        add(displayRPM);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private eu.hansolo.steelseries.gauges.DisplaySingle displayRPM;
    // End of variables declaration//GEN-END:variables
}
