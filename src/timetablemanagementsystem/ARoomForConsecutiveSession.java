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
public class ARoomForConsecutiveSession extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String roomNo_rowSelected;
    private String  consecsession_name, session_building, session_room;
    private int consecsession_roomID;
    /**
     * Creates new form ARoomForConsecutiveSession
     */
    public ARoomForConsecutiveSession() {
        initComponents();
        dbconnect();
        show_ConsecSessionRoomDetails();
        FillComboConSessions();
        FillComboBuildingName();
        FillComboRooms();    
        btn_addRoomsConSession.setBackground(new java.awt.Color(8,142,88));
    }
    
    public ArrayList<ARoomConsecSessionModel> roomConsecSessionList() {
        
        ArrayList<ARoomConsecSessionModel> roomConsecSessionList = new ArrayList<>();
        try {
            String query = "SELECT * FROM consecutiverooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomConsecSessionModel consecsessionroommodel ;

            while(rs.next()){
                consecsessionroommodel = new ARoomConsecSessionModel (rs.getInt("consecroom_id"), rs.getString("consecroom_name"), rs.getString("sessionid1"), rs.getString("sessionid2"), rs.getString("SubCode1"), rs.getString("SubCode2"), rs.getString("SubName1"), rs.getString("SubName2"), rs.getString("Tag1"), rs.getString("Tag2"), rs.getString("Buildings"), rs.getString("rooms"));
                roomConsecSessionList.add(consecsessionroommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomConsecSessionList;            
    }
    
    public void show_ConsecSessionRoomDetails(){
        
        ArrayList<ARoomConsecSessionModel> roomConsecSessionList = roomConsecSessionList();
        DefaultTableModel tableModel = (DefaultTableModel) table_displayConSessionRoomDetails.getModel();
        
        Object[] row = new Object[14];
        for (int i = 0; i < roomConsecSessionList.size(); i++) {
            
            row[0] = roomConsecSessionList.get(i).getId();
            row[1] = roomConsecSessionList.get(i).getConsecSession_name();
            row[2] = roomConsecSessionList.get(i).getSessionidOne();
            row[3] = roomConsecSessionList.get(i).getSessionidTwo();
            row[4] = roomConsecSessionList.get(i).getSubject_codeOne();
            row[5] = roomConsecSessionList.get(i).getSubject_codeTwo();
            row[6] = roomConsecSessionList.get(i).getSubject_nameOne();
            row[7] = roomConsecSessionList.get(i).getSubject_nameTwo();
            row[8] = roomConsecSessionList.get(i).getConsecSession_tagOne();
            row[9] = roomConsecSessionList.get(i).getConsecSession_tagTwo();
            row[10] = roomConsecSessionList.get(i).getConsecSessionBuilding();
            row[11] = roomConsecSessionList.get(i).getConsecSessionRoom();
            
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
        roomConSessionName.setSelectedItem("Select Consecutive Session");
        consessionRoomBuildingName.setSelectedItem("Select Building");
        consessionRoomName.setSelectedItem("Select Room");
    }     
    
    private void FillComboConSessions(){
        try {
            String bcomboquery = "SELECT * FROM consec";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String consecsessionnames = rst.getString("consec_name");
                roomConSessionName.addItem(consecsessionnames);
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
                consessionRoomBuildingName.addItem(bnames);
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
                consessionRoomName.addItem(roomnames);
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
        btn_addRoomsConSession = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageRoomsConSession = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addRoomConSession_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addRoomsConSession = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_roomAddConSession = new javax.swing.JButton();
        roomConSessionName = new javax.swing.JComboBox<>();
        consessionRoomBuildingName = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        consessionRoomName = new javax.swing.JComboBox<>();
        jp_manageRoomsConSession = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_displayConSessionRoomDetails = new javax.swing.JTable();
        btn_deleteManageConSessionRoom = new javax.swing.JButton();
        btn_clearManage = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        btn_searchManageRoom = new javax.swing.JButton();
        btn_refreshManageRoom = new javax.swing.JButton();
        btn_viewRoomsTable = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        addRoomConSession_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageRoomConSession_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addRoomsConSession.setBackground(new java.awt.Color(39, 156, 109));
        btn_addRoomsConSession.setToolTipText("If you click this you can view add room page");
        btn_addRoomsConSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addRoomsConSessionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addRoomsConSessionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addRoomsConSessionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addRoomsConSessionMousePressed(evt);
            }
        });
        btn_addRoomsConSession.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Add_Icon.png"))); // NOI18N
        btn_addRoomsConSession.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Room For Con Session");
        btn_addRoomsConSession.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, 20));

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

        btn_addRoomsConSession.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addRoomsConSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageRoomsConSession.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageRoomsConSession.setToolTipText("If you click this you can view manage rooms page");
        btn_ManageRoomsConSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsConSessionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsConSessionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsConSessionMouseExited(evt);
            }
        });
        btn_ManageRoomsConSession.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Manage_Icon.png"))); // NOI18N
        btn_ManageRoomsConSession.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Con Session Room");
        btn_ManageRoomsConSession.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, 20));

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

        btn_ManageRoomsConSession.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageRoomsConSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addRoomConSession_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addRoomConSession_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomConSession_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        addRoomConSession_backBtn.setText("BACK");
        addRoomConSession_backBtn.setToolTipText("Go Back");
        addRoomConSession_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addRoomConSession_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        addRoomConSession_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomConSession_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addRoomConSession_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addRoomsConSession.setBackground(new java.awt.Color(247, 247, 247));
        jp_addRoomsConSession.setPreferredSize(new java.awt.Dimension(625, 600));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Consecutive Session Name :");

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

        btn_roomAddConSession.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_roomAddConSession.setForeground(new java.awt.Color(255, 255, 255));
        btn_roomAddConSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_roomAddConSession.setText("ADD");
        btn_roomAddConSession.setToolTipText("If you click this iserted data goes to database");
        btn_roomAddConSession.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_roomAddConSession.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_roomAddConSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_roomAddConSessionActionPerformed(evt);
            }
        });

        roomConSessionName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Consecutive Session" }));
        roomConSessionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomConSessionNameActionPerformed(evt);
            }
        });

        consessionRoomBuildingName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building" }));
        consessionRoomBuildingName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consessionRoomBuildingNameActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Room Name :");

        consessionRoomName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));
        consessionRoomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consessionRoomNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_addRoomsConSessionLayout = new javax.swing.GroupLayout(jp_addRoomsConSession);
        jp_addRoomsConSession.setLayout(jp_addRoomsConSessionLayout);
        jp_addRoomsConSessionLayout.setHorizontalGroup(
            jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsConSessionLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsConSessionLayout.createSequentialGroup()
                        .addGroup(jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_addRoomsConSessionLayout.createSequentialGroup()
                                .addComponent(roomConSessionName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsConSessionLayout.createSequentialGroup()
                                .addGroup(jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(consessionRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jp_addRoomsConSessionLayout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jp_addRoomsConSessionLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)))
                        .addGroup(jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consessionRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsConSessionLayout.createSequentialGroup()
                        .addComponent(btn_roomAddConSession, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        jp_addRoomsConSessionLayout.setVerticalGroup(
            jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsConSessionLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomConSessionName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consessionRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consessionRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addGroup(jp_addRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_roomAddConSession, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        jPanel6.add(jp_addRoomsConSession, "card2");

        jp_manageRoomsConSession.setBackground(new java.awt.Color(247, 247, 247));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        table_displayConSessionRoomDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Consecutive Session Name", "Session ID 1", "Session ID 2", "Subject Code 1", "Subject Code 2", "Subject Name 1", "Subject Name 2", "Tag Name 1", "Tag Name 2", "Building", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_displayConSessionRoomDetails.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table_displayConSessionRoomDetails.getTableHeader().setReorderingAllowed(false);
        table_displayConSessionRoomDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_displayConSessionRoomDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_displayConSessionRoomDetails);
        if (table_displayConSessionRoomDetails.getColumnModel().getColumnCount() > 0) {
            table_displayConSessionRoomDetails.getColumnModel().getColumn(0).setMinWidth(100);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(0).setPreferredWidth(100);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(1).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(2).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(3).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(4).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(5).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(6).setMinWidth(100);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(7).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(8).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(9).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(10).setMinWidth(180);
            table_displayConSessionRoomDetails.getColumnModel().getColumn(11).setMinWidth(180);
        }

        btn_deleteManageConSessionRoom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_deleteManageConSessionRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteManageConSessionRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_deleteManageConSessionRoom.setText("DELETE");
        btn_deleteManageConSessionRoom.setToolTipText("if you click this you can delete selected item from the database");
        btn_deleteManageConSessionRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_deleteManageConSessionRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        btn_deleteManageConSessionRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteManageConSessionRoomRoomActionPerformed(evt);
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

        javax.swing.GroupLayout jp_manageRoomsConSessionLayout = new javax.swing.GroupLayout(jp_manageRoomsConSession);
        jp_manageRoomsConSession.setLayout(jp_manageRoomsConSessionLayout);
        jp_manageRoomsConSessionLayout.setHorizontalGroup(
            jp_manageRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsConSessionLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_manageRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_manageRoomsConSessionLayout.createSequentialGroup()
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(jp_manageRoomsConSessionLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btn_deleteManageConSessionRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_manageRoomsConSessionLayout.setVerticalGroup(
            jp_manageRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsConSessionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_manageRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_manageRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField)
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jp_manageRoomsConSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteManageConSessionRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel6.add(jp_manageRoomsConSession, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addRoomConSession_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD ROOMS FOR CONSECUTIVE SESSION");

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

        javax.swing.GroupLayout addRoomConSession_TopBarLayout = new javax.swing.GroupLayout(addRoomConSession_TopBar);
        addRoomConSession_TopBar.setLayout(addRoomConSession_TopBarLayout);
        addRoomConSession_TopBarLayout.setHorizontalGroup(
            addRoomConSession_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomConSession_TopBarLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addRoomConSession_TopBarLayout.setVerticalGroup(
            addRoomConSession_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomConSession_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addRoomConSession_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        JPanel7.add(addRoomConSession_TopBar);

        manageRoomConSession_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE CONSECUTIVE SESSION ROOMS");

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

        javax.swing.GroupLayout manageRoomConSession_TopbarLayout = new javax.swing.GroupLayout(manageRoomConSession_Topbar);
        manageRoomConSession_Topbar.setLayout(manageRoomConSession_TopbarLayout);
        manageRoomConSession_TopbarLayout.setHorizontalGroup(
            manageRoomConSession_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomConSession_TopbarLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageRoomConSession_TopbarLayout.setVerticalGroup(
            manageRoomConSession_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomConSession_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageRoomConSession_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        JPanel7.add(manageRoomConSession_Topbar);

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

    private void btn_addRoomsConSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsConSessionMouseClicked
        // TODO add your handling code here:
        jp_addRoomsConSession.setVisible(true);
        jp_manageRoomsConSession.setVisible(false);
        addRoomConSession_TopBar.setVisible(true);
        manageRoomConSession_Topbar.setVisible(false);
        btn_addRoomsConSession.setBackground(new java.awt.Color(8,142,88));
        btn_ManageRoomsConSession.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addRoomsConSessionMouseClicked

    private void btn_addRoomsConSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsConSessionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsConSessionMouseEntered

    private void btn_addRoomsConSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsConSessionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsConSessionMouseExited

    private void btn_addRoomsConSessionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsConSessionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsConSessionMousePressed

    private void btn_ManageRoomsConSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsConSessionMouseClicked
        // TODO add your handling code here:
        jp_manageRoomsConSession.setVisible(true);
        jp_addRoomsConSession.setVisible(false);
        addRoomConSession_TopBar.setVisible(false);
        manageRoomConSession_Topbar.setVisible(true);
        btn_ManageRoomsConSession.setBackground(new java.awt.Color(8,142,88));
        btn_addRoomsConSession.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageRoomsConSessionMouseClicked

    private void btn_ManageRoomsConSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsConSessionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageRoomsConSessionMouseEntered

    private void btn_ManageRoomsConSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsConSessionMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageRoomsConSessionMouseExited

    private void addRoomConSession_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomConSession_backBtnActionPerformed
        // TODO add your handling code here:
        AAssignRooms aAssignRooms = new AAssignRooms();
        aAssignRooms.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoomConSession_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFieldsAdd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_roomAddConSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roomAddConSessionActionPerformed
        // TODO add your handling code here:
        this.consecsession_name = roomConSessionName.getSelectedItem().toString();
        this.session_building = consessionRoomBuildingName.getSelectedItem().toString();
        this.session_room = consessionRoomName.getSelectedItem().toString();

        if (roomConSessionName.getSelectedItem().toString().equals("Select Consecutive Session") || consessionRoomBuildingName.getSelectedItem().toString().equals("Select Building") || consessionRoomName.getSelectedItem().toString().equals("Select Room")) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

        } else {
            if ("" != roomConSessionName.getSelectedItem().toString()) {

                try {
                    String query_roomexits = "select consecroom_name from consecutiverooms where consecroom_name like '"+'%'+roomConSessionName.getSelectedItem().toString()+'%'+"'";
                    Statement st_rooms = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_rooms.executeQuery(query_roomexits);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "This Consecutive Session Room Already Exist");

                    } else {

                        try {
                            String query = "insert into consecutiverooms(consecroom_name, Buildings, rooms, sessionid1, sessionid2, SubCode1, SubCode2, SubName1, SubName2, Tag1, Tag2) "
                            + "values ( ?, ?, ?, (SELECT sessionid1 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"'), (SELECT sessionid2 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"'), (SELECT SubCode1 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"'), (SELECT SubCode2 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"'), (SELECT SubName1 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"'), (SELECT SubName2 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"'), (SELECT Tag1 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"' ), (SELECT Tag2 FROM consec WHERE consec_name='"+roomConSessionName.getSelectedItem().toString()+"' ))";

                            preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, consecsession_name);
                            preparedStmt.setString(2, session_building);
                            preparedStmt.setString(3, session_room);

                            preparedStmt.execute();

                            JOptionPane.showMessageDialog(null, "Room Assigned Successfully. \n Thank You!");
                            DefaultTableModel model = (DefaultTableModel) table_displayConSessionRoomDetails.getModel();
                            model.setRowCount(0);
                            show_ConsecSessionRoomDetails();

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
    }//GEN-LAST:event_btn_roomAddConSessionActionPerformed

    private void roomConSessionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomConSessionNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomConSessionNameActionPerformed

    private void consessionRoomBuildingNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consessionRoomBuildingNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consessionRoomBuildingNameActionPerformed

    private void consessionRoomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consessionRoomNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consessionRoomNameActionPerformed

    private void table_displayConSessionRoomDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_displayConSessionRoomDetailsMouseClicked
        // TODO add your handling code here:
        int i = table_displayConSessionRoomDetails.getSelectedRow();
        TableModel model = table_displayConSessionRoomDetails.getModel();

        roomNo_rowSelected = model.getValueAt(i,0).toString();
        consecsession_name = model.getValueAt(i,1).toString();
    }//GEN-LAST:event_table_displayConSessionRoomDetailsMouseClicked

    private void btn_deleteManageConSessionRoomRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteManageConSessionRoomRoomActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + roomNo_rowSelected + " - "
            + consecsession_name + " assigned room details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM consecutiverooms WHERE consecroom_id = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, roomNo_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Consecutive Session Room removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) table_displayConSessionRoomDetails.getModel();
                model.setRowCount(0);
                show_ConsecSessionRoomDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteManageConSessionRoomRoomActionPerformed

    private void btn_clearManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearManageMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displayConSessionRoomDetails.getModel();
        model.setRowCount(0);
        show_ConsecSessionRoomDetails();
    }//GEN-LAST:event_btn_clearManageMouseClicked

    private void btn_clearManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearManageActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)table_displayConSessionRoomDetails.getModel();
        String search = searchTextField.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        table_displayConSessionRoomDetails.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void btn_searchManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchManageRoomActionPerformed

    private void btn_refreshManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displayConSessionRoomDetails.getModel();
        model.setRowCount(0);
        show_ConsecSessionRoomDetails();
    }//GEN-LAST:event_btn_refreshManageRoomMouseClicked

    private void btn_refreshManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshManageRoomActionPerformed

    private void btn_viewRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRoomsTableActionPerformed
        // TODO add your handling code here:
        AViewConsecutiveSessionRoomTable aViewConsecutiveSessionRoomTable = new AViewConsecutiveSessionRoomTable();
        aViewConsecutiveSessionRoomTable.setVisible(true);
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
            java.util.logging.Logger.getLogger(ARoomForConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ARoomForConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ARoomForConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ARoomForConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ARoomForConsecutiveSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel addRoomConSession_TopBar;
    private javax.swing.JButton addRoomConSession_backBtn;
    private javax.swing.JPanel btn_ManageRoomsConSession;
    private javax.swing.JPanel btn_addRoomsConSession;
    private javax.swing.JButton btn_clearManage;
    private javax.swing.JButton btn_deleteManageConSessionRoom;
    private javax.swing.JButton btn_refreshManageRoom;
    private javax.swing.JButton btn_roomAddConSession;
    private javax.swing.JButton btn_searchManageRoom;
    private javax.swing.JButton btn_viewRoomsTable;
    private javax.swing.JComboBox<String> consessionRoomBuildingName;
    private javax.swing.JComboBox<String> consessionRoomName;
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
    private javax.swing.JPanel jp_addRoomsConSession;
    private javax.swing.JPanel jp_manageRoomsConSession;
    private javax.swing.JPanel manageRoomConSession_Topbar;
    private javax.swing.JComboBox<String> roomConSessionName;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table_displayConSessionRoomDetails;
    // End of variables declaration//GEN-END:variables
}
