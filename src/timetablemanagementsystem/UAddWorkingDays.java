/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

import java.awt.Color;
import static java.lang.Boolean.getBoolean;
import static java.lang.Integer.getInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import timetablemanagementsystem.UHome;

/**
 *
 * @author umesha
 */
public class UAddWorkingDays extends javax.swing.JFrame {

    /**
     * Creates new form UAddWorkingDays
     */
    private WorkingDaysModel workingDaysModel;
    private Connection connection;
    private int numof_hours,numof_miniutes,workingDayID;
    private String numof_workingdays;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private boolean mondayV,tuesdayV,wednsdayV,thrusdayV,fridayV,saterdayV,sundayV;
    
    
    public UAddWorkingDays() {
        initComponents();
        dbconnection();
        ShowWorkingDayTable();
        btn_addWorkingDays.setBackground(new java.awt.Color(8,142,88));
    }

    //sad
    private void dbconnection() {
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
    
    
    public ArrayList getWorkingDayList() {
        
        ArrayList<WorkingDaysModel> workingDayList = new ArrayList<>();
        
        String query = "select * from workingdays";
        
        try {
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query);
            
             //String query = "insert into workingdays(workinghours,workingminiutes,noofworkingdays, monday, tuesday, wednesday, thrusday, friday, saterday, sunday) values(?,?,?,?,?,?,?,?,?,?)";
            
            while(res.next()) {
                workingDaysModel = new WorkingDaysModel(res.getString("noofworkingdays"), res.getInt("workingminiutes") , res.getInt("workinghours"), res.getBoolean("monday"), res.getBoolean("tuesday"), res.getBoolean("wednesday"), res.getBoolean("thrusday"), res.getBoolean("friday"), res.getBoolean("saterday"), res.getBoolean("sunday"));
                workingDaysModel.setId(res.getInt("workingdaysid"));
                workingDayList.add(workingDaysModel);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UAddWorkingDays.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workingDayList;
    }
    
    public void ShowWorkingDayTable() {
        
        ArrayList<WorkingDaysModel> dayList = getWorkingDayList();
        DefaultTableModel table_model = (DefaultTableModel) display_table.getModel();
        //DefaultTableModel model = (DefaultTableModel) display_table.getModel();
        table_model.setRowCount(0);
        Object[] row = new Object[4];
        String temp = "";
        
        int hr_count=0;
        
        for(int i=0;i<dayList.size();i++) {
            
            if(dayList.get(i).isMonday()) {
                temp = temp + "Monday, ";
                hr_count++;
            } if (dayList.get(i).isTuesday()) {
                temp = temp + "Tuesday, ";
                hr_count++;
            }
             if (dayList.get(i).isWednesday()) {
                 temp = temp + "Wednesday, ";
                hr_count++;
            }
             if (dayList.get(i).isThrusday()) {
                 temp = temp + "Thursday, ";
                hr_count++;
            }
             if (dayList.get(i).isFriday()) {
                 temp = temp + "Friday, ";
                hr_count++;
            }
             if (dayList.get(i).isSaterday()) {
                 temp = temp + "Saturday, ";
                hr_count++;
            }
             if (dayList.get(i).isSunday()) {
                 temp = temp + "Sunday, ";
                hr_count++;
            }
            
            row[0] = temp;
            row[1] = dayList.get(i).getNumof_workingdays();
            row[2] = dayList.get(i).getNumof_hours()*hr_count;
            row[3] = dayList.get(i).getId();
            temp = "";
            table_model.addRow(row);
        }
        
       hr_count = 0;
        
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
        btn_addWorkingDays = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_ManageWorkingDays = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addWorkingDays_backBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jp_addWorkingDays = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        NoOfWorkingDays = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_clearworkingdays = new javax.swing.JButton();
        addWorkingDays = new javax.swing.JButton();
        monday = new java.awt.Checkbox();
        tuesday = new java.awt.Checkbox();
        wednsday = new java.awt.Checkbox();
        thrusday = new java.awt.Checkbox();
        friday = new java.awt.Checkbox();
        saterday = new java.awt.Checkbox();
        sunday = new java.awt.Checkbox();
        hours = new javax.swing.JSpinner();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        miniutes = new javax.swing.JSpinner();
        jp_manageWorkingDays = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        display_table = new javax.swing.JTable();
        label3 = new java.awt.Label();
        update_workingdays = new javax.swing.JComboBox<>();
        btnupdate = new javax.swing.JButton();
        btnclearupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        update_hours = new javax.swing.JSpinner();
        label6 = new java.awt.Label();
        update_miniutes = new javax.swing.JSpinner();
        label7 = new java.awt.Label();
        update_monday = new java.awt.Checkbox();
        update_tuesday = new java.awt.Checkbox();
        update_wednesday = new java.awt.Checkbox();
        update_thrusday = new java.awt.Checkbox();
        update_friday = new java.awt.Checkbox();
        update_saterday = new java.awt.Checkbox();
        update_sunday = new java.awt.Checkbox();
        searchBox = new javax.swing.JTextField();
        JPanel7 = new javax.swing.JPanel();
        addWorkingDays_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        manageWorkingDays_Topbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        SidePanel.setBackground(new java.awt.Color(39, 156, 109));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addWorkingDays.setBackground(new java.awt.Color(39, 156, 109));
        btn_addWorkingDays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addWorkingDaysMousePressed(evt);
            }
        });
        btn_addWorkingDays.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/Add_Icon.png"))); // NOI18N
        btn_addWorkingDays.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Working Days");
        btn_addWorkingDays.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 140, -1));

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

        btn_addWorkingDays.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SidePanel.add(btn_addWorkingDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 60));

        btn_ManageWorkingDays.setBackground(new java.awt.Color(39, 156, 109));
        btn_ManageWorkingDays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageWorkingDaysMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageWorkingDaysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageWorkingDaysMouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/Manage_Icon.png"))); // NOI18N

        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Manage Working Days");

        javax.swing.GroupLayout btn_ManageWorkingDaysLayout = new javax.swing.GroupLayout(btn_ManageWorkingDays);
        btn_ManageWorkingDays.setLayout(btn_ManageWorkingDaysLayout);
        btn_ManageWorkingDaysLayout.setHorizontalGroup(
            btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 214, Short.MAX_VALUE)))
        );
        btn_ManageWorkingDaysLayout.setVerticalGroup(
            btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_ManageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_ManageWorkingDaysLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        SidePanel.add(btn_ManageWorkingDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/ABC Logo 150x150.png"))); // NOI18N
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 110));

        addWorkingDays_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addWorkingDays_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        addWorkingDays_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        addWorkingDays_backBtn.setText("BACK");
        addWorkingDays_backBtn.setToolTipText("Returns Previously Shown Window ");
        addWorkingDays_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWorkingDays_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        addWorkingDays_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkingDays_backBtnActionPerformed(evt);
            }
        });
        SidePanel.add(addWorkingDays_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, 31));

        jPanel6.setBackground(new java.awt.Color(247, 247, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(625, 329));
        jPanel6.setLayout(new java.awt.CardLayout());

        jp_addWorkingDays.setBackground(new java.awt.Color(247, 247, 247));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("No Of Working Days :");

        NoOfWorkingDays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Day", "2 Days", "3 Days", "4 Days", "5 Days", "6 Days", "7 Days" }));
        NoOfWorkingDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoOfWorkingDaysActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Working Time Per Day :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Working Days :");

        btn_clearworkingdays.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_clearworkingdays.setForeground(new java.awt.Color(255, 255, 255));
        btn_clearworkingdays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        btn_clearworkingdays.setText("CLEAR");
        btn_clearworkingdays.setToolTipText("Click The Clear Button To Clear the data");
        btn_clearworkingdays.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_clearworkingdays.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        btn_clearworkingdays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearworkingdaysActionPerformed(evt);
            }
        });

        addWorkingDays.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addWorkingDays.setForeground(new java.awt.Color(255, 255, 255));
        addWorkingDays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        addWorkingDays.setText("ADD");
        addWorkingDays.setToolTipText("Click The Add Button To Add The Data");
        addWorkingDays.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWorkingDays.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn hover.png"))); // NOI18N
        addWorkingDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkingDaysActionPerformed(evt);
            }
        });

        monday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        monday.setLabel("  Monday");

        tuesday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tuesday.setLabel("  Tuesday");

        wednsday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        wednsday.setLabel(" Wednesday");

        thrusday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        thrusday.setLabel(" Thursday");

        friday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        friday.setLabel("  Friday");

        saterday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        saterday.setLabel("  Saturday");

        sunday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        sunday.setLabel("  Sunday");

        label1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        label1.setText("Hours :");

        label2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        label2.setText("Minutes :");

        javax.swing.GroupLayout jp_addWorkingDaysLayout = new javax.swing.GroupLayout(jp_addWorkingDays);
        jp_addWorkingDays.setLayout(jp_addWorkingDaysLayout);
        jp_addWorkingDaysLayout.setHorizontalGroup(
            jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                        .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(saterday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoOfWorkingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 318, Short.MAX_VALUE))
                    .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                        .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addWorkingDaysLayout.createSequentialGroup()
                                        .addComponent(addWorkingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))
                                .addGap(50, 50, 50)
                                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(miniutes, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(btn_clearworkingdays, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                                .addComponent(monday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                                        .addComponent(tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(wednsday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(thrusday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(friday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(sunday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jp_addWorkingDaysLayout.setVerticalGroup(
            jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoOfWorkingDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wednsday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thrusday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saterday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_addWorkingDaysLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(miniutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_addWorkingDaysLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp_addWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addWorkingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clearworkingdays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))))
        );

        jPanel6.add(jp_addWorkingDays, "card2");

        jp_manageWorkingDays.setBackground(new java.awt.Color(247, 247, 247));

        display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "            Working Days", "       No of Working Days", "      Time For Per Week", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_tableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(display_table);
        if (display_table.getColumnModel().getColumnCount() > 0) {
            display_table.getColumnModel().getColumn(0).setMinWidth(300);
            display_table.getColumnModel().getColumn(0).setMaxWidth(500);
        }

        label3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        label3.setText("No Of  Working Days :");

        update_workingdays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Day", "2 Days", "3 Days", "4 Days", "5 Days", "6 Days", "7 Days" }));
        update_workingdays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_workingdaysActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.setToolTipText("Click Update Button To Update Details");
        btnupdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnupdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn hover.png"))); // NOI18N
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnclearupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclearupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnclearupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        btnclearupdate.setText("CLEAR");
        btnclearupdate.setToolTipText("Click Clear Button To Clear the Details");
        btnclearupdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnclearupdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        btnclearupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearupdateActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        btndelete.setText("DELETE");
        btndelete.setToolTipText("Click Delete Button To Delete Details");
        btndelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndelete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnsearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(255, 255, 255));
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn.png"))); // NOI18N
        btnsearch.setText("SEARCH");
        btnsearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/add btn hover.png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label4.setText("Working Time Per Day :");

        label5.setText("Hours :");

        label6.setText("Minutes :");

        label7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label7.setText("Working Days :");

        update_monday.setLabel("  Monday");

        update_tuesday.setLabel("  Tuseday");

        update_wednesday.setLabel("  Wednesday");

        update_thrusday.setLabel("  Thursday");

        update_friday.setLabel("  Friday");

        update_saterday.setLabel("  Saturday");

        update_sunday.setLabel("  Sunday");

        searchBox.setText("Search");
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_manageWorkingDaysLayout = new javax.swing.GroupLayout(jp_manageWorkingDays);
        jp_manageWorkingDays.setLayout(jp_manageWorkingDaysLayout);
        jp_manageWorkingDaysLayout.setHorizontalGroup(
            jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                        .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_workingdays, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(update_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(update_miniutes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_thrusday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                        .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update_monday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_saterday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update_sunday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                                .addComponent(update_tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(update_wednesday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(update_friday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(btnclearupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jp_manageWorkingDaysLayout.setVerticalGroup(
            jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_manageWorkingDaysLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_miniutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_workingdays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update_tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_monday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_wednesday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_thrusday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_friday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update_saterday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_sunday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jp_manageWorkingDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclearupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel6.add(jp_manageWorkingDays, "card3");

        JPanel7.setBackground(new java.awt.Color(20, 181, 117));
        JPanel7.setLayout(new java.awt.CardLayout());

        addWorkingDays_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD WORKING DAYS AND HOURS");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.setToolTipText("Logout From The System");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/UImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addWorkingDays_TopBarLayout = new javax.swing.GroupLayout(addWorkingDays_TopBar);
        addWorkingDays_TopBar.setLayout(addWorkingDays_TopBarLayout);
        addWorkingDays_TopBarLayout.setHorizontalGroup(
            addWorkingDays_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addWorkingDays_TopBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        addWorkingDays_TopBarLayout.setVerticalGroup(
            addWorkingDays_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addWorkingDays_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addWorkingDays_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanel7.add(addWorkingDays_TopBar, "card2");

        manageWorkingDays_Topbar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE WORKING DAYS AND HOURS");

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

        javax.swing.GroupLayout manageWorkingDays_TopbarLayout = new javax.swing.GroupLayout(manageWorkingDays_Topbar);
        manageWorkingDays_Topbar.setLayout(manageWorkingDays_TopbarLayout);
        manageWorkingDays_TopbarLayout.setHorizontalGroup(
            manageWorkingDays_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageWorkingDays_TopbarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        manageWorkingDays_TopbarLayout.setVerticalGroup(
            manageWorkingDays_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageWorkingDays_TopbarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(manageWorkingDays_TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        JPanel7.add(manageWorkingDays_Topbar, "card3");

        javax.swing.GroupLayout Background_pnlLayout = new javax.swing.GroupLayout(Background_pnl);
        Background_pnl.setLayout(Background_pnlLayout);
        Background_pnlLayout.setHorizontalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)))
        );
        Background_pnlLayout.setVerticalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(JPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
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

    private void btn_addWorkingDaysMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addWorkingDaysMousePressed

    private void btn_addWorkingDaysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMouseClicked
        // TODO add your handling code here:
        jp_addWorkingDays.setVisible(true);
        jp_manageWorkingDays.setVisible(false);
        addWorkingDays_TopBar.setVisible(true);
        manageWorkingDays_Topbar.setVisible(false);
        btn_addWorkingDays.setBackground(new java.awt.Color(8,142,88));
        btn_ManageWorkingDays.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_addWorkingDaysMouseClicked

    private void btn_addWorkingDaysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addWorkingDaysMouseEntered

    private void btn_addWorkingDaysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addWorkingDaysMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addWorkingDaysMouseExited

    private void btn_ManageWorkingDaysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageWorkingDaysMouseClicked
        // TODO add your handling code here:
        jp_manageWorkingDays.setVisible(true);
        jp_addWorkingDays.setVisible(false);
        addWorkingDays_TopBar.setVisible(false);
        manageWorkingDays_Topbar.setVisible(true);
        btn_ManageWorkingDays.setBackground(new java.awt.Color(8,142,88));
        btn_addWorkingDays.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_btn_ManageWorkingDaysMouseClicked

    private void btn_ManageWorkingDaysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageWorkingDaysMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ManageWorkingDaysMouseEntered

    private void btn_ManageWorkingDaysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageWorkingDaysMouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_btn_ManageWorkingDaysMouseExited

    private void addWorkingDays_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkingDays_backBtnActionPerformed
        // TODO add your handling code here:
        new UHome().setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_addWorkingDays_backBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        
        String updated_workingdays = update_workingdays.getSelectedItem().toString();
        int updated_hours = (int) update_hours.getValue();
        int updated_miniutes = (int) update_miniutes.getValue();
        boolean updated_monday = update_monday.getState();
        boolean updated_tuestday = update_tuesday.getState();
        boolean updated_wednesday = update_wednesday.getState();
        boolean updated_thrusday = update_thrusday.getState();
        boolean updated_friday = update_friday.getState();
        boolean updated_saterday = update_saterday.getState();
        boolean updated_sunday = update_sunday.getState();
        
        int u_day_count = 0;
        int u_working_day_count = Integer.parseInt(updated_workingdays.split(" ")[0]);
        
        if(updated_monday) {
            u_day_count++;
        }
        if(updated_tuestday) {
            u_day_count++;
        }
        if(updated_wednesday) {
            u_day_count++;
        }
        if(updated_thrusday) {
            u_day_count++;
        }
        if(updated_friday) {
            u_day_count++;
        }
        if(updated_saterday) {
            u_day_count++;
        }
        if(updated_saterday) {
            u_day_count++;
        }
        if(updated_sunday) {
            u_day_count++;
        }
        
        if(u_working_day_count==u_day_count) {
              try {
                String query = "update workingdays "+"set workinghours = ?, workingminiutes = ?, noofworkingdays = ?, monday = ?, tuesday = ?, wednesday = ?, thrusday = ?, friday = ?, saterday = ?, sunday = ? " + "where workingdaysid = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, updated_hours);
                preparedStatement.setInt(2, updated_miniutes);
                preparedStatement.setString(3, updated_workingdays);
                preparedStatement.setBoolean(4, updated_monday);
                preparedStatement.setBoolean(5, updated_tuestday);
                preparedStatement.setBoolean(6, updated_wednesday);
                preparedStatement.setBoolean(7, updated_thrusday);
                preparedStatement.setBoolean(8, updated_friday);
                preparedStatement.setBoolean(9, updated_saterday);
                preparedStatement.setBoolean(10, updated_sunday);
                preparedStatement.setInt(11, workingDayID);

                preparedStatement.execute();

                JOptionPane.showMessageDialog(null, "Working Days updated successfully");


                DefaultTableModel model = (DefaultTableModel) display_table.getModel();
                model.setRowCount(0);
                ShowWorkingDayTable();


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                Logger.getLogger(UAddWorkingDays.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             JOptionPane.showMessageDialog(null, "Selected number of working days must equal number of working days!");
        }
        
        //  String query = "insert into workingdays(workinghours,workingminiutes,noofworkingdays, monday, tuesday, wednesday, thrusday, friday, saterday, sunday) values(?,?,?,?,?,?,?,?,?,?)";
        
        
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnclearupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearupdateActionPerformed
        // TODO add your handling code here:
        
        update_monday.setState(false);
        update_tuesday.setState(false);
        update_wednesday.setState(false);
        update_thrusday.setState(false);
        update_friday.setState(false);
        update_saterday.setState(false);
        update_sunday.setState(false);
        update_hours.setValue(0);
        update_miniutes.setValue(0);
        update_workingdays.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnclearupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete","Delete", JOptionPane.YES_NO_OPTION);
        
        String query = "delete from workingdays where workingdaysid = ?";
        
        if(opt==0) {
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, workingDayID);

                preparedStatement.execute();

                DefaultTableModel model = (DefaultTableModel) display_table.getModel();
                model.setRowCount(0);
                ShowWorkingDayTable();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                Logger.getLogger(UAddWorkingDays.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
        
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel table_model = (DefaultTableModel) display_table.getModel();
        String searchTxt = searchBox.getText().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table_model);
        display_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchTxt));
        
        
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btn_clearworkingdaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearworkingdaysActionPerformed
            // TODO add your handling code here:
        this.numof_workingdays = NoOfWorkingDays.getSelectedItem().toString();
        this.numof_miniutes = (int) miniutes.getValue();
        this.numof_hours = (int) hours.getValue();
        
       this.mondayV = monday.getState();
       this.tuesdayV = tuesday.getState();
       this.wednsdayV = wednsday.getState();
       this.thrusdayV = thrusday.getState();
       this.fridayV = friday.getState();
       this.saterdayV = saterday.getState();
       this.sundayV = sunday.getState();
           
        NoOfWorkingDays.setSelectedItem("1 Day");
        miniutes.setValue(0);
        hours.setValue(0);
        monday.setState(false);
        tuesday.setState(false);
        wednsday.setState(false);
        thrusday.setState(false);
        friday.setState(false);
        saterday.setState(false);
        sunday.setState(false);
        
        
        
        
    }//GEN-LAST:event_btn_clearworkingdaysActionPerformed

    private void addWorkingDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkingDaysActionPerformed

        this.numof_workingdays = NoOfWorkingDays.getSelectedItem().toString();
        this.numof_miniutes = (int) miniutes.getValue();
        this.numof_hours = (int) hours.getValue();
        
       this.mondayV = monday.getState();
       this.tuesdayV = tuesday.getState();
       this.wednsdayV = wednsday.getState();
       this.thrusdayV = thrusday.getState();
       this.fridayV = friday.getState();
       this.saterdayV = saterday.getState();
       this.sundayV = sunday.getState();
       
       int day_count = 0;
    
       
       if(mondayV) {
          day_count++;
       }
       if(tuesdayV) {
           day_count++;
       }if(wednsdayV) {
           day_count++;
       }if(thrusdayV) {
           day_count++;
       }if(fridayV) {
           day_count++;
       }if(saterdayV) {
           day_count++;
       }if(sundayV) {
           day_count++;
       }
       

       
       
       int working_day_count = Integer.parseInt(numof_workingdays.split(" ")[0]);
       
       if(working_day_count==day_count) {
         
        
        workingDaysModel = new WorkingDaysModel(numof_workingdays, numof_miniutes, numof_hours, mondayV, tuesdayV, wednsdayV, thrusdayV, fridayV, saterdayV, sundayV);
        
        String query = "insert into workingdays(workinghours,workingminiutes,noofworkingdays, monday, tuesday, wednesday, thrusday, friday, saterday, sunday) values(?,?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = connection.prepareStatement(query);
           
            preparedStatement.setInt(1, numof_hours);
            preparedStatement.setInt(2, numof_miniutes);
            preparedStatement.setString(3, numof_workingdays);
            preparedStatement.setBoolean(4, mondayV);
            preparedStatement.setBoolean(5, tuesdayV);
            preparedStatement.setBoolean(6, wednsdayV);
            preparedStatement.setBoolean(7, thrusdayV);
            preparedStatement.setBoolean(8, fridayV);
            preparedStatement.setBoolean(9, saterdayV);
            preparedStatement.setBoolean(10, sundayV);
            
            boolean res = preparedStatement.execute();
            
       
            JOptionPane.showMessageDialog(null, "Working Days And Hours Added Successfully. \n Thank You!");
           
            
             DefaultTableModel model = (DefaultTableModel) display_table.getModel();
            model.setRowCount(0);
            ShowWorkingDayTable();
            
           
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
            Logger.getLogger(UAddWorkingDays.class.getName()).log(Level.SEVERE, null, ex);
        } 
       } else {
           
           JOptionPane.showMessageDialog(null, "Selected days must equal to number of days!");
       }
       
        
    }//GEN-LAST:event_addWorkingDaysActionPerformed

    private void NoOfWorkingDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoOfWorkingDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoOfWorkingDaysActionPerformed

    private void display_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_tableMouseClicked
        // TODO add your handling code here:
        int i = display_table.getSelectedRow();
        TableModel model = display_table.getModel();
        

       // System.out.println(model.getValueAt(i, 2).toString());
        
        update_workingdays.setSelectedItem(model.getValueAt(i, 1).toString());
       // update_hours.setValue(model.getValueAt(i, 2));
        workingDayID =  (int) model.getValueAt(i, 3); 
        
        String query = "select * from workingdays where workingdaysid= ?";
        
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, (int) model.getValueAt(i, 3));    
            ResultSet res = preparedStatement.executeQuery();
            
            while(res.next()) {
                
                update_hours.setValue(res.getInt("workinghours"));
                update_monday.setState(res.getBoolean("monday"));
                update_tuesday.setState(res.getBoolean("tuesday"));
                update_wednesday.setState(res.getBoolean("wednesday"));
                update_thrusday.setState(res.getBoolean("thrusday"));
                update_friday.setState(res.getBoolean("friday"));
                update_saterday.setState(res.getBoolean("saterday"));
                update_sunday.setState(res.getBoolean("sunday"));
              
            }
            
            // update_workingdays.setSelectedItem(model.getValueAt(i, 2).toString());
            // update_hours.add(2)
        } catch (SQLException ex) {
            Logger.getLogger(UAddWorkingDays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_display_tableMouseClicked

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxActionPerformed

    private void update_workingdaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_workingdaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_workingdaysActionPerformed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
        jp_manageWorkingDays.setVisible(true);
        jp_addWorkingDays.setVisible(false);
        addWorkingDays_TopBar.setVisible(false);
        manageWorkingDays_Topbar.setVisible(true);
        jPanel3.setBackground(new java.awt.Color(8,142,88));
        btn_addWorkingDays.setBackground(new java.awt.Color(39,156,109));
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseEntered

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
            java.util.logging.Logger.getLogger(UAddWorkingDays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UAddWorkingDays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UAddWorkingDays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UAddWorkingDays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UAddWorkingDays().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JPanel JPanel7;
    private javax.swing.JComboBox<String> NoOfWorkingDays;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton addWorkingDays;
    private javax.swing.JPanel addWorkingDays_TopBar;
    private javax.swing.JButton addWorkingDays_backBtn;
    private javax.swing.JPanel btn_ManageWorkingDays;
    private javax.swing.JPanel btn_addWorkingDays;
    private javax.swing.JButton btn_clearworkingdays;
    private javax.swing.JButton btnclearupdate;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTable display_table;
    private java.awt.Checkbox friday;
    private javax.swing.JSpinner hours;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jp_addWorkingDays;
    private javax.swing.JPanel jp_manageWorkingDays;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JPanel manageWorkingDays_Topbar;
    private javax.swing.JSpinner miniutes;
    private java.awt.Checkbox monday;
    private java.awt.Checkbox saterday;
    private javax.swing.JTextField searchBox;
    private java.awt.Checkbox sunday;
    private javax.swing.JScrollPane tableScrollPane;
    private java.awt.Checkbox thrusday;
    private java.awt.Checkbox tuesday;
    private java.awt.Checkbox update_friday;
    private javax.swing.JSpinner update_hours;
    private javax.swing.JSpinner update_miniutes;
    private java.awt.Checkbox update_monday;
    private java.awt.Checkbox update_saterday;
    private java.awt.Checkbox update_sunday;
    private java.awt.Checkbox update_thrusday;
    private java.awt.Checkbox update_tuesday;
    private java.awt.Checkbox update_wednesday;
    private javax.swing.JComboBox<String> update_workingdays;
    private java.awt.Checkbox wednsday;
    // End of variables declaration//GEN-END:variables
}
