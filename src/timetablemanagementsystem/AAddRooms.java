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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
<<<<<<< HEAD
=======
import static jdk.nashorn.internal.runtime.JSType.isNumber;
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5

/**
 *
 * @author ashan
 */
public class AAddRooms extends javax.swing.JFrame {

    /**
     * Creates new form AAddRooms
     */
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String roomNo_rowSelected;
    private String building_no, building_name, room_no, room_name, room_type;
    private String room_capacity;
    
    public AAddRooms() {
        initComponents();
        dbconnect();
        show_roomDetails();
        FillComboBuildingNo();
        btn_addRooms.setBackground(new java.awt.Color(8,142,88));
    }
    
    public ArrayList<ARoomModel> roomList() {
        
        ArrayList<ARoomModel> roomList = new ArrayList<>();
        try {
            String query = "SELECT * FROM ROOMS";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomModel roommodel ;

            while(rs.next()){
                roommodel = new ARoomModel ( rs.getString("building_no"), rs.getString("building_name"), rs.getString("room_no"), rs.getString("room_name"), rs.getString("room_type"), rs.getString("room_capacity"));
                roomList.add(roommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomList;            
    }
    
    public void show_roomDetails(){
        
        ArrayList<ARoomModel> roomList = roomList();
        DefaultTableModel tableModel = (DefaultTableModel) table_displayRoomDetails.getModel();
        
        Object[] row = new Object[6];
        for (int i = 0; i < roomList.size(); i++) {
            
            row[0] = roomList.get(i).getBuildingNumber();
            row[1] = roomList.get(i).getBuildingName();
            row[2] = roomList.get(i).getRoomNumber();
            row[3] = roomList.get(i).getRoomName();
            row[4] = roomList.get(i).getRoomType();
            row[5] = roomList.get(i).getRoomCapacity();
            
            tableModel.addRow(row);                       
        } 
    }
    
    
    private void clearFieldsAdd(){
        roomBuildingNo.setSelectedItem("Select Building Number");
        roomBuildingName.setSelectedItem("Select Building Name");
        roomNo.setText(null);
        roomName.setText(null);
        roomType.setSelectedItem("Select Room Type");
        roomCapacity.setText(null);
    }
    
    private void clearFieldsManage(){
        buildingNoManageRoom.setSelectedItem("Select Building Number");
        buildingNameManageRoom.setSelectedItem("Select Building Name");
        roomNoManage.setText(null);
        roomNameManage.setText(null);
        roomTypeManage.setSelectedItem("Select Room Type");
        roomCapacityManage.setText(null);
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
    
    private void FillComboBuildingNo(){
        try {
            String bcomboquery = "SELECT * FROM BUILDINGS";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String bnumbers = rst.getString("building_no");
                String bnames = rst.getString("building_name");
                String bmnumbers = rst.getString("building_no");
                String bmnames = rst.getString("building_name");
                roomBuildingNo.addItem(bnumbers);
                roomBuildingName.addItem(bnames);
                buildingNoManageRoom.addItem(bmnumbers);
                buildingNameManageRoom.addItem(bmnames);
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
        btn_addRooms = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageRooms = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addRoom_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addRooms = new javax.swing.JPanel();
        roomNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_roomAdd = new javax.swing.JButton();
        roomName = new javax.swing.JTextField();
        roomCapacity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        roomBuildingNo = new javax.swing.JComboBox<>();
        roomType = new javax.swing.JComboBox<>();
        roomBuildingName = new javax.swing.JComboBox<>();
        jp_manageRooms = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_displayRoomDetails = new javax.swing.JTable();
        buildingNoManageRoom = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        buildingNameManageRoom = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        roomNoManage = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        roomNameManage = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        roomTypeManage = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        roomCapacityManage = new javax.swing.JTextField();
        btn_updateManageRoom = new javax.swing.JButton();
        btn_deleteManageRoom = new javax.swing.JButton();
        btn_clearManage = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        btn_searchManageRoom = new javax.swing.JButton();
        btn_refreshManageRoom = new javax.swing.JButton();
        btn_viewRoomsTable = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        addRoom_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageRoom_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addRooms.setBackground(new java.awt.Color(39, 156, 109));
        btn_addRooms.setToolTipText("If you click this you can view add room page");
        btn_addRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addRoomsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addRoomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addRoomsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addRoomsMousePressed(evt);
            }
        });
        btn_addRooms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Add_Icon.png"))); // NOI18N
        btn_addRooms.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Rooms");
        btn_addRooms.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 106, -1));

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

        btn_addRooms.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageRooms.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageRooms.setToolTipText("If you click this you can view manage rooms page");
        btn_ManageRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsMouseExited(evt);
            }
        });
        btn_ManageRooms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Manage_Icon.png"))); // NOI18N
        btn_ManageRooms.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Rooms");
        btn_ManageRooms.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 120, -1));

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

        btn_ManageRooms.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addRoom_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addRoom_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoom_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        addRoom_backBtn.setText("BACK");
        addRoom_backBtn.setToolTipText("Go Back");
        addRoom_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addRoom_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        addRoom_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoom_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addRoom_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addRooms.setBackground(new java.awt.Color(247, 247, 247));
        jp_addRooms.setPreferredSize(new java.awt.Dimension(625, 600));

<<<<<<< HEAD
        roomNo.setForeground(new java.awt.Color(153, 153, 153));
=======
        roomNo.setForeground(new java.awt.Color(51, 51, 51));
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        roomNo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roomNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Select Building Number :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Select Building Name :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Room Number :");

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

        btn_roomAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_roomAdd.setForeground(new java.awt.Color(255, 255, 255));
        btn_roomAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_roomAdd.setText("ADD");
<<<<<<< HEAD
=======
        btn_roomAdd.setToolTipText("If you click this iserted data goes to database");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        btn_roomAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_roomAdd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_roomAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_roomAddActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        roomName.setForeground(new java.awt.Color(153, 153, 153));
=======
        roomName.setForeground(new java.awt.Color(51, 51, 51));
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        roomName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        roomName.setToolTipText("");
        roomName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roomName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roomName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roomNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomNameFocusLost(evt);
            }
        });
        roomName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomNameMouseClicked(evt);
            }
        });
        roomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNameActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        roomCapacity.setForeground(new java.awt.Color(153, 153, 153));
=======
        roomCapacity.setForeground(new java.awt.Color(51, 51, 51));
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        roomCapacity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        roomCapacity.setToolTipText("");
        roomCapacity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roomCapacity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roomCapacity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roomCapacityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomCapacityFocusLost(evt);
            }
        });
        roomCapacity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomCapacityMouseClicked(evt);
            }
        });
        roomCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomCapacityActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Room Name :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Room Capacity :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Select Room Type :");

        roomBuildingNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building Number" }));
        roomBuildingNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomBuildingNoActionPerformed(evt);
            }
        });

        roomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Type", "Lecture Hall", "Lab", "Auditorium" }));

        roomBuildingName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building Name" }));

        javax.swing.GroupLayout jp_addRoomsLayout = new javax.swing.GroupLayout(jp_addRooms);
        jp_addRooms.setLayout(jp_addRoomsLayout);
        jp_addRoomsLayout.setHorizontalGroup(
            jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsLayout.createSequentialGroup()
                        .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_addRoomsLayout.createSequentialGroup()
                                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomBuildingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(roomType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(roomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(94, 94, 94))
                            .addGroup(jp_addRoomsLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)))
                        .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsLayout.createSequentialGroup()
                        .addComponent(btn_roomAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        jp_addRoomsLayout.setVerticalGroup(
            jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomBuildingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomType, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jp_addRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_roomAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        jPanel6.add(jp_addRooms, "card2");

        jp_manageRooms.setBackground(new java.awt.Color(247, 247, 247));

        table_displayRoomDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Building Number", "Building Name", "Room Number", "Room Name", "Room Type", "Room Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_displayRoomDetails.getTableHeader().setReorderingAllowed(false);
        table_displayRoomDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_displayRoomDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_displayRoomDetails);

        buildingNoManageRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building Number" }));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Select Building Number :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Select Building Name :");

        buildingNameManageRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building Name" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Room Number (Cannot Edit):");

        roomNoManage.setEditable(false);
        roomNoManage.setBackground(new java.awt.Color(214, 214, 214));
        roomNoManage.setForeground(new java.awt.Color(51, 51, 51));
        roomNoManage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roomNoManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNoManageActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Room Name :");

        roomNameManage.setForeground(new java.awt.Color(51, 51, 51));
        roomNameManage.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        roomNameManage.setToolTipText("");
        roomNameManage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roomNameManage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roomNameManage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roomNameManageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomNameManageFocusLost(evt);
            }
        });
        roomNameManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomNameManageMouseClicked(evt);
            }
        });
        roomNameManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNameManageActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Select Room Type :");

        roomTypeManage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Type", "Lecture Hall", "Lab", "Auditorium" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Room Capacity :");

        roomCapacityManage.setForeground(new java.awt.Color(51, 51, 51));
        roomCapacityManage.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        roomCapacityManage.setToolTipText("");
        roomCapacityManage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roomCapacityManage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roomCapacityManage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roomCapacityManageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomCapacityManageFocusLost(evt);
            }
        });
        roomCapacityManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomCapacityManageMouseClicked(evt);
            }
        });
        roomCapacityManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomCapacityManageActionPerformed(evt);
            }
        });

        btn_updateManageRoom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_updateManageRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_updateManageRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_updateManageRoom.setText("UPDATE");
<<<<<<< HEAD
=======
        btn_updateManageRoom.setToolTipText("If click this record will be update");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        btn_updateManageRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_updateManageRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_updateManageRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateManageRoomActionPerformed(evt);
            }
        });

        btn_deleteManageRoom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_deleteManageRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteManageRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_deleteManageRoom.setText("DELETE");
<<<<<<< HEAD
=======
        btn_deleteManageRoom.setToolTipText("if you click this you can delete selected item from the database");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
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
        btn_clearManage.setText("CLEAR");
<<<<<<< HEAD
=======
        btn_clearManage.setToolTipText("If you click this all fields will be empy");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        btn_clearManage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_clearManage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
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
<<<<<<< HEAD
=======
        btn_searchManageRoom.setToolTipText("If you clcik this you can search all details of rooms");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
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
<<<<<<< HEAD
=======
        btn_refreshManageRoom.setToolTipText("If you click this you refresh page");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
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
<<<<<<< HEAD
=======
        btn_viewRoomsTable.setToolTipText("If you click this you can view only datatable");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        btn_viewRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_viewRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_viewRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewRoomsTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_manageRoomsLayout = new javax.swing.GroupLayout(jp_manageRooms);
        jp_manageRooms.setLayout(jp_manageRoomsLayout);
        jp_manageRoomsLayout.setHorizontalGroup(
            jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_manageRoomsLayout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                        .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buildingNoManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(roomTypeManage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomNoManage, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16))
                        .addGap(94, 94, 94))
                    .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)))
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomCapacityManage, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNameManage, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buildingNameManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_manageRoomsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_updateManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_deleteManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        jp_manageRoomsLayout.setVerticalGroup(
            jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField)
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buildingNoManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buildingNameManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomNoManage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomNameManage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomTypeManage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_manageRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomCapacityManage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jp_manageRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_updateManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel6.add(jp_manageRooms, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addRoom_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD ROOMS");

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

        javax.swing.GroupLayout addRoom_TopBarLayout = new javax.swing.GroupLayout(addRoom_TopBar);
        addRoom_TopBar.setLayout(addRoom_TopBarLayout);
        addRoom_TopBarLayout.setHorizontalGroup(
            addRoom_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoom_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addRoom_TopBarLayout.setVerticalGroup(
            addRoom_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoom_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addRoom_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(addRoom_TopBar);

        manageRoom_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE ROOMS");

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

        javax.swing.GroupLayout manageRoom_TopbarLayout = new javax.swing.GroupLayout(manageRoom_Topbar);
        manageRoom_Topbar.setLayout(manageRoom_TopbarLayout);
        manageRoom_TopbarLayout.setHorizontalGroup(
            manageRoom_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoom_TopbarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageRoom_TopbarLayout.setVerticalGroup(
            manageRoom_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoom_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageRoom_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(manageRoom_Topbar);

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

    private void btn_addRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsMouseClicked
        // TODO add your handling code here:
        jp_addRooms.setVisible(true);
        jp_manageRooms.setVisible(false);
        addRoom_TopBar.setVisible(true);
        manageRoom_Topbar.setVisible(false);
        btn_addRooms.setBackground(new java.awt.Color(8,142,88));
        btn_ManageRooms.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addRoomsMouseClicked

    private void btn_addRoomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsMouseEntered

    private void btn_addRoomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsMouseExited

    private void btn_addRoomsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsMousePressed

    private void btn_ManageRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsMouseClicked
        // TODO add your handling code here:
        jp_manageRooms.setVisible(true);
        jp_addRooms.setVisible(false);
        addRoom_TopBar.setVisible(false);
        manageRoom_Topbar.setVisible(true);
        btn_ManageRooms.setBackground(new java.awt.Color(8,142,88));
        btn_addRooms.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageRoomsMouseClicked

    private void btn_ManageRoomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageRoomsMouseEntered

    private void btn_ManageRoomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsMouseExited
        // TODO add your handling code here

    }//GEN-LAST:event_btn_ManageRoomsMouseExited

    private void roomNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFieldsAdd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_roomAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roomAddActionPerformed
        // TODO add your handling code here:
        this.building_no = roomBuildingNo.getSelectedItem().toString();
        this.building_name = roomBuildingName.getSelectedItem().toString();
        this.room_no = roomNo.getText();
        this.room_name = roomName.getText();
        this.room_type = roomType.getSelectedItem().toString();
        this.room_capacity =  roomCapacity.getText();
        
        if (roomBuildingNo.getSelectedItem().toString().equals("Select Building Number") || roomBuildingName.getSelectedItem().toString().equals("Select Building Name") || roomNo.getText().equals("") || roomName.getText().equals("") || roomType.getSelectedItem().toString().equals("Select Room Type") || roomCapacity.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

        } else {
            if ("" != roomNo.getText()) {

                try {
                    String query_roomexits = "select room_no from rooms where room_no like '"+'%'+roomNo.getText()+'%'+"'";
                    Statement st_rooms = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_rooms.executeQuery(query_roomexits);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "This Room Already Exist");

                    } else {

                        try {
                            String query = "insert into rooms(building_no, building_name, room_no, room_name, room_type, room_capacity) "
                                    + "values ( ?, ?, ?, ?, ?, ? )";

                            preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, building_no);
                            preparedStmt.setString(2, building_name);
                            preparedStmt.setString(3, room_no);
                            preparedStmt.setString(4, room_name);
                            preparedStmt.setString(5, room_type);
                            preparedStmt.setString(6, room_capacity);

                            preparedStmt.execute();

                            JOptionPane.showMessageDialog(null, "Room Added Successfully. \n Thank You!");
                            DefaultTableModel model = (DefaultTableModel) table_displayRoomDetails.getModel();
                            model.setRowCount(0);
                            show_roomDetails();

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
    }//GEN-LAST:event_btn_roomAddActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addRoom_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoom_backBtnActionPerformed
        // TODO add your handling code here:
        ALocationHome aaLocationHome = new ALocationHome();
        aaLocationHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoom_backBtnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void roomNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameFocusGained

    private void roomNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameFocusLost

    private void roomNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameMouseClicked

    private void roomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameActionPerformed

    private void roomCapacityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomCapacityFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityFocusGained

    private void roomCapacityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomCapacityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityFocusLost

    private void roomCapacityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomCapacityMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityMouseClicked

    private void roomCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityActionPerformed

    private void roomNoManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNoManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNoManageActionPerformed

    private void roomNameManageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNameManageFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameManageFocusGained

    private void roomNameManageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNameManageFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameManageFocusLost

    private void roomNameManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomNameManageMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameManageMouseClicked

    private void roomNameManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNameManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameManageActionPerformed

    private void roomCapacityManageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomCapacityManageFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityManageFocusGained

    private void roomCapacityManageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomCapacityManageFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityManageFocusLost

    private void roomCapacityManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomCapacityManageMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityManageMouseClicked

    private void roomCapacityManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomCapacityManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomCapacityManageActionPerformed

    private void btn_updateManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateManageRoomActionPerformed
        // TODO add your handling code here:
        String updated_buildingNoRooms = buildingNoManageRoom.getSelectedItem().toString();
        String updated_buildingNameRooms = buildingNameManageRoom.getSelectedItem().toString();
        String updated_roomNo = roomNoManage.getText();
        String updated_roomName = roomNameManage.getText();
        String updated_roomType = roomTypeManage.getSelectedItem().toString();
        String updated_roomCapacity = roomCapacityManage.getText();
        
        if (buildingNoManageRoom.getSelectedItem().toString().equals("Select Building Number") || buildingNameManageRoom.getSelectedItem().toString().equals("Select Building Name") || roomNoManage.getText().equals("") || roomNameManage.getText().equals("") || roomTypeManage.getSelectedItem().toString().equals("Select Room Type") || roomCapacityManage.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");
            
        } else{ 
            
             try {      
                 String query = "update rooms " + "set building_no = ?, building_name = ?, room_no = ?, room_name = ?, room_type = ?, room_capacity = ?"
                                                    + "where room_no = ?";  
                 
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, updated_buildingNoRooms);
                preparedStmt.setString(2, updated_buildingNameRooms);
                preparedStmt.setString(3, updated_roomNo);
                preparedStmt.setString(4, updated_roomName);
                preparedStmt.setString(5, updated_roomType);
                preparedStmt.setString(6, updated_roomCapacity);
                preparedStmt.setString(7, roomNo_rowSelected);                 
                 
                preparedStmt.execute();
                
                DefaultTableModel model = (DefaultTableModel) table_displayRoomDetails.getModel();
                model.setRowCount(0);
                show_roomDetails();  
                JOptionPane.showMessageDialog(null, "Room details updated successfully");
                
                 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in Update operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
                
            }                 
        }     

    }//GEN-LAST:event_btn_updateManageRoomActionPerformed

    private void btn_deleteManageRoomRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteManageRoomRoomActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + roomNo_rowSelected + " - "
                + room_name + " details ?", "Delete", JOptionPane.YES_NO_OPTION);
        
        if (opt == 0) {
            try {
                String query = "DELETE FROM rooms WHERE room_no = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, roomNo_rowSelected);
                
                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Room removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) table_displayRoomDetails.getModel();
                model.setRowCount(0);
                show_roomDetails();          
                
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteManageRoomRoomActionPerformed

    private void btn_clearManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearManageActionPerformed
        // TODO add your handling code here:
        clearFieldsManage();
    }//GEN-LAST:event_btn_clearManageActionPerformed

    private void btn_searchManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchManageRoomActionPerformed

    private void btn_refreshManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displayRoomDetails.getModel();
        model.setRowCount(0);
        show_roomDetails();
        clearFieldsManage();
    }//GEN-LAST:event_btn_refreshManageRoomMouseClicked

    private void btn_refreshManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshManageRoomActionPerformed

    private void roomBuildingNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomBuildingNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomBuildingNoActionPerformed

    private void table_displayRoomDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_displayRoomDetailsMouseClicked
        // TODO add your handling code here:
        int i = table_displayRoomDetails.getSelectedRow();
        TableModel model = table_displayRoomDetails.getModel();
        
        buildingNoManageRoom.setSelectedItem(model.getValueAt(i, 0).toString());
        buildingNameManageRoom.setSelectedItem(model.getValueAt(i, 1).toString());
        roomNoManage.setText(model.getValueAt(i, 2).toString());  
        roomNameManage.setText(model.getValueAt(i, 3).toString()); 
        roomTypeManage.setSelectedItem(model.getValueAt(i, 4).toString()); 
        roomCapacityManage.setText(model.getValueAt(i, 5).toString()); 
        
        roomNo_rowSelected = model.getValueAt(i,2).toString();
        building_no = model.getValueAt(i,0).toString();
        building_name = model.getValueAt(i,1).toString();
        
        room_name = model.getValueAt(i,3).toString();
        room_type = model.getValueAt(i,4).toString();
        room_capacity = model.getValueAt(i,5).toString();
    }//GEN-LAST:event_table_displayRoomDetailsMouseClicked

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)table_displayRoomDetails.getModel();
        String search = searchTextField.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        table_displayRoomDetails.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void btn_viewRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRoomsTableActionPerformed
        // TODO add your handling code here:
        AViewRoomsTable aViewRoomsTable = new AViewRoomsTable();
        aViewRoomsTable.setVisible(true);
    }//GEN-LAST:event_btn_viewRoomsTableActionPerformed

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
            java.util.logging.Logger.getLogger(AAddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AAddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AAddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AAddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AAddRooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel addRoom_TopBar;
    private javax.swing.JButton addRoom_backBtn;
    private javax.swing.JPanel btn_ManageRooms;
    private javax.swing.JPanel btn_addRooms;
    private javax.swing.JButton btn_clearManage;
    private javax.swing.JButton btn_deleteManageRoom;
    private javax.swing.JButton btn_refreshManageRoom;
    private javax.swing.JButton btn_roomAdd;
    private javax.swing.JButton btn_searchManageRoom;
    private javax.swing.JButton btn_updateManageRoom;
    private javax.swing.JButton btn_viewRoomsTable;
    private javax.swing.JComboBox<String> buildingNameManageRoom;
    private javax.swing.JComboBox<String> buildingNoManageRoom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_addRooms;
    private javax.swing.JPanel jp_manageRooms;
    private javax.swing.JPanel manageRoom_Topbar;
    private javax.swing.JComboBox<String> roomBuildingName;
    private javax.swing.JComboBox<String> roomBuildingNo;
    private javax.swing.JTextField roomCapacity;
    private javax.swing.JTextField roomCapacityManage;
    private javax.swing.JTextField roomName;
    private javax.swing.JTextField roomNameManage;
    private javax.swing.JTextField roomNo;
    private javax.swing.JTextField roomNoManage;
    private javax.swing.JComboBox<String> roomType;
    private javax.swing.JComboBox<String> roomTypeManage;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table_displayRoomDetails;
    // End of variables declaration//GEN-END:variables
}
