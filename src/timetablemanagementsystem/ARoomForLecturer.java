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
public class ARoomForLecturer extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String roomNo_rowSelected;
    private String  lecturer_name, lecturer_subject, lecturer_tag, lecturer_building, lecturer_room;
    private int lecturer_roomID;
    /**
     * Creates new form ARoomForLecturer
     */
    public ARoomForLecturer() {
        initComponents();
        dbconnect();
        show_LecturerRoomDetails();
        FillComboBuildingName();
        FillComboSubjects();
        FillComboLecturer();
        FillComboTags();
        FillComboRooms();        
        btn_addRoomsLecturer.setBackground(new java.awt.Color(8,142,88));
    }
    
    public ArrayList<ARoomLecturerModel> roomLecturerList() {
        
        ArrayList<ARoomLecturerModel> roomLecturerList = new ArrayList<>();
        try {
            String query = "SELECT * FROM lecturerrooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomLecturerModel lecturerroommodel ;

            while(rs.next()){
                lecturerroommodel = new ARoomLecturerModel (rs.getInt("lecturerroom_id"), rs.getString("lecturer_name"), rs.getString("lecturer_tag"), rs.getString("lecturer_subject"), rs.getString("lecturer_building"), rs.getString("lecturer_room"));
                roomLecturerList.add(lecturerroommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomLecturerList;            
    }
    
    public void show_LecturerRoomDetails(){
        
        ArrayList<ARoomLecturerModel> roomLecturerList = roomLecturerList();
        DefaultTableModel tableModel = (DefaultTableModel) table_displayLecturerRoomDetails.getModel();
        
        Object[] row = new Object[6];
        for (int i = 0; i < roomLecturerList.size(); i++) {
            
            row[0] = roomLecturerList.get(i).getId();
            row[1] = roomLecturerList.get(i).getLecturer_name();
            row[2] = roomLecturerList.get(i).getLecturerTag();
            row[3] = roomLecturerList.get(i).getLecturerSubject();
            row[4] = roomLecturerList.get(i).getLecturerBuilding();
            row[5] = roomLecturerList.get(i).getLecturerRoom();
            
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
        roomLecturerName.setSelectedItem("Select Lecturer Name");
        lecturerRoomTagName.setSelectedItem("Select Tag");
        lecturerRoomSubjectName.setSelectedItem("Select Subject");
        lecturerRoomBuildingName.setSelectedItem("Select Building");
        lecturerRoomName.setSelectedItem("Select Room");
    }   
    
    
    private void FillComboSubjects(){
        try {
            String bcomboquery = "SELECT * FROM subjects";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String snames = rst.getString("subject_name");
                lecturerRoomSubjectName.addItem(snames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    

    private void FillComboLecturer(){
        try {
            String bcomboquery = "SELECT * FROM lecturers";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String lnames = rst.getString("lecturer_name");
                roomLecturerName.addItem(lnames);
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
                lecturerRoomTagName.addItem(tagnames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    
    
    private void FillComboBuildingName(){
        try {
            String bcomboquery = "SELECT * FROM BUILDINGS";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String bnames = rst.getString("building_name");
                lecturerRoomBuildingName.addItem(bnames);
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
                lecturerRoomName.addItem(roomnames);
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
        btn_addRoomsLecturer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageRoomsLecturer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addRoomSubject_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addRoomsLecturer = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_roomAddSubject = new javax.swing.JButton();
        roomLecturerName = new javax.swing.JComboBox<>();
        lecturerRoomTagName = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        lecturerRoomSubjectName = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        lecturerRoomName = new javax.swing.JComboBox<>();
        lecturerRoomBuildingName = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jp_manageRoomsLecturer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_displayLecturerRoomDetails = new javax.swing.JTable();
        btn_deleteManageLecturerRoom = new javax.swing.JButton();
        btn_clearManage = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        btn_searchManageRoom = new javax.swing.JButton();
        btn_refreshManageRoom = new javax.swing.JButton();
        btn_viewRoomsTable = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        addRoomLecturer_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageRoomLecturer_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addRoomsLecturer.setBackground(new java.awt.Color(39, 156, 109));
        btn_addRoomsLecturer.setToolTipText("If you click this you can view add room page");
        btn_addRoomsLecturer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addRoomsLecturerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addRoomsLecturerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addRoomsLecturerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addRoomsLecturerMousePressed(evt);
            }
        });
        btn_addRoomsLecturer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Add_Icon.png"))); // NOI18N
        btn_addRoomsLecturer.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Room For Lecturer");
        btn_addRoomsLecturer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_addRoomsLecturer.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addRoomsLecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageRoomsLecturer.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageRoomsLecturer.setToolTipText("If you click this you can view manage rooms page");
        btn_ManageRoomsLecturer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsLecturerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsLecturerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsLecturerMouseExited(evt);
            }
        });
        btn_ManageRoomsLecturer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Manage_Icon.png"))); // NOI18N
        btn_ManageRoomsLecturer.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Lecturer Room");
        btn_ManageRoomsLecturer.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_ManageRoomsLecturer.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageRoomsLecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

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

        jp_addRoomsLecturer.setBackground(new java.awt.Color(247, 247, 247));
        jp_addRoomsLecturer.setPreferredSize(new java.awt.Dimension(625, 600));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Lecturer Name:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Select Tag :");

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

        roomLecturerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer Name" }));
        roomLecturerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomLecturerNameActionPerformed(evt);
            }
        });

        lecturerRoomTagName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag" }));
        lecturerRoomTagName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturerRoomTagNameActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Select Subject :");

        lecturerRoomSubjectName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject" }));
        lecturerRoomSubjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturerRoomSubjectNameActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Select Room :");

        lecturerRoomName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));

        lecturerRoomBuildingName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building" }));
        lecturerRoomBuildingName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturerRoomBuildingNameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Select Building :");

        javax.swing.GroupLayout jp_addRoomsLecturerLayout = new javax.swing.GroupLayout(jp_addRoomsLecturer);
        jp_addRoomsLecturer.setLayout(jp_addRoomsLecturerLayout);
        jp_addRoomsLecturerLayout.setHorizontalGroup(
            jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsLecturerLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsLecturerLayout.createSequentialGroup()
                        .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_addRoomsLecturerLayout.createSequentialGroup()
                                .addComponent(roomLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(jp_addRoomsLecturerLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsLecturerLayout.createSequentialGroup()
                                .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lecturerRoomSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jp_addRoomsLecturerLayout.createSequentialGroup()
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(66, 66, 66)))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lecturerRoomName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lecturerRoomTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lecturerRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsLecturerLayout.createSequentialGroup()
                        .addComponent(btn_roomAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        jp_addRoomsLecturerLayout.setVerticalGroup(
            jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsLecturerLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lecturerRoomTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lecturerRoomSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lecturerRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lecturerRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jp_addRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_roomAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        jPanel6.add(jp_addRoomsLecturer, "card2");

        jp_manageRoomsLecturer.setBackground(new java.awt.Color(247, 247, 247));

        table_displayLecturerRoomDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lecturer Name", "Tag", "Subject", "Building", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_displayLecturerRoomDetails.getTableHeader().setReorderingAllowed(false);
        table_displayLecturerRoomDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_displayLecturerRoomDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_displayLecturerRoomDetails);

        btn_deleteManageLecturerRoom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_deleteManageLecturerRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteManageLecturerRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_deleteManageLecturerRoom.setText("DELETE");
        btn_deleteManageLecturerRoom.setToolTipText("if you click this you can delete selected item from the database");
        btn_deleteManageLecturerRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_deleteManageLecturerRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        btn_deleteManageLecturerRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteManageLecturerRoomRoomActionPerformed(evt);
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

        javax.swing.GroupLayout jp_manageRoomsLecturerLayout = new javax.swing.GroupLayout(jp_manageRoomsLecturer);
        jp_manageRoomsLecturer.setLayout(jp_manageRoomsLecturerLayout);
        jp_manageRoomsLecturerLayout.setHorizontalGroup(
            jp_manageRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsLecturerLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_manageRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_manageRoomsLecturerLayout.createSequentialGroup()
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(jp_manageRoomsLecturerLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btn_deleteManageLecturerRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_manageRoomsLecturerLayout.setVerticalGroup(
            jp_manageRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsLecturerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_manageRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_manageRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField)
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jp_manageRoomsLecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteManageLecturerRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel6.add(jp_manageRoomsLecturer, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addRoomLecturer_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD ROOMS FOR LECTURER");

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

        javax.swing.GroupLayout addRoomLecturer_TopBarLayout = new javax.swing.GroupLayout(addRoomLecturer_TopBar);
        addRoomLecturer_TopBar.setLayout(addRoomLecturer_TopBarLayout);
        addRoomLecturer_TopBarLayout.setHorizontalGroup(
            addRoomLecturer_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomLecturer_TopBarLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(43, 43, 43)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addRoomLecturer_TopBarLayout.setVerticalGroup(
            addRoomLecturer_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomLecturer_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addRoomLecturer_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(addRoomLecturer_TopBar);

        manageRoomLecturer_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE LECTURER ROOMS");

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

        javax.swing.GroupLayout manageRoomLecturer_TopbarLayout = new javax.swing.GroupLayout(manageRoomLecturer_Topbar);
        manageRoomLecturer_Topbar.setLayout(manageRoomLecturer_TopbarLayout);
        manageRoomLecturer_TopbarLayout.setHorizontalGroup(
            manageRoomLecturer_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomLecturer_TopbarLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageRoomLecturer_TopbarLayout.setVerticalGroup(
            manageRoomLecturer_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomLecturer_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageRoomLecturer_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(manageRoomLecturer_Topbar);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addRoomsLecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsLecturerMouseClicked
        // TODO add your handling code here:
        jp_addRoomsLecturer.setVisible(true);
        jp_manageRoomsLecturer.setVisible(false);
        addRoomLecturer_TopBar.setVisible(true);
        manageRoomLecturer_Topbar.setVisible(false);
        btn_addRoomsLecturer.setBackground(new java.awt.Color(8,142,88));
        btn_ManageRoomsLecturer.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addRoomsLecturerMouseClicked

    private void btn_addRoomsLecturerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsLecturerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsLecturerMouseEntered

    private void btn_addRoomsLecturerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsLecturerMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsLecturerMouseExited

    private void btn_addRoomsLecturerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsLecturerMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsLecturerMousePressed

    private void btn_ManageRoomsLecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsLecturerMouseClicked
        // TODO add your handling code here:
        jp_manageRoomsLecturer.setVisible(true);
        jp_addRoomsLecturer.setVisible(false);
        addRoomLecturer_TopBar.setVisible(false);
        manageRoomLecturer_Topbar.setVisible(true);
        btn_ManageRoomsLecturer.setBackground(new java.awt.Color(8,142,88));
        btn_addRoomsLecturer.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageRoomsLecturerMouseClicked

    private void btn_ManageRoomsLecturerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsLecturerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageRoomsLecturerMouseEntered

    private void btn_ManageRoomsLecturerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsLecturerMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageRoomsLecturerMouseExited

    private void addRoomSubject_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomSubject_backBtnActionPerformed
        // TODO add your handling code here:
        ALocationHome aaLocationHome = new ALocationHome();
        aaLocationHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoomSubject_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFieldsAdd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_roomAddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roomAddSubjectActionPerformed
        // TODO add your handling code here:
        this.lecturer_name = roomLecturerName.getSelectedItem().toString();
        this.lecturer_tag = lecturerRoomTagName.getSelectedItem().toString();
        this.lecturer_subject = lecturerRoomSubjectName.getSelectedItem().toString();
        this.lecturer_building = lecturerRoomBuildingName.getSelectedItem().toString();
        this.lecturer_room = lecturerRoomName.getSelectedItem().toString();

        if (roomLecturerName.getSelectedItem().toString().equals("Select Lecturer Name") || lecturerRoomTagName.getSelectedItem().toString().equals("Select Tag") || lecturerRoomSubjectName.getSelectedItem().toString().equals("Select Subject") || lecturerRoomBuildingName.getSelectedItem().toString().equals("Select Building") || lecturerRoomName.getSelectedItem().toString().equals("Select Room")) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

        } else {
            if ("" != roomLecturerName.getSelectedItem().toString()) {

                try {
                    String query_roomexits = "select lecturer_room from lecturerrooms where lecturer_room like '"+'%'+lecturerRoomName.getSelectedItem().toString()+'%'+"'";
                    Statement st_rooms = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_rooms.executeQuery(query_roomexits);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "This Lecturer Room Already Exist");

                    } else {

                        try {
                            String query = "insert into lecturerrooms(lecturer_name, lecturer_tag, lecturer_subject, lecturer_building, lecturer_room) "
                            + "values ( ?, ?, ?, ?, ? )";

                            preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, lecturer_name);
                            preparedStmt.setString(2, lecturer_tag);
                            preparedStmt.setString(3, lecturer_subject);
                            preparedStmt.setString(4, lecturer_building);
                            preparedStmt.setString(5, lecturer_room);

                            preparedStmt.execute();

                            JOptionPane.showMessageDialog(null, "Room Assigned Successfully. \n Thank You!");
                            DefaultTableModel model = (DefaultTableModel) table_displayLecturerRoomDetails.getModel();
                            model.setRowCount(0);
                            show_LecturerRoomDetails();

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

    private void roomLecturerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomLecturerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomLecturerNameActionPerformed

    private void lecturerRoomTagNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturerRoomTagNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturerRoomTagNameActionPerformed

    private void lecturerRoomSubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturerRoomSubjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturerRoomSubjectNameActionPerformed

    private void lecturerRoomBuildingNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturerRoomBuildingNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturerRoomBuildingNameActionPerformed

    private void table_displayLecturerRoomDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_displayLecturerRoomDetailsMouseClicked
        // TODO add your handling code here:
        int i = table_displayLecturerRoomDetails.getSelectedRow();
        TableModel model = table_displayLecturerRoomDetails.getModel();

        roomNo_rowSelected = model.getValueAt(i,0).toString();
        lecturer_name = model.getValueAt(i,1).toString();

    }//GEN-LAST:event_table_displayLecturerRoomDetailsMouseClicked

    private void btn_deleteManageLecturerRoomRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteManageLecturerRoomRoomActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + roomNo_rowSelected + " - "
            + lecturer_name + " assigned room details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM lecturerrooms WHERE lecturerroom_id = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, roomNo_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Lecturer Room removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) table_displayLecturerRoomDetails.getModel();
                model.setRowCount(0);
                show_LecturerRoomDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteManageLecturerRoomRoomActionPerformed

    private void btn_clearManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearManageMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displayLecturerRoomDetails.getModel();
        model.setRowCount(0);
        show_LecturerRoomDetails();
    }//GEN-LAST:event_btn_clearManageMouseClicked

    private void btn_clearManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearManageActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)table_displayLecturerRoomDetails.getModel();
        String search = searchTextField.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        table_displayLecturerRoomDetails.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void btn_searchManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchManageRoomActionPerformed

    private void btn_refreshManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displayLecturerRoomDetails.getModel();
        model.setRowCount(0);
        show_LecturerRoomDetails();
    }//GEN-LAST:event_btn_refreshManageRoomMouseClicked

    private void btn_refreshManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshManageRoomActionPerformed

    private void btn_viewRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRoomsTableActionPerformed
        // TODO add your handling code here:
        AViewLecturerRoomTable aViewLecturerRoomTable = new AViewLecturerRoomTable();
        aViewLecturerRoomTable.setVisible(true);
    }//GEN-LAST:event_btn_viewRoomsTableActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(ARoomForLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ARoomForLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ARoomForLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ARoomForLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ARoomForLecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel addRoomLecturer_TopBar;
    private javax.swing.JButton addRoomSubject_backBtn;
    private javax.swing.JPanel btn_ManageRoomsLecturer;
    private javax.swing.JPanel btn_addRoomsLecturer;
    private javax.swing.JButton btn_clearManage;
    private javax.swing.JButton btn_deleteManageLecturerRoom;
    private javax.swing.JButton btn_refreshManageRoom;
    private javax.swing.JButton btn_roomAddSubject;
    private javax.swing.JButton btn_searchManageRoom;
    private javax.swing.JButton btn_viewRoomsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jp_addRoomsLecturer;
    private javax.swing.JPanel jp_manageRoomsLecturer;
    private javax.swing.JComboBox<String> lecturerRoomBuildingName;
    private javax.swing.JComboBox<String> lecturerRoomName;
    private javax.swing.JComboBox<String> lecturerRoomSubjectName;
    private javax.swing.JComboBox<String> lecturerRoomTagName;
    private javax.swing.JPanel manageRoomLecturer_Topbar;
    private javax.swing.JComboBox<String> roomLecturerName;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table_displayLecturerRoomDetails;
    // End of variables declaration//GEN-END:variables
}
