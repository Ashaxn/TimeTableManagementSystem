/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import timetablemanagementsystem.dbConnect;
import timetablemanagementsystem.UHome;

/**
 *
 * @author umesha
 */
public class UGenerateTimeSlots extends javax.swing.JFrame {

    /**
     * Creates new form UGenerateTimeSlots
     */
    
    private TimeSlotModel timeSlotModel;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private int time_id;
            
    public UGenerateTimeSlots() {
        dbconnection();
        initComponents();
        initTImeSolts();
        btn_GenerateTimeSlots.setBackground(new java.awt.Color(8,142,88));
        initTable();
    }

      private void dbconnection() {
        String currentDir = System.getProperty("user.dir");
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String JDBC_URL = "jdbc:derby:"+currentDir+"\\TTMS";
       
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException ex) {
           
          Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        
        Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
       }  
         
    }
    
    public void initTImeSolts() {
        this.timeSolts.addItem("08.30 - 9.30");
        this.timeSolts.addItem("9.30  - 10.30");
        this.timeSolts.addItem("10.30 - 11.30");
        this.timeSolts.addItem("11.30-12.00        Break");
        this.timeSolts.addItem("12.00  - 1.00");
        this.timeSolts.addItem("1.00   -  2.00");
        this.timeSolts.addItem("3.00   -  4.00");
        this.timeSolts.addItem("4.00   -  5.00");
    }
    
    public ArrayList getTimeTableVal() {
        
        ArrayList<TimeSlotModel> timeTableSlots = new ArrayList<>();
        
        String query = "select * from timeslots";
        
        try {
           statement = connection.createStatement();
           ResultSet res = statement.executeQuery(query);
            
            while(res.next()) {
                timeSlotModel = new TimeSlotModel(res.getInt("slotid"),res.getString("slot"));
                timeTableSlots.add(timeSlotModel);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UGenerateTimeSlots.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timeTableSlots;
    }
    
    public void initTable() {
        ArrayList<TimeSlotModel> list = getTimeTableVal();
        DefaultTableModel table_model = (DefaultTableModel) display_table.getModel();
        table_model.setRowCount(0);
        Object[] row = new Object[2];
        
        for(int i = 0;i<list.size();i++) {
            row[0] = list.get(i).getSlotid();
            row[1] = list.get(i).getSlot();
             table_model.addRow(row);
        }
        
    }
  
    public void addTImeSlot() {
        
        String slotVal = this.timeSolts.getSelectedItem().toString();
        
        String query = "insert into timeslots(slot) values(?)";
        
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, slotVal);
            preparedStatement.execute();
            
            DefaultTableModel model = (DefaultTableModel) display_table.getModel();
            model.setRowCount(0);
            initTable();
            
            JOptionPane.showMessageDialog(null, "Time Slot Added Successfully. \n Thank You!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
            Logger.getLogger(UGenerateTimeSlots.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteSlot() {
        
        String query = "delete from timeslots where slotid=?";
        
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, time_id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Time Slot Deleted Successfully. \n Thank You!");
            
            DefaultTableModel model = (DefaultTableModel) display_table.getModel();
            model.setRowCount(0);
            initTable();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
            Logger.getLogger(UGenerateTimeSlots.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void refreshSlots() {
        
        String query = "delete from timeslots";
        
        try {
            preparedStatement = connection.prepareCall(query);
            preparedStatement.execute();
            
            JOptionPane.showMessageDialog(null, "Refresh Time Slots Successfully. \n Thank You!");
            
            DefaultTableModel model = (DefaultTableModel) display_table.getModel();
            model.setRowCount(0);
            initTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
            Logger.getLogger(UGenerateTimeSlots.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background_pnl = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        btn_GenerateTimeSlots = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        GenerateTimeSlots_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_GenerateTimeSlots = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        timeSolts = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display_table = new javax.swing.JTable();
        JPanel7 = new javax.swing.JPanel();
        GenarateTimeSlots_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_GenerateTimeSlots.setBackground(new java.awt.Color(39, 156, 109));
        btn_GenerateTimeSlots.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_GenerateTimeSlots.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GenerateTimeSlotsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_GenerateTimeSlotsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_GenerateTimeSlotsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_GenerateTimeSlotsMousePressed(evt);
            }
        });
        btn_GenerateTimeSlots.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/Add_Icon.png"))); // NOI18N
        btn_GenerateTimeSlots.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Generate Time Slot");
        btn_GenerateTimeSlots.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 140, -1));

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_GenerateTimeSlots.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_GenerateTimeSlots, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        GenerateTimeSlots_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GenerateTimeSlots_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        GenerateTimeSlots_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        GenerateTimeSlots_backBtn.setText("BACK");
        GenerateTimeSlots_backBtn.setToolTipText("Returns  to a previously shown window ");
        GenerateTimeSlots_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GenerateTimeSlots_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        GenerateTimeSlots_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateTimeSlots_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(GenerateTimeSlots_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_GenerateTimeSlots.setBackground(new java.awt.Color(247, 247, 247));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Select Time :");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        jButton1.setText("DELETE");
        jButton1.setToolTipText("Click The Delete Button To Delete The Details");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        jButton2.setText("GENERATE");
        jButton2.setToolTipText("Generate Time Slots");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn hover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        timeSolts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time" }));
        timeSolts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeSoltsActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        jButton4.setText("REFRESH");
        jButton4.setToolTipText("Click The Refresh Button To Refresh The Detailes");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn hover.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Solt ID", "Time Slot", "Monday", "Tusday", "WednesDay", "Thrusday", "Friday", "SaterDay", "Sunday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(display_table);
        if (display_table.getColumnModel().getColumnCount() > 0) {
            display_table.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jp_GenerateTimeSlotsLayout = new javax.swing.GroupLayout(jp_GenerateTimeSlots);
        jp_GenerateTimeSlots.setLayout(jp_GenerateTimeSlotsLayout);
        jp_GenerateTimeSlotsLayout.setHorizontalGroup(
            jp_GenerateTimeSlotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_GenerateTimeSlotsLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jp_GenerateTimeSlotsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jp_GenerateTimeSlotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_GenerateTimeSlotsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jp_GenerateTimeSlotsLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeSolts, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        jp_GenerateTimeSlotsLayout.setVerticalGroup(
            jp_GenerateTimeSlotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_GenerateTimeSlotsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jp_GenerateTimeSlotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeSolts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jp_GenerateTimeSlotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jPanel6.add(jp_GenerateTimeSlots, "card2");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new java.awt.CardLayout());

        GenarateTimeSlots_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GENERATE TIME SLOTS");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.setToolTipText("Logout From The System");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GenarateTimeSlots_TopBarLayout = new javax.swing.GroupLayout(GenarateTimeSlots_TopBar);
        GenarateTimeSlots_TopBar.setLayout(GenarateTimeSlots_TopBarLayout);
        GenarateTimeSlots_TopBarLayout.setHorizontalGroup(
            GenarateTimeSlots_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenarateTimeSlots_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        GenarateTimeSlots_TopBarLayout.setVerticalGroup(
            GenarateTimeSlots_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenarateTimeSlots_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(GenarateTimeSlots_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(GenarateTimeSlots_TopBar, "card2");

        javax.swing.GroupLayout Background_pnlLayout = new javax.swing.GroupLayout(Background_pnl);
        Background_pnl.setLayout(Background_pnlLayout);
        Background_pnlLayout.setHorizontalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Background_pnlLayout.setVerticalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(JPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GenerateTimeSlotsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GenerateTimeSlotsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_GenerateTimeSlotsMouseClicked

    private void btn_GenerateTimeSlotsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GenerateTimeSlotsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_GenerateTimeSlotsMouseEntered

    private void btn_GenerateTimeSlotsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GenerateTimeSlotsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_GenerateTimeSlotsMouseExited

    private void btn_GenerateTimeSlotsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GenerateTimeSlotsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_GenerateTimeSlotsMousePressed

    private void GenerateTimeSlots_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateTimeSlots_backBtnActionPerformed
        // TODO add your handling code here:
            new UHome().setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_GenerateTimeSlots_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        deleteSlot();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        addTImeSlot();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        refreshSlots();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void timeSoltsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeSoltsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeSoltsActionPerformed

    private void display_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_tableMouseClicked
        // TODO add your handling code here:
        
        int i = display_table.getSelectedRow();
        
        TableModel model = display_table.getModel();
        
        time_id = (int) model.getValueAt(i, 0);
        
    }//GEN-LAST:event_display_tableMouseClicked

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
            java.util.logging.Logger.getLogger(UGenerateTimeSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UGenerateTimeSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UGenerateTimeSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UGenerateTimeSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UGenerateTimeSlots().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel GenarateTimeSlots_TopBar;
    private javax.swing.JButton GenerateTimeSlots_backBtn;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel btn_GenerateTimeSlots;
    private javax.swing.JTable display_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_GenerateTimeSlots;
    private javax.swing.JComboBox<String> timeSolts;
    // End of variables declaration//GEN-END:variables
}
