package GUI;


import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Estado;
import monitorizacion.Monitor;

/**
 *
 * @author pablorobles
 */

public class Interfaz extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    private static DecimalFormat df2 = new DecimalFormat(".##");
    //Velocimetro
    private eu.hansolo.steelseries.gauges.Radial2Lcd radial2Lcd1;
    //Pantalla distancia
    private eu.hansolo.steelseries.gauges.DisplaySingle displayDistancia; 
    //Medidor combustible
    private eu.hansolo.steelseries.gauges.Radial1Square radial1Square2;
    //Pantalla combustible
    private eu.hansolo.steelseries.gauges.DisplaySingle displayCombustible; 
    
    // Labels
    private JLabel
            velocidad,
            combustible,
            vueltasDesde,
            alertaAceite, 
            alertaPastillas,
            alertaRevision,
            distancia,  
            velocidad_media,
            consumo_medio;
    
    // Panels
    private JPanel
            panel,
            panel_principal,
            panelEstados,
            panelControles,
            panelCombustible,
            subpanelCombustibleA,
            subpanelCombustibleB,
            panelVelocidad,
            subpanelVelocidadA,
            subpanelVelocidadB,
            panelMecanico,
            panelInforMec,
            infor1;
    
    // Buttons
    private JToggleButton onOff, frenar;
    private JRadioButton acelerar, parar, mantener, reiniciar;
    private JButton
            repostar, 
            vueltasAceite,
            vueltasPastillas,
            vueltasRevision,
            cambioAceite,
            cambioPastillas,
            cambioRevision;

    private ControlVelocidad controlVelocidad;
    private Monitor monitor;
    public Thread thr;
	
	
    public Interfaz(ControlVelocidad controlVelocidad, Monitor monitor) {
        
        this.setPreferredSize(new java.awt.Dimension(1200, 600));
        this.setBackground(Color.WHITE);
        this.setLayout(new java.awt.BorderLayout());
        
        //Panel BASE sobre el que se añaden el resto de componentes
        panel = new JPanel();
        panel.setPreferredSize(new java.awt.Dimension(1200, 600));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new java.awt.GridLayout(2, 2));
        add(panel);

        //Etiquetas para los datos
        velocidad = new JLabel();
        combustible = new JLabel();
        vueltasDesde = new JLabel("Vueltas desde: ");
        alertaAceite = new JLabel("Alerta aceite: CORRECTO");
        alertaPastillas = new JLabel("Alerta pastillas: CORRECTO");
        alertaRevision = new JLabel("Alerta revision: CORRECTO");
        distancia = new JLabel();
        velocidad_media = new JLabel();
        consumo_medio = new JLabel();
        
        //Boton encendido/apagado
        onOff = new JToggleButton("Encendido / Apagado", false);
        onOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOffActionPerformed(evt);
            }
        });
        
        //Boton de freno
        frenar = new JToggleButton("Frenar", false);
        frenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frenarActionPerformed(evt);
            }
        });
        
        /**
         * PALANCA DE CAMBIOS
         */
        
        //Boton acelerador
        acelerar = new JRadioButton("Acelerar", false);
        acelerar.setBackground(Color.WHITE);
        acelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acelerarActionPerformed(evt);
            }
        });
        
        //Boton parar
        parar = new JRadioButton("Parar", true);
        parar.setBackground(Color.WHITE);
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });
        
        //Boton mantener
        mantener = new JRadioButton("Mantener", false);
        mantener.setBackground(Color.WHITE);
        mantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenerActionPerformed(evt);
            }
        });
        
        //Boton reiniciar 
        reiniciar = new JRadioButton("Reiniciar", false);
        reiniciar.setBackground(Color.WHITE);
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        
        /**
         * Boton de repostaje
         * Simula recarga de gasolina
         */
        repostar = new JButton("Repostar");
        repostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostarActionPerformed(evt);
            }
        });
        
        /**
         * Boton de vueltas de aceite
         * Muestra por pantalla la información relativa a las vueltas de aceite
         */
        vueltasAceite = new JButton("Vueltas aceite");
        vueltasAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vueltasAceiteActionPerformed(evt);
            }
        });
        /**
         * Boton de vueltas de pastillas
         * Muestra por pantalla la información relativa a 
         * las vueltas de pastillas
         */
        vueltasPastillas = new JButton("Vueltas pastillas");
        vueltasPastillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vueltasPastillasActionPerformed(evt);
            }
        });
        /**
         * Boton de vueltas de revision
         * Muestra por pantalla la información relativa a 
         * las vueltas de revision
         */
        vueltasRevision = new JButton("Vueltas revision");
        vueltasRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vueltasRevisionActionPerformed(evt);
            }
        });
         /**
         * Boton de cambio de aceite
         * Simula el cambio de aceite
         */
        cambioAceite = new JButton("Cambio aceite");
        cambioAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioAceiteActionPerformed(evt);
            }
        });
         /**
         * Boton de cambio de pastillas de freno
         * Simula el cambio de pastillas de freno
         */
        cambioPastillas = new JButton("Cambio pastillas");
        cambioPastillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioPastillasActionPerformed(evt);
            }
        });
         /**
         * Boton de cambio revisión
         * Añade las vueltas de esta revision a las anteriores
         */
        cambioRevision = new JButton("Revisión");
        cambioRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioRevisionActionPerformed(evt);
            }
        });
        
        /**
         * COMPONENTES STEELSERIES
         */
        //Indicador numerico de distancia recorrida
        displayDistancia = new eu.hansolo.steelseries.gauges.DisplaySingle();
        displayDistancia.setUnitString("Km");
        //Indicador numerico de combustible
        displayCombustible = new eu.hansolo.steelseries.gauges.DisplaySingle();
        displayCombustible.setUnitString("litros");
        
        //Velocimetro
        radial2Lcd1 = new eu.hansolo.steelseries.gauges.Radial2Lcd();
        radial2Lcd1.setSize(100,100);
        radial2Lcd1.setMaxValue(150.0);
        radial2Lcd1.setValue(10.0);
        radial2Lcd1.setTitle("Velocidad");
        radial2Lcd1.setUnitString("km/h");
        radial2Lcd1.setValueTickPeriod(20);
        
        //Combustible
        radial1Square2 = new eu.hansolo.steelseries.gauges.Radial1Square();
        radial1Square2.setSize(100, 100);
        
        radial1Square2.setMaxValue(500.0);
        radial1Square2.setTickLabelPeriod(100);
        radial1Square2.setTitle("Combustible");
        radial1Square2.setUnitString("litros");
        
        
        /**
         * PANEL PRINCIPAL
         */
        panel_principal = new JPanel();
        panel_principal.setMinimumSize(new java.awt.Dimension(600, 400));
        //Layout
        panel_principal.setBorder(new TitledBorder(new EtchedBorder(), "Panel principal"));
        panel_principal.setBackground(Color.WHITE);
        
        panel.add(panel_principal);
        
        /**
         * PANEL VELOCIDAD
         */
        panelVelocidad = new JPanel();
        panelVelocidad.setBackground(Color.WHITE);
        panelVelocidad.setBorder(new TitledBorder(new EtchedBorder(), "Velocidad"));
        panelVelocidad.setLayout(new java.awt.BorderLayout());
        
        //Subpanel A para la aguja de velocidad
        subpanelVelocidadA = new JPanel();
        subpanelVelocidadA.setBackground(Color.WHITE);
        subpanelVelocidadA.add(radial2Lcd1);
        panelVelocidad.add(subpanelVelocidadA, java.awt.BorderLayout.NORTH);
        //Subpanel B para la distancia recorrida
        subpanelVelocidadB = new JPanel();
        subpanelVelocidadB.setBackground(Color.WHITE);
        subpanelVelocidadB.add(displayDistancia);
        panelVelocidad.add(subpanelVelocidadB, java.awt.BorderLayout.SOUTH);
        
        panel_principal.add(panelVelocidad);

        /**
         * PANEL COMBUSTIBLE
         * */
        panelCombustible = new JPanel();
        panelCombustible.setBackground(Color.WHITE);
        panelCombustible.setBorder(new TitledBorder(new EtchedBorder(), "Combustible"));
        panelCombustible.setLayout(new java.awt.BorderLayout());
        
        //Subpanel A para la aguja de combustible
        subpanelCombustibleA = new JPanel();
        subpanelCombustibleA.setBackground(Color.WHITE);
        subpanelCombustibleA.add(radial1Square2);
        panelCombustible.add(subpanelCombustibleA, java.awt.BorderLayout.NORTH);
        //Subpanel B para cifra de combustible y boton repostar
        subpanelCombustibleB = new JPanel();
        subpanelCombustibleB.setBackground(Color.WHITE);
        subpanelCombustibleB.add(displayCombustible);
        subpanelCombustibleB.add(repostar);
        panelCombustible.add(subpanelCombustibleB, java.awt.BorderLayout.SOUTH);
        
        panel_principal.add(panelCombustible);
        
        
        /**
         * PANEL DE CONTROLES
         */
        panelControles = new JPanel();
        panelControles.setPreferredSize(new java.awt.Dimension(800, 200));
        panelControles.setLayout(new java.awt.FlowLayout());
        panelControles.setBackground(Color.WHITE);
        panelControles.setBorder(new TitledBorder(new EtchedBorder(), "Controles"));
        //Añadimos los controles
        panelControles.add(onOff);
        panelControles.add(frenar);
        panel.add(panelControles);
        
        //Panel de palanca de cambios
        panelEstados = new JPanel();
        panelEstados.setBackground(Color.WHITE);
        panelEstados.setBorder(new TitledBorder(new EtchedBorder(), "Palanca"));

        
        //Añadimos los botones de la palanca de cambios al panel de estados
        panelEstados.add(acelerar);
        panelEstados.add(parar);
        panelEstados.add(mantener);
        panelEstados.add(reiniciar);
        
        panelControles.add(panelEstados);
        
        
        /**
         * PANEL MECANICO
         * */
        
        panelMecanico = new JPanel();
        panelMecanico.setBackground(Color.WHITE);
        panelMecanico.setLayout(new java.awt.FlowLayout());
        panelMecanico.setBorder(new TitledBorder(new EtchedBorder(), "Mecánico"));

        panel.add(panelMecanico);
        // Añadimos los botones de muestra de información
        // y los de simulación de cambio de componentes
        panelMecanico.add(vueltasAceite);
        panelMecanico.add(vueltasPastillas);
        panelMecanico.add(vueltasRevision);
        panelMecanico.add(cambioAceite);
        panelMecanico.add(cambioPastillas);
        panelMecanico.add(cambioRevision);
        
        /**
         * PANEL DE ALERTAS DE INFO MECANICO
         */
        
        panelInforMec = new JPanel();
        panelInforMec.setBackground(Color.WHITE);
        panelInforMec.setLayout(new java.awt.BorderLayout());
        panelInforMec.setBorder(new TitledBorder(new EtchedBorder(), "Informacion Mecánico"));
        
        //Subpanel de panelInforMec
        infor1 = new JPanel();
        infor1.setBackground(Color.WHITE);
        infor1.setLayout(new BoxLayout(infor1, BoxLayout.PAGE_AXIS));
        
        panel.add(panelInforMec);
        panelInforMec.add(infor1);
        infor1.add(vueltasDesde);
        infor1.add(velocidad_media);
        infor1.add(consumo_medio);
        infor1.add(alertaAceite);
        infor1.add(alertaPastillas);
        infor1.add(alertaRevision);

        this.controlVelocidad = controlVelocidad;
        this.monitor = monitor;
        thr = new Thread(this);
    }

    // Accion Boton onOff
    private void onOffActionPerformed(java.awt.event.ActionEvent evt) {
        controlVelocidad.cambiarEstadoMotor();
        if (!onOff.isSelected()) {
            parar.setSelected(true);
            acelerar.setSelected(false);
            mantener.setSelected(false);
            reiniciar.setSelected(false);
            controlVelocidad.moverPalanca(Estado.PARADO);
        }
    }

    // Accion Boton frenar
    private void frenarActionPerformed(java.awt.event.ActionEvent evt) {
        if (frenar.isSelected()) {
            if (!parar.isSelected()) parar.setSelected(true);
            acelerar.setSelected(false);
            mantener.setSelected(false);
            reiniciar.setSelected(false);
            controlVelocidad.cambiarEstadoFreno();
            controlVelocidad.moverPalanca(Estado.PARADO);
        } else {
            controlVelocidad.cambiarEstadoFreno();
        }
    }

    // Accion Boton acelerar
    private void acelerarActionPerformed(java.awt.event.ActionEvent evt) {
        if (acelerar.isSelected()) {
            parar.setSelected(false);
            mantener.setSelected(false);
            reiniciar.setSelected(false);
            if (frenar.isSelected()) {
                frenar.setSelected(false);
                controlVelocidad.cambiarEstadoFreno();
            }
            controlVelocidad.moverPalanca(Estado.ACELERANDO);
        } else if (!parar.isSelected() && !mantener.isSelected() && !reiniciar.isSelected()) {
            acelerar.setSelected(true);
        }
    }

    // Accion Boton parar
    private void pararActionPerformed(java.awt.event.ActionEvent evt) {
        if (parar.isSelected()) {
            acelerar.setSelected(false);
            mantener.setSelected(false);
            reiniciar.setSelected(false);
            controlVelocidad.moverPalanca(Estado.PARADO);
        } else if (!acelerar.isSelected() && !mantener.isSelected() && !reiniciar.isSelected()) {
            parar.setSelected(true);
        }
    }

    // Accion Boton mantener
    private void mantenerActionPerformed(java.awt.event.ActionEvent evt) {
        if (mantener.isSelected()) {
            acelerar.setSelected(false);
            parar.setSelected(false);
            reiniciar.setSelected(false);
            if (frenar.isSelected()) {
                frenar.setSelected(false);
                controlVelocidad.cambiarEstadoFreno();
            }
            controlVelocidad.moverPalanca(Estado.MANTENIENDO);
        } else if (!acelerar.isSelected() && !parar.isSelected() && !reiniciar.isSelected()) {
            mantener.setSelected(true);
        }
    }

    // Accion Boton reiniciar
    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {
        if (reiniciar.isSelected()) {
            acelerar.setSelected(false);
            parar.setSelected(false);
            mantener.setSelected(false);
            if (frenar.isSelected()) {
                frenar.setSelected(false);
                controlVelocidad.cambiarEstadoFreno();
            }
            controlVelocidad.moverPalanca(Estado.REINICIANDO);
        } else if (!acelerar.isSelected() && !parar.isSelected() && !mantener.isSelected()) {
            reiniciar.setSelected(true);
        }
    }

    // Accion Boton repostar
    private void repostarActionPerformed(java.awt.event.ActionEvent evt) {
        monitor.repostar();
    }

    // Accion Boton vueltasAceite
    private void vueltasAceiteActionPerformed(java.awt.event.ActionEvent evt) {
        vueltasDesde.setText(
            "Vueltas desde el oltimo cambio de aceite: "
            + String.valueOf((int) monitor.getVueltasAceite())
        );
    }

    // Accion Boton vueltasPastillas
    private void vueltasPastillasActionPerformed(java.awt.event.ActionEvent evt) {
        vueltasDesde.setText(
            "Vueltas desde el último cambio de pastillas: " 
            + String.valueOf((int) monitor.getVueltasPastillas())
        );
    }

    // Accion Boton vueltasRevision
    private void vueltasRevisionActionPerformed(java.awt.event.ActionEvent evt) {
        vueltasDesde.setText(
            "Vueltas desde la última revision: " 
            + String.valueOf((int) monitor.getVueltasRevision())
        );
    }

    // Accion Boton cambioAceite
    private void cambioAceiteActionPerformed(java.awt.event.ActionEvent evt) {
        monitor.cambioAceite();
    }

    // Accion Boton cambioPastillas
    private void cambioPastillasActionPerformed(java.awt.event.ActionEvent evt) {
        monitor.cambioPastillas();
    }

    // Accion Boton cambioRevision
    private void cambioRevisionActionPerformed(java.awt.event.ActionEvent evt) {
        monitor.cambioRevision();
    }



    public void run() {
        while (true) {
            velocidad.setText("Velocidad: " + String.valueOf((int) controlVelocidad.getVelocidad()) + " km/h");
            //Manillas Velocimetro
            radial2Lcd1.setValue(controlVelocidad.getVelocidad());
            //Display km recorridos
            this.displayDistancia.setValue(controlVelocidad.getDistancia());
            combustible.setText("Combustible: " + df2.format(monitor.getNivelDeposito()));
            //Manillas combustible
            this.radial1Square2.setValue(monitor.getNivelDeposito());
            //Display litros combustible
            this.displayCombustible.setValue(monitor.getNivelDeposito());
            
            distancia.setText("Distancia recorrida: " + df2.format(controlVelocidad.getDistancia()) + " m");
            velocidad_media.setText("Velocidad media: " + monitor.getVelocidadMedia());
            consumo_medio.setText("Consumo medio: " + df2.format(monitor.getConsumoMedio()));


            if(monitor.notificarAceite()) {
                alertaAceite.setText("Alerta: Es necesario un cambio de aceite.");
                alertaAceite.setForeground(Color.RED);
            } else {
                alertaAceite.setText("Alerta aceite: CORRECTO");
                alertaAceite.setForeground(Color.BLACK);
            }	

            if (monitor.notificarPastillas()) {
                alertaPastillas.setText("Alerta: Es necesario un cambio de pastillas.");
                alertaPastillas.setForeground(Color.RED);
            } else {
                alertaPastillas.setText("Alerta pastillas: CORRECTO");
                alertaPastillas.setForeground(Color.BLACK);
            }

            if (monitor.notificarRevision()) {
                alertaRevision.setText("Alerta: Es necesario realizar una revision.");
                alertaRevision.setForeground(Color.RED);
            } else {
                alertaRevision.setText("Alerta revision: CORRECTO");
                alertaRevision.setForeground(Color.BLACK);
            }

            if (controlVelocidad.getVelocidad() == 0 && !controlVelocidad.getEstadoMotor()) {
                repostar.setEnabled(true);
                cambioAceite.setEnabled(true);
                cambioPastillas.setEnabled(true);
                cambioRevision.setEnabled(true);
            } else {
                repostar.setEnabled(false);
                cambioAceite.setEnabled(false);
                cambioPastillas.setEnabled(false);
                cambioRevision.setEnabled(false);
            }

            if(monitor.getNivelDeposito() <= 0) {
                controlVelocidad.moverPalanca(Estado.PARADO);
                acelerar.setEnabled(false);
                parar.setEnabled(true);
            }
        }
	
    }
	
}
