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
public class ARoomForSession extends javax.swing.JFrame {
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String roomNo_rowSelected;    
    private String  session_name, session_building, session_room;
    private int session_roomID;
    /**
     * Creates new form ARoomForSession
     */
    public ARoomForSession() {
        initComponents();
        dbconnect();
        show_SessionRoomDetails();
        FillComboSessions();
        FillComboBuildingName();
        FillComboRooms();
        btn_addRoomsSession.setBackground(new java.awt.Color(8,142,88));
    }

    public ArrayList<ARoomSessionModel> roomSessionList() {
        
        ArrayList<ARoomSessionModel> roomSessionList = new ArrayList<>();
        try {
            String query = "SELECT * FROM sessionrooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomSessionModel sessionroommodel ;

            while(rs.next()){
                sessionroommodel = new ARoomSessionModel (rs.getInt("sessionroom_id"), rs.getString("session_name"), rs.getString("lecture_1"), rs.getString("lecture_2"), rs.getString("lecture_3"), rs.getString("subject_code"), rs.getString("subject_name"), rs.getString("group_id"), rs.getString("tag"), rs.getString("buildings"), rs.getString("rooms"));
                roomSessionList.add(sessionroommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomSessionList;            
    }
    
    public void show_SessionRoomDetails(){
        
        ArrayList<ARoomSessionModel> roomSessionList = roomSessionList();
        DefaultTableModel tableModel = (DefaultTableModel) table_displaySessionRoomDetails.getModel();
        
        Object[] row = new Object[12];
        for (int i = 0; i < roomSessionList.size(); i++) {
            
            row[0] = roomSessionList.get(i).getId();
            row[1] = roomSessionList.get(i).getSession_name();
            row[2] = roomSessionList.get(i).getLecture_one();
            row[3] = roomSessionList.get(i).getLecture_two();
            row[4] = roomSessionList.get(i).getLecture_three();
            row[5] = roomSessionList.get(i).getSubject_code();
            row[6] = roomSessionList.get(i).getSubject_name();
            row[7] = roomSessionList.get(i).getGroup_id();
            row[8] = roomSessionList.get(i).getSeesion_tag();
            row[9] = roomSessionList.get(i).getSessionBuilding();
            row[10] = roomSessionList.get(i).getSessionRoom();
            
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
        roomSessionName.setSelectedItem("Select Session");
        sessionRoomBuildingName.setSelectedItem("Select Building");
        sessionRoomName.setSelectedItem("Select Room");
    }     
    
    
    private void FillComboSessions(){
        try {
            String bcomboquery = "SELECT * FROM sessions";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String sessionnames = rst.getString("session_name");
                roomSessionName.addItem(sessionnames);
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
                sessionRoomBuildingName.addItem(bnames);
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
                sessionRoomName.addItem(roomnames);
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
        btn_addRoomsSession = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageRoomsSession = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addRoomSession_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addRoomsSession = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_roomAddSession = new javax.swing.JButton();
        roomSessionName = new javax.swing.JComboBox<>();
        sessionRoomBuildingName = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        sessionRoomName = new javax.swing.JComboBox<>();
        jp_manageRoomsSession = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_displaySessionRoomDetails = new javax.swing.JTable();
        btn_deleteManageSessionRoom = new javax.swing.JButton();
        btn_clearManage = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        btn_searchManageRoom = new javax.swing.JButton();
        btn_refreshManageRoom = new javax.swing.JButton();
        btn_viewRoomsTable = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        addRoomSession_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageRoomSession_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addRoomsSession.setBackground(new java.awt.Color(39, 156, 109));
        btn_addRoomsSession.setToolTipText("If you click this you can view add room page");
        btn_addRoomsSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addRoomsSessionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addRoomsSessionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addRoomsSessionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addRoomsSessionMousePressed(evt);
            }
        });
        btn_addRoomsSession.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Add_Icon.png"))); // NOI18N
        btn_addRoomsSession.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Room For Session");
        btn_addRoomsSession.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_addRoomsSession.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addRoomsSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageRoomsSession.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageRoomsSession.setToolTipText("If you click this you can view manage rooms page");
        btn_ManageRoomsSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsSessionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsSessionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsSessionMouseExited(evt);
            }
        });
        btn_ManageRoomsSession.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Manage_Icon.png"))); // NOI18N
        btn_ManageRoomsSession.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Session Room");
        btn_ManageRoomsSession.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_ManageRoomsSession.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageRoomsSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addRoomSession_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addRoomSession_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomSession_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        addRoomSession_backBtn.setText("BACK");
        addRoomSession_backBtn.setToolTipText("Go Back");
        addRoomSession_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addRoomSession_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        addRoomSession_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomSession_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addRoomSession_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addRoomsSession.setBackground(new java.awt.Color(247, 247, 247));
        jp_addRoomsSession.setPreferredSize(new java.awt.Dimension(625, 600));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Session Name :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Building Name :");

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

        btn_roomAddSession.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_roomAddSession.setForeground(new java.awt.Color(255, 255, 255));
        btn_roomAddSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_roomAddSession.setText("ADD");
        btn_roomAddSession.setToolTipText("If you click this iserted data goes to database");
        btn_roomAddSession.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_roomAddSession.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_roomAddSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_roomAddSessionActionPerformed(evt);
            }
        });

        roomSessionName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Session" }));
        roomSessionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomSessionNameActionPerformed(evt);
            }
        });

        sessionRoomBuildingName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building" }));
        sessionRoomBuildingName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionRoomBuildingNameActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Room Name :");

        sessionRoomName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));
        sessionRoomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionRoomNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_addRoomsSessionLayout = new javax.swing.GroupLayout(jp_addRoomsSession);
        jp_addRoomsSession.setLayout(jp_addRoomsSessionLayout);
        jp_addRoomsSessionLayout.setHorizontalGroup(
            jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsSessionLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsSessionLayout.createSequentialGroup()
                        .addGroup(jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_addRoomsSessionLayout.createSequentialGroup()
                                .addComponent(roomSessionName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(jp_addRoomsSessionLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsSessionLayout.createSequentialGroup()
                                .addGroup(jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sessionRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jp_addRoomsSessionLayout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sessionRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsSessionLayout.createSequentialGroup()
                        .addComponent(btn_roomAddSession, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        jp_addRoomsSessionLayout.setVerticalGroup(
            jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsSessionLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomSessionName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sessionRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sessionRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addGroup(jp_addRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_roomAddSession, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        jPanel6.add(jp_addRoomsSession, "card2");

        jp_manageRoomsSession.setBackground(new java.awt.Color(247, 247, 247));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        table_displaySessionRoomDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Session Name", "Lecture 1", "Lecture 2", "Lecture 3", "Subject Code", "Subject Name", "Group ID", "Tag", "Building", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_displaySessionRoomDetails.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table_displaySessionRoomDetails.getTableHeader().setReorderingAllowed(false);
        table_displaySessionRoomDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_displaySessionRoomDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_displaySessionRoomDetails);
        if (table_displaySessionRoomDetails.getColumnModel().getColumnCount() > 0) {
            table_displaySessionRoomDetails.getColumnModel().getColumn(0).setMinWidth(80);
            table_displaySessionRoomDetails.getColumnModel().getColumn(1).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(2).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(3).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(4).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(5).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(6).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(7).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(8).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(9).setMinWidth(180);
            table_displaySessionRoomDetails.getColumnModel().getColumn(10).setMinWidth(180);
        }

        btn_deleteManageSessionRoom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_deleteManageSessionRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteManageSessionRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_deleteManageSessionRoom.setText("DELETE");
        btn_deleteManageSessionRoom.setToolTipText("if you click this you can delete selected item from the database");
        btn_deleteManageSessionRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_deleteManageSessionRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        btn_deleteManageSessionRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteManageSessionRoomRoomActionPerformed(evt);
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

        javax.swing.GroupLayout jp_manageRoomsSessionLayout = new javax.swing.GroupLayout(jp_manageRoomsSession);
        jp_manageRoomsSession.setLayout(jp_manageRoomsSessionLayout);
        jp_manageRoomsSessionLayout.setHorizontalGroup(
            jp_manageRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsSessionLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_manageRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_manageRoomsSessionLayout.createSequentialGroup()
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(jp_manageRoomsSessionLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btn_deleteManageSessionRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_manageRoomsSessionLayout.setVerticalGroup(
            jp_manageRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsSessionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_manageRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_manageRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField)
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jp_manageRoomsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteManageSessionRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel6.add(jp_manageRoomsSession, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addRoomSession_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD ROOMS FOR SESSION");

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

        javax.swing.GroupLayout addRoomSession_TopBarLayout = new javax.swing.GroupLayout(addRoomSession_TopBar);
        addRoomSession_TopBar.setLayout(addRoomSession_TopBarLayout);
        addRoomSession_TopBarLayout.setHorizontalGroup(
            addRoomSession_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomSession_TopBarLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(43, 43, 43)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addRoomSession_TopBarLayout.setVerticalGroup(
            addRoomSession_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomSession_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addRoomSession_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(addRoomSession_TopBar);

        manageRoomSession_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE SESSION ROOMS");

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

        javax.swing.GroupLayout manageRoomSession_TopbarLayout = new javax.swing.GroupLayout(manageRoomSession_Topbar);
        manageRoomSession_Topbar.setLayout(manageRoomSession_TopbarLayout);
        manageRoomSession_TopbarLayout.setHorizontalGroup(
            manageRoomSession_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomSession_TopbarLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageRoomSession_TopbarLayout.setVerticalGroup(
            manageRoomSession_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomSession_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageRoomSession_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(manageRoomSession_Topbar);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addRoomsSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSessionMouseClicked
        // TODO add your handling code here:
        jp_addRoomsSession.setVisible(true);
        jp_manageRoomsSession.setVisible(false);
        addRoomSession_TopBar.setVisible(true);
        manageRoomSession_Topbar.setVisible(false);
        btn_addRoomsSession.setBackground(new java.awt.Color(8,142,88));
        btn_ManageRoomsSession.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addRoomsSessionMouseClicked

    private void btn_addRoomsSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSessionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsSessionMouseEntered

    private void btn_addRoomsSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSessionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsSessionMouseExited

    private void btn_addRoomsSessionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsSessionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsSessionMousePressed

    private void btn_ManageRoomsSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsSessionMouseClicked
        // TODO add your handling code here:
        jp_manageRoomsSession.setVisible(true);
        jp_addRoomsSession.setVisible(false);
        addRoomSession_TopBar.setVisible(false);
        manageRoomSession_Topbar.setVisible(true);
        btn_ManageRoomsSession.setBackground(new java.awt.Color(8,142,88));
        btn_addRoomsSession.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageRoomsSessionMouseClicked

    private void btn_ManageRoomsSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsSessionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageRoomsSessionMouseEntered

    private void btn_ManageRoomsSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsSessionMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageRoomsSessionMouseExited

    private void addRoomSession_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomSession_backBtnActionPerformed
        // TODO add your handling code here:
        AAssignRooms aAssignRooms = new AAssignRooms();
        aAssignRooms.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoomSession_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFieldsAdd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_roomAddSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roomAddSessionActionPerformed
        // TODO add your handling code here:
        this.session_name = roomSessionName.getSelectedItem().toString();
        this.session_building = sessionRoomBuildingName.getSelectedItem().toString();
        this.session_room = sessionRoomName.getSelectedItem().toString();

        if (roomSessionName.getSelectedItem().toString().equals("Select Session") || sessionRoomBuildingName.getSelectedItem().toString().equals("Select Building") || sessionRoomName.getSelectedItem().toString().equals("Select Room")) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

        } else {
            if ("" != roomSessionName.getSelectedItem().toString()) {

                try {
                    String query_roomexits = "select session_name from sessionrooms where session_name like '"+'%'+roomSessionName.getSelectedItem().toString()+'%'+"'";
                    Statement st_rooms = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_rooms.executeQuery(query_roomexits);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "This Session Room Already Exist");

                    } else {

                        try {
                            String query = "insert into sessionrooms(session_name, buildings, rooms, lecture_1, lecture_2, lecture_3, subject_code, subject_name, group_id, tag) "
                            + "values ( ?, ?, ?, (SELECT lecture_1 FROM sessions WHERE session_name='"+roomSessionName.getSelectedItem().toString()+"'), (SELECT lecture_2 FROM sessions WHERE session_name='"+roomSessionName.getSelectedItem().toString()+"'), (SELECT lecture_3 FROM sessions WHERE session_name='"+roomSessionName.getSelectedItem().toString()+"'), (SELECT subject_code FROM sessions WHERE session_name='"+roomSessionName.getSelectedItem().toString()+"'), (SELECT subject_name FROM sessions WHERE session_name='"+roomSessionName.getSelectedItem().toString()+"'), (SELECT group_id FROM sessions WHERE session_name='"+roomSessionName.getSelectedItem().toString()+"'), (SELECT tag FROM sessions WHERE session_name='"+roomSessionName.getSelectedItem().toString()+"' ))";

                            preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, session_name);
                            preparedStmt.setString(2, session_building);
                            preparedStmt.setString(3, session_room);

                            preparedStmt.execute();

                            JOptionPane.showMessageDialog(null, "Room Assigned Successfully. \n Thank You!");
                            DefaultTableModel model = (DefaultTableModel) table_displaySessionRoomDetails.getModel();
                            model.setRowCount(0);
                            show_SessionRoomDetails();

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
    }//GEN-LAST:event_btn_roomAddSessionActionPerformed

    private void roomSessionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomSessionNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomSessionNameActionPerformed

    private void sessionRoomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionRoomNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sessionRoomNameActionPerformed

    private void table_displaySessionRoomDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_displaySessionRoomDetailsMouseClicked
        // TODO add your handling code here:
        int i = table_displaySessionRoomDetails.getSelectedRow();
        TableModel model = table_displaySessionRoomDetails.getModel();

        roomNo_rowSelected = model.getValueAt(i,0).toString();
        session_name = model.getValueAt(i,1).toString();
    }//GEN-LAST:event_table_displaySessionRoomDetailsMouseClicked

    private void btn_deleteManageSessionRoomRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteManageSessionRoomRoomActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + roomNo_rowSelected + " - "
            + session_name + " assigned room details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM sessionrooms WHERE sessionroom_id = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, roomNo_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Session Room removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) table_displaySessionRoomDetails.getModel();
                model.setRowCount(0);
                show_SessionRoomDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteManageSessionRoomRoomActionPerformed

    private void btn_clearManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearManageMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displaySessionRoomDetails.getModel();
        model.setRowCount(0);
        show_SessionRoomDetails();
    }//GEN-LAST:event_btn_clearManageMouseClicked

    private void btn_clearManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearManageActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)table_displaySessionRoomDetails.getModel();
        String search = searchTextField.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        table_displaySessionRoomDetails.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void btn_searchManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchManageRoomActionPerformed

    private void btn_refreshManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displaySessionRoomDetails.getModel();
        model.setRowCount(0);
        show_SessionRoomDetails();
    }//GEN-LAST:event_btn_refreshManageRoomMouseClicked

    private void btn_refreshManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshManageRoomActionPerformed

    private void btn_viewRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRoomsTableActionPerformed
        // TODO add your handling code here:
        AViewSessionRoomTable aViewSessionRoomTable = new AViewSessionRoomTable();
        aViewSessionRoomTable.setVisible(true);
    }//GEN-LAST:event_btn_viewRoomsTableActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void sessionRoomBuildingNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionRoomBuildingNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sessionRoomBuildingNameActionPerformed

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
            java.util.logging.Logger.getLogger(ARoomForSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ARoomForSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ARoomForSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ARoomForSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ARoomForSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel addRoomSession_TopBar;
    private javax.swing.JButton addRoomSession_backBtn;
    private javax.swing.JPanel btn_ManageRoomsSession;
    private javax.swing.JPanel btn_addRoomsSession;
    private javax.swing.JButton btn_clearManage;
    private javax.swing.JButton btn_deleteManageSessionRoom;
    private javax.swing.JButton btn_refreshManageRoom;
    private javax.swing.JButton btn_roomAddSession;
    private javax.swing.JButton btn_searchManageRoom;
    private javax.swing.JButton btn_viewRoomsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jp_addRoomsSession;
    private javax.swing.JPanel jp_manageRoomsSession;
    private javax.swing.JPanel manageRoomSession_Topbar;
    private javax.swing.JComboBox<String> roomSessionName;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> sessionRoomBuildingName;
    private javax.swing.JComboBox<String> sessionRoomName;
    private javax.swing.JTable table_displaySessionRoomDetails;
    // End of variables declaration//GEN-END:variables
}
