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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.ComboBoxEditor;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author ashan
 */
public class ATimeTableGroup extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String Hnon_rowSelected;
    private String Hmanagerow_rowSelected;
    private String session_id, session_name;
    private String lecturer_1,lecturer_2, lecturer_3;
    private String subject_code,subject_name;
    private String group_id,tag;
    private String student_count, duration;
    private String assign_id ,timeslot ,day;
    /**
     * Creates new form ATimeTableGroup
     */
    public ATimeTableGroup() {
        initComponents();
        dbconnect();
        generatetimetble();
        SelectLec();
        btn_GroupsTimetableSide.setBackground(new java.awt.Color(8,142,88));
    }
    
     private void dbconnect(){
        String currentDir = System.getProperty("user.dir");
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String JDBC_URL = "jdbc:derby:"+currentDir+"\\TTMS";
        
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
     }
     
     public ArrayList<UAssignTimeModel> AssignTimeList() {
        
        ArrayList<UAssignTimeModel> NonList = new ArrayList<>();
        try {
            String query = "SELECT * FROM ASSIGNTIME order by days";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            UAssignTimeModel uAssignTimeModel ;
            
            while(rs.next()){
                uAssignTimeModel = new UAssignTimeModel (rs.getInt("assigntime_id"), rs.getInt("session_id"), rs.getString("session_name"), rs.getString("lecturer_1"), rs.getString("lecturer_2"), rs.getString("lecturer_3"), rs.getString("subject_code"), rs.getString("subject_name"), rs.getString("group_id"), rs.getString("tag"),rs.getInt("student_count"),rs.getString("duration"),rs.getString("room"), rs.getString("timeslot"), rs.getString("days"));
                NonList.add(uAssignTimeModel);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in NonLists method");
            Logger.getLogger(HParallel.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return NonList;
    }
    
      public void generatetimetble(){
         ArrayList<UAssignTimeModel> AssignTimeList = AssignTimeList();
        DefaultTableModel tableModel = (DefaultTableModel) display_generatetablelec.getModel();
         
         

         Object[] row = new Object[15];
          for (int i = 0; i < AssignTimeList.size(); i++) {

             row[0] = AssignTimeList.get(i).getday(); 

             String lecture = AssignTimeList.get(i).getlecturer_1();
             String subcode = AssignTimeList.get(i).getsubject_code();
             String tag = AssignTimeList.get(i).gettag();
             String group_id = AssignTimeList.get(i).getgroup_id();
             String room = AssignTimeList.get(i).getroom();
             String rowdetails = ""+lecture+" , "+ subcode+" , "+tag +" ," +group_id +", " +room +" " ;
           
              
             row[1] = AssignTimeList.get(i).gettimeslot();
             row[2] = rowdetails;
             
             
 
              tableModel.addRow(row);
              
          }
        }
      
       private void SelectLec(){
        try {
            String bcomboquery = "SELECT * FROM ASSIGNTIME";
            preparedStmt = connection.prepareStatement(bcomboquery);
            ResultSet rst = preparedStmt.executeQuery();
            
            while(rst.next()){
                String bnames = rst.getString("group_id");
                GroupCombo.addItem(bnames);
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
        btn_GroupsTimetableSide = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        groupsTimetable_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_groupsTimeTablePnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        display_generatetablelec = new javax.swing.JTable();
        btn_printGroupsTable = new javax.swing.JButton();
        btn_GenerateGroupsTable = new javax.swing.JButton();
        btn_refreshGroupsTable = new javax.swing.JButton();
        GroupCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JPanel7 = new javax.swing.JPanel();
        groupsTimeTable_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_GroupsTimetableSide.setBackground(new java.awt.Color(39, 156, 109));
        btn_GroupsTimetableSide.setToolTipText("If you click this you can view manage rooms page");
        btn_GroupsTimetableSide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GroupsTimetableSideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_GroupsTimetableSideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_GroupsTimetableSideMouseExited(evt);
            }
        });
        btn_GroupsTimetableSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/time_table_icon.png"))); // NOI18N
        btn_GroupsTimetableSide.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 37, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Groups TimeTable");
        btn_GroupsTimetableSide.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_GroupsTimetableSide.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_GroupsTimetableSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        groupsTimetable_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groupsTimetable_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        groupsTimetable_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        groupsTimetable_backBtn.setText("BACK");
        groupsTimetable_backBtn.setToolTipText("Go Back");
        groupsTimetable_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        groupsTimetable_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        groupsTimetable_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupsTimetable_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(groupsTimetable_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_groupsTimeTablePnl.setBackground(new java.awt.Color(247, 247, 247));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        display_generatetablelec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Time Slots", "Session Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_generatetablelec.getTableHeader().setReorderingAllowed(false);
        display_generatetablelec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_generatetablelecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(display_generatetablelec);
        if (display_generatetablelec.getColumnModel().getColumnCount() > 0) {
            display_generatetablelec.getColumnModel().getColumn(0).setMinWidth(80);
            display_generatetablelec.getColumnModel().getColumn(1).setMinWidth(80);
            display_generatetablelec.getColumnModel().getColumn(2).setMinWidth(300);
        }

        btn_printGroupsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_printGroupsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_printGroupsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/print_btn.png"))); // NOI18N
        btn_printGroupsTable.setText("PRINT");
        btn_printGroupsTable.setToolTipText("If you click this all fields will be empy");
        btn_printGroupsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_printGroupsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/print_btn_hover.png"))); // NOI18N
        btn_printGroupsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printGroupsTableMouseClicked(evt);
            }
        });
        btn_printGroupsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printGroupsTableActionPerformed(evt);
            }
        });

        btn_GenerateGroupsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_GenerateGroupsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_GenerateGroupsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_GenerateGroupsTable.setText("Generate");
        btn_GenerateGroupsTable.setToolTipText("If you clcik this you can search all details of rooms");
        btn_GenerateGroupsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_GenerateGroupsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_GenerateGroupsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GenerateGroupsTableActionPerformed(evt);
            }
        });

        btn_refreshGroupsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_refreshGroupsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_refreshGroupsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_refreshGroupsTable.setText("REFRESH");
        btn_refreshGroupsTable.setToolTipText("If you click this you refresh page");
        btn_refreshGroupsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refreshGroupsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_refreshGroupsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshGroupsTableMouseClicked(evt);
            }
        });
        btn_refreshGroupsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshGroupsTableActionPerformed(evt);
            }
        });

        GroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Group" }));

        jLabel2.setText("Select Sub-Group / Group :");

        javax.swing.GroupLayout jp_groupsTimeTablePnlLayout = new javax.swing.GroupLayout(jp_groupsTimeTablePnl);
        jp_groupsTimeTablePnl.setLayout(jp_groupsTimeTablePnlLayout);
        jp_groupsTimeTablePnlLayout.setHorizontalGroup(
            jp_groupsTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_groupsTimeTablePnlLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_groupsTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_groupsTimeTablePnlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_GenerateGroupsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_groupsTimeTablePnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_refreshGroupsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_printGroupsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        jp_groupsTimeTablePnlLayout.setVerticalGroup(
            jp_groupsTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_groupsTimeTablePnlLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_groupsTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_GenerateGroupsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jp_groupsTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refreshGroupsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_printGroupsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jPanel6.add(jp_groupsTimeTablePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));

        groupsTimeTable_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GROUPS TIMETABLE");

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

        javax.swing.GroupLayout groupsTimeTable_TopbarLayout = new javax.swing.GroupLayout(groupsTimeTable_Topbar);
        groupsTimeTable_Topbar.setLayout(groupsTimeTable_TopbarLayout);
        groupsTimeTable_TopbarLayout.setHorizontalGroup(
            groupsTimeTable_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupsTimeTable_TopbarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        groupsTimeTable_TopbarLayout.setVerticalGroup(
            groupsTimeTable_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupsTimeTable_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(groupsTimeTable_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPanel7Layout = new javax.swing.GroupLayout(JPanel7);
        JPanel7.setLayout(JPanel7Layout);
        JPanel7Layout.setHorizontalGroup(
            JPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(groupsTimeTable_Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JPanel7Layout.setVerticalGroup(
            JPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(groupsTimeTable_Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
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

    private void btn_GroupsTimetableSideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GroupsTimetableSideMouseClicked
        // TODO add your handling code here:
        jp_groupsTimeTablePnl.setVisible(true);;
        groupsTimeTable_Topbar.setVisible(true);
        btn_GroupsTimetableSide.setBackground(new java.awt.Color(8,142,88));
    }//GEN-LAST:event_btn_GroupsTimetableSideMouseClicked

    private void btn_GroupsTimetableSideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GroupsTimetableSideMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_GroupsTimetableSideMouseEntered

    private void btn_GroupsTimetableSideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GroupsTimetableSideMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_GroupsTimetableSideMouseExited

    private void groupsTimetable_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupsTimetable_backBtnActionPerformed
        // TODO add your handling code here:
        ATimeTablesHome aTimeTablesHome = new ATimeTablesHome();
        aTimeTablesHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_groupsTimetable_backBtnActionPerformed

    private void display_generatetablelecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_generatetablelecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_display_generatetablelecMouseClicked

    private void btn_printGroupsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printGroupsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printGroupsTableMouseClicked

    private void btn_printGroupsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printGroupsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printGroupsTableActionPerformed

    private void btn_GenerateGroupsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerateGroupsTableActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel table_model = (DefaultTableModel) display_generatetablelec.getModel();
        String searchTxt = GroupCombo.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table_model);
        display_generatetablelec.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchTxt)); 
        
    }//GEN-LAST:event_btn_GenerateGroupsTableActionPerformed

    private void btn_refreshGroupsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshGroupsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshGroupsTableMouseClicked

    private void btn_refreshGroupsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshGroupsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshGroupsTableActionPerformed

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
            java.util.logging.Logger.getLogger(ATimeTableGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATimeTableGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATimeTableGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATimeTableGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATimeTableGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JComboBox<String> GroupCombo;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btn_GenerateGroupsTable;
    private javax.swing.JPanel btn_GroupsTimetableSide;
    private javax.swing.JButton btn_printGroupsTable;
    private javax.swing.JButton btn_refreshGroupsTable;
    private javax.swing.JTable display_generatetablelec;
    private javax.swing.JPanel groupsTimeTable_Topbar;
    private javax.swing.JButton groupsTimetable_backBtn;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_groupsTimeTablePnl;
    // End of variables declaration//GEN-END:variables
}
