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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author ashan
 */
public class AStatistics extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private Statement statement1;
    private Statement statement2;
    private Statement statement3;
    
    private Statement statements1;
    private Statement statements2;
    private Statement statements3;
    private Statement statements4;    
    private Statement statements5;  
    private Statement statements6;
    private Statement statements7;
    private Statement statements8;
    private Statement statements9;
    
    private PreparedStatement preparedStmt;
    
    /**
     * Creates new form AStatistics
     */
    public AStatistics() {
        initComponents();
        dbconnect();
        showActionPerformed();
        showwhatsnew();
        btn_statistics.setBackground(new java.awt.Color(8,142,88));
    }
    
    
    private void dbconnect(){
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String JDBC_URL = "jdbc:derby:C:/Derby/TTMS;create=true";
        
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
    
    private void showActionPerformed() {
        try {

            String sq1 = "SELECT COUNT(*) FROM lecturers";
            String sq2 = "SELECT COUNT(*) FROM groups";
            String sq3 = "SELECT COUNT(*) FROM subjects";
            String sq4 = "SELECT COUNT(*) FROM buildings";
            String sq5 = "SELECT COUNT(*) FROM rooms";

            statements1 = connection.createStatement();
            ResultSet rs = statements1.executeQuery(sq1);
            
            statements2 = connection.createStatement();
            ResultSet rs1 = statements2.executeQuery(sq2);

            statements3 = connection.createStatement();
            ResultSet rs2 = statements3.executeQuery(sq3);

            statements4 = connection.createStatement();
            ResultSet rs3 = statements4.executeQuery(sq4);

            statements5 = connection.createStatement();
            ResultSet rs4 = statements5.executeQuery(sq5);             
            
            int tot_lecs = 0, tot_groups = 0, tot_subjects = 0, tot_buildings = 0, tot_rooms = 0 ;

            while (rs.next()) {
                tot_lecs = rs.getInt(1);
                tot_lecturers.setText(rs.getString(1));
            }
            
            while (rs1.next()) {
                tot_groups = rs1.getInt(1);
                totl_groups.setText(rs1.getString(1));
            }           

            while (rs2.next()) {
                tot_subjects  = rs2.getInt(1);
                totl_subjects.setText(rs2.getString(1));
            }

            while (rs3.next()) {
                tot_buildings = rs3.getInt(1);
                totl_buildings.setText(rs3.getString(1));
            }

            while (rs4.next()) {
                tot_rooms = rs4.getInt(1);
                totl_rooms.setText(rs4.getString(1));
            }           
            
        } catch (Exception e) {
                    
            
        }
    }
    
    
    private void showwhatsnew(){

        try {
            
            String sq6 = "SELECT LECTURER_NAME FROM LECTURERS WHERE LECTURER_ID = (SELECT max(LECTURER_ID) FROM LECTURERS)";
            String sq7 = "SELECT GROUP_ID FROM GROUPS WHERE ID = (SELECT max(ID) FROM GROUPS)";
            String sq8 = "SELECT SUBJECT_NAME FROM SUBJECTS WHERE SUBJECT_CODE = (SELECT max(SUBJECT_CODE) FROM SUBJECTS)";
            String sq9 = "SELECT ROOM_NAME FROM ROOMS WHERE ID = (SELECT max(ID) FROM ROOMS)";
            
            statements6 = connection.createStatement();
            ResultSet rs5 = statements6.executeQuery(sq6);  
            
            statements7 = connection.createStatement();
            ResultSet rs6 = statements7.executeQuery(sq7);  

            statements8 = connection.createStatement();
            ResultSet rs7 = statements8.executeQuery(sq8);  

            statements9 = connection.createStatement();
            ResultSet rs8 = statements9.executeQuery(sq9);              
            
            String latest_lec, latest_group, latest_subject, latest_room;         
            
            while (rs5.next()) {
                latest_lec = rs5.getString(1);
                lastest_lecturer.setText(rs5.getString(1));
            }

            while (rs6.next()) {
                latest_group = rs6.getString(1);
                lastest_group.setText(rs6.getString(1));
            }

            while (rs7.next()) {
                latest_subject = rs7.getString(1);
                lastest_subject.setText(rs7.getString(1));
            }

            while (rs8.next()) {
                latest_room = rs8.getString(1);
                lastest_room.setText(rs8.getString(1));
            }
            

        } catch (Exception e) {
                    
            
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
        btn_statistics = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        statistics_backBtn = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        statistics_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tot_lecturers = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        totl_groups = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        totl_subjects = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        totl_buildings = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        totl_rooms = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        location_stat = new javax.swing.JButton();
        lecturer_stat = new javax.swing.JButton();
        groups_stat = new javax.swing.JButton();
        subjects_stat = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        lastest_lecturer = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lastest_group = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lastest_subject = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lastest_room = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_statistics.setBackground(new java.awt.Color(39, 156, 109));
        btn_statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_statisticsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_statisticsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_statisticsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_statisticsMousePressed(evt);
            }
        });
        btn_statistics.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Statistics_Icon.png"))); // NOI18N
        btn_statistics.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Statistics");
        btn_statistics.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 106, -1));

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

        btn_statistics.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_statistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        statistics_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statistics_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        statistics_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        statistics_backBtn.setText("BACK");
        statistics_backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        statistics_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statistics_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        statistics_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistics_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(statistics_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 112, 31));

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));

        statistics_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("STATISTICS");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statistics_TopBarLayout = new javax.swing.GroupLayout(statistics_TopBar);
        statistics_TopBar.setLayout(statistics_TopBarLayout);
        statistics_TopBarLayout.setHorizontalGroup(
            statistics_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statistics_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7)
                .addGap(405, 405, 405)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        statistics_TopBarLayout.setVerticalGroup(
            statistics_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statistics_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(statistics_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPanel7Layout = new javax.swing.GroupLayout(JPanel7);
        JPanel7.setLayout(JPanel7Layout);
        JPanel7Layout.setHorizontalGroup(
            JPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel7Layout.createSequentialGroup()
                .addComponent(statistics_TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanel7Layout.setVerticalGroup(
            JPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statistics_TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(211, 211, 216));

        tot_lecturers.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        tot_lecturers.setForeground(new java.awt.Color(20, 181, 117));
        tot_lecturers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(39, 156, 109));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total Lecturers");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tot_lecturers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tot_lecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(211, 211, 216));

        totl_groups.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        totl_groups.setForeground(new java.awt.Color(20, 181, 117));
        totl_groups.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(39, 156, 109));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total Groups");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(totl_groups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totl_groups, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(211, 211, 216));

        totl_subjects.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        totl_subjects.setForeground(new java.awt.Color(20, 181, 117));
        totl_subjects.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 156, 109));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total Subjects");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(totl_subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totl_subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(211, 211, 216));

        totl_buildings.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        totl_buildings.setForeground(new java.awt.Color(20, 181, 117));
        totl_buildings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 156, 109));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Total Buildings");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(totl_buildings, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totl_buildings, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(211, 211, 216));

        totl_rooms.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        totl_rooms.setForeground(new java.awt.Color(20, 181, 117));
        totl_rooms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(39, 156, 109));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total Rooms");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totl_rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totl_rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(211, 211, 216));

        location_stat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        location_stat.setForeground(new java.awt.Color(102, 102, 102));
        location_stat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/btn_sta_loc.png"))); // NOI18N
        location_stat.setText("                   Locations Graph");
        location_stat.setActionCommand("Locations Graph");
        location_stat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        location_stat.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/sat_hover_loc.png"))); // NOI18N
        location_stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                location_statActionPerformed(evt);
            }
        });

        lecturer_stat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lecturer_stat.setForeground(new java.awt.Color(102, 102, 102));
        lecturer_stat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/stat_lec_btn.png"))); // NOI18N
        lecturer_stat.setText("                  Lecturers Graph");
        lecturer_stat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lecturer_stat.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/stat_lec_hover.png"))); // NOI18N
        lecturer_stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_statActionPerformed(evt);
            }
        });

        groups_stat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        groups_stat.setForeground(new java.awt.Color(102, 102, 102));
        groups_stat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/stat_student_btn.png"))); // NOI18N
        groups_stat.setText("               Groups Graph");
        groups_stat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        groups_stat.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/stat_student_hover.png"))); // NOI18N
        groups_stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groups_statActionPerformed(evt);
            }
        });

        subjects_stat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subjects_stat.setForeground(new java.awt.Color(102, 102, 102));
        subjects_stat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/stat_subject_btn.png"))); // NOI18N
        subjects_stat.setText("                 Subjects Graph");
        subjects_stat.setActionCommand("        Subjects Graph");
        subjects_stat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        subjects_stat.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/stat_subject_hover.png"))); // NOI18N
        subjects_stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjects_statActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(location_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groups_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lecturer_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjects_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(location_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groups_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lecturer_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjects_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(211, 211, 216));
        jPanel8.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("WHAT'S NEW");

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Latest Lecturer");

        lastest_lecturer.setBackground(new java.awt.Color(204, 204, 204));
        lastest_lecturer.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lastest_lecturer.setForeground(new java.awt.Color(39, 156, 109));
        lastest_lecturer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Latest Group");

        lastest_group.setBackground(new java.awt.Color(204, 204, 204));
        lastest_group.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lastest_group.setForeground(new java.awt.Color(39, 156, 109));
        lastest_group.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Latest Subject");

        lastest_subject.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lastest_subject.setForeground(new java.awt.Color(39, 156, 109));
        lastest_subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Latest Room");

        lastest_room.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lastest_room.setForeground(new java.awt.Color(39, 156, 109));
        lastest_room.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lastest_lecturer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lastest_group, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lastest_subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lastest_room, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastest_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastest_group, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastest_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastest_room, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout Background_pnlLayout = new javax.swing.GroupLayout(Background_pnl);
        Background_pnl.setLayout(Background_pnlLayout);
        Background_pnlLayout.setHorizontalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Background_pnlLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        Background_pnlLayout.setVerticalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(JPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_statisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_statisticsMouseClicked
        // TODO add your handling code here:
        btn_statistics.setBackground(new java.awt.Color(8,142,88));
    }//GEN-LAST:event_btn_statisticsMouseClicked

    private void btn_statisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_statisticsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_statisticsMouseEntered

    private void btn_statisticsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_statisticsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_statisticsMouseExited

    private void btn_statisticsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_statisticsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_statisticsMousePressed

    private void statistics_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistics_backBtnActionPerformed
        // TODO add your handling code here:
        HomePage homepage = new HomePage();
        homepage.setVisible(true);
        this.setVisible(false);          
    }//GEN-LAST:event_statistics_backBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void location_statActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_location_statActionPerformed
        // TODO add your handling code here:
        
        try {
            
            String query1 = "SELECT COUNT(*) FROM rooms WHERE ROOM_TYPE='Lab'";
            String query2 = "SELECT COUNT(*) FROM rooms WHERE ROOM_TYPE='Lecture Hall'";
            int lab_count = 0,lecture_count = 0;
            
            statement = connection.createStatement();
            statement1 = connection.createStatement();
            ResultSet rs = statement.executeQuery(query1);
            
            ResultSet rs1 = statement1.executeQuery(query2);
            
            while(rs1.next()) {
//                System.out.println(rs1.getInt(1));
                lecture_count = rs1.getInt(1);
            }
            
            while(rs.next()) {
//                System.out.println(rs.getInt(1));
                lab_count = rs.getInt(1);
            }
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            dataset.addValue(lab_count, "Rooms", "Labs");
            dataset.addValue(lecture_count, "Rooms", "Lecture Halls");
            
            JFreeChart chart = ChartFactory.createBarChart3D("Total Labs And Lecture Halls", "Room Type", "Room Count", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            
            ((BarRenderer)p.getRenderer()).setBarPainter(new StandardBarPainter());
            BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
            r.setSeriesPaint(0, new java.awt.Color(4, 181, 98));
            
            ChartFrame frame = new ChartFrame("Rooms Statistics Chart", chart);

            frame.setVisible(true);
            frame.setSize(650, 550);
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_location_statActionPerformed

    private void lecturer_statActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_statActionPerformed
        // TODO add your handling code here:
        try {

            String query1 = "SELECT COUNT(*) FROM lecturers WHERE lecturer_faculty='faculty of computing'";
            String query2 = "SELECT COUNT(*) FROM lecturers WHERE lecturer_faculty='faculty of business'";
            String query3 = "SELECT COUNT(*) FROM lecturers WHERE lecturer_faculty='faculty of engineering'";
            String query4 = "SELECT COUNT(*) FROM lecturers WHERE lecturer_faculty='faculty of humanities & sciences'";
            
            int fcomputing = 0, fengineering = 0, fbusiness = 0, fhumanities = 0;

            statement = connection.createStatement();
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
            statement3 = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query1);
            ResultSet rs1 = statement1.executeQuery(query2);
            ResultSet rs2 = statement2.executeQuery(query3);
            ResultSet rs3 = statement3.executeQuery(query4);

            while (rs.next()) {
//                System.out.println(rs.getInt(1));
                fcomputing = rs.getInt(1);
            }
            
            while (rs1.next()) {
//                System.out.println(rs.getInt(1));
                fbusiness = rs1.getInt(1);
            }
            
            while (rs2.next()) {
//                System.out.println(rs1.getInt(1));
                fengineering = rs2.getInt(1);
            }            
            
            while (rs3.next()) {
//                System.out.println(rs.getInt(1));
                fhumanities = rs3.getInt(1);
            }            
            

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            dataset.addValue(fcomputing, "Lecturers", "Faculty Of Computing");
            dataset.addValue(fbusiness, "Lecturers", "Faculty Of Business");
            dataset.addValue(fengineering, "Lecturers", "Faculty Of Engineering");
            dataset.addValue(fhumanities, "Lecturers", "Faculty Of Humanities & Sciences");            

            JFreeChart chart = ChartFactory.createBarChart3D("Total Lecturers In Faculties", "Faculties", "Lecturers", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ((BarRenderer) p.getRenderer()).setBarPainter(new StandardBarPainter());
            BarRenderer r = (BarRenderer) chart.getCategoryPlot().getRenderer();
            r.setSeriesPaint(0, new java.awt.Color(0, 136, 181));

            ChartFrame frame = new ChartFrame("Lecturers & Faculties Statistics Chart", chart);

            frame.setVisible(true);
            frame.setSize(800, 550);

        } catch (Exception e) {

        }

    }//GEN-LAST:event_lecturer_statActionPerformed

    private void groups_statActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groups_statActionPerformed
        // TODO add your handling code here:
        try {

            String query1 = "SELECT COUNT(*) FROM groups WHERE faculty='faculty of computing'";
            String query2 = "SELECT COUNT(*) FROM groups WHERE faculty='faculty of business'";
            String query3 = "SELECT COUNT(*) FROM groups WHERE faculty='faculty of engineering'";
            String query4 = "SELECT COUNT(*) FROM groups WHERE faculty='faculty of humanities & sciences'";
            
            int gfcomputing = 0, gfengineering = 0, gfbusiness = 0, gfhumanities = 0;

            statement = connection.createStatement();
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
            statement3 = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query1);
            ResultSet rs1 = statement1.executeQuery(query2);
            ResultSet rs2 = statement2.executeQuery(query3);
            ResultSet rs3 = statement3.executeQuery(query4);

            while (rs.next()) {
//                System.out.println(rs.getInt(1));
                gfcomputing = rs.getInt(1);
            }
            
            while (rs1.next()) {
//                System.out.println(rs.getInt(1));
                gfbusiness = rs1.getInt(1);
            }
            
            while (rs2.next()) {
//                System.out.println(rs1.getInt(1));
                gfengineering = rs2.getInt(1);
            }            
            
            while (rs3.next()) {
//                System.out.println(rs.getInt(1));
                gfhumanities = rs3.getInt(1);
            }            
            

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            dataset.addValue(gfcomputing, "Groups", "Faculty Of Computing");
            dataset.addValue(gfbusiness, "Groups", "Faculty Of Business");
            dataset.addValue(gfengineering, "Groups", "Faculty Of Engineering");
            dataset.addValue(gfhumanities, "Groups", "Faculty Of Humanities & Sciences");            

            JFreeChart chart = ChartFactory.createBarChart3D("Total Student Groups In Faculties", "Faculties", "Groups", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ((BarRenderer) p.getRenderer()).setBarPainter(new StandardBarPainter());
            BarRenderer r = (BarRenderer) chart.getCategoryPlot().getRenderer();
            r.setSeriesPaint(0, new java.awt.Color(150, 65, 141));

            ChartFrame frame = new ChartFrame("Student Groups & Faculties Statistics Chart", chart);

            frame.setVisible(true);
            frame.setSize(800, 550);

        } catch (Exception e) {

        }        
        
    }//GEN-LAST:event_groups_statActionPerformed

    private void subjects_statActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjects_statActionPerformed
        // TODO add your handling code here:
        try {

            String query1 = "SELECT COUNT(*) FROM subjects WHERE offered_year='Year 01'";
            String query2 = "SELECT COUNT(*) FROM subjects WHERE offered_year='Year 02'";
            String query3 = "SELECT COUNT(*) FROM subjects WHERE offered_year='Year 03'";
            String query4 = "SELECT COUNT(*) FROM subjects WHERE offered_year='Year 04'";
            
            int year1 = 0, year2 = 0, year3 = 0, year4 = 0;

            statement = connection.createStatement();
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
            statement3 = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query1);
            ResultSet rs1 = statement1.executeQuery(query2);
            ResultSet rs2 = statement2.executeQuery(query3);
            ResultSet rs3 = statement3.executeQuery(query4);

            while (rs.next()) {
//                System.out.println(rs.getInt(1));
                year1 = rs.getInt(1);
            }
            
            while (rs1.next()) {
//                System.out.println(rs.getInt(1));
                year2 = rs1.getInt(1);
            }
            
            while (rs2.next()) {
//                System.out.println(rs1.getInt(1));
                year3 = rs2.getInt(1);
            }            
            
            while (rs3.next()) {
//                System.out.println(rs.getInt(1));
                year4 = rs3.getInt(1);
            }            
            

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            dataset.addValue(year1, "Subjects", "Year 01");
            dataset.addValue(year2, "Subjects", "Year 02");
            dataset.addValue(year3, "Subjects", "Year 03");
            dataset.addValue(year4, "Subjects", "Year 04");            

            JFreeChart chart = ChartFactory.createBarChart3D("Total Subjects and Years", "Years", "Subjects", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ((BarRenderer) p.getRenderer()).setBarPainter(new StandardBarPainter());
            BarRenderer r = (BarRenderer) chart.getCategoryPlot().getRenderer();
            r.setSeriesPaint(0, new java.awt.Color(214, 41, 61));

            ChartFrame frame = new ChartFrame("Subjects & Years Statistics Chart", chart);

            frame.setVisible(true);
            frame.setSize(800, 550);

        } catch (Exception e) {

        }        
    }//GEN-LAST:event_subjects_statActionPerformed

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
            java.util.logging.Logger.getLogger(AStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AStatistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel btn_statistics;
    private javax.swing.JButton groups_stat;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lastest_group;
    private javax.swing.JLabel lastest_lecturer;
    private javax.swing.JLabel lastest_room;
    private javax.swing.JLabel lastest_subject;
    private javax.swing.JButton lecturer_stat;
    private javax.swing.JButton location_stat;
    private javax.swing.JPanel statistics_TopBar;
    private javax.swing.JButton statistics_backBtn;
    private javax.swing.JButton subjects_stat;
    private javax.swing.JLabel tot_lecturers;
    private javax.swing.JLabel totl_buildings;
    private javax.swing.JLabel totl_groups;
    private javax.swing.JLabel totl_rooms;
    private javax.swing.JLabel totl_subjects;
    // End of variables declaration//GEN-END:variables
}
