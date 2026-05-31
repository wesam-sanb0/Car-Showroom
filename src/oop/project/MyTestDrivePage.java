/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oop.project;

/**
 *
 * @author Shoaaa
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Formatter;

public class MyTestDrivePage extends javax.swing.JFrame {

    private int customerID;
    private personalQuery pq = new personalQuery(); 

    public MyTestDrivePage(int customerID) {
        this.customerID = customerID;
        super("My Test Drive Page");
        initComponents();
        loadTestDriveRequests();
    }



private void loadTestDriveRequests() {
    try (Connection conn = pq.getConnection()) {
        String query = "SELECT * FROM TestDrive WHERE CustomerID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, customerID);
        ResultSet rs = ps.executeQuery();

        jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        boolean hasResults = false;

while (rs.next()) {
    hasResults = true;

    int id = rs.getInt("TestDriveID");
    int carId = rs.getInt("CarID");
    Date date = rs.getDate("Date");
    Time time = rs.getTime("Time");

    String imagePath = getCarImagePath(carId);
    JLabel imageLabel;
    File imgFile = new File(imagePath);
    if (imagePath != null && !imagePath.isEmpty() && imgFile.exists()) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(img));
    } else {
        imageLabel = new JLabel("No Image Available", SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(150, 120));
    }
    imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel infoLabel = new JLabel("<html><center>Test Drive ID: " + id +
            "<br/>Car ID: " + carId +
            "<br/>Date: " + date +
            "<br/>Time: " + time +
            "</center></html>", SwingConstants.CENTER);

    JButton invoiceBtn = new JButton("View Invoice");
    invoiceBtn.addActionListener(e -> generateInvoice(id, customerID, carId, date, time));

    JButton deleteBtn = new JButton("Delete");
    deleteBtn.addActionListener(e -> {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this request?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            deleteTestDriveRequest(id);
        }
    });

    JPanel btnPanel = new JPanel(new FlowLayout());
    btnPanel.add(invoiceBtn);
    btnPanel.add(deleteBtn);

    JPanel card = new JPanel(new BorderLayout(5, 5));
    card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    card.setPreferredSize(new Dimension(240, 300));
    card.add(imageLabel, BorderLayout.NORTH);
    card.add(infoLabel, BorderLayout.CENTER);
    card.add(btnPanel, BorderLayout.SOUTH);

    jPanel3.add(card);
}


        if (!hasResults) {
            JLabel noDataLabel = new JLabel("No Test Drive Requests Found");
            noDataLabel.setFont(new Font("Arial", Font.BOLD, 18));
            noDataLabel.setForeground(Color.WHITE);
            noDataLabel.setPreferredSize(new Dimension(400, 40));
            jPanel3.add(noDataLabel);
        }

        jPanel3.revalidate();
        jPanel3.repaint();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void generateInvoice(int testDriveId, int customerId, int carId, Date date, Time time) {
    try {
        File dir = new File("TestDriveInvoices");
        if (!dir.exists()) dir.mkdirs();

        String fileName = "TestDriveInvoice_" + testDriveId + ".txt";
        File file = new File(dir, fileName);

        FileWriter writer = new FileWriter(file);
        try (Formatter formatter = new Formatter(writer)) {
            formatter.format("====== TEST DRIVE INVOICE ======%n");
            formatter.format("Test Drive ID: %d%n", testDriveId);
            formatter.format("Customer ID: %d%n", customerId);
            formatter.format("Car ID: %d%n", carId);
            formatter.format("Date: %s%n", date.toString());
            formatter.format("Time: %s%n", time.toString());
            formatter.format("===============================%n");
        } 

        JOptionPane.showMessageDialog(this,
            "Invoice has been generated and sent to you.\nSaved at:\n" + file.getAbsolutePath(),
            "Invoice Sent",
            JOptionPane.INFORMATION_MESSAGE);

    } catch (HeadlessException | IOException e) {
        JOptionPane.showMessageDialog(this, "Error writing invoice: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private String getCarImagePath(int carId) {
    try (Connection conn = pq.getConnection()) {
        String query = "SELECT ImagePath FROM Car WHERE CarID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, carId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String path = rs.getString("ImagePath");
            return (path != null && !path.isEmpty()) ? "src/" + path : null;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(123, 103, 103));
        jPanel2.setPreferredSize(new java.awt.Dimension(869, 606));

        jPanel3.setBackground(new java.awt.Color(123, 103, 103));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setToolTipText("to go back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("My Test Drive");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                        
    dispose(); 
    new CustomerPlatForm(customerID).setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteTestDriveRequest(int testDriveId) {
    try (Connection conn = pq.getConnection()) {
        String query = "DELETE FROM TestDrive WHERE TestDriveID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, testDriveId);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Test drive request deleted.");
            this.dispose();
            new MyTestDrivePage(customerID).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete the test drive request.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyTestDrivePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MyTestDrivePage(1).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


}
