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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class VManageSessions extends javax.swing.JFrame {
    PreparedStatement insert;
   
    Connection conn;
    /**
     * Creates new form VManageSessions
     */
    public VManageSessions() {
        initComponents();
        loadLecturers();
        loadTags();
        loadSubjects();
        loadMainGroupIDs();
        loadSubGroupIDs();
        table_update();
        
        txtsubname.setEditable(false);
    }
    
     private void table_update(){
    int c;
    
        try {
            
            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
            Connection conn = DriverManager.getConnection(URL);
            
            Statement stmt = conn.createStatement();
            
            insert= (PreparedStatement) conn.prepareStatement("select session_id,session_name,lecture_1,lecture_2,lecture_3,tag,subject_code,subject_name,group_id,NoStu,duration from sessions where status = true");
           
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData res = rs.getMetaData();
            
            c = res.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTablesessions.getModel();
            df.setRowCount(0);
            
            while (rs.next()){
                
            Vector v2 = new Vector();
            
            for(int a=1; a<=c ; a++){
            
               v2.add(rs.getInt("session_id"));
               v2.add(rs.getString("session_name"));
               v2.add(rs.getString("lecture_1"));
               v2.add(rs.getString("lecture_2"));
               v2.add(rs.getString("lecture_3"));
               v2.add(rs.getString("tag"));
               v2.add(rs.getString("subject_code"));
               v2.add(rs.getString("subject_name"));
               v2.add(rs.getString("group_id"));
               v2.add(rs.getInt("NoStu"));
               v2.add(rs.getString("duration"));
            }
                  df.addRow(v2);
              }
            
            
       } catch (ClassNotFoundException ex) {
            
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } 
        
        catch(SQLException ex){
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
    
    
    
    
    }
    
     public void loadLecturers(){
        try {
            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
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
            
            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
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
            
            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select subCode from Subject where status = true ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
          
            ResultSet rs = insert.executeQuery();
            
            while (rs.next()) {
               String scode = rs.getString("subCode");
              combo_sel_subcode.addItem(scode);
              scrsubject.addItem(scode);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
      
       public void loadMainGroupIDs(){
    
        try {
            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
            Connection conn = DriverManager.getConnection(URL);
            
            Statement stmt = conn.createStatement();
            
            String sql = "select GROUPID from SGROUPS ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
            
            ResultSet rs = insert.executeQuery();
            
            while (rs.next()) {
               String mg = rs.getString("GROUPID");
              combo_group.addItem(mg);
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    } 
       
       public void loadSubGroupIDs(){
    
        try {
            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
            Connection conn = DriverManager.getConnection(URL);

            
            Statement stmt = conn.createStatement();
            
            String sql = "select SUBGROUPID from SGROUPS ";
            insert =  (PreparedStatement) conn.prepareStatement(sql);
            
            ResultSet rs = insert.executeQuery();
            
            while (rs.next()) {
               String smg = rs.getString("SUBGROUPID");
             combo_group.addItem(smg);
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
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

        jScrollPane2 = new javax.swing.JScrollPane();
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
        jButton5 = new javax.swing.JButton();
        scrsubject = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablesessions = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_sname = new javax.swing.JTextField();
        txt_dur = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        combo_sel_tag = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_stcount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        combo_sel_subcode = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        combo_group = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        btn_updateSession = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        combo_selLec1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        combo_selLec2 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        combo_selLec3 = new javax.swing.JComboBox<>();
        txtsubname = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        txt_sid = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addSession.setBackground(new java.awt.Color(39, 156, 109));
        btn_addSession.setToolTipText("If you click this you can view add session page");
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
        btn_ManageSess.setToolTipText("If you click this you can view manage session page");
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
        jLabel4.setText("MANAGE SESSIONS");

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

        javax.swing.GroupLayout manageSess_TopbarLayout = new javax.swing.GroupLayout(manageSess_Topbar);
        manageSess_Topbar.setLayout(manageSess_TopbarLayout);
        manageSess_TopbarLayout.setHorizontalGroup(
            manageSess_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageSess_TopbarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageSess_TopbarLayout.setVerticalGroup(
            manageSess_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageSess_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageSess_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        JPanel7.add(manageSess_Topbar);

        scrsubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject" }));
        scrsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrsubjectActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(34, 108, 252));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("REFRESH");
        jButton7.setToolTipText("Click on to add Lecturer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTablesessions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "          ID", "Session Name", "Lecturer 01", "Lecturer 02", "Lecturer 03", "        Tag", "Subject Code", "Subject Name", "Group Id ", "Student Count", "Duration"
            }
        ));
        jTablesessions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablesessionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablesessions);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Session ID:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Tag:");

        combo_sel_tag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag" }));
        combo_sel_tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sel_tagActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("No of students:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setText("Duration (Hours):");

        combo_sel_subcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Code" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Subject Name:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Subject Code:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setText("Group Id:");

        combo_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));

        jButton9.setBackground(new java.awt.Color(34, 108, 252));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("VIEW");
        jButton9.setToolTipText("Click on to add Subject");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btn_updateSession.setBackground(new java.awt.Color(34, 108, 252));
        btn_updateSession.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_updateSession.setForeground(new java.awt.Color(255, 255, 255));
        btn_updateSession.setText("UPDATE");
        btn_updateSession.setToolTipText("Click on to add Subject");
        btn_updateSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateSessionActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(186, 38, 43));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CLEAR");
        jButton4.setToolTipText("Click on to clear values");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(186, 38, 43));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("DELETE");
        jButton11.setToolTipText("Click on to clear values");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(34, 108, 252));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("SEARCH");
        jButton12.setToolTipText("Click on to add Lecturer");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel11.setText("Select Subject");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setText("Select Lecturer 01:");

        combo_selLec1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 1" }));
        combo_selLec1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_selLec1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_selLec1MousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Select Lecturer 02:");

        combo_selLec2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 2" }));
        combo_selLec2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_selLec2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_selLec2MousePressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setText("Select Lecturer 03:");

        combo_selLec3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer 3" }));
        combo_selLec3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_selLec3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_selLec3MousePressed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(34, 108, 252));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Generate");
        jButton13.setToolTipText("Click on to add Subject");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setText("Session Name:");

        javax.swing.GroupLayout Background_pnlLayout = new javax.swing.GroupLayout(Background_pnl);
        Background_pnl.setLayout(Background_pnlLayout);
        Background_pnlLayout.setHorizontalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12)
                        .addGap(262, 262, 262))
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sid, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_selLec1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_selLec2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Background_pnlLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)))
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_sel_tag, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_stcount, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dur, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_selLec3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_updateSession, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)
                                .addGap(34, 34, 34))
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_sel_subcode, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_group, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Background_pnlLayout.createSequentialGroup()
                                        .addComponent(txtsubname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton13)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Background_pnlLayout.createSequentialGroup()
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Background_pnlLayout.createSequentialGroup()
                                .addGap(514, 514, 514)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Background_pnlLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        Background_pnlLayout.setVerticalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(JPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scrsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton7)
                                    .addComponent(jLabel16)))
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel21))))
                        .addGap(6, 6, 6)
                        .addComponent(combo_sel_subcode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsubname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13)))
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(txt_sid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(combo_selLec3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_sel_tag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Background_pnlLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Background_pnlLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combo_selLec1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_stcount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel14))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_selLec2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dur, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_group, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_updateSession, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(Background_pnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addSessionMouseClicked

       // addSess_TopBar.setVisible(true);
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
            table_update();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void combo_sel_tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_sel_tagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_sel_tagActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         
        String lec1 = combo_selLec1.getSelectedItem().toString();
        String lec2 = combo_selLec2.getSelectedItem().toString();
        String lec3 = combo_selLec3.getSelectedItem().toString();
        String scode = combo_sel_subcode.getSelectedItem().toString();
        String suname = txtsubname.getText();
        String tagName = combo_sel_tag.getSelectedItem().toString();
        String group = combo_group.getSelectedItem().toString();
        String nstu = txt_stcount.getText();
        String duration = txt_dur.getText();
        
        if(lec1 == "Select Lecturer 1"){
                 String session = lec2+""+lec3+""+"-"+scode +"-"+suname+"-"+tagName+"-"+group+"-"+nstu +"-"+  duration;
                  JOptionPane.showMessageDialog(this, session);
                
        }
        else if(lec2 == "Select Lecturer 2"){
                String session = lec1+""+lec3+""+"-"+scode +"-"+suname+"-"+tagName+"-"+group+"-"+nstu +"-"+  duration;
                  JOptionPane.showMessageDialog(this, session);
        }
        else if(lec3 != "Select Lecturer 3"){
                     String session = lec1+""+lec2+""+"-"+scode +"-"+suname+"-"+tagName+"-"+group+"-"+nstu +"-"+  duration;
                  JOptionPane.showMessageDialog(this, session);
                    
                }
        else if((lec1 == "Select Lecturer 1")&& (lec2 == "Select Lecturer 2")) {
            String session = lec3+""+"-"+scode +"-"+suname+"-"+tagName+"-"+group+"-"+nstu +"-"+  duration;
                  JOptionPane.showMessageDialog(this, session);
    }
            else if((lec1 == "Select Lecturer 1")&& (lec3 == "Select Lecturer 3")) {
            String session = lec2+""+"-"+scode +"-"+suname+"-"+tagName+"-"+group+"-"+nstu +"-"+  duration;
                  JOptionPane.showMessageDialog(this, session);
    }
         else if((lec2 == "Select Lecturer 1")&& (lec3 == "Select Lecturer 3")) {
            String session = lec1+"-"+scode +"-"+suname+"-"+tagName+"-"+group+"-"+nstu +"-"+  duration;
                  JOptionPane.showMessageDialog(this, session);
    }
            
        
      
        String session = lec1+""+lec2+""+lec3+""+"-"+scode +"-"+suname+"-"+tagName+"-"+group+"-"+nstu +"-"+  duration;
       
        
       
                 JOptionPane.showMessageDialog(this, session);

                  

       
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn_updateSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateSessionActionPerformed
         DefaultTableModel df = (DefaultTableModel) jTablesessions.getModel();
         int selectedIndex = jTablesessions.getSelectedRow();

         String id = df.getValueAt(selectedIndex,0).toString();
         
         String sesname = txt_sname.getText();
         String lec1 = combo_selLec1.getSelectedItem().toString();
         String lec2 = combo_selLec2.getSelectedItem().toString();
         String lec3 = combo_selLec3.getSelectedItem().toString();
         String tagName = combo_sel_tag.getSelectedItem().toString();
         
         String duration = txt_dur.getText();
         String scode = combo_sel_subcode.getSelectedItem().toString();
         String suname = txtsubname.getText();
         String group = combo_group.getSelectedItem().toString();
         
         String nstu = txt_stcount.getText();
         int nos = Integer.parseInt(nstu);
         
         String sesId = txt_sid.getText();
         int sid = Integer.parseInt(sesId);
         
         try {
            
            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
            Connection conn = DriverManager.getConnection(URL);
             
             Statement stmt = conn.createStatement();
             
               insert = (PreparedStatement) conn.prepareStatement("update sessions set session_name = ?, lecture_1 = ?,lecture_2 =?,lecture_3 = ?, NoStu = ?, duration = ?,subject_code =?, subject_name = ?, group_id =?, tag = ? where session_id = ?");
               insert.setString(1,sesname);
               insert.setString(2,lec1);
               insert.setString(3,lec2);
               insert.setString(4,lec3);
               insert.setInt(5, nos);
               insert.setString(6,duration);
               insert.setString(7,scode);
               insert.setString(8,suname);
               insert.setString(9,group);
               insert.setString(10,tagName);
               
                insert.setInt(11, sid);
                
                
            
            insert.executeUpdate();
            table_update();
            
             JOptionPane.showMessageDialog(this, "Session is Updated");
             table_update();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_updateSessionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            txt_sid.setText("");
            txt_sname.setText("");
            combo_selLec1.setSelectedItem("Select Lecturer 1");
            combo_selLec2.setSelectedItem("Select Lecturer 2");
            combo_selLec3.setSelectedItem("Select Lecturer 3");
            combo_sel_tag.setSelectedItem("Select Tag");
            txt_stcount.setText("");
            txt_dur.setText("");
            combo_sel_subcode.setSelectedItem("Select Subject Code");
            txtsubname.setText("");
            combo_group.setSelectedItem("none");
            
            
            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
          DefaultTableModel df = (DefaultTableModel)  jTablesessions.getModel();
          int selectedIndex =  jTablesessions.getSelectedRow();

          String id = df.getValueAt(selectedIndex,0).toString();
          
          try {
                  int dialogrsult = JOptionPane.showConfirmDialog(null,"Do you want to delete the record ?","warning",JOptionPane.YES_NO_OPTION);

                   if(dialogrsult == JOptionPane.YES_OPTION){

            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
            Connection conn = DriverManager.getConnection(URL);

                    Statement stmt = conn.createStatement();

                    insert = (PreparedStatement) conn.prepareStatement("update sessions set status =false where session_id = ?");
                    insert.setString(1,id);

                    insert.executeUpdate();
                    table_update();

                     JOptionPane.showMessageDialog(this, "Session is Deleted");
             
            }
        }  catch(SQLException ex){
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }

        catch(ClassNotFoundException ex){
            java.util.logging.Logger.getLogger( VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void combo_selLec1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec1MouseClicked
        // loadlecNo();
    }//GEN-LAST:event_combo_selLec1MouseClicked

    private void combo_selLec1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec1MousePressed

    }//GEN-LAST:event_combo_selLec1MousePressed

    private void combo_selLec2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec2MouseClicked

    private void combo_selLec2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec2MousePressed

    private void combo_selLec3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec3MouseClicked

    private void combo_selLec3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_selLec3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_selLec3MousePressed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {

            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
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

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTablesessionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablesessionsMouseClicked
      
        DefaultTableModel df = (DefaultTableModel) jTablesessions.getModel();
        int selectedIndex = jTablesessions.getSelectedRow();
        
         txt_sid.setText(jTablesessions.getValueAt(selectedIndex,0).toString());
         txt_sname.setText(jTablesessions.getValueAt(selectedIndex,1).toString());
         combo_selLec1.setSelectedItem(jTablesessions.getValueAt(selectedIndex,2).toString());
         combo_selLec2.setSelectedItem(jTablesessions.getValueAt(selectedIndex,3).toString());
         combo_selLec3.setSelectedItem(jTablesessions.getValueAt(selectedIndex,4).toString());
         combo_sel_tag.setSelectedItem(jTablesessions.getValueAt(selectedIndex,5).toString());
         combo_sel_subcode.setSelectedItem(jTablesessions.getValueAt(selectedIndex,6).toString());
         txtsubname.setText(jTablesessions.getValueAt(selectedIndex,7).toString());
         combo_group.setSelectedItem(jTablesessions.getValueAt(selectedIndex,8).toString());
         txt_stcount.setText(jTablesessions.getValueAt(selectedIndex,9).toString());
         txt_dur.setText(jTablesessions.getValueAt(selectedIndex,10).toString());
                 
        
    }//GEN-LAST:event_jTablesessionsMouseClicked

    private void scrsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrsubjectActionPerformed
        // TODO add your handling code here
        int c;
        try {

            String currentDir = System.getProperty("user.dir");
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String URL = "jdbc:derby:"+currentDir+"\\TTMS";
            Connection conn = DriverManager.getConnection(URL);

            Statement stmt = conn.createStatement();

            insert = (PreparedStatement) conn.prepareStatement("select * from sessions where subject_code =?");
            insert.setString(1, scrsubject.getSelectedItem().toString());
            ResultSet rs2 = insert.executeQuery();

            ResultSetMetaData res = rs2.getMetaData();

            c = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTablesessions.getModel();
            df.setRowCount(0);

            while (rs2.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {

                    v2.add(rs2.getInt("session_id"));
                    v2.add(rs2.getString("session_name"));
                    v2.add(rs2.getString("lecture_1"));
                    v2.add(rs2.getString("lecture_2"));
                    v2.add(rs2.getString("lecture_3"));
                    v2.add(rs2.getString("subject_code"));
                    v2.add(rs2.getString("subject_name"));
                    v2.add(rs2.getString("group_id"));
                }
                df.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scrsubjectActionPerformed

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
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VManageSessions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton addsess_backBtn;
    private javax.swing.JPanel btn_ManageSess;
    private javax.swing.JPanel btn_addSession;
    private javax.swing.JButton btn_updateSession;
    private javax.swing.JComboBox<String> combo_group;
    private javax.swing.JComboBox<String> combo_selLec1;
    private javax.swing.JComboBox<String> combo_selLec2;
    private javax.swing.JComboBox<String> combo_selLec3;
    private javax.swing.JComboBox<String> combo_sel_subcode;
    private javax.swing.JComboBox<String> combo_sel_tag;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablesessions;
    private javax.swing.JPanel manageSess_Topbar;
    private javax.swing.JComboBox<String> scrsubject;
    private javax.swing.JTextField txt_dur;
    private javax.swing.JTextField txt_sid;
    private javax.swing.JTextField txt_sname;
    private javax.swing.JTextField txt_stcount;
    private javax.swing.JTextField txtsubname;
    // End of variables declaration//GEN-END:variables
}
