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
public class ARoomForGroup extends javax.swing.JFrame {
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String roomNo_rowSelected;
    private String group_name, group_subgrpname, group_tag, group_building, group_room;
    private int group_roomid;

    /**
     * Creates new form ARoomForGroup
     */
    public ARoomForGroup() {
        initComponents();
        dbconnect();
        show_GroupRoomDetails();
        FillComboGroups();
        FillComboSubGroups();
        FillComboTags();
        FillComboBuildingName();
        FillComboRooms();
        btn_addRoomsGroup.setBackground(new java.awt.Color(8,142,88));
    }

    public ArrayList<ARoomGroupModel> roomGroupList() {
        
        ArrayList<ARoomGroupModel> roomGroupList = new ArrayList<>();
        try {
            String query = "SELECT * FROM grouprooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomGroupModel grouproommodel ;

            while(rs.next()){
                grouproommodel = new ARoomGroupModel (rs.getInt("grouproom_id"), rs.getString("group_id"), rs.getString("groupsub_id"), rs.getString("group_tag"), rs.getString("group_building"), rs.getString("group_room"));
                roomGroupList.add(grouproommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomGroupList;            
    }
    
    public void show_GroupRoomDetails(){
        
        ArrayList<ARoomGroupModel> roomGroupList = roomGroupList();
        DefaultTableModel tableModel = (DefaultTableModel) table_displayGroupRoomDetails.getModel();
        
        Object[] row = new Object[6];
        for (int i = 0; i < roomGroupList.size(); i++) {
            
            row[0] = roomGroupList.get(i).getId();
            row[1] = roomGroupList.get(i).getGroup_name();
            row[2] = roomGroupList.get(i).getGroupSub_name();
            row[3] = roomGroupList.get(i).getGroupTag();
            row[4] = roomGroupList.get(i).getGroupBuilding();
            row[5] = roomGroupList.get(i).getGroupRoom();
            
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
        roomGroupName.setSelectedItem("Select Group ID");
        roomSubGroupName.setSelectedItem("Select Sub Group ID");
        groupRoomTagName.setSelectedItem("Select Tag");
        groupRoomBuildingName.setSelectedItem("Select Building");
        groupRoomName.setSelectedItem("Select Room");
    }  

    private void FillComboGroups(){
        try {
            String bcomboquery = "SELECT * FROM stgroups";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String grpnames = rst.getString("group_id");
                roomGroupName.addItem(grpnames);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }      
    
    private void FillComboSubGroups(){
        try {
            String bcomboquery = "SELECT * FROM stsubgroups";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String subgrpnames = rst.getString("subgroup_id");
                roomSubGroupName.addItem(subgrpnames);
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
                groupRoomTagName.addItem(tagnames);
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
                groupRoomBuildingName.addItem(bnames);
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
                groupRoomName.addItem(roomnames);
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
        btn_addRoomsGroup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageRoomsGroup = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addRoomGroup_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addRoomsGroup = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_roomAddGroup = new javax.swing.JButton();
        roomGroupName = new javax.swing.JComboBox<>();
        roomSubGroupName = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        groupRoomTagName = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        groupRoomName = new javax.swing.JComboBox<>();
        groupRoomBuildingName = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jp_manageRoomsGroup = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_displayGroupRoomDetails = new javax.swing.JTable();
        btn_deleteManageGroupRoom = new javax.swing.JButton();
        btn_clearManage = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        btn_searchManageRoom = new javax.swing.JButton();
        btn_refreshManageRoom = new javax.swing.JButton();
        btn_viewRoomsTable = new javax.swing.JButton();
        JPanel7 = new javax.swing.JPanel();
        addRoomGroup_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageRoomGroup_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addRoomsGroup.setBackground(new java.awt.Color(39, 156, 109));
        btn_addRoomsGroup.setToolTipText("If you click this you can view add room page");
        btn_addRoomsGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addRoomsGroupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addRoomsGroupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addRoomsGroupMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addRoomsGroupMousePressed(evt);
            }
        });
        btn_addRoomsGroup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Add_Icon.png"))); // NOI18N
        btn_addRoomsGroup.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Room For Group");
        btn_addRoomsGroup.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_addRoomsGroup.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addRoomsGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageRoomsGroup.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageRoomsGroup.setToolTipText("If you click this you can view manage rooms page");
        btn_ManageRoomsGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsGroupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsGroupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageRoomsGroupMouseExited(evt);
            }
        });
        btn_ManageRoomsGroup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/Manage_Icon.png"))); // NOI18N
        btn_ManageRoomsGroup.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Group Room");
        btn_ManageRoomsGroup.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_ManageRoomsGroup.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageRoomsGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addRoomGroup_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addRoomGroup_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomGroup_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        addRoomGroup_backBtn.setText("BACK");
        addRoomGroup_backBtn.setToolTipText("Go Back");
        addRoomGroup_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addRoomGroup_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        addRoomGroup_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomGroup_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addRoomGroup_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addRoomsGroup.setBackground(new java.awt.Color(247, 247, 247));
        jp_addRoomsGroup.setPreferredSize(new java.awt.Dimension(625, 600));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Group ID :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Sub Group ID :");

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

        btn_roomAddGroup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_roomAddGroup.setForeground(new java.awt.Color(255, 255, 255));
        btn_roomAddGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_roomAddGroup.setText("ADD");
        btn_roomAddGroup.setToolTipText("If you click this iserted data goes to database");
        btn_roomAddGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_roomAddGroup.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_roomAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_roomAddGroupActionPerformed(evt);
            }
        });

        roomGroupName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Group ID" }));
        roomGroupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomGroupNameActionPerformed(evt);
            }
        });

        roomSubGroupName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Sub Group ID" }));
        roomSubGroupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomSubGroupNameActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Select Tag :");

        groupRoomTagName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag" }));
        groupRoomTagName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupRoomTagNameActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Select Room :");

        groupRoomName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));

        groupRoomBuildingName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building" }));
        groupRoomBuildingName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupRoomBuildingNameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Select Building :");

        javax.swing.GroupLayout jp_addRoomsGroupLayout = new javax.swing.GroupLayout(jp_addRoomsGroup);
        jp_addRoomsGroup.setLayout(jp_addRoomsGroupLayout);
        jp_addRoomsGroupLayout.setHorizontalGroup(
            jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsGroupLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsGroupLayout.createSequentialGroup()
                        .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_addRoomsGroupLayout.createSequentialGroup()
                                .addComponent(roomGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(jp_addRoomsGroupLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsGroupLayout.createSequentialGroup()
                                .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(groupRoomTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jp_addRoomsGroupLayout.createSequentialGroup()
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(66, 66, 66)))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(groupRoomName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roomSubGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addRoomsGroupLayout.createSequentialGroup()
                        .addComponent(btn_roomAddGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        jp_addRoomsGroupLayout.setVerticalGroup(
            jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addRoomsGroupLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomSubGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupRoomTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupRoomBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jp_addRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_roomAddGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        jPanel6.add(jp_addRoomsGroup, "card2");

        jp_manageRoomsGroup.setBackground(new java.awt.Color(247, 247, 247));

        table_displayGroupRoomDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Group ID", "Sub Group ID", "Tag", "Building", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_displayGroupRoomDetails.getTableHeader().setReorderingAllowed(false);
        table_displayGroupRoomDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_displayGroupRoomDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_displayGroupRoomDetails);

        btn_deleteManageGroupRoom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_deleteManageGroupRoom.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteManageGroupRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_deleteManageGroupRoom.setText("DELETE");
        btn_deleteManageGroupRoom.setToolTipText("if you click this you can delete selected item from the database");
        btn_deleteManageGroupRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_deleteManageGroupRoom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        btn_deleteManageGroupRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteManageGroupRoomRoomActionPerformed(evt);
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

        javax.swing.GroupLayout jp_manageRoomsGroupLayout = new javax.swing.GroupLayout(jp_manageRoomsGroup);
        jp_manageRoomsGroup.setLayout(jp_manageRoomsGroupLayout);
        jp_manageRoomsGroupLayout.setHorizontalGroup(
            jp_manageRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsGroupLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_manageRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_manageRoomsGroupLayout.createSequentialGroup()
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(jp_manageRoomsGroupLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btn_deleteManageGroupRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_manageRoomsGroupLayout.setVerticalGroup(
            jp_manageRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageRoomsGroupLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_manageRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_searchManageRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_manageRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField)
                        .addComponent(btn_viewRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refreshManageRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jp_manageRoomsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteManageGroupRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearManage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel6.add(jp_manageRoomsGroup, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addRoomGroup_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD ROOMS FOR GROUP");

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

        javax.swing.GroupLayout addRoomGroup_TopBarLayout = new javax.swing.GroupLayout(addRoomGroup_TopBar);
        addRoomGroup_TopBar.setLayout(addRoomGroup_TopBarLayout);
        addRoomGroup_TopBarLayout.setHorizontalGroup(
            addRoomGroup_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomGroup_TopBarLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(64, 64, 64)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addRoomGroup_TopBarLayout.setVerticalGroup(
            addRoomGroup_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomGroup_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addRoomGroup_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(addRoomGroup_TopBar);

        manageRoomGroup_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE GROUP ROOMS");

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

        javax.swing.GroupLayout manageRoomGroup_TopbarLayout = new javax.swing.GroupLayout(manageRoomGroup_Topbar);
        manageRoomGroup_Topbar.setLayout(manageRoomGroup_TopbarLayout);
        manageRoomGroup_TopbarLayout.setHorizontalGroup(
            manageRoomGroup_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomGroup_TopbarLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(64, 64, 64)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageRoomGroup_TopbarLayout.setVerticalGroup(
            manageRoomGroup_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRoomGroup_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageRoomGroup_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(manageRoomGroup_Topbar);

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

    private void btn_addRoomsGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsGroupMouseClicked
        // TODO add your handling code here:
        jp_addRoomsGroup.setVisible(true);
        jp_manageRoomsGroup.setVisible(false);
        addRoomGroup_TopBar.setVisible(true);
        manageRoomGroup_Topbar.setVisible(false);
        btn_addRoomsGroup.setBackground(new java.awt.Color(8,142,88));
        btn_ManageRoomsGroup.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addRoomsGroupMouseClicked

    private void btn_addRoomsGroupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsGroupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsGroupMouseEntered

    private void btn_addRoomsGroupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsGroupMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsGroupMouseExited

    private void btn_addRoomsGroupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addRoomsGroupMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addRoomsGroupMousePressed

    private void btn_ManageRoomsGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsGroupMouseClicked
        // TODO add your handling code here:
        jp_manageRoomsGroup.setVisible(true);
        jp_addRoomsGroup.setVisible(false);
        addRoomGroup_TopBar.setVisible(false);
        manageRoomGroup_Topbar.setVisible(true);
        btn_ManageRoomsGroup.setBackground(new java.awt.Color(8,142,88));
        btn_addRoomsGroup.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageRoomsGroupMouseClicked

    private void btn_ManageRoomsGroupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsGroupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageRoomsGroupMouseEntered

    private void btn_ManageRoomsGroupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageRoomsGroupMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageRoomsGroupMouseExited

    private void addRoomGroup_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomGroup_backBtnActionPerformed
        // TODO add your handling code here:
        ALocationHome aaLocationHome = new ALocationHome();
        aaLocationHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoomGroup_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFieldsAdd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_roomAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roomAddGroupActionPerformed
        // TODO add your handling code here:
        
        this.group_name = roomGroupName.getSelectedItem().toString();
        this.group_subgrpname = roomSubGroupName.getSelectedItem().toString();
        this.group_tag = groupRoomTagName.getSelectedItem().toString();
        this.group_building = groupRoomBuildingName.getSelectedItem().toString();
        this.group_room = groupRoomName.getSelectedItem().toString();

        if (roomGroupName.getSelectedItem().toString().equals("Select Group ID") || roomSubGroupName.getSelectedItem().toString().equals("Select Sub Group ID") || groupRoomTagName.getSelectedItem().toString().equals("Select Tag") || groupRoomBuildingName.getSelectedItem().toString().equals("Select Building") || groupRoomName.getSelectedItem().toString().equals("Select Room")) {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

        } else {
            if ("" != roomSubGroupName.getSelectedItem().toString()) {

                try {
                    String query_roomexits = "select groupsub_id from grouprooms where groupsub_id like '"+'%'+roomSubGroupName.getSelectedItem().toString()+'%'+"'";
                    Statement st_rooms = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_rooms.executeQuery(query_roomexits);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "This Group Room Already Exist");

                    } else {

                        try {
                            String query = "insert into grouprooms(group_id, groupsub_id, group_tag, group_building, group_room) "
                            + "values ( ?, ?, ?, ?, ? )";

                            preparedStmt = connection.prepareStatement(query);
                            preparedStmt.setString(1, group_name);
                            preparedStmt.setString(2, group_subgrpname);
                            preparedStmt.setString(3, group_tag);
                            preparedStmt.setString(4, group_building);
                            preparedStmt.setString(5, group_room);

                            preparedStmt.execute();

                            JOptionPane.showMessageDialog(null, "Room Assigned Successfully. \n Thank You!");
                            DefaultTableModel model = (DefaultTableModel) table_displayGroupRoomDetails.getModel();
                            model.setRowCount(0);
                            show_GroupRoomDetails();

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
    }//GEN-LAST:event_btn_roomAddGroupActionPerformed

    private void roomGroupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomGroupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomGroupNameActionPerformed

    private void roomSubGroupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomSubGroupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomSubGroupNameActionPerformed

    private void groupRoomTagNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupRoomTagNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupRoomTagNameActionPerformed

    private void groupRoomBuildingNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupRoomBuildingNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupRoomBuildingNameActionPerformed

    private void table_displayGroupRoomDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_displayGroupRoomDetailsMouseClicked
        // TODO add your handling code here:
        int i = table_displayGroupRoomDetails.getSelectedRow();
        TableModel model = table_displayGroupRoomDetails.getModel();

        roomNo_rowSelected = model.getValueAt(i,0).toString();
        group_subgrpname = model.getValueAt(i,1).toString();
    }//GEN-LAST:event_table_displayGroupRoomDetailsMouseClicked

    private void btn_deleteManageGroupRoomRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteManageGroupRoomRoomActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + roomNo_rowSelected + " - "
            + group_subgrpname + " assigned room details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM grouprooms WHERE grouproom_id = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, roomNo_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Group Room removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) table_displayGroupRoomDetails.getModel();
                model.setRowCount(0);
                show_GroupRoomDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteManageGroupRoomRoomActionPerformed

    private void btn_clearManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearManageMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displayGroupRoomDetails.getModel();
        model.setRowCount(0);
        show_GroupRoomDetails();
    }//GEN-LAST:event_btn_clearManageMouseClicked

    private void btn_clearManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearManageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearManageActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)table_displayGroupRoomDetails.getModel();
        String search = searchTextField.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        table_displayGroupRoomDetails.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void btn_searchManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchManageRoomActionPerformed

    private void btn_refreshManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_displayGroupRoomDetails.getModel();
        model.setRowCount(0);
        show_GroupRoomDetails();
    }//GEN-LAST:event_btn_refreshManageRoomMouseClicked

    private void btn_refreshManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshManageRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshManageRoomActionPerformed

    private void btn_viewRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRoomsTableActionPerformed
        // TODO add your handling code here:
        AViewGroupRoomTable aViewGroupRoomTable = new AViewGroupRoomTable();
        aViewGroupRoomTable.setVisible(true);
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
            java.util.logging.Logger.getLogger(ARoomForGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ARoomForGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ARoomForGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ARoomForGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ARoomForGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel addRoomGroup_TopBar;
    private javax.swing.JButton addRoomGroup_backBtn;
    private javax.swing.JPanel btn_ManageRoomsGroup;
    private javax.swing.JPanel btn_addRoomsGroup;
    private javax.swing.JButton btn_clearManage;
    private javax.swing.JButton btn_deleteManageGroupRoom;
    private javax.swing.JButton btn_refreshManageRoom;
    private javax.swing.JButton btn_roomAddGroup;
    private javax.swing.JButton btn_searchManageRoom;
    private javax.swing.JButton btn_viewRoomsTable;
    private javax.swing.JComboBox<String> groupRoomBuildingName;
    private javax.swing.JComboBox<String> groupRoomName;
    private javax.swing.JComboBox<String> groupRoomTagName;
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
    private javax.swing.JPanel jp_addRoomsGroup;
    private javax.swing.JPanel jp_manageRoomsGroup;
    private javax.swing.JPanel manageRoomGroup_Topbar;
    private javax.swing.JComboBox<String> roomGroupName;
    private javax.swing.JComboBox<String> roomSubGroupName;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table_displayGroupRoomDetails;
    // End of variables declaration//GEN-END:variables
}
