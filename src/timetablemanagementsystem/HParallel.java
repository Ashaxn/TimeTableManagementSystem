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
public class HParallel extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    private String HPara_rowSelected;
    private String Hmanagerow_rowSelected;
    private String session_id1, session_id2;
    private String sub_code1,sub_code2;
    private String sub_name1,sub_name2;
    private String tag1,tag2;
    private String para_name;
    
    
    /**
     * Creates new form HParallel
     */
    public HParallel() {
        initComponents();
        dbconnect();
        show_ParaDetails();
        show_SessionDetails();
        btn_addPara.setBackground(new java.awt.Color(8,142,88));
    }
    
    public ArrayList<HParallelModel> ParaList() {
        
        ArrayList<HParallelModel> ParaList = new ArrayList<>();
        try {
            String query = "SELECT * FROM PARA";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            HParallelModel hParallelModel ;
            
            while(rs.next()){
                hParallelModel = new HParallelModel (rs.getInt("para_id"),rs.getString("para_name"), rs.getInt("sessionid1"), rs.getInt("sessionid2"), rs.getString("SubCode1"), rs.getString("SubCode2"), rs.getString("SubName1"),rs.getString("SubName2"),rs.getString("Tag1"),rs.getString("Tag2"));
                ParaList.add(hParallelModel);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in ConsecsList method");
            Logger.getLogger(HParallel.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return ParaList;
    }
    
   public void show_ParaDetails(){
        ArrayList<HParallelModel> ParaList = ParaList();
        DefaultTableModel tableModel = (DefaultTableModel) display_manageparal.getModel();
        
        Object[] row = new Object[10];
        for (int i = 0; i < ParaList.size(); i++) {
            row[0] = ParaList.get(i).getparallel_id();
            row[1] = ParaList.get(i).getparallel_name();
            row[2] = ParaList.get(i).getsessionid1();
            row[3] = ParaList.get(i).getsessionid2();
            row[4] = ParaList.get(i).getSubCode1();
            row[5] = ParaList.get(i).getSubCode2();
            row[6] = ParaList.get(i).getSubName1();
            row[7] = ParaList.get(i).getSubName2();
            row[8] = ParaList.get(i).getTag1();
            row[9] = ParaList.get(i).getTag2();
            
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
            row[0] = false;
            row[1] = SessionList.get(i).getsession_id();
            row[2] = SessionList.get(i).getsession_name();
            row[3] = SessionList.get(i).getlecturer_1();
            row[4] = SessionList.get(i).getlecturer_2();
            row[5] = SessionList.get(i).getlecturer_3();
            row[6] = SessionList.get(i).getsubject_code();
            row[7] = SessionList.get(i).getsubject_name();
            row[8] = SessionList.get(i).getgroup_id();
            row[9] = SessionList.get(i).gettag();
            row[10] = SessionList.get(i).getstudent_count();
            row[11] = SessionList.get(i).getduration();
            
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
            Logger.getLogger(HAddTags.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HAddTags.class.getName()).log(Level.SEVERE, null, ex);
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
        btn_addPara = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManagePara = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addPara_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addTags = new javax.swing.JPanel();
        btn_viewparadetails = new javax.swing.JButton();
        btn_paraladd = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        display_sessionstable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        SessionID2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        SessionID1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SubCode2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        SubCode1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        SubjectName2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        SubjectName1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Tag2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Tag1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ParaName = new javax.swing.JTextField();
        jp_manageTags = new javax.swing.JPanel();
        btn_backToAdd = new javax.swing.JButton();
        btn_deletePara = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display_manageparal = new javax.swing.JTable();
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

        btn_addPara.setBackground(new java.awt.Color(39, 156, 109));
        btn_addPara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addParaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addParaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addParaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addParaMousePressed(evt);
            }
        });
        btn_addPara.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/Add_Icon.png"))); // NOI18N
        btn_addPara.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Parallel");
        btn_addPara.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 150, -1));

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

        btn_addPara.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManagePara.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManagePara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageParaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageParaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageParaMouseExited(evt);
            }
        });
        btn_ManagePara.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/Manage_Icon.png"))); // NOI18N
        btn_ManagePara.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 37, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Parallel");
        btn_ManagePara.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 160, -1));

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

        btn_ManagePara.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_ManagePara, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addPara_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addPara_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addPara_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        addPara_backBtn.setText("BACK");
        addPara_backBtn.setToolTipText("Return To Dashboard");
        addPara_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addPara_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        addPara_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPara_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addPara_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addTags.setBackground(new java.awt.Color(247, 247, 247));

        btn_viewparadetails.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_viewparadetails.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewparadetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn.png"))); // NOI18N
        btn_viewparadetails.setText("VIEW");
        btn_viewparadetails.setToolTipText("Clear All Fields");
        btn_viewparadetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_viewparadetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/clear btn hover.png"))); // NOI18N
        btn_viewparadetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_viewparadetailsMouseClicked(evt);
            }
        });
        btn_viewparadetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewparadetailsActionPerformed(evt);
            }
        });

        btn_paraladd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_paraladd.setForeground(new java.awt.Color(255, 255, 255));
        btn_paraladd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/add btn.png"))); // NOI18N
        btn_paraladd.setText("ADD");
        btn_paraladd.setToolTipText("Add record to Database");
        btn_paraladd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_paraladd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/HImages/add btn hover.png"))); // NOI18N
        btn_paraladd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paraladdActionPerformed(evt);
            }
        });

        jLabel11.setText("SELECT SESSIONS");

        display_sessionstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "ID", "FirstLec", "SecondLec", "Subject Code", "Subject Name", "Group ID", "Tag", "Duration", "Student Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jLabel8.setText("Session ID 1");

        SessionID2.setEditable(false);

        jLabel9.setText("Session ID 2");

        SessionID1.setEditable(false);
        SessionID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SessionID1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Subject Code 1");

        SubCode2.setEditable(false);
        SubCode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCode2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Subject Code 2");

        SubCode1.setEditable(false);

        jLabel13.setText("Subject Name 1");

        SubjectName2.setEditable(false);

        jLabel14.setText("Subject Name 2");

        SubjectName1.setEditable(false);

        jLabel15.setText("Tag 1");

        Tag2.setEditable(false);

        jLabel16.setText("Tag 2");

        Tag1.setEditable(false);

        jLabel17.setText("Parallel Name");

        javax.swing.GroupLayout jp_addTagsLayout = new javax.swing.GroupLayout(jp_addTags);
        jp_addTags.setLayout(jp_addTagsLayout);
        jp_addTagsLayout.setHorizontalGroup(
            jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addTagsLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addTagsLayout.createSequentialGroup()
                            .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(jp_addTagsLayout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addComponent(btn_paraladd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(64, 64, 64)
                                    .addComponent(btn_viewparadetails, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(158, 158, 158))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addTagsLayout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(76, 76, 76)))
                    .addGroup(jp_addTagsLayout.createSequentialGroup()
                        .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ParaName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Tag2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(SubjectName2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(SubCode2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(SessionID2, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addComponent(jLabel10)))
                                        .addComponent(jLabel13)))
                                .addComponent(jLabel15)))
                        .addGap(74, 74, 74)
                        .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(SessionID1)
                            .addComponent(SubCode1)
                            .addComponent(SubjectName1)
                            .addComponent(Tag1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))))
        );
        jp_addTagsLayout.setVerticalGroup(
            jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addTagsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ParaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SessionID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SessionID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubjectName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubjectName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jp_addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_paraladd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewparadetails, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel6.add(jp_addTags, "card2");

        jp_manageTags.setBackground(new java.awt.Color(247, 247, 247));
        jp_manageTags.setMinimumSize(new java.awt.Dimension(630, 455));
        jp_manageTags.setPreferredSize(new java.awt.Dimension(625, 329));

        btn_backToAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_backToAdd.setForeground(new java.awt.Color(255, 255, 255));
        btn_backToAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_backToAdd.setText("BACK");
        btn_backToAdd.setToolTipText("Update Selected Record");
        btn_backToAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_backToAdd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_backToAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backToAddActionPerformed(evt);
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

        display_manageparal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Para ID", "Para_Name", "SessionID1", "SessionID2", "SubCode1", "SubCode2", "SubName1", "SubName1", "Tag1", "Tag2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_manageparal.getTableHeader().setReorderingAllowed(false);
        display_manageparal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_manageparalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(display_manageparal);

        javax.swing.GroupLayout jp_manageTagsLayout = new javax.swing.GroupLayout(jp_manageTags);
        jp_manageTags.setLayout(jp_manageTagsLayout);
        jp_manageTagsLayout.setHorizontalGroup(
            jp_manageTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageTagsLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jp_manageTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_manageTagsLayout.createSequentialGroup()
                        .addComponent(btn_backToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btn_backToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jPanel6.add(jp_manageTags, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new javax.swing.OverlayLayout(JPanel7));

        addTags_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD PARALLEL SESSION");

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
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
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
        jLabel4.setText("MANAGE TAGS");

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
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
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

    private void btn_addParaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addParaMouseClicked
        // TODO add your handling code here:
        jp_addTags.setVisible(true);
        jp_manageTags.setVisible(false);
        addTags_TopBar.setVisible(true);
        manageTags_Topbar.setVisible(false);
        btn_addPara.setBackground(new java.awt.Color(8,142,88));
        btn_ManagePara.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addParaMouseClicked

    private void btn_addParaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addParaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addParaMouseEntered

    private void btn_addParaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addParaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addParaMouseExited

    private void btn_addParaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addParaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addParaMousePressed

    private void btn_ManageParaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageParaMouseClicked
        // TODO add your handling code here:
        jp_manageTags.setVisible(true);
        jp_addTags.setVisible(false);
        addTags_TopBar.setVisible(false);
        manageTags_Topbar.setVisible(true);
        btn_ManagePara.setBackground(new java.awt.Color(8,142,88));
        btn_addPara.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageParaMouseClicked

    private void btn_ManageParaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageParaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageParaMouseEntered

    private void btn_ManageParaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageParaMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageParaMouseExited

    private void addPara_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPara_backBtnActionPerformed
        // TODO add your handling code here:

        new HCPNSessionsHome().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addPara_backBtnActionPerformed

    private void btn_viewparadetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewparadetailsActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_viewparadetailsActionPerformed

    private void btn_paraladdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paraladdActionPerformed
        // TODO add your handling code here:

        this.para_name = ParaName.getText();
        this.session_id1 = SessionID2.getText();
        this.session_id2 = SessionID1.getText();
        this.sub_code1 = SubCode2.getText();
        this.sub_code2 = SubCode1.getText();
        this.sub_name1 = SubjectName2.getText();
        this.sub_name2 = SubjectName1.getText();
        this.tag1 = Tag2.getText();
        this.tag2 = Tag1.getText();

        if(SessionID2.getText().equals("") ||  SessionID1.getText().equals("") || SubCode2.getText().equals("") || SubCode1.getText().equals("") || SubjectName2.getText().equals("") || SubjectName1.getText().equals("") || SubjectName2.getText().equals("") || SubjectName2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select two consectutive sessions");

        } else {

            if (ParaName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please Add Parallel Name sessions");

            }else {

                if  ("" != SessionID2.getText()) {

                    try {
                        String query_tagsexits = "select * from PARA where sessionid1=" + SessionID2.getText() + "";
                        Statement st_tag = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                        ResultSet rs1 = st_tag.executeQuery(query_tagsexits);
                        if (rs1.first()) {
                            JOptionPane.showMessageDialog(null, "This Parallel Session Already Exist");

                        } else {
                            try {
                                String query = "insert into PARA(para_name, sessionid1, sessionid2, SubCode1, SubCode2, SubName1, SubName2, Tag1, Tag2) "
                                + "values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

                                preparedStmt = connection.prepareStatement(query);
                                preparedStmt.setString(1, para_name);
                                preparedStmt.setString(2, session_id1);
                                preparedStmt.setString(3, session_id2);
                                preparedStmt.setString(4, sub_code1);
                                preparedStmt.setString(5, sub_code2);
                                preparedStmt.setString(6, sub_name1);
                                preparedStmt.setString(7, sub_name2);
                                preparedStmt.setString(8, tag1);
                                preparedStmt.setString(9, tag2);

                                preparedStmt.execute();

                                JOptionPane.showMessageDialog(null, "Parallel Session Added Successfully. \n Thank You!");
                                DefaultTableModel model = (DefaultTableModel) display_manageparal.getModel();
                                model.setRowCount(0);
                                show_ParaDetails();

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
        }
    }//GEN-LAST:event_btn_paraladdActionPerformed

    private void display_sessionstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_sessionstableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_display_sessionstableMouseClicked

    private void display_sessionstablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_display_sessionstablePropertyChange
        // TODO add your handling code here:
        //display_sessionstable.setRowSelectionAllowed(true);
        //display_sessionstable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

       TableModel model = display_sessionstable.getModel();
        int i[] = display_sessionstable.getSelectedRows();
    
        
        for(int j= 0; j<i.length; j++){
               
               String sid = model.getValueAt(i[0], 1).toString();
               
          
               if (SessionID1.getText().equals(sid)){
                SessionID2.setText(model.getValueAt(i[j], 1).toString());
                SubCode2.setText(model.getValueAt(i[j], 6).toString());
                SubjectName2.setText(model.getValueAt(i[j],7).toString());
                Tag2.setText(model.getValueAt(i[j],9).toString());
        
                HPara_rowSelected = model.getValueAt(i[j], 0).toString();
                session_id2 = model.getValueAt(i[j],1).toString(); 
                sub_code2 = model.getValueAt(i[j],6).toString();
                sub_name2 = model.getValueAt(i[j],7).toString();
                tag2 = model.getValueAt(i[j],9).toString();
                
               
               }
               else {
               SessionID1.setText(model.getValueAt(i[j], 1).toString());
               SubCode1.setText(model.getValueAt(i[j], 6).toString());
               SubjectName1.setText(model.getValueAt(i[j],7).toString());
               Tag1.setText(model.getValueAt(i[j],9).toString());
        
               HPara_rowSelected = model.getValueAt(i[j], 0).toString();
               session_id1 = model.getValueAt(i[j],1).toString(); 
               sub_code1 = model.getValueAt(i[j],6).toString();
               sub_name1 = model.getValueAt(i[j],7).toString();
               tag1 = model.getValueAt(i[j],9).toString();
               
                
              
               }
        }

    }//GEN-LAST:event_display_sessionstablePropertyChange

    private void SessionID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SessionID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SessionID1ActionPerformed

    private void SubCode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCode2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubCode2ActionPerformed

    private void btn_backToAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backToAddActionPerformed
        //TODO add your handling code here:
       jp_addTags.setVisible(true);
        jp_manageTags.setVisible(false);
        addTags_TopBar.setVisible(true);
        manageTags_Topbar.setVisible(false);
        btn_addPara.setBackground(new java.awt.Color(8,142,88));
        btn_ManagePara.setBackground(new java.awt.Color(39,156,109));
        
    }//GEN-LAST:event_btn_backToAddActionPerformed

    private void btn_deleteParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteParaActionPerformed
        // TODO add your handling code here:
      int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + Hmanagerow_rowSelected + " - "
            + para_name + " details ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            try {
                String query = "DELETE FROM PARA WHERE para_id =?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, Hmanagerow_rowSelected);

                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Parallel session removed successfully from the Database");
                DefaultTableModel model = (DefaultTableModel) display_manageparal.getModel();
                model.setRowCount(0);
                show_ParaDetails();

            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                System.err.println("Exception in delete operation : " + ex);
                System.err.println(ex.getMessage());
                Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btn_deleteParaActionPerformed

    private void display_manageparalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_manageparalMouseClicked
        // TODO add your handling code here:
         int i = display_manageparal.getSelectedRow();
        TableModel model = display_manageparal.getModel();
        

        Hmanagerow_rowSelected = model.getValueAt(i, 0).toString();
       
    }//GEN-LAST:event_display_manageparalMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_viewparadetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewparadetailsMouseClicked
        // TODO add your handling code here:
        jp_manageTags.setVisible(true);
        jp_addTags.setVisible(false);
        addTags_TopBar.setVisible(false);
        manageTags_Topbar.setVisible(true);
        btn_ManagePara.setBackground(new java.awt.Color(8,142,88));
        btn_addPara.setBackground(new java.awt.Color(39,156,109));
        
    }//GEN-LAST:event_btn_viewparadetailsMouseClicked

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
            java.util.logging.Logger.getLogger(HParallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HParallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HParallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HParallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HParallel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JTextField ParaName;
    private javax.swing.JTextField SessionID1;
    private javax.swing.JTextField SessionID2;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JTextField SubCode1;
    private javax.swing.JTextField SubCode2;
    private javax.swing.JTextField SubjectName1;
    private javax.swing.JTextField SubjectName2;
    private javax.swing.JTextField Tag1;
    private javax.swing.JTextField Tag2;
    private javax.swing.JButton addPara_backBtn;
    private javax.swing.JPanel addTags_TopBar;
    private javax.swing.JPanel btn_ManagePara;
    private javax.swing.JPanel btn_addPara;
    private javax.swing.JButton btn_backToAdd;
    private javax.swing.JButton btn_deletePara;
    private javax.swing.JButton btn_paraladd;
    private javax.swing.JButton btn_viewparadetails;
    private javax.swing.JTable display_manageparal;
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
