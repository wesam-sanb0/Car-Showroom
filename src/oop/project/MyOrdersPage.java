/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oop.project;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author wesam
 */
public class MyOrdersPage extends javax.swing.JFrame {

    private int customerID;

    public MyOrdersPage(int customerID) {
        this.customerID = customerID;
        super("My Orders Page");
        initComponents();
        loadCustomerOrders();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(123, 103, 103));
        jPanel1.setPreferredSize(new java.awt.Dimension(869, 606));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Back\n");
        jButton1.setToolTipText("to go back to the dashboard");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("My Orders");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new CustomerPlatForm(customerID).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

private void loadCustomerOrders() {
    try (Connection conn = new personalQuery().getConnection()) {
        String sql = "SELECT * FROM OrderTable WHERE CustomerID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, customerID);
        ResultSet rs = ps.executeQuery();

        jPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
        boolean hasResults = false;
        
while (rs.next()) {
    hasResults = true;
    int orderId = rs.getInt("OrderID");
    int carId = rs.getInt("CarID");
    double totalPrice = rs.getDouble("TotalPrice");
    String status = rs.getString("Status");
    Date orderDate = rs.getDate("OrderDate");

    String imagePath = getCarImagePath(carId);
    ImageIcon imageIcon = null;
    if (imagePath != null && !imagePath.isEmpty()) {
        File imageFile = new File("src/" + imagePath);
        if (imageFile.exists()) {
            Image img = new ImageIcon(imageFile.getAbsolutePath()).getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(img);
        }
    }

    JPanel card = new JPanel();
    card.setPreferredSize(new Dimension(260, 200));
    card.setBackground(Color.WHITE);
    card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    card.setLayout(new BorderLayout());

    JLabel imgLabel = new JLabel();
    imgLabel.setPreferredSize(new Dimension(120, 90));
    if (imageIcon != null) {
        imgLabel.setIcon(imageIcon);
    } else {
        imgLabel.setText("No Image");
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    JLabel infoLabel = new JLabel("<html>Order ID: " + orderId + "<br>Car ID: " + carId
            + "<br>Status: " + status + "<br>Price: $" + totalPrice + "<br>Date: " + orderDate + "</html>");
    infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JButton invoiceButton = new JButton("View Invoice");
    invoiceButton.addActionListener(e -> {
        generateInvoice(orderId, customerID, carId, totalPrice, status, orderDate);
    });

    JButton deleteButton = new JButton("Delete Order");
    deleteButton.addActionListener(e -> {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this order?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            deleteOrder(orderId);
        }
    });

    JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    btnPanel.add(invoiceButton);
    btnPanel.add(deleteButton);

    card.add(imgLabel, BorderLayout.WEST);
    card.add(infoLabel, BorderLayout.CENTER);
    card.add(btnPanel, BorderLayout.SOUTH);

    jPanel1.add(card); 
}
        if (!hasResults) {
            JLabel noDataLabel = new JLabel("No Test Drive Requests Found");
            noDataLabel.setFont(new Font("Arial", Font.BOLD, 18));
            noDataLabel.setForeground(Color.WHITE);
            noDataLabel.setPreferredSize(new Dimension(400, 40));
            jPanel1.add(noDataLabel);
        }

        jPanel1.revalidate();
        jPanel1.repaint();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void generateInvoice(int orderId, int customerID, int carId, double totalPrice, String status, Date orderDate) {
        try {
            File dir = new File("PurchaseInvoices");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = "PurchaseInvoice_Order" + orderId + ".txt";
            File file = new File(dir, fileName);

            String content
                    = "========= PURCHASE INVOICE =========\n"
                    + "Order ID: " + orderId + "\n"
                    + "Customer ID: " + customerID + "\n"
                    + "Car ID: " + carId + "\n"
                    + "Total Price: $" + totalPrice + "\n"
                    + "Status: " + status + "\n"
                    + "Order Date: " + orderDate + "\n"
                    + "====================================\n";

            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();

            JOptionPane.showMessageDialog(this, "Invoice saved: " + file.getAbsolutePath());

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error generating invoice: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getCarImagePath(int carId) {
        try (Connection conn = new personalQuery().getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT ImagePath FROM Car WHERE CarID = ?");
            ps.setInt(1, carId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String path = rs.getString("ImagePath");
                return (path != null && !path.isEmpty()) ? path : null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
private void deleteOrder(int orderId) {
    try (Connection conn = new personalQuery().getConnection()) {
        String sql = "DELETE FROM OrderTable WHERE OrderID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderId);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Order deleted successfully.");
            this.dispose();
            new MyOrdersPage(customerID).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete the order.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(MyOrdersPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MyOrdersPage(1).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
