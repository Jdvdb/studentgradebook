/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgradebook;

/**
 *
 * @author rajan
 */
public class GradebookFrame extends javax.swing.JFrame {

    final String[] quotes;
    
    /**
     * Creates new form GradebookFrame
     */
    public GradebookFrame() {
        this.quotes = new String[]{"\"Don't let what you cannot do interfere with what you can do.\" -John Wooden", "\"Successful and unsuccessful people do not vary greatly in their abilities. They vary in their desires to reach their potential.\" -John Maxwell", "\"Strive for progress, not perfection.\" -Unknown", "\"There are no shortcuts to any place worth going.\" -Beverly Sills", "\"Failure is the opportunity to begin again more intelligently.\" -Henry Ford", "\"Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time.\" -Thomas A. Edison", "\"You've got to get up every morning with determination if you're going to go to bed with satisfaction.\" �George Lorimer", "\"Start where you are. Use what you have. Do what you can.\" -Arthur Ashe", "\"The secret of success is to do the common things uncommonly well.\" -John D. Rockefeller", "\"Don't wish it were easier; wish you were better.\" -Jim Rohn"};
        initComponents();
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
        classButton = new javax.swing.JButton();
        scheduleButton = new javax.swing.JButton();
        performanceButton = new javax.swing.JButton();
        quoteLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Gradebook");

        classButton.setText("View Classes");
        classButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classButtonMouseClicked(evt);
            }
        });

        scheduleButton.setText("View Schedule");
        scheduleButton.setMaximumSize(new java.awt.Dimension(121, 23));
        scheduleButton.setMinimumSize(new java.awt.Dimension(121, 23));
        scheduleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleButtonMouseClicked(evt);
            }
        });
        scheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleButtonActionPerformed(evt);
            }
        });

        performanceButton.setText("View Performance");
        performanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performanceButtonMouseClicked(evt);
            }
        });

        quoteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quoteLabel.setText(quotes[(int)Math.floor(Math.random()*quotes.length)]);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quoteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(classButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(performanceButton)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classButton)
                    .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(performanceButton))
                .addGap(18, 18, 18)
                .addComponent(quoteLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classButtonMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_classButtonMouseClicked

    private void scheduleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleButtonMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_scheduleButtonMouseClicked

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void performanceButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_performanceButtonMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_performanceButtonMouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GradebookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradebookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradebookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradebookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradebookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton classButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JButton performanceButton;
    private javax.swing.JLabel quoteLabel;
    public javax.swing.JButton scheduleButton;
    // End of variables declaration//GEN-END:variables
}
