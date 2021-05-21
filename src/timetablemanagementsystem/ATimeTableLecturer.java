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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.ComboBoxEditor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author ashan
 */
public class ATimeTableLecturer extends javax.swing.JFrame {
    
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
     * Creates new form ATimeTableLecturer
     */
    public ATimeTableLecturer() {
        initComponents();
        dbconnect();
        generatetimetble();
        SelectLec();
        btn_LecturerTimetableSide.setBackground(new java.awt.Color(8,142,88));
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
                String bnames = rst.getString("lecturer_1");
                LecCombo.addItem(bnames);
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
        btn_LecturerTimetableSide = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lecturerTimetable_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_lecturerTimeTablePnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        display_generatetablelec = new javax.swing.JTable();
        btn_printLecturerTable = new javax.swing.JButton();
        btn_GenerateLecturerTable = new javax.swing.JButton();
        btn_refreshLecturerTable = new javax.swing.JButton();
        LecCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JPanel7 = new javax.swing.JPanel();
        lecturerTimeTable_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_LecturerTimetableSide.setBackground(new java.awt.Color(39, 156, 109));
        btn_LecturerTimetableSide.setToolTipText("If you click this you can view manage rooms page");
        btn_LecturerTimetableSide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LecturerTimetableSideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_LecturerTimetableSideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_LecturerTimetableSideMouseExited(evt);
            }
        });
        btn_LecturerTimetableSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/time_table_icon.png"))); // NOI18N
        btn_LecturerTimetableSide.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 37, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Lecturer TimeTable");
        btn_LecturerTimetableSide.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, -1));

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

        btn_LecturerTimetableSide.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_LecturerTimetableSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        lecturerTimetable_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lecturerTimetable_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        lecturerTimetable_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        lecturerTimetable_backBtn.setText("BACK");
        lecturerTimetable_backBtn.setToolTipText("Go Back");
        lecturerTimetable_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lecturerTimetable_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        lecturerTimetable_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturerTimetable_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(lecturerTimetable_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_lecturerTimeTablePnl.setBackground(new java.awt.Color(247, 247, 247));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        display_generatetablelec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Days", "Time Slots", "Session Details"
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

        btn_printLecturerTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_printLecturerTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_printLecturerTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/print_btn.png"))); // NOI18N
        btn_printLecturerTable.setText("PRINT");
        btn_printLecturerTable.setToolTipText("If you click this all fields will be empy");
        btn_printLecturerTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_printLecturerTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/print_btn_hover.png"))); // NOI18N
        btn_printLecturerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printLecturerTableMouseClicked(evt);
            }
        });
        btn_printLecturerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printLecturerTableActionPerformed(evt);
            }
        });

        btn_GenerateLecturerTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_GenerateLecturerTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_GenerateLecturerTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_GenerateLecturerTable.setText("Generate");
        btn_GenerateLecturerTable.setToolTipText("If you clcik this you can search all details of rooms");
        btn_GenerateLecturerTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_GenerateLecturerTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_GenerateLecturerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GenerateLecturerTableActionPerformed(evt);
            }
        });

        btn_refreshLecturerTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_refreshLecturerTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_refreshLecturerTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_refreshLecturerTable.setText("REFRESH");
        btn_refreshLecturerTable.setToolTipText("If you click this you refresh page");
        btn_refreshLecturerTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refreshLecturerTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_refreshLecturerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshLecturerTableMouseClicked(evt);
            }
        });
        btn_refreshLecturerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshLecturerTableActionPerformed(evt);
            }
        });

        LecCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer" }));
        LecCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LecComboActionPerformed(evt);
            }
        });
        LecCombo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LecComboPropertyChange(evt);
            }
        });
        LecCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LecComboKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LecComboKeyReleased(evt);
            }
        });

        jLabel2.setText("Select Lecturer :");

        javax.swing.GroupLayout jp_lecturerTimeTablePnlLayout = new javax.swing.GroupLayout(jp_lecturerTimeTablePnl);
        jp_lecturerTimeTablePnl.setLayout(jp_lecturerTimeTablePnlLayout);
        jp_lecturerTimeTablePnlLayout.setHorizontalGroup(
            jp_lecturerTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_lecturerTimeTablePnlLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jp_lecturerTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_lecturerTimeTablePnlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LecCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_GenerateLecturerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_lecturerTimeTablePnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_refreshLecturerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_printLecturerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jp_lecturerTimeTablePnlLayout.setVerticalGroup(
            jp_lecturerTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_lecturerTimeTablePnlLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jp_lecturerTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_GenerateLecturerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LecCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jp_lecturerTimeTablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refreshLecturerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_printLecturerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jPanel6.add(jp_lecturerTimeTablePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));

        lecturerTimeTable_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LECTURER TIMETABLE");

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

        javax.swing.GroupLayout lecturerTimeTable_TopbarLayout = new javax.swing.GroupLayout(lecturerTimeTable_Topbar);
        lecturerTimeTable_Topbar.setLayout(lecturerTimeTable_TopbarLayout);
        lecturerTimeTable_TopbarLayout.setHorizontalGroup(
            lecturerTimeTable_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lecturerTimeTable_TopbarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        lecturerTimeTable_TopbarLayout.setVerticalGroup(
            lecturerTimeTable_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lecturerTimeTable_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(lecturerTimeTable_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPanel7Layout = new javax.swing.GroupLayout(JPanel7);
        JPanel7.setLayout(JPanel7Layout);
        JPanel7Layout.setHorizontalGroup(
            JPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lecturerTimeTable_Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JPanel7Layout.setVerticalGroup(
            JPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lecturerTimeTable_Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LecturerTimetableSideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LecturerTimetableSideMouseClicked
        // TODO add your handling code here:
        jp_lecturerTimeTablePnl.setVisible(true);;
        lecturerTimeTable_Topbar.setVisible(true);
        btn_LecturerTimetableSide.setBackground(new java.awt.Color(8,142,88));
    }//GEN-LAST:event_btn_LecturerTimetableSideMouseClicked

    private void btn_LecturerTimetableSideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LecturerTimetableSideMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LecturerTimetableSideMouseEntered

    private void btn_LecturerTimetableSideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LecturerTimetableSideMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_LecturerTimetableSideMouseExited

    private void lecturerTimetable_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturerTimetable_backBtnActionPerformed
        // TODO add your handling code here:
        ATimeTablesHome aTimeTablesHome = new ATimeTablesHome();
        aTimeTablesHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lecturerTimetable_backBtnActionPerformed

    private void display_generatetablelecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_generatetablelecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_display_generatetablelecMouseClicked

    private void btn_printLecturerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printLecturerTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printLecturerTableMouseClicked

    private void btn_printLecturerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printLecturerTableActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Timetable Report");
        try {
            display_generatetablelec.print(JTable.PrintMode.NORMAL, header, null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btn_printLecturerTableActionPerformed

    private void btn_GenerateLecturerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerateLecturerTableActionPerformed
        // TODO add your handling code here:
       
        DefaultTableModel table_model = (DefaultTableModel) display_generatetablelec.getModel();
        String searchTxt = LecCombo.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table_model);
        display_generatetablelec.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchTxt)); 
     
        
    }//GEN-LAST:event_btn_GenerateLecturerTableActionPerformed

    private void btn_refreshLecturerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshLecturerTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshLecturerTableMouseClicked

    private void btn_refreshLecturerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshLecturerTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshLecturerTableActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void LecComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LecComboKeyPressed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_LecComboKeyPressed

    private void LecComboPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LecComboPropertyChange
        // TODO add your handling code here:
         
    }//GEN-LAST:event_LecComboPropertyChange

    private void LecComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LecComboKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_LecComboKeyReleased

    private void LecComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LecComboActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_LecComboActionPerformed

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
            java.util.logging.Logger.getLogger(ATimeTableLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATimeTableLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATimeTableLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATimeTableLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATimeTableLecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JComboBox<String> LecCombo;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btn_GenerateLecturerTable;
    private javax.swing.JPanel btn_LecturerTimetableSide;
    private javax.swing.JButton btn_printLecturerTable;
    private javax.swing.JButton btn_refreshLecturerTable;
    private javax.swing.JTable display_generatetablelec;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_lecturerTimeTablePnl;
    private javax.swing.JPanel lecturerTimeTable_Topbar;
    private javax.swing.JButton lecturerTimetable_backBtn;
    // End of variables declaration//GEN-END:variables
}
