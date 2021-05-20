/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;
import java.awt.Color;
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
import javax.swing.RowFilter;
import javax.swing.ComboBoxEditor;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static jdk.nashorn.internal.runtime.JSType.isNumber;
/**
 *
 * @author user
 */
public class GenerateTimeTable extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String Hnon_rowSelected;
    private String Hmanagerow_rowSelected;
    private String session_id, session_name;
    private String lecturer_1,lecturer_2, lecturer_3;
    private String subject_code,subject_name;
    private String group_id,tag;
    private String student_count, duration;
    private String assign_id ,timeslot ,day;
    
    
    /**
     * Creates new form GenerateTimeTable
     */
    public GenerateTimeTable() {
        initComponents();
        dbconnect();
        generatetimetble();
        btn_addNon.setBackground(new java.awt.Color(8,142,88));
    }

    private void dbconnect(){
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String JDBC_URL = "jdbc:derby:C:/Derby/TTMS;create=true";
        
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
     }
    
    public ArrayList<UAssignTimeModel> AssignTimeList() {
        
        ArrayList<UAssignTimeModel> NonList = new ArrayList<>();
        try {
            String query = "SELECT * FROM ASSIGNTIME ORDER BY timeslot";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            UAssignTimeModel uAssignTimeModel ;
            
            while(rs.next()){
                uAssignTimeModel = new UAssignTimeModel (rs.getInt("assigntime_id"), rs.getInt("session_id"), rs.getString("session_name"), rs.getString("lecturer_1"), rs.getString("lecturer_2"), rs.getString("lecturer_3"), rs.getString("subject_code"), rs.getString("subject_name"), rs.getString("group_id"), rs.getString("tag"),rs.getInt("student_count"),rs.getString("duration"), rs.getString("timeslot"), rs.getString("days"));
                NonList.add(uAssignTimeModel);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in NonLists method");
            Logger.getLogger(HParallel.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return NonList;
    }
    
    
    public void generatetimetble(){
         ArrayList<UAssignTimeModel> AssignTimeList = AssignTimeList();
        DefaultTableModel tableModel = (DefaultTableModel) display_generatetable.getModel();
         
         

         Object[] row = new Object[15];
          for (int i = 0; i < AssignTimeList.size(); i++) {

             row[0] = AssignTimeList.get(i).gettimeslot(); 
          
             String dayselect = AssignTimeList.get(i).getday();
             String lecture = AssignTimeList.get(i).getlecturer_1();
             String subcode = AssignTimeList.get(i).getsubject_code();
             String tag = AssignTimeList.get(i).gettag();
             String def ="--";
             String rowdetails = ""+lecture+" , "+ subcode+" , "+tag +" " ;
           
              
              
             if (dayselect.equals("MONDAY")){
              
              
              row[1] = rowdetails;
              
             }
             else if(dayselect.equals("TUESDAY")){
             
             row[2] = rowdetails;
             
             }
             
             else if(dayselect.equals("WEDNESDAY")){
             
             row[3] = rowdetails;
             
             }
             
             
             else if(dayselect.equals("THURSDAY")){
             
             row[4] = rowdetails;
             
             }
             
             
             else if(dayselect.equals("FRIDAY")){
             
             row[1] = def;
             row[5] = rowdetails;
             
             }
             
             else if(dayselect.equals("SATURDAY")){
             
             row[6] =rowdetails;
             
             }
             
             else if(dayselect.equals("SUNDAY")){
             
             row[7] = rowdetails;
             
             }
 
              tableModel.addRow(row);
              
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
        btn_addNon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addNon_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addTags = new javax.swing.JPanel();
        btn_viewnon = new javax.swing.JButton();
        btn_nonadd = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        display_generatetable = new javax.swing.JTable();
        JPanel7 = new javax.swing.JPanel();
        addTags_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageTags_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addNon.setBackground(new java.awt.Color(39, 156, 109));
        btn_addNon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addNonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addNonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addNonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addNonMousePressed(evt);
            }
        });
        btn_addNon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/Add_Icon.png"))); // NOI18N
        btn_addNon.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Non Overlap");
        btn_addNon.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 150, -1));

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

        btn_addNon.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addNon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addNon_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addNon_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addNon_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        addNon_backBtn.setText("BACK");
        addNon_backBtn.setToolTipText("Return To Dashboard");
        addNon_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addNon_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        addNon_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNon_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addNon_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addTags.setBackground(new java.awt.Color(247, 247, 247));

        btn_viewnon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_viewnon.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewnon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        btn_viewnon.setText("VIEW");
        btn_viewnon.setToolTipText("Clear All Fields");
        btn_viewnon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_viewnon.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        btn_viewnon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_viewnonMouseClicked(evt);
            }
        });
        btn_viewnon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewnonActionPerformed(evt);
            }
        });

        btn_nonadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_nonadd.setForeground(new java.awt.Color(255, 255, 255));
        btn_nonadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/add btn.png"))); // NOI18N
        btn_nonadd.setText("ADD");
        btn_nonadd.setToolTipText("Add record to Database");
        btn_nonadd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nonadd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/add btn hover.png"))); // NOI18N
        btn_nonadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nonaddActionPerformed(evt);
            }
        });

        jLabel11.setText("SELECT SESSION");

        display_generatetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TIME SLOTS", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_generatetable.getTableHeader().setReorderingAllowed(false);
        display_generatetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_generatetableMouseClicked(evt);
            }
        });
        display_generatetable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                display_generatetablePropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(display_generatetable);

        javax.swing.GroupLayout jp_addTagsLayout = new javax.swing.GroupLayout(jp_addTags);
        jp_addTags.setLayout(jp_addTagsLayout);
        jp_addTagsLayout.setHorizontalGroup(
            jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addTagsLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jp_addTagsLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btn_nonadd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btn_viewnon, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(158, 158, 158))
            .addGroup(jp_addTagsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jp_addTagsLayout.setVerticalGroup(
            jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addTagsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nonadd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewnon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel6.add(jp_addTags, "card2");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addTags_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD NON OVERLAPPING SESSION");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.setToolTipText("Logout from system");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addTags_TopBarLayout = new javax.swing.GroupLayout(addTags_TopBar);
        addTags_TopBar.setLayout(addTags_TopBarLayout);
        addTags_TopBarLayout.setHorizontalGroup(
            addTags_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTags_TopBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addTags_TopBarLayout.setVerticalGroup(
            addTags_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTags_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addTags_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(addTags_TopBar);

        manageTags_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE NON OVERLAP");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        jButton5.setText("LOGOUT");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageTags_TopbarLayout = new javax.swing.GroupLayout(manageTags_Topbar);
        manageTags_Topbar.setLayout(manageTags_TopbarLayout);
        manageTags_TopbarLayout.setHorizontalGroup(
            manageTags_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageTags_TopbarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageTags_TopbarLayout.setVerticalGroup(
            manageTags_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageTags_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageTags_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(manageTags_Topbar);

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
                    .addComponent(JPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        Background_pnlLayout.setVerticalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(JPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addNonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btn_addNonMouseClicked

    private void btn_addNonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNonMouseEntered

    private void btn_addNonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNonMouseExited

    private void btn_addNonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNonMousePressed

    private void addNon_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNon_backBtnActionPerformed
        // TODO add your handling code here:

        new VsessionHome().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addNon_backBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void display_generatetablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_display_generatetablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_display_generatetablePropertyChange

    private void display_generatetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_generatetableMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_display_generatetableMouseClicked

    private void btn_nonaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nonaddActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_btn_nonaddActionPerformed

    private void btn_viewnonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewnonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewnonActionPerformed

    private void btn_viewnonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewnonMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_viewnonMouseClicked

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
            java.util.logging.Logger.getLogger(GenerateTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateTimeTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton addNon_backBtn;
    private javax.swing.JPanel addTags_TopBar;
    private javax.swing.JPanel btn_addNon;
    private javax.swing.JButton btn_nonadd;
    private javax.swing.JButton btn_viewnon;
    private javax.swing.JTable display_generatetable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jp_addTags;
    private javax.swing.JPanel manageTags_Topbar;
    // End of variables declaration//GEN-END:variables
}
