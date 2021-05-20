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

/**
 *
 * @author umesha
 */
public class ULecturersNotAvailableTime extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String lecNo_rowSelected;    
    private String  LectureName, student_grp, student_subgrp, start_time, end_time;
    private int session_id;
    
    /**
     * Creates new form ULecturersNotAvailableTime
     */
    public ULecturersNotAvailableTime() {
        initComponents();
         dbconnect();
         FillComboLecturers();
         FillComboSessions();
         FillComboGroups();
         FillComboSubGroups();
         show_LecNotAvailableDetails();
         btn_addWorkingDays.setBackground(new java.awt.Color(8,142,88));
    }

    
    public ArrayList<ULectureNotAvailableTimeModel> lectnotavilableList() {
        
        ArrayList<ULectureNotAvailableTimeModel> lectnotavilableList = new ArrayList<>();
        try {
            String query = "SELECT * FROM LECNOTAVAILABLE";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ULectureNotAvailableTimeModel lecnotavailabletimemodel ;

            while(rs.next()){
                lecnotavailabletimemodel = new ULectureNotAvailableTimeModel (rs.getInt("LECNOTID"), rs.getInt("SESSIONID"), rs.getString("LECTURENAME"), rs.getString("STUDGROUP"), rs.getString("STUSUBGROUP"), rs.getString("STARTTIME"), rs.getString("ENDTIME"));
                lectnotavilableList.add(lecnotavailabletimemodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in Lecture Not AvailableList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return lectnotavilableList;            
    }
    
    public void show_LecNotAvailableDetails(){
        
        ArrayList<ULectureNotAvailableTimeModel> lectnotavilableList = lectnotavilableList();
        DefaultTableModel tableModel = (DefaultTableModel) display_table.getModel();
        
        Object[] row = new Object[8];
        for (int i = 0; i < lectnotavilableList.size(); i++) {
            
            row[0] = lectnotavilableList.get(i).getId();
            row[1] = lectnotavilableList.get(i).getSession_id();
            row[2] = lectnotavilableList.get(i).getLecturename();
            row[3] = lectnotavilableList.get(i).getStugrpname();
            row[4] = lectnotavilableList.get(i).getStusubgrpname();
            row[5] = lectnotavilableList.get(i).getStart_time();
            row[6] = lectnotavilableList.get(i).getEnd_time();
            
            tableModel.addRow(row);                       
        } 
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
    
    private void clearFieldsAdd(){
        NoOfWorkingDayslec.setSelectedItem("Lecturer");
        jComboBox2.setSelectedItem("ID");
        jComboBox1.setSelectedItem("group");
        jComboBox4.setSelectedItem("sub-Group");
        startTimeTextBox.setText(null);
        endTimeTextBox.setText(null);
    } 
    
    private void FillComboLecturers(){
        try {
            String bcomboquery = "SELECT * FROM lec";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String lecnames = rst.getString("LNAME");
                NoOfWorkingDayslec.addItem(lecnames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }      
    
     private void FillComboSessions(){
        try {
            String bcomboquery = "SELECT * FROM sessions";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String sessionlist = rst.getString("session_id");
                jComboBox2.addItem(sessionlist);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    
     
     private void FillComboGroups(){
        try {
            String bcomboquery = "SELECT * FROM sgroups";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String grplist = rst.getString("groupid");
                jComboBox1.addItem(grplist);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }     

     private void FillComboSubGroups(){
        try {
            String bcomboquery = "SELECT * FROM sgroups";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String subgrplist = rst.getString("subgroupid");
                jComboBox4.addItem(subgrplist);
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

        Background_pnl = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        btn_addWorkingDays = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageWorkingDays = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addWorkingDays_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addNotAvilableTime = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        NoOfWorkingDayslec = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_clearworkingdays = new javax.swing.JButton();
        addWorkingDays = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        startTimeTextBox = new javax.swing.JTextField();
        endTimeTextBox = new javax.swing.JTextField();
        jp_manageNotAvailableTime = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        display_table = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        btnclearupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        JPanel7 = new javax.swing.JPanel();
        addNotAvailableTime_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageNotAvailabeLectures_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addWorkingDays.setBackground(new java.awt.Color(39, 156, 109));
        btn_addWorkingDays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMousePressed(evt);
            }
        });
        btn_addWorkingDays.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/Add_Icon.png"))); // NOI18N
        btn_addWorkingDays.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Not Available Time");
        btn_addWorkingDays.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

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

        btn_addWorkingDays.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addWorkingDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageWorkingDays.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageWorkingDays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageWorkingDaysMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageWorkingDaysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageWorkingDaysMouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/Manage_Icon.png"))); // NOI18N

        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Not Available Time");

        javax.swing.GroupLayout btn_ManageWorkingDaysLayout = new javax.swing.GroupLayout(btn_ManageWorkingDays);
        btn_ManageWorkingDays.setLayout(btn_ManageWorkingDaysLayout);
        btn_ManageWorkingDaysLayout.setHorizontalGroup(
            btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 214, Short.MAX_VALUE)))
        );
        btn_ManageWorkingDaysLayout.setVerticalGroup(
            btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        SidePanel.add(btn_ManageWorkingDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addWorkingDays_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addWorkingDays_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addWorkingDays_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        addWorkingDays_backBtn.setText("BACK");
        addWorkingDays_backBtn.setToolTipText("Returns Previously Shown Window ");
        addWorkingDays_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWorkingDays_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        addWorkingDays_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkingDays_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addWorkingDays_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addNotAvilableTime.setBackground(new java.awt.Color(247, 247, 247));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Select Lecturer :");

        NoOfWorkingDayslec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lecturer" }));
        NoOfWorkingDayslec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoOfWorkingDayslecActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Start Time :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Select Group :");

        btn_clearworkingdays.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_clearworkingdays.setForeground(new java.awt.Color(255, 255, 255));
        btn_clearworkingdays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        btn_clearworkingdays.setText("CLEAR");
        btn_clearworkingdays.setToolTipText("Click The Clear Button To Clear the data");
        btn_clearworkingdays.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_clearworkingdays.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        btn_clearworkingdays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearworkingdaysActionPerformed(evt);
            }
        });

        addWorkingDays.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addWorkingDays.setForeground(new java.awt.Color(255, 255, 255));
        addWorkingDays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        addWorkingDays.setText("ADD");
        addWorkingDays.setToolTipText("Click The Add Button To Add The Data");
        addWorkingDays.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWorkingDays.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn hover.png"))); // NOI18N
        addWorkingDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkingDaysActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "group" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Select Session ID :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Select Sub Group :");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sub-Group" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("End Time :");

        javax.swing.GroupLayout jp_addNotAvilableTimeLayout = new javax.swing.GroupLayout(jp_addNotAvilableTime);
        jp_addNotAvilableTime.setLayout(jp_addNotAvilableTimeLayout);
        jp_addNotAvilableTimeLayout.setHorizontalGroup(
            jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addNotAvilableTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_addNotAvilableTimeLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(addWorkingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_clearworkingdays, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 227, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addNotAvilableTimeLayout.createSequentialGroup()
                        .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoOfWorkingDayslec, 0, 226, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox1, 0, 226, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(startTimeTextBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox4, 0, 237, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endTimeTextBox))
                        .addGap(74, 74, 74))))
        );
        jp_addNotAvilableTimeLayout.setVerticalGroup(
            jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addNotAvilableTimeLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoOfWorkingDayslec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTimeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_addNotAvilableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWorkingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearworkingdays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jPanel6.add(jp_addNotAvilableTime, "card2");

        jp_manageNotAvailableTime.setBackground(new java.awt.Color(247, 247, 247));

        display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  ID", "Session ID", " Lectuer Name", "  Group ID", "Sub Group ID", "Start Time", "End Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
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
        tableScrollPane.setViewportView(display_table);

        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        btnupdate.setText("REFRESH");
        btnupdate.setToolTipText("Click Update Button To Update Details");
        btnupdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnupdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn hover.png"))); // NOI18N
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnclearupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclearupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnclearupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        btnclearupdate.setText("Search");
        btnclearupdate.setToolTipText("Click Clear Button To Clear the Details");
        btnclearupdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnclearupdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        btnclearupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearupdateActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        btndelete.setText("DELETE");
        btndelete.setToolTipText("Click Delete Button To Delete Details");
        btndelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndelete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select To Search" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_manageNotAvailableTimeLayout = new javax.swing.GroupLayout(jp_manageNotAvailableTime);
        jp_manageNotAvailableTime.setLayout(jp_manageNotAvailableTimeLayout);
        jp_manageNotAvailableTimeLayout.setHorizontalGroup(
            jp_manageNotAvailableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageNotAvailableTimeLayout.createSequentialGroup()
                .addGroup(jp_manageNotAvailableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_manageNotAvailableTimeLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnclearupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_manageNotAvailableTimeLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 113, Short.MAX_VALUE))
            .addGroup(jp_manageNotAvailableTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_manageNotAvailableTimeLayout.setVerticalGroup(
            jp_manageNotAvailableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageNotAvailableTimeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_manageNotAvailableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclearupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addGroup(jp_manageNotAvailableTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jp_manageNotAvailableTime, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new java.awt.CardLayout());

        addNotAvailableTime_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LECTURES NOT AVAILABALE TIME");

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

        javax.swing.GroupLayout addNotAvailableTime_TopBarLayout = new javax.swing.GroupLayout(addNotAvailableTime_TopBar);
        addNotAvailableTime_TopBar.setLayout(addNotAvailableTime_TopBarLayout);
        addNotAvailableTime_TopBarLayout.setHorizontalGroup(
            addNotAvailableTime_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNotAvailableTime_TopBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        addNotAvailableTime_TopBarLayout.setVerticalGroup(
            addNotAvailableTime_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNotAvailableTime_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addNotAvailableTime_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        JPanel7.add(addNotAvailableTime_TopBar, "card2");

        manageNotAvailabeLectures_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE LECTURES NOT AVAILABLE TIME");

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

        javax.swing.GroupLayout manageNotAvailabeLectures_TopbarLayout = new javax.swing.GroupLayout(manageNotAvailabeLectures_Topbar);
        manageNotAvailabeLectures_Topbar.setLayout(manageNotAvailabeLectures_TopbarLayout);
        manageNotAvailabeLectures_TopbarLayout.setHorizontalGroup(
            manageNotAvailabeLectures_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageNotAvailabeLectures_TopbarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        manageNotAvailabeLectures_TopbarLayout.setVerticalGroup(
            manageNotAvailabeLectures_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageNotAvailabeLectures_TopbarLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(manageNotAvailabeLectures_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        JPanel7.add(manageNotAvailabeLectures_Topbar, "card3");

        javax.swing.GroupLayout Background_pnlLayout = new javax.swing.GroupLayout(Background_pnl);
        Background_pnl.setLayout(Background_pnlLayout);
        Background_pnlLayout.setHorizontalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
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

    private void btn_addWorkingDaysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMouseClicked
        // TODO add your handling code here:
        jp_addNotAvilableTime.setVisible(true);
        jp_manageNotAvailableTime.setVisible(false);
        addNotAvailableTime_TopBar.setVisible(true);
        manageNotAvailabeLectures_Topbar.setVisible(false);
        btn_addWorkingDays.setBackground(new java.awt.Color(8,142,88));
        btn_ManageWorkingDays.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addWorkingDaysMouseClicked

    private void btn_addWorkingDaysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addWorkingDaysMouseEntered

    private void btn_addWorkingDaysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addWorkingDaysMouseExited

    private void btn_addWorkingDaysMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addWorkingDaysMousePressed

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MousePressed

    private void btn_ManageWorkingDaysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageWorkingDaysMouseClicked
        // TODO add your handling code here:
        jp_manageNotAvailableTime.setVisible(true);
        jp_addNotAvilableTime.setVisible(false);
        addNotAvailableTime_TopBar.setVisible(false);
        manageNotAvailabeLectures_Topbar.setVisible(true);
        btn_ManageWorkingDays.setBackground(new java.awt.Color(8,142,88));
        btn_addWorkingDays.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageWorkingDaysMouseClicked

    private void btn_ManageWorkingDaysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageWorkingDaysMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageWorkingDaysMouseEntered

    private void btn_ManageWorkingDaysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageWorkingDaysMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageWorkingDaysMouseExited

    private void addWorkingDays_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkingDays_backBtnActionPerformed
        // TODO add your handling code here:
        new UHome().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addWorkingDays_backBtnActionPerformed

    private void NoOfWorkingDayslecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoOfWorkingDayslecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoOfWorkingDayslecActionPerformed

    private void btn_clearworkingdaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearworkingdaysActionPerformed
        // TODO add your handling code here:    
        clearFieldsAdd();
    }//GEN-LAST:event_btn_clearworkingdaysActionPerformed

    private void addWorkingDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkingDaysActionPerformed
        
        this.LectureName = NoOfWorkingDayslec.getSelectedItem().toString();
        this.session_id = Integer.valueOf((String)jComboBox2.getSelectedItem());
        this.student_grp = jComboBox1.getSelectedItem().toString();
        this.student_subgrp = jComboBox4.getSelectedItem().toString();
        this.start_time = startTimeTextBox.getText();
        this.end_time = endTimeTextBox.getText();

        if (NoOfWorkingDayslec.getSelectedItem().toString().equals("Lecturer") || Integer.valueOf((String)jComboBox2.getSelectedItem()).equals("ID") || jComboBox1.getSelectedItem().toString().equals("group") || jComboBox4.getSelectedItem().toString().equals("sub-Group") || startTimeTextBox.getText().equals("") || endTimeTextBox.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

        } else {
            if ("" != NoOfWorkingDayslec.getSelectedItem().toString()) {

                try {
                    String query_roomexits = "select LECTURENAME from LECNOTAVAILABLE where LECTURENAME like '"+'%'+NoOfWorkingDayslec.getSelectedItem().toString()+'%'+"'";
                    Statement st_rooms = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_rooms.executeQuery(query_roomexits);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "This Lecturer Already Exist");

                    } else {

                        try {
                            String query = "insert into LECNOTAVAILABLE(LECTURENAME, SESSIONID, STUDGROUP, STUSUBGROUP, STARTTIME, ENDTIME) "
                            + "values ( ?, ?, ?, ?, ?, ?)";

                            preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, LectureName);
                            preparedStmt.setInt(2, session_id);
                            preparedStmt.setString(3, student_grp);
                            preparedStmt.setString(4, student_subgrp);
                            preparedStmt.setString(5, start_time);
                            preparedStmt.setString(6, end_time);

                            preparedStmt.execute();

                            JOptionPane.showMessageDialog(null, "Not Available Time Added Successfully. \n Thank You!");
                            DefaultTableModel model = (DefaultTableModel) display_table.getModel();
                            model.setRowCount(0);
                            show_LecNotAvailableDetails();

                            //                    buildingNo.setText("");
                            //                    buildingName.setText("");
                            //                    noRooms.setValue("");

                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                            System.err.println("Got an exception!");
                            System.err.println(e.getMessage());
                            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, e);
                        }

                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());
                    Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, e);
                }

            }
        }   
               
    }//GEN-LAST:event_addWorkingDaysActionPerformed

    private void display_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_tableMouseClicked
        // TODO add your handling code here:
        int i = display_table.getSelectedRow();
        TableModel model = display_table.getModel();

        lecNo_rowSelected = model.getValueAt(i,0).toString();
        LectureName = model.getValueAt(i,1).toString();
            // update_workingdays.setSelectedItem(model.getValueAt(i, 2).toString());
            // update_hours.add(2)
       
    }//GEN-LAST:event_display_tableMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        DefaultTableModel model = (DefaultTableModel) display_table.getModel();
        model.setRowCount(0);
        show_LecNotAvailableDetails();       // TODO add your handling code here:       //  String query = "insert into workingdays(workinghours,workingminiutes,noofworkingdays, monday, tuesday, wednesday, thrusday, friday, saterday, sunday) values(?,?,?,?,?,?,?,?,?,?)";

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + lecNo_rowSelected + " - "
            + LectureName + "Not Available Time details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM LECNOTAVAILABLE WHERE LECNOTID = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, lecNo_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Not Available removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) display_table.getModel();
                model.setRowCount(0);
                show_LecNotAvailableDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }//GEN-LAST:event_btndeleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnclearupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearupdateActionPerformed
        // TODO add your handling code here:

       
    }//GEN-LAST:event_btnclearupdateActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(ULecturersNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ULecturersNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ULecturersNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ULecturersNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ULecturersNotAvailableTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JComboBox<String> NoOfWorkingDayslec;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel addNotAvailableTime_TopBar;
    private javax.swing.JButton addWorkingDays;
    private javax.swing.JButton addWorkingDays_backBtn;
    private javax.swing.JPanel btn_ManageWorkingDays;
    private javax.swing.JPanel btn_addWorkingDays;
    private javax.swing.JButton btn_clearworkingdays;
    private javax.swing.JButton btnclearupdate;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTable display_table;
    private javax.swing.JTextField endTimeTextBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jp_addNotAvilableTime;
    private javax.swing.JPanel jp_manageNotAvailableTime;
    private javax.swing.JPanel manageNotAvailabeLectures_Topbar;
    private javax.swing.JTextField startTimeTextBox;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
