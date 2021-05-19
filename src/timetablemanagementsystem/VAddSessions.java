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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class VAddSessions extends javax.swing.JFrame {
    PreparedStatement insert;
   
    Connection conn;
   
    /**
     * Creates new form VAddSessions
     */
    public VAddSessions() {
        initComponents();
        loadLecturers();
        loadTags();
        loadSubjects();
        loadMainGroupIDs();
        loadSubGroupIDs();
        
        txtsubname.setEditable(false);
       
        
    }

    
    public void loadLecturers(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select lname from Lec where status = true";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
          
            ResultSet rs = insert.executeQuery();
            
             while (rs.next()) {
               String lname = rs.getString("lname");
               //lecid = rs.getInt("lecId");
               //String lno = String.valueOf(lecid);
              combo_selLec1.addItem(lname);
               combo_selLec2.addItem(lname);
                combo_selLec3.addItem(lname);
                 
            }
             
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    
    public void loadTags(){
        
        try {
            
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select RELATED_TAG from TAGS ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
          
            ResultSet rs = insert.executeQuery();
            
             while (rs.next()) {
               String tag = rs.getString("RELATED_TAG");
              combo_sel_tag.addItem(tag);
             
                 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loadSubjects(){
    
        try {
            
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select subCode from Subject where status = true ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
          
            ResultSet rs = insert.executeQuery();
            
            while (rs.next()) {
               String scode = rs.getString("subCode");
              combo_sel_subcode.addItem(scode);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public void loadMainGroupIDs(){
    
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select GROUPID from SGROUPS ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
            
            ResultSet rs = insert.executeQuery();
            
            while (rs.next()) {
               String mg = rs.getString("GROUPID");
              combo_Maingroup.addItem(mg);
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    } 
    
     public void loadSubGroupIDs(){
    
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select SUBGROUPID from SGROUPS ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
            
            ResultSet rs = insert.executeQuery();
            
            while (rs.next()) {
               String smg = rs.getString("SUBGROUPID");
             combo_selsubgroup.addItem(smg);
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    } 
    
   /* public void loadlecNo(){
        
        String lecname = combo_selLec1.getSelectedItem().toString();
        try {
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:C:/Users/Asus/AppData/Roaming/NetBeans/12.3/derby/TTMS";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            insert =  (PreparedStatement) conn.prepareStatement("select lecId from Lec where lname = ?");
            insert.setString(1,lecname);
            ResultSet rs2 =  insert.executeQuery();
            
            String lno = String.valueOf((rs2.getInt("lecId")));
           
           
            txtLno.setText(lno);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Background_pnl = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        btn_addSession = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageSess = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addsess_backBtn = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        manageSess_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        combo_selLec1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        combo_selLec3 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        combo_selLec2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        combo_sel_subcode = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_duration = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtsubname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        combo_sel_tag = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        combo_selsubgroup = new javax.swing.JComboBox<>();
        combo_Maingroup = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btn_AddSess = new javax.swing.JButton();
        txt_stcount = new javax.swing.JTextField();
        txt_sname = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addSession.setBackground(new java.awt.Color(39, 156, 109));
        btn_addSession.setToolTipText("If you click this you can view add room page");
        btn_addSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addSessionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addSessionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addSessionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addSessionMousePressed(evt);
            }
        });
        btn_addSession.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Add_Icon.png"))); // NOI18N
        btn_addSession.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Sessions");
        btn_addSession.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 106, -1));

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

        btn_addSession.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageSess.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageSess.setToolTipText("If you click this you can view manage rooms page");
        btn_ManageSess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageSessMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageSessMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageSessMouseExited(evt);
            }
        });
        btn_ManageSess.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Manage_Icon.png"))); // NOI18N
        btn_ManageSess.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Sessions");
        btn_ManageSess.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 150, -1));

        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_ManageSess.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageSess, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addsess_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addsess_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addsess_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        addsess_backBtn.setText("BACK");
        addsess_backBtn.setToolTipText("Go Back");
        addsess_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addsess_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        addsess_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsess_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addsess_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        manageSess_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ADD SESSIONS");

        jButton10.setBackground(new java.awt.Color(186, 38, 43));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("LOGOUT");
        jButton10.setToolTipText("Logout from the system");
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageSess_TopbarLayout = new javax.swing.GroupLayout(manageSess_Topbar);
        manageSess_Topbar.setLayout(manageSess_TopbarLayout);
        manageSess_TopbarLayout.setHorizontalGroup(
            manageSess_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageSess_TopbarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        manageSess_TopbarLayout.setVerticalGroup(
            manageSess_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageSess_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageSess_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        JPanel7.add(manageSess_Topbar);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Add Lectureres");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Select Lecturer 01:");

        combo_selLec1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 1" }));
        combo_selLec1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_selLec1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_selLec1MousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Select Lecturer 02:");

        combo_selLec3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 3" }));
        combo_selLec3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_selLec3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_selLec3MousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setText("Select Lecturer 03:");

        combo_selLec2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 2" }));
        combo_selLec2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_selLec2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_selLec2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_selLec1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_selLec2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_selLec3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combo_selLec1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_selLec2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(combo_selLec3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Tag:");

        combo_sel_subcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Code" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("No of students:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setText("Duration (Hours):");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Subject Code:");

        combo_sel_tag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag" }));
        combo_sel_tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sel_tagActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Subject Name:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setText("Main Group Id:");

        combo_selsubgroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));

        combo_Maingroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setText("Sub Group Id:");

        jButton7.setBackground(new java.awt.Color(34, 108, 252));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Generate");
        jButton7.setToolTipText("Click on to add Subject");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(186, 38, 43));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        jButton8.setText("CLEAR");
        jButton8.setToolTipText("Click on to clear values");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btn_AddSess.setBackground(new java.awt.Color(34, 108, 252));
        btn_AddSess.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_AddSess.setForeground(new java.awt.Color(255, 255, 255));
        btn_AddSess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_AddSess.setText("ADD");
        btn_AddSess.setToolTipText("Click on to add Session");
        btn_AddSess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_AddSess.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_AddSess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddSessActionPerformed(evt);
            }
        });

        txt_sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_snameActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Session Name:");

        javax.swing.GroupLayout Background_pnlLayout = new javax.swing.GroupLayout(Background_pnl);
        Background_pnl.setLayout(Background_pnlLayout);
        Background_pnlLayout.setHorizontalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(txt_duration)
                            .addComponent(combo_sel_tag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_stcount)
                            .addComponent(txt_sname)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_Maingroup, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_selsubgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addComponent(txtsubname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_sel_subcode, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(233, 233, 233))))))
            .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Background_pnlLayout.createSequentialGroup()
                    .addContainerGap(483, Short.MAX_VALUE)
                    .addComponent(btn_AddSess, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(416, 416, 416)))
        );
        Background_pnlLayout.setVerticalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(JPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_sname)
                    .addComponent(combo_sel_subcode, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsubname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(combo_sel_tag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Maingroup, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stcount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_selsubgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_duration, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Background_pnlLayout.createSequentialGroup()
                    .addContainerGap(881, Short.MAX_VALUE)
                    .addComponent(btn_AddSess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(66, 66, 66)))
        );

        jScrollPane1.setViewportView(Background_pnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addSessionMouseClicked
         
        //addSess_TopBar.setVisible(true);
        manageSess_Topbar.setVisible(false);
        btn_addSession.setBackground(new java.awt.Color(8,142,88));
        btn_ManageSess.setBackground(new java.awt.Color(39,156,109));
        
         VAddSessions vr = new  VAddSessions();
         vr.setVisible(true);
         this.dispose();
        
        
    }//GEN-LAST:event_btn_addSessionMouseClicked

    private void btn_addSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addSessionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addSessionMouseEntered

    private void btn_addSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addSessionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addSessionMouseExited

    private void btn_addSessionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addSessionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addSessionMousePressed

    private void btn_ManageSessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageSessMouseClicked
        
        //addSess_TopBar.setVisible(false);
        manageSess_Topbar.setVisible(true);
        btn_ManageSess.setBackground(new java.awt.Color(8,142,88));
        btn_addSession.setBackground(new java.awt.Color(39,156,109));    
        
          VManageSessions vr = new  VManageSessions();
         vr.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btn_ManageSessMouseClicked

    private void btn_ManageSessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageSessMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageSessMouseEntered

    private void btn_ManageSessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageSessMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageSessMouseExited

    private void addsess_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsess_backBtnActionPerformed
        VsessionHome vr = new  VsessionHome();
         vr.setVisible(true);
         this.dispose();
        
    }//GEN-LAST:event_addsess_backBtnActionPerformed

    private void combo_sel_tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_sel_tagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_sel_tagActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select sname from Subject where subCode = ? ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
            
            insert.setString(1, combo_sel_subcode.getSelectedItem().toString());
            
            ResultSet rs = insert.executeQuery();
            
             if (rs.next()) {
                 String val = rs.getString("sname");
                 txtsubname.setText(val);
             }
            
        } catch (Exception e) {
        }
 
        
        

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        txt_sname.setText("");
        txt_stcount.setText("");
        txt_duration.setText("");
        txtsubname.setText("");
        combo_sel_subcode.setSelectedItem("Select Subject Code");
        combo_sel_tag.setSelectedItem("Select Tag");
        combo_Maingroup.setSelectedItem("none");
        combo_selsubgroup.setSelectedItem("none");
        combo_selLec1.setSelectedItem("Select Lecturer 1");
        combo_selLec2.setSelectedItem("Select Lecturer 2");
        combo_selLec3.setSelectedItem("Select Lecturer 3");
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void combo_selLec1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec1MouseClicked
        // loadlecNo();
    }//GEN-LAST:event_combo_selLec1MouseClicked

    private void combo_selLec1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec1MousePressed
       
    }//GEN-LAST:event_combo_selLec1MousePressed

    private void combo_selLec3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec3MouseClicked

    private void combo_selLec3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec3MousePressed

    private void combo_selLec2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec2MouseClicked

    private void combo_selLec2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec2MousePressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btn_AddSessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddSessActionPerformed
       
        String Mstugr = combo_Maingroup.getSelectedItem().toString();
        String Sstugr = combo_selsubgroup.getSelectedItem().toString();
        
        if (Sstugr == "none"){
        
            String sesname = txt_sname.getText();
            String lec1 = combo_selLec1.getSelectedItem().toString();
            String lec2 = combo_selLec2.getSelectedItem().toString();
            String lec3 = combo_selLec3.getSelectedItem().toString();
            String tagName = combo_sel_tag.getSelectedItem().toString();
            String nstu = txt_stcount.getText();
            String duration = txt_duration.getText();
            String scode = combo_sel_subcode.getSelectedItem().toString();
            String suname = txtsubname.getText();
            String mgroup = combo_Maingroup.getSelectedItem().toString();
            
           int nostu = Integer.parseInt(nstu);
            
                    if(sesname.trim().isEmpty()){
                            JOptionPane.showMessageDialog(this, "Enter Session Name", "Alert", JOptionPane.ERROR_MESSAGE);  
                    }
                    else if (nstu.trim().isEmpty()){
                    JOptionPane.showMessageDialog(this,"Enter number of students ","Alert", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                    
                        try {
                             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                             String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
                             Connection conn = DriverManager.getConnection(URL);

                             Statement stmt = conn.createStatement();

                             insert =  (PreparedStatement)conn.prepareStatement("insert into sessions(session_name,lecture_1,lecture_2,lecture_3,NoStu,duration,subject_code,subject_name,group_id,tag) values (?,?,?,?,?,?,?,?,?,?)");    
                             insert.setString(1,sesname);
                             insert.setString(2,lec1);
                             insert.setString(3,lec2);
                             insert.setString(4,lec3);
                             insert.setInt(5, nostu);
                             insert.setString(6,duration);
                             insert.setString(7,scode);
                             insert.setString(8,suname);
                             insert.setString(9,mgroup);
                             insert.setString(10,tagName);
                             
                             insert.executeUpdate();

                             JOptionPane.showMessageDialog(this, " Session added successfully");
            
                             conn.close();
                             
                        } catch (SQLException e) {
                            Logger.getLogger(VaddLec.class.getName()).log(Level.SEVERE,null,e);
                        }
                        
                        catch(ClassNotFoundException ex){
                            Logger.getLogger( VaddLec.class.getName()).log(Level.SEVERE,null,ex);
                        }
                    
                    }
        }
        
        else{
            
             String sesname = txt_sname.getText();
            String lec1 = combo_selLec1.getSelectedItem().toString();
            String lec2 = combo_selLec2.getSelectedItem().toString();
            String lec3 = combo_selLec3.getSelectedItem().toString();
            String tagName = combo_sel_tag.getSelectedItem().toString();
            String nstu = txt_stcount.getText();
            String duration = txt_duration.getText();
            String scode = combo_sel_subcode.getSelectedItem().toString();
            String suname = txtsubname.getText();
            String sgroup = combo_selsubgroup.getSelectedItem().toString();
            
           int nostu = Integer.parseInt(nstu);
            
                    if(sesname.trim().isEmpty()){
                            JOptionPane.showMessageDialog(this, "Enter Session Name", "Alert", JOptionPane.ERROR_MESSAGE);  
                    }
                    else if (nstu.trim().isEmpty()){
                    JOptionPane.showMessageDialog(this,"Enter number of students ","Alert", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                    
                        try {
                             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                             String URL = "jdbc:derby:C:/Derby/TTMS;create=true";
                             Connection conn = DriverManager.getConnection(URL);

                             Statement stmt = conn.createStatement();

                             insert =  (PreparedStatement)conn.prepareStatement("insert into sessions(session_name,lecture_1,lecture_2,lecture_3,NoStu,duration,subject_code,subject_name,group_id,tag) values (?,?,?,?,?,?,?,?,?,?)");    
                             insert.setString(1,sesname);
                             insert.setString(2,lec1);
                             insert.setString(3,lec2);
                             insert.setString(4,lec3);
                             insert.setInt(5, nostu);
                             insert.setString(6,duration);
                             insert.setString(7,scode);
                             insert.setString(8,suname);
                             insert.setString(9,sgroup);
                             insert.setString(10,tagName);
                             
                             insert.executeUpdate();

                             JOptionPane.showMessageDialog(this, " Session added successfully");
            
                             conn.close();
                             
                        } catch (SQLException e) {
                            Logger.getLogger(VaddLec.class.getName()).log(Level.SEVERE,null,e);
                        }
                        
                        catch(ClassNotFoundException ex){
                            Logger.getLogger( VaddLec.class.getName()).log(Level.SEVERE,null,ex);
                        }
                    
                    }
        
        
        }
    }//GEN-LAST:event_btn_AddSessActionPerformed

    private void txt_snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_snameActionPerformed

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
            java.util.logging.Logger.getLogger(VAddSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VAddSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VAddSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VAddSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VAddSessions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton addsess_backBtn;
    private javax.swing.JButton btn_AddSess;
    private javax.swing.JPanel btn_ManageSess;
    private javax.swing.JPanel btn_addSession;
    private javax.swing.JComboBox<String> combo_Maingroup;
    private javax.swing.JComboBox<String> combo_selLec1;
    private javax.swing.JComboBox<String> combo_selLec2;
    private javax.swing.JComboBox<String> combo_selLec3;
    private javax.swing.JComboBox<String> combo_sel_subcode;
    private javax.swing.JComboBox<String> combo_sel_tag;
    private javax.swing.JComboBox<String> combo_selsubgroup;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel manageSess_Topbar;
    private javax.swing.JTextField txt_duration;
    private javax.swing.JTextField txt_sname;
    private javax.swing.JTextField txt_stcount;
    private javax.swing.JTextField txtsubname;
    // End of variables declaration//GEN-END:variables
}
