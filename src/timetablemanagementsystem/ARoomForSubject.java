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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ashan
 */
public class ARoomForSubject extends javax.swing.JFrame {

    /**
     * Creates new form ARoomForSubject
     */
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String roomNo_rowSelected;
    private String  subject_name, subject_lecturer, subject_tag, subject_building, subject_room;
    private String  subject_code;
    
    
    public ARoomForSubject() {
        initComponents();
        dbconnect();
        show_SubjectroomDetails();
        FillComboBuildingName();
        FillComboSubjects();
        FillComboLecturer();
        FillComboTags();
        FillComboRooms();
        btn_addRoomsSubject.setBackground(new java.awt.Color(8,142,88));
    }
    
    public ArrayList<ARoomSubjectModel> roomSubjectList() {
        
        ArrayList<ARoomSubjectModel> roomSubjectList = new ArrayList<>();
        try {
            String query = "SELECT * FROM subjectrooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomSubjectModel subjectroommodel ;

            while(rs.next()){
                subjectroommodel = new ARoomSubjectModel ( rs.getString("roomsubject_code"), rs.getString("roomsubject_name"), rs.getString("subject_lecturer"), rs.getString("subject_tag"), rs.getString("subject_building"), rs.getString("subject_room"));
                roomSubjectList.add(subjectroommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomSubjectList;            
    }
    
    public void show_SubjectroomDetails(){
        
        ArrayList<ARoomSubjectModel> roomSubjectList = roomSubjectList();
        DefaultTableModel tableModel = (DefaultTableModel) table_displaySubjectRoomDetails.getModel();
        
        Object[] row = new Object[6];
        for (int i = 0; i < roomSubjectList.size(); i++) {
            
            row[0] = roomSubjectList.get(i).getSubjectCode();
            row[1] = roomSubjectList.get(i).getSubjectName();
            row[2] = roomSubjectList.get(i).getSubjectLecturer();
            row[3] = roomSubjectList.get(i).getSubjectTag();
            row[4] = roomSubjectList.get(i).getSubjectBuilding();
            row[5] = roomSubjectList.get(i).getSubjectRoom();
            
            tableModel.addRow(row);                       
        } 
    }
    
    private void clearFieldsAdd(){
        roomSubjectCode.setSelectedItem("Select Subject Code");
        subjectNameForRoom.setSelectedItem("Select Subject Name");
        subjectRoomLecturerName.setSelectedItem("Select Lecturer");
        subjectRoomTagName.setSelectedItem("Select Tag");
        subjectroomBuildingName.setSelectedItem("Select Building");
        subjectRoomName.setSelectedItem("Select Room");
    }
    
    
    private void FillComboBuildingName(){
        try {
            String bcomboquery = "SELECT * FROM BUILDINGS";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String bnames = rst.getString("building_name");
                subjectroomBuildingName.addItem(bnames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void FillComboSubjects(){
        try {
            String bcomboquery = "SELECT * FROM subject";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String scodes = rst.getString("subcode");
                String snames = rst.getString("sname");
                roomSubjectCode.addItem(scodes);
                subjectNameForRoom.addItem(snames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void FillComboLecturer(){
        try {
            String bcomboquery = "SELECT * FROM lec";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String lnames = rst.getString("lname");
                subjectRoomLecturerName.addItem(lnames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    
    
    private void FillComboTags(){
        try {
            String bcomboquery = "SELECT * FROM tags";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String tagnames = rst.getString("tag_name");
                subjectRoomTagName.addItem(tagnames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void FillComboRooms(){
        try {
            String bcomboquery = "SELECT * FROM rooms";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String roomnames = rst.getString("room_name");
                subjectRoomName.addItem(roomnames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        btn_addRoomsSubject = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageRoomsSubject = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addRoomSubject_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addRoomsSubject = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_roomAddSubject = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        roomSubjectCode = new javax.swing.JComboBox<>();
        subjectRoomName = new javax.swing.JComboBox<>();
        subjectNameForRoom = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        subjectRoomLecturerName = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        subjectroomBuildingName = new javax.swing.JComboBox<>();
        subjectRoomTagName = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jp_manageRoomsSubject = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_displaySubjectRoomDetails = new javax.swing.JTable();
        btn_deleteManageRoom = new javax.swing.JButton();
        btn_clearManage = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        btn_searchManageRoom = new javax.swing.JButton();
        btn_refreshManageRoom = new javax.swing.JButton();
        btn_viewRoomsTable = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        addRoomSubject_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageRoomSubject_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addRoomsSubject.setBackground(new java.awt.Color(39, 156, 109));
        btn_addRoomsSubject.setToolTipText("If you click this you can view add room page");
        btn_addRoomsSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addRoomsSubjectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addRoomsSubjectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addRoomsSubjectMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addRoomsSubjectMousePressed(evt);
            }
        });
        btn_addRoomsSubject.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Add_Icon.png"))); // NOI18N
        btn_addRoomsSubject.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Room For Subject");
        btn_addRoomsSubject.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 20, 160, -1));

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

        btn_addRoomsSubject.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addRoomsSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageRoomsSubject.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageRoomsSubject.setToolTipText("If you click this you can view manage rooms page");
        btn_ManageRoomsSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsSubjectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsSubjectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsSubjectMouseExited(evt);
            }
        });
        btn_ManageRoomsSubject.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Manage_Icon.png"))); // NOI18N
        btn_ManageRoomsSubject.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Subject Room");
        btn_ManageRoomsSubject.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, -1));

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

        btn_ManageRoomsSubject.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageRoomsSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addRoomSubject_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addRoomSubject_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomSubject_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        addRoomSubject_backBtn.setText("BACK");
        addRoomSubject_backBtn.setToolTipText("Go Back");
        addRoomSubject_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addRoomSubject_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        addRoomSubject_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomSubject_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addRoomSubject_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addRoomsSubject.setBackground(new java.awt.Color(247, 247, 247));
        jp_addRoomsSubject.setPreferredSize(new java.awt.Dimension(625, 600));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Select Subject Code:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Select Subject Name :");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.setToolTipText("If you click this you clear all fields");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_roomAddSubject.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_roomAddSubject.setForeground(new java.awt.Color(255, 255, 255));
        btn_roomAddSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_roomAddSubject.setText("ADD");
        btn_roomAddSubject.setToolTipText("If you click this iserted data goes to database");
        btn_roomAddSubject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_roomAddSubject.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_roomAddSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_roomAddSubjectActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Select Room:");

        roomSubjectCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Code" }));
        roomSubjectCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomSubjectCodeActionPerformed(evt);
            }
        });

        subjectRoomName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));
        subjectRoomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectRoomNameActionPerformed(evt);
            }
        });

        subjectNameForRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Name" }));
        subjectNameForRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectNameForRoomActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Select Lecturer :");

        subjectRoomLecturerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer" }));
        subjectRoomLecturerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectRoomLecturerNameActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Select Building:");

        subjectroomBuildingName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building" }));

        subjectRoomTagName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag" }));
        subjectRoomTagName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectRoomTagNameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Select Tag :");

        javax.swing.GroupLayout jp_addRoomsSubjectLayout = new javax.swing.GroupLayout(jp_addRoomsSubject);
        jp_addRoomsSubject.setLayout(jp_addRoomsSubjectLayout);
        jp_addRoomsSubjectLayout.setHorizontalGroup(
            jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsSubjectLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsSubjectLayout.createSequentialGroup()
                        .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_addRoomsSubjectLayout.createSequentialGroup()
                                .addComponent(roomSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(jp_addRoomsSubjectLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsSubjectLayout.createSequentialGroup()
                                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(subjectRoomLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jp_addRoomsSubjectLayout.createSequentialGroup()
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(66, 66, 66)))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subjectroomBuildingName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subjectNameForRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subjectRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subjectRoomTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsSubjectLayout.createSequentialGroup()
                        .addComponent(btn_roomAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        jp_addRoomsSubjectLayout.setVerticalGroup(
            jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsSubjectLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectNameForRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectRoomLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectRoomTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectroomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jp_addRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_roomAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        jPanel6.add(jp_addRoomsSubject, "card2");

        jp_manageRoomsSubject.setBackground(new java.awt.Color(247, 247, 247));

        table_displaySubjectRoomDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room Subject No", "Subject Name", "Lecturer Name", "Tag", "Building", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_displaySubjectRoomDetails.getTableHeader().setReorderingAllowed(false);
        table_displaySubjectRoomDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_displaySubjectRoomDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_displaySubjectRoomDetails);

        btn_deleteManageRoom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_deleteManageRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteManageRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_deleteManageRoom.setText("DELETE");
        btn_deleteManageRoom.setToolTipText("if you click this you can delete selected item from the database");
        btn_deleteManageRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_deleteManageRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        btn_deleteManageRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteManageRoomRoomActionPerformed(evt);
            }
        });

        btn_clearManage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_clearManage.setForeground(new java.awt.Color(255, 255, 255));
        btn_clearManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_clearManage.setText("CANCEL");
        btn_clearManage.setToolTipText("If you click this all fields will be empy");
        btn_clearManage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_clearManage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        btn_clearManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clearManageMouseClicked(evt);
            }
        });
        btn_clearManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearManageActionPerformed(evt);
            }
        });

        searchTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        btn_searchManageRoom.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_searchManageRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchManageRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_searchManageRoom.setText("Search");
        btn_searchManageRoom.setToolTipText("If you clcik this you can search all details of rooms");
        btn_searchManageRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_searchManageRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_searchManageRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchManageRoomActionPerformed(evt);
            }
        });

        btn_refreshManageRoom.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_refreshManageRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_refreshManageRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_refreshManageRoom.setText("Refresh");
        btn_refreshManageRoom.setToolTipText("If you click this you refresh page");
        btn_refreshManageRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refreshManageRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_refreshManageRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshManageRoomMouseClicked(evt);
            }
        });
        btn_refreshManageRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshManageRoomActionPerformed(evt);
            }
        });

        btn_viewRoomsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_viewRoomsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewRoomsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_viewRoomsTable.setText("View Table");
        btn_viewRoomsTable.setToolTipText("If you click this you can view only datatable");
        btn_viewRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_viewRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_viewRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewRoomsTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_manageRoomsSubjectLayout = new javax.swing.GroupLayout(jp_manageRoomsSubject);
        jp_manageRoomsSubject.setLayout(jp_manageRoomsSubjectLayout);
        jp_manageRoomsSubjectLayout.setHorizontalGroup(
            jp_manageRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsSubjectLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_manageRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_manageRoomsSubjectLayout.createSequentialGroup()
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(jp_manageRoomsSubjectLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btn_deleteManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_manageRoomsSubjectLayout.setVerticalGroup(
            jp_manageRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsSubjectLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_manageRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_manageRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField)
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jp_manageRoomsSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel6.add(jp_manageRoomsSubject, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addRoomSubject_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD ROOMS FOR SUBJECT");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.setToolTipText("Logout from the system");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addRoomSubject_TopBarLayout = new javax.swing.GroupLayout(addRoomSubject_TopBar);
        addRoomSubject_TopBar.setLayout(addRoomSubject_TopBarLayout);
        addRoomSubject_TopBarLayout.setHorizontalGroup(
            addRoomSubject_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomSubject_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addRoomSubject_TopBarLayout.setVerticalGroup(
            addRoomSubject_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomSubject_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addRoomSubject_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(addRoomSubject_TopBar);

        manageRoomSubject_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE SUBJECT ROOMS");

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

        javax.swing.GroupLayout manageRoomSubject_TopbarLayout = new javax.swing.GroupLayout(manageRoomSubject_Topbar);
        manageRoomSubject_Topbar.setLayout(manageRoomSubject_TopbarLayout);
        manageRoomSubject_TopbarLayout.setHorizontalGroup(
            manageRoomSubject_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomSubject_TopbarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageRoomSubject_TopbarLayout.setVerticalGroup(
            manageRoomSubject_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomSubject_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageRoomSubject_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(manageRoomSubject_Topbar);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addRoomsSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSubjectMouseClicked
        // TODO add your handling code here:
        jp_addRoomsSubject.setVisible(true);
        jp_manageRoomsSubject.setVisible(false);
        addRoomSubject_TopBar.setVisible(true);
        manageRoomSubject_Topbar.setVisible(false);
        btn_addRoomsSubject.setBackground(new java.awt.Color(8,142,88));
        btn_ManageRoomsSubject.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addRoomsSubjectMouseClicked

    private void btn_addRoomsSubjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSubjectMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsSubjectMouseEntered

    private void btn_addRoomsSubjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSubjectMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsSubjectMouseExited

    private void btn_addRoomsSubjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSubjectMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsSubjectMousePressed

    private void btn_ManageRoomsSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsSubjectMouseClicked
        // TODO add your handling code here:
        jp_manageRoomsSubject.setVisible(true);
        jp_addRoomsSubject.setVisible(false);
        addRoomSubject_TopBar.setVisible(false);
        manageRoomSubject_Topbar.setVisible(true);
        btn_ManageRoomsSubject.setBackground(new java.awt.Color(8,142,88));
        btn_addRoomsSubject.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageRoomsSubjectMouseClicked

    private void btn_ManageRoomsSubjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsSubjectMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageRoomsSubjectMouseEntered

    private void btn_ManageRoomsSubjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsSubjectMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageRoomsSubjectMouseExited

    private void addRoomSubject_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomSubject_backBtnActionPerformed
        // TODO add your handling code here:
        AAssignRooms aAssignRooms = new AAssignRooms();
        aAssignRooms.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoomSubject_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFieldsAdd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_roomAddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roomAddSubjectActionPerformed
        // TODO add your handling code here:
        this.subject_code = roomSubjectCode.getSelectedItem().toString();
        this.subject_name = subjectNameForRoom.getSelectedItem().toString();
        this.subject_lecturer = subjectRoomLecturerName.getSelectedItem().toString();
        this.subject_tag = subjectRoomTagName.getSelectedItem().toString();
        this.subject_building = subjectroomBuildingName.getSelectedItem().toString();
        this.subject_room =  subjectRoomName.getSelectedItem().toString();

        if (roomSubjectCode.getSelectedItem().toString().equals("Select Subject Code") || subjectNameForRoom.getSelectedItem().toString().equals("Select Subject Name") || subjectRoomLecturerName.getSelectedItem().toString().equals("Select Lecturer") || subjectRoomTagName.getSelectedItem().toString().equals("Select Tag") || subjectroomBuildingName.getSelectedItem().toString().equals("Select Building") || subjectRoomName.getSelectedItem().toString().equals("Select Room")) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

        } else {
            if ("" != roomSubjectCode.getSelectedItem().toString()) {

                try {
                    String query_roomexits = "select subject_room from subjectrooms where subject_room like '"+'%'+subjectRoomName.getSelectedItem().toString()+'%'+"'";
                    Statement st_rooms = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_rooms.executeQuery(query_roomexits);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "This Subject Room Already Exist");

                    } else {

                        try {
                            String query = "insert into subjectrooms(roomsubject_code, roomsubject_name, subject_lecturer, subject_tag, subject_building, subject_room) "
                            + "values ( ?, ?, ?, ?, ?, ? )";

                            preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, subject_code);
                            preparedStmt.setString(2, subject_name);
                            preparedStmt.setString(3, subject_lecturer);
                            preparedStmt.setString(4, subject_tag);
                            preparedStmt.setString(5, subject_building);
                            preparedStmt.setString(6, subject_room);

                            preparedStmt.execute();

                            JOptionPane.showMessageDialog(null, "Room Assigned Successfully. \n Thank You!");
                            DefaultTableModel model = (DefaultTableModel) table_displaySubjectRoomDetails.getModel();
                            model.setRowCount(0);
                            show_SubjectroomDetails();

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
    }//GEN-LAST:event_btn_roomAddSubjectActionPerformed

    private void roomSubjectCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomSubjectCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomSubjectCodeActionPerformed

    private void table_displaySubjectRoomDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_displaySubjectRoomDetailsMouseClicked
        // TODO add your handling code here:
        int i = table_displaySubjectRoomDetails.getSelectedRow();
        TableModel model = table_displaySubjectRoomDetails.getModel();
        
        roomNo_rowSelected = model.getValueAt(i,0).toString();
        subject_name = model.getValueAt(i,1).toString();
     
    }//GEN-LAST:event_table_displaySubjectRoomDetailsMouseClicked

    private void btn_deleteManageRoomRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteManageRoomRoomActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + roomNo_rowSelected + " - "
            + subject_name + " details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM subjectrooms WHERE roomsubject_code = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, roomNo_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Subject Room removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) table_displaySubjectRoomDetails.getModel();
                model.setRowCount(0);
                show_SubjectroomDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteManageRoomRoomActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)table_displaySubjectRoomDetails.getModel();
        String search = searchTextField.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        table_displaySubjectRoomDetails.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void btn_searchManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchManageRoomActionPerformed

    private void btn_refreshManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displaySubjectRoomDetails.getModel();
        model.setRowCount(0);
        show_SubjectroomDetails();
    }//GEN-LAST:event_btn_refreshManageRoomMouseClicked

    private void btn_refreshManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshManageRoomActionPerformed

    private void btn_viewRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRoomsTableActionPerformed
        // TODO add your handling code here:
        AViewSubjectRoomTable aViewSubjectRoomTable = new AViewSubjectRoomTable();
        aViewSubjectRoomTable.setVisible(true);
    }//GEN-LAST:event_btn_viewRoomsTableActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void subjectRoomLecturerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectRoomLecturerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectRoomLecturerNameActionPerformed

    private void subjectRoomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectRoomNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectRoomNameActionPerformed

    private void subjectNameForRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectNameForRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectNameForRoomActionPerformed

    private void btn_clearManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearManageActionPerformed

    private void subjectRoomTagNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectRoomTagNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectRoomTagNameActionPerformed

    private void btn_clearManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearManageMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displaySubjectRoomDetails.getModel();
        model.setRowCount(0);
        show_SubjectroomDetails();        
    }//GEN-LAST:event_btn_clearManageMouseClicked

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
            java.util.logging.Logger.getLogger(ARoomForSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ARoomForSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ARoomForSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ARoomForSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ARoomForSubject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel addRoomSubject_TopBar;
    private javax.swing.JButton addRoomSubject_backBtn;
    private javax.swing.JPanel btn_ManageRoomsSubject;
    private javax.swing.JPanel btn_addRoomsSubject;
    private javax.swing.JButton btn_clearManage;
    private javax.swing.JButton btn_deleteManageRoom;
    private javax.swing.JButton btn_refreshManageRoom;
    private javax.swing.JButton btn_roomAddSubject;
    private javax.swing.JButton btn_searchManageRoom;
    private javax.swing.JButton btn_viewRoomsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_addRoomsSubject;
    private javax.swing.JPanel jp_manageRoomsSubject;
    private javax.swing.JPanel manageRoomSubject_Topbar;
    private javax.swing.JComboBox<String> roomSubjectCode;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> subjectNameForRoom;
    private javax.swing.JComboBox<String> subjectRoomLecturerName;
    private javax.swing.JComboBox<String> subjectRoomName;
    private javax.swing.JComboBox<String> subjectRoomTagName;
    private javax.swing.JComboBox<String> subjectroomBuildingName;
    private javax.swing.JTable table_displaySubjectRoomDetails;
    // End of variables declaration//GEN-END:variables
}
