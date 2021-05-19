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
import javax.swing.ComboBoxEditor;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author user
 */
public class HNonOverlap extends javax.swing.JFrame {

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
    private String non_id;
    /**
     * Creates new form HNonOverlap
     */
    public HNonOverlap() {
        initComponents();
        dbconnect();
        show_nonDetails();
        show_SessionDetails();
        btn_addNon.setBackground(new java.awt.Color(8,142,88));
    }

    public ArrayList<HNonOverlapModel> NonList() {
        
        ArrayList<HNonOverlapModel> NonList = new ArrayList<>();
        try {
            String query = "SELECT * FROM NONOVER";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            HNonOverlapModel hNonOverlapModel ;
            
            while(rs.next()){
                hNonOverlapModel = new HNonOverlapModel (rs.getInt("non_id"), rs.getInt("session_id"), rs.getString("session_name"), rs.getString("lecturer_1"), rs.getString("lecturer_2"), rs.getString("lecturer_3"), rs.getString("subject_code"), rs.getString("subject_name"), rs.getString("group_id"), rs.getString("tag"),rs.getInt("student_count"),rs.getString("duration"));
                NonList.add(hNonOverlapModel);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in NonLists method");
            Logger.getLogger(HParallel.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return NonList;
    }
    
   public void show_nonDetails(){
        ArrayList<HNonOverlapModel> NonList = NonList();
        DefaultTableModel tableModel = (DefaultTableModel) display_managenon.getModel();
        
        Object[] row = new Object[13];
        for (int i = 0; i < NonList.size(); i++) {
            row[0] = NonList.get(i).getnonoverID();
            row[1] = NonList.get(i).getsession_id();
            row[2] = NonList.get(i).getsession_name();
            row[3] = NonList.get(i).getlecturer_1();
            row[4] = NonList.get(i).getlecturer_2();
            row[5] = NonList.get(i).getlecturer_3();
            row[6] = NonList.get(i).getsubject_code();
            row[7] = NonList.get(i).getsubject_name();
            row[8] = NonList.get(i).getgroup_id();
            row[9] = NonList.get(i).gettag();
            row[10] = NonList.get(i).getstudent_count();
            row[11] = NonList.get(i).getduration();
            
            tableModel.addRow(row);
        }
    }
   
   
 public ArrayList<VSessionModel> SessionsList() {
        
        ArrayList<VSessionModel> SessionList = new ArrayList<>();
        try {
            String query = "SELECT * FROM SESSIONS";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            VSessionModel vSessionModel ;
            
            while(rs.next()){
                vSessionModel = new VSessionModel (rs.getInt("session_id"),rs.getString("session_name"), rs.getString("lecture_1"), rs.getString("lecture_2"), rs.getString("lecture_3"), rs.getString("subject_code"),rs.getString("subject_name"),rs.getString("group_id"),rs.getString("tag"), rs.getInt("NoStu"), rs.getString("duration"));
                SessionList.add(vSessionModel);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in TagList method");
            Logger.getLogger(HConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return SessionList;
    }
    
   public void show_SessionDetails(){
        ArrayList<VSessionModel> SessionList = SessionsList();
        DefaultTableModel tableModel = (DefaultTableModel) display_sessionstable.getModel();
        
        Object[] row = new Object[15];
        for (int i = 0; i < SessionList.size(); i++) { 
            row[0] = SessionList.get(i).getsession_id();
            row[1] = SessionList.get(i).getsession_name();
            row[2] = SessionList.get(i).getlecturer_1();
            row[3] = SessionList.get(i).getlecturer_2();
            row[4] = SessionList.get(i).getlecturer_3();
            row[5] = SessionList.get(i).getsubject_code();
            row[6] = SessionList.get(i).getsubject_name();
            row[7] = SessionList.get(i).getgroup_id();
            row[8] = SessionList.get(i).gettag();
            row[9] = SessionList.get(i).getstudent_count();
            row[10] = SessionList.get(i).getduration();
            
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
            Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, ex);
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
        btn_addNon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageNon = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addNon_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addTags = new javax.swing.JPanel();
        btn_viewnon = new javax.swing.JButton();
        btn_nonadd = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        display_sessionstable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        Lecturer1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Lecturer2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SubjectCode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        SubjectName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        GroupID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Tag = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        StudentCount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Duration = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        SessionID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        SessionName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Lecturer3 = new javax.swing.JTextField();
        jp_manageTags = new javax.swing.JPanel();
        btn_backTonon = new javax.swing.JButton();
        btn_deletePara = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display_managenon = new javax.swing.JTable();
        JPanel7 = new javax.swing.JPanel();
        addTags_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageTags_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addNon.setBackground(new java.awt.Color(39, 156, 109));
        btn_addNon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addNonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addNonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addNonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addNonMousePressed(evt);
            }
        });
        btn_addNon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/Add_Icon.png"))); // NOI18N
        btn_addNon.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Non Overlap");
        btn_addNon.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 150, -1));

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

        btn_addNon.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addNon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageNon.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageNon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageNonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageNonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageNonMouseExited(evt);
            }
        });
        btn_ManageNon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/Manage_Icon.png"))); // NOI18N
        btn_ManageNon.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Non Overlap");
        btn_ManageNon.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 160, -1));

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

        btn_ManageNon.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManageNon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addNon_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addNon_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addNon_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        addNon_backBtn.setText("BACK");
        addNon_backBtn.setToolTipText("Return To Dashboard");
        addNon_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addNon_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        addNon_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNon_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addNon_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addTags.setBackground(new java.awt.Color(247, 247, 247));

        btn_viewnon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_viewnon.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewnon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        btn_viewnon.setText("VIEW");
        btn_viewnon.setToolTipText("Clear All Fields");
        btn_viewnon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_viewnon.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        btn_viewnon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_viewnonMouseClicked(evt);
            }
        });
        btn_viewnon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewnonActionPerformed(evt);
            }
        });

        btn_nonadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_nonadd.setForeground(new java.awt.Color(255, 255, 255));
        btn_nonadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/add btn.png"))); // NOI18N
        btn_nonadd.setText("ADD");
        btn_nonadd.setToolTipText("Add record to Database");
        btn_nonadd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nonadd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/add btn hover.png"))); // NOI18N
        btn_nonadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nonaddActionPerformed(evt);
            }
        });

        jLabel11.setText("SELECT SESSION");

        display_sessionstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Session Name", "FirstLec", "SecondLec", "ThirdLec", "Subject Code", "Subject Name", "Group ID", "Tag", "Duration", "Student Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_sessionstable.getTableHeader().setReorderingAllowed(false);
        display_sessionstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_sessionstableMouseClicked(evt);
            }
        });
        display_sessionstable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                display_sessionstablePropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(display_sessionstable);

        jLabel8.setText("Lecturer 1");

        Lecturer1.setEditable(false);

        jLabel9.setText("Lecturer 2");

        Lecturer2.setEditable(false);
        Lecturer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lecturer2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Subject code");

        SubjectCode.setEditable(false);
        SubjectCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectCodeActionPerformed(evt);
            }
        });

        jLabel12.setText("Subject Name");

        SubjectName.setEditable(false);

        jLabel13.setText("Group ID");

        GroupID.setEditable(false);

        jLabel14.setText("Tag");

        Tag.setEditable(false);

        jLabel15.setText("Student Count");

        StudentCount.setEditable(false);

        jLabel16.setText("Duration");

        Duration.setEditable(false);

        jLabel17.setText("Session ID");

        SessionID.setEditable(false);

        jLabel18.setText("Session Name");

        SessionName.setEditable(false);

        jLabel19.setText("Lecture 3");

        Lecturer3.setEditable(false);

        javax.swing.GroupLayout jp_addTagsLayout = new javax.swing.GroupLayout(jp_addTags);
        jp_addTags.setLayout(jp_addTagsLayout);
        jp_addTagsLayout.setHorizontalGroup(
            jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addTagsLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addTagsLayout.createSequentialGroup()
                        .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_addTagsLayout.createSequentialGroup()
                                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(StudentCount, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(GroupID, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(SubjectCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jLabel13)))
                                    .addComponent(jLabel15))
                                .addGap(74, 74, 74)
                                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(SubjectName)
                                    .addComponent(Tag)
                                    .addComponent(Duration, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                            .addComponent(jLabel19)
                            .addComponent(jLabel11)
                            .addGroup(jp_addTagsLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(btn_nonadd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(btn_viewnon, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_addTagsLayout.createSequentialGroup()
                                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Lecturer3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(SessionID, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Lecturer1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                                        .addComponent(jLabel17)))
                                .addGap(74, 74, 74)
                                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel9)
                                    .addComponent(Lecturer2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(SessionName))))
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addTagsLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jp_addTagsLayout.setVerticalGroup(
            jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addTagsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SessionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SessionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lecturer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lecturer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(Lecturer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GroupID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nonadd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewnon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel6.add(jp_addTags, "card2");

        jp_manageTags.setBackground(new java.awt.Color(247, 247, 247));
        jp_manageTags.setMinimumSize(new java.awt.Dimension(630, 455));
        jp_manageTags.setPreferredSize(new java.awt.Dimension(625, 329));

        btn_backTonon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_backTonon.setForeground(new java.awt.Color(255, 255, 255));
        btn_backTonon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_backTonon.setText("BACK");
        btn_backTonon.setToolTipText("Update Selected Record");
        btn_backTonon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_backTonon.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_backTonon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backTononActionPerformed(evt);
            }
        });

        btn_deletePara.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_deletePara.setForeground(new java.awt.Color(255, 255, 255));
        btn_deletePara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        btn_deletePara.setText("DELETE");
        btn_deletePara.setToolTipText("Delete Selected Record");
        btn_deletePara.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_deletePara.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        btn_deletePara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteParaActionPerformed(evt);
            }
        });

        display_managenon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Non_ID", "Session ID", "SessionName", "Lecturer 1", "Lecturer 2", "Lecturer 3", "Subject Code", "Subject Name", "Group ID", "Tag", "Student Count", "Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_managenon.getTableHeader().setReorderingAllowed(false);
        display_managenon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_managenonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(display_managenon);

        javax.swing.GroupLayout jp_manageTagsLayout = new javax.swing.GroupLayout(jp_manageTags);
        jp_manageTags.setLayout(jp_manageTagsLayout);
        jp_manageTagsLayout.setHorizontalGroup(
            jp_manageTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageTagsLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jp_manageTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_manageTagsLayout.createSequentialGroup()
                        .addComponent(btn_backTonon, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_deletePara, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_manageTagsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jp_manageTagsLayout.setVerticalGroup(
            jp_manageTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageTagsLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_manageTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deletePara, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_backTonon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jPanel6.add(jp_manageTags, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addTags_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD NON OVERLAPPING SESSION");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.setToolTipText("Logout from system");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addTags_TopBarLayout = new javax.swing.GroupLayout(addTags_TopBar);
        addTags_TopBar.setLayout(addTags_TopBarLayout);
        addTags_TopBarLayout.setHorizontalGroup(
            addTags_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTags_TopBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        addTags_TopBarLayout.setVerticalGroup(
            addTags_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTags_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addTags_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(addTags_TopBar);

        manageTags_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE NON OVERLAP");

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

        javax.swing.GroupLayout manageTags_TopbarLayout = new javax.swing.GroupLayout(manageTags_Topbar);
        manageTags_Topbar.setLayout(manageTags_TopbarLayout);
        manageTags_TopbarLayout.setHorizontalGroup(
            manageTags_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageTags_TopbarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageTags_TopbarLayout.setVerticalGroup(
            manageTags_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageTags_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageTags_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        JPanel7.add(manageTags_Topbar);

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
                    .addComponent(JPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
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

    private void btn_addNonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMouseClicked
        // TODO add your handling code here:
        jp_addTags.setVisible(true);
        jp_manageTags.setVisible(false);
        addTags_TopBar.setVisible(true);
        manageTags_Topbar.setVisible(false);
        btn_addNon.setBackground(new java.awt.Color(8,142,88));
        btn_ManageNon.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addNonMouseClicked

    private void btn_addNonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNonMouseEntered

    private void btn_addNonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNonMouseExited

    private void btn_addNonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addNonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNonMousePressed

    private void btn_ManageNonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageNonMouseClicked
        // TODO add your handling code here:
        jp_manageTags.setVisible(true);
        jp_addTags.setVisible(false);
        addTags_TopBar.setVisible(false);
        manageTags_Topbar.setVisible(true);
        btn_ManageNon.setBackground(new java.awt.Color(8,142,88));
        btn_addNon.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageNonMouseClicked

    private void btn_ManageNonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageNonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageNonMouseEntered

    private void btn_ManageNonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageNonMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageNonMouseExited

    private void addNon_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNon_backBtnActionPerformed
        // TODO add your handling code here:

        new HCPNSessionsHome().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addNon_backBtnActionPerformed

    private void btn_viewnonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewnonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_viewnonActionPerformed

    private void btn_nonaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nonaddActionPerformed
        // TODO add your handling code here:

        this.session_id = SessionID.getText();
        this.session_name = SessionName.getText();
        this.lecturer_1 = Lecturer1.getText();
        this.lecturer_2 = Lecturer2.getText();
        this.lecturer_3 = Lecturer3.getText();
        this.subject_code = SubjectCode.getText();
        this.subject_name = SubjectName.getText();
        this.group_id = GroupID.getText();
        this.tag = Tag.getText();
        this.student_count = StudentCount.getText();
        this.duration = Duration.getText();

        if(SessionID.getText().equals("") || SessionName.getText().equals("") ||  SubjectCode.getText().equals("") || SubjectName.getText().equals("") || GroupID.getText().equals("") || Tag.getText().equals("") || GroupID.getText().equals("") || GroupID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select session");

       
            }else {

                if  ("" != SessionID.getText()) {

                    try {
                        String query_tagsexits = "select * from NONOVER where session_id=" + SessionID.getText() + "";
                        Statement st_tag = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                        ResultSet rs1 = st_tag.executeQuery(query_tagsexits);
                        if (rs1.first()) {
                            JOptionPane.showMessageDialog(null, "This Non Overlapping Session Already Exist");

                        } else {
                            try {
                                String query = "insert into NONOVER(session_id, session_name, lecturer_1, lecturer_2, lecturer_3, subject_code, subject_name, group_id, tag, student_count, duration) "
                                + "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

                                preparedStmt = connection.prepareStatement(query);
                                preparedStmt.setString(1, session_id);
                                preparedStmt.setString(2, session_name);
                                preparedStmt.setString(3, lecturer_1);
                                preparedStmt.setString(4, lecturer_2);
                                preparedStmt.setString(5, lecturer_3);
                                preparedStmt.setString(6, subject_code);
                                preparedStmt.setString(7, subject_name);
                                preparedStmt.setString(8, group_id);
                                preparedStmt.setString(9, tag);
                                preparedStmt.setString(10, student_count);
                                preparedStmt.setString(11, duration);

                                preparedStmt.execute();

                                JOptionPane.showMessageDialog(null, "Non Overlapping Session Added Successfully. \n Thank You!");
                                DefaultTableModel model = (DefaultTableModel) display_managenon.getModel();
                                model.setRowCount(0);
                                show_nonDetails();

                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                                System.err.println("Got an exception!");
                                System.err.println(e.getMessage());
                                Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, e);
                            }

                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                        System.err.println("Got an exception!");
                        System.err.println(e.getMessage());
                        Logger.getLogger(HNonOverlap.class.getName()).log(Level.SEVERE, null, e);
                    }

                }

            
        }
    }//GEN-LAST:event_btn_nonaddActionPerformed

    private void display_sessionstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_sessionstableMouseClicked
        // TODO add your handling code here:
        TableModel model = display_sessionstable.getModel();
        int i = display_sessionstable.getSelectedRow();

                SessionID.setText(model.getValueAt(i, 0).toString());
                SessionName.setText(model.getValueAt(i, 1).toString());
                Lecturer1.setText(model.getValueAt(i, 2).toString());
                Lecturer2.setText(model.getValueAt(i, 3).toString());
                Lecturer3.setText(model.getValueAt(i, 4).toString());
                SubjectCode.setText(model.getValueAt(i, 5).toString());
                SubjectName.setText(model.getValueAt(i, 6).toString());
                GroupID.setText(model.getValueAt(i, 7).toString());
                Tag.setText(model.getValueAt(i,8).toString());
                StudentCount.setText(model.getValueAt(i,9).toString());
                Duration.setText(model.getValueAt(i,10).toString());

                Hnon_rowSelected = model.getValueAt(i, 0).toString();
                session_id = model.getValueAt(i, 0).toString();
                session_name = model.getValueAt(i, 1).toString();
                lecturer_1 = model.getValueAt(i, 2).toString();
                lecturer_2 = model.getValueAt(i, 3).toString();
                lecturer_3 = model.getValueAt(i, 4).toString();
                subject_code = model.getValueAt(i, 5).toString();
                subject_name = model.getValueAt(i, 6).toString();
                group_id = model.getValueAt(i, 7).toString();
                tag = model.getValueAt(i,8).toString();
                student_count = model.getValueAt(i, 9).toString();
                duration = model.getValueAt(i, 10).toString();
            
        
    }//GEN-LAST:event_display_sessionstableMouseClicked

    private void display_sessionstablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_display_sessionstablePropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_display_sessionstablePropertyChange

    private void Lecturer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lecturer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Lecturer2ActionPerformed

    private void SubjectCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectCodeActionPerformed

    private void btn_backTononActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backTononActionPerformed
        //TODO add your handling code here:
        jp_addTags.setVisible(true);
        jp_manageTags.setVisible(false);
        addTags_TopBar.setVisible(true);
        manageTags_Topbar.setVisible(false);
        btn_addNon.setBackground(new java.awt.Color(8,142,88));
        btn_ManageNon.setBackground(new java.awt.Color(39,156,109));

    }//GEN-LAST:event_btn_backTononActionPerformed

    private void btn_deleteParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteParaActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + Hmanagerow_rowSelected + " - "
            + non_id + " details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM NONOVER WHERE non_id =?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, Hmanagerow_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Non session removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) display_managenon.getModel();
                model.setRowCount(0);
                show_nonDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btn_deleteParaActionPerformed

    private void display_managenonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_managenonMouseClicked
        // TODO add your handling code here:
        int i = display_managenon.getSelectedRow();
        TableModel model = display_managenon.getModel();

        Hmanagerow_rowSelected = model.getValueAt(i, 0).toString();

    }//GEN-LAST:event_display_managenonMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_viewnonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewnonMouseClicked
        // TODO add your handling code here:
         jp_manageTags.setVisible(true);
        jp_addTags.setVisible(false);
        addTags_TopBar.setVisible(false);
        manageTags_Topbar.setVisible(true);
        btn_ManageNon.setBackground(new java.awt.Color(8,142,88));
        btn_addNon.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_viewnonMouseClicked

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
            java.util.logging.Logger.getLogger(HNonOverlap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HNonOverlap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HNonOverlap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HNonOverlap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HNonOverlap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JTextField Duration;
    private javax.swing.JTextField GroupID;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JTextField Lecturer1;
    private javax.swing.JTextField Lecturer2;
    private javax.swing.JTextField Lecturer3;
    private javax.swing.JTextField SessionID;
    private javax.swing.JTextField SessionName;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JTextField StudentCount;
    private javax.swing.JTextField SubjectCode;
    private javax.swing.JTextField SubjectName;
    private javax.swing.JTextField Tag;
    private javax.swing.JButton addNon_backBtn;
    private javax.swing.JPanel addTags_TopBar;
    private javax.swing.JPanel btn_ManageNon;
    private javax.swing.JPanel btn_addNon;
    private javax.swing.JButton btn_backTonon;
    private javax.swing.JButton btn_deletePara;
    private javax.swing.JButton btn_nonadd;
    private javax.swing.JButton btn_viewnon;
    private javax.swing.JTable display_managenon;
    private javax.swing.JTable display_sessionstable;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jp_addTags;
    private javax.swing.JPanel jp_manageTags;
    private javax.swing.JPanel manageTags_Topbar;
    // End of variables declaration//GEN-END:variables
}
