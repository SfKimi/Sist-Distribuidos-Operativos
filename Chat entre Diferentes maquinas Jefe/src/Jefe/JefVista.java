package Jefe;
import java.util.Observer;
import javax.swing.UIManager;
import java.util.Observable;
public class JefVista extends javax.swing.JFrame implements Observer {
    public JefVista() {
        initComponents();
        //se establece como default el boton deenviar reporte
        this.getRootPane().setDefaultButton(this.BotonReportar);
        //se invoca la clase servior creando un objeto y pasandole un puerto al constructor de servidor
        JefServidor Serv = new JefServidor(5000);
        //al objeto servidor se le agrega un observador
        Serv.addObserver(this);
        //se crea un theard el cual se le pasa como parametro de constructor el objeto servidor
        Thread thre = new Thread(Serv);
        //se inicializa el theard
        thre.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CuadroChat = new javax.swing.JTextArea();
        BotonReportar = new javax.swing.JButton();
        CuadroEnvio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHAT - Jefe de Planta");
        setBackground(new java.awt.Color(51, 153, 255));

        CuadroChat.setBackground(new java.awt.Color(255, 204, 255));
        CuadroChat.setColumns(20);
        CuadroChat.setRows(5);
        jScrollPane1.setViewportView(CuadroChat);

        BotonReportar.setBackground(new java.awt.Color(204, 204, 255));
        BotonReportar.setFont(new java.awt.Font("Tempus Sans ITC", 2, 18)); // NOI18N
        BotonReportar.setText("Reportar");
        BotonReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReportarActionPerformed(evt);
            }
        });

        CuadroEnvio.setBackground(new java.awt.Color(153, 255, 255));
        CuadroEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuadroEnvioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CuadroEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonReportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(BotonReportar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CuadroEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReportarActionPerformed
        // se define el string a obtener del campo de escritura del empleado  por medi de get       
        String nota = "Jefe Dice--> " + this.CuadroEnvio.getText() +  "\n";
        //se escribe  el string en el  campo detexto del chap por medio de append
        this.CuadroChat.append(nota);
        // se hace conexion y se envia el mensaje del empleado por medio dell constructor de la case cliente en su para metro string
        // tambien hay que dar el puerto y direccion ipv4 de la computadora jefe
        JefCliente clien = new JefCliente(5000,"192.168.12.55", nota); // se crea un objeto de la clase empleado cliente
        Thread threa = new Thread(clien);// se crea un thread pasandole como parametro en su constructor el Empleadocliente creado
        threa.start();// se inicializa el thread
    }//GEN-LAST:event_BotonReportarActionPerformed

    private void CuadroEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuadroEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuadroEnvioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JefVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JefVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JefVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JefVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JefVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonReportar;
    private javax.swing.JTextArea CuadroChat;
    private javax.swing.JTextField CuadroEnvio;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable obs, Object arget) {
        this.CuadroChat.append((String) arget);
    }
}
