import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MainFrame
  extends JFrame
{
  JScrollPane scrollPane = new JScrollPane();
  static int screenWidth;
  static int screenHeight;
  private Calendar today = Calendar.getInstance();
  private int year;
  private int month;
  private int day;
  JTabbedPane tabbedPane;
  Icon icon;
  static Connection con;
  private DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel();
  private String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", 
    "November", "December" };
  private DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel(this.months);
  private DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel();
  JPanel checkIn;
  private JTextField txtCheckInID;
  private JTextField txtCheckInFName;
  private JTextField txtCheckInMName;
  private JTextField txtCheckInLName;
  private JTextField txtCheckInCenter;
  private JTextField txtCheckInCountry;
  private JLabel lblCheckInSize;
  private JTextField txtCheckInSuccess;
  private JLabel lblCheckInBaggage;
  private JLabel lblCheckInCountry;
  private JLabel lblcheckinlogo;
  private JLabel lblCheckInBaggageTag;
  private JLabel lblCheckInTshirtSize;
  private JButton btnUncheckin;
  private JPanel pnlInput;
  private JPanel pnlUncheckin;
  private JPanel pnlBasicInfo;
  private JPanel pnlMainInfo;
  private static JSplitPane spnCheckinInfo;
  private JLabel lblAcc;
  private JPanel sessionRegister;
  private JButton btnGetsessions;
  private JButton btnSelectsession;
  public DefaultListModel<String> listmodel = new DefaultListModel();
  private JList<String> lstSessions;
  private String sessionTable;
  private JTextField txtsessionID;
  private JLabel lblSessionID;
  private String[][] sessionTableData;
  private String[] sessionColNames = { "ID", "First Name", "MiddleName", "Surname", "Time" };
  private DefaultTableModel tablemodel = new DefaultTableModel(this.sessionTableData, this.sessionColNames);
  private JTextField txtSession;
  private JLabel txtSessionRegistered;
  private JTable tblSessions;
  private JTextField txtSessionPresent;
  private JTextField txtSessionAbsent;
  private JLabel lblsessionLogo;
  private JPanel addNewAttendee;
  private JLabel lblAddCountry;
  private JLabel lblAddFName;
  private JTextField txtAddFName;
  private JLabel lblAddCenter;
  private JLabel lblAddTShirtSize;
  private JLabel lbladdEmail;
  private JTextField txtAddEmail;
  private JLabel lblAddSName;
  private JTextField txtAddSName;
  private JTextField txtAddMName;
  private JLabel lblAddMName;
  private JLabel lblAddRegistrationFee;
  private JLabel lblAddLiabilityForm;
  private JLabel lblAddTransport;
  private JTextField txtAddTransport;
  private JLabel lblAddDepartureDate;
  private JLabel lblAddArrivalsection;
  private JTextField txtAddArrivalSection;
  private JLabel lblAddArrivalAirline;
  private JTextField txtAddArrivalAirline;
  private JLabel lblAddArrivalTime;
  private JLabel lblAddBaggageTag;
  private JLabel lblAddDateOfBirth;
  private JTextField txtAddBaggageTag;
  private JLabel lblAddDepartureAirline;
  private JTextField txtAddDepartureAirline;
  private JLabel lblAddDepartureTime;
  private JLabel lblAddDepartureSection;
  private JTextField txtAddDepartureSection;
  private JButton btnAddNewAttendee;
  private JTextField txtAddAccomodation;
  private JLabel lbladdnewLogo;
  private JPanel pnlAddNew;
  private JComboBox<String> cmbAddCountry;
  private JComboBox<String> cmbAddCenter;
  private String[] arrCountries = new String[0];
  private String[] arrCenters = new String[0];
  private DefaultComboBoxModel<String> cmbCountriesModel = new DefaultComboBoxModel(this.arrCountries);
  private DefaultComboBoxModel<String> cmbCentersModel = new DefaultComboBoxModel(this.arrCenters);
  private JComboBox<String> cmbAddSize;
  private JComboBox<String> cmbAddLiabilityForm;
  private JComboBox<String> cmbAddDOBDay;
  private JComboBox<String> cmbAddDOBMonth;
  private JComboBox<String> cmbAddDOBYear;
  private JComboBox<String> cmbAddADDay;
  private JComboBox<String> cmbAddADMonth;
  private JComboBox<String> cmbAddADYear;
  private JComboBox<String> cmbAddDDDay;
  private JComboBox<String> cmbAddDDMonth;
  private JComboBox<String> cmbAddDDYear;
  private JSpinner spnAddATHour;
  private JLabel label_4;
  private JSpinner spnAddATMinute;
  private JPanel pnlAddDepartureTime;
  private JSpinner spnAddDTHour;
  private JSpinner spnAddDTMinute;
  private DefaultComboBoxModel<String> groupNameModel = new DefaultComboBoxModel();
  private JComboBox<String> cmbAddGroupName;
  private JPanel database;
  private JTable tblData;
  private JButton btnShowAttendees;
  private String[][] databaseTableData;
  private String[] databaseColNames = { "ID", "Group", "Country", "Center", "First Name", "Middle Name", "Surname", "Email", "TShirt Size", 
    "Registration Fee", "Liability Form", 
    "Transport", "Arrival Date", "Arrival Time", "Arrival Airline", "Arrival Section", "Departure Date", "Departure Time", 
    "Departure Airline", "Departure Section", "Date of Birth", "Baggage Tag", "Accomodation", "Age", "BGNumber" };
  private DefaultTableModel DatabaseModel = new DefaultTableModel(this.databaseTableData, this.databaseColNames);
  private JLabel lblFilterCenter;
  private JLabel lblFilterName;
  private JTextField txtFilterCenter;
  private JTextField txtFilterName;
  private JButton btnShowCheckIn;
  private JScrollPane scpDatabase;
  private JLabel lblDatabaseLogo;
  private JLabel lblAge;
  private JLabel lblBGNumber;
  private JLabel label_2;
  private JLabel label_3;
  private JSpinner spnAddAge;
  private JSpinner spnAddBGNumber;
  private JLabel label;
  private JLabel label_1;
  private JComboBox<String> cmbAddRegistrationFee;
  
  public static void main(String[] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Throwable e)
    {
      e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
          MainFrame.screenWidth = gd.getDisplayMode().getWidth();
          MainFrame.screenHeight = gd.getDisplayMode().getHeight() - 50;
          MainFrame mainFrame = new MainFrame();
          mainFrame.setDefaultCloseOperation(2);
          mainFrame.setSize(MainFrame.screenWidth, MainFrame.screenHeight);
          mainFrame.setVisible(true);
          mainFrame.setExtendedState(6);
          mainFrame.setTitle("Shibir Management System");
          mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/Resources/BAPS_Aksharderi_Logo.png")));
          MainFrame.spnCheckinInfo.setDividerLocation(0.33D);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public MainFrame()
  {
    setFont(new Font("Open Sans", 0, 16));
    setTitle("Shibir Management Tool");
    //setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/Resources/BAPS_Aksharderi_Logo.png")));
    setDefaultCloseOperation(2);
    
    initComponents();
    createEvents();
  }
  
  private void initComponents()
  {
	/*  
    try
    {
      Image myPicture = ImageIO.read(getClass().getResource("/Resources/SS16_Logo_Final_V1.png")).getScaledInstance(400, 400, 0);
      this.icon = new ImageIcon(myPicture);
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }
    */
    this.year = this.today.get(1);
    this.month = this.today.get(2);
    this.day = this.today.get(5);
    
    this.tabbedPane = new JTabbedPane(1);
    this.tabbedPane.setFont(new Font("Open Sans", 0, 16));
    this.scrollPane.setViewportView(this.tabbedPane);
    getContentPane().add(this.scrollPane);
    for (int k = 1; k < 32; k++) {
      this.dayModel.addElement(Integer.toString(k));
    }
    int count = 0;
    while (count < 41)
    {
      this.yearModel.addElement(Integer.toString(this.year - count));
      count++;
    }
    this.checkIn = new JPanel();
    this.checkIn.setBackground(UIManager.getColor("Button.light"));
    this.checkIn.setForeground(new Color(255, 140, 0));
    this.checkIn.setBounds(0, 0, screenWidth - 100, screenHeight - 50);
    this.checkIn.setLayout(new BorderLayout(5, 5));
    this.tabbedPane.addTab("Check In", this.checkIn);
    
    JPanel pnlInfo = new JPanel();
    this.checkIn.add(pnlInfo, "Center");
    pnlInfo.setLayout(new BorderLayout(0, 0));
    
    this.pnlBasicInfo = new JPanel();
    this.pnlBasicInfo.setLayout(new GridLayout(5, 2, 10, 10));
    
    JLabel lblFname = new JLabel("First Name");
    lblFname.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(lblFname);
    lblFname.setForeground(Color.BLACK);
    lblFname.setFont(new Font("Open Sans Light", 0, 16));
    
    this.txtCheckInFName = new JTextField();
    this.txtCheckInFName.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(this.txtCheckInFName);
    this.txtCheckInFName.setEditable(false);
    this.txtCheckInFName.setFont(new Font("Open Sans", 0, 20));
    this.txtCheckInFName.setColumns(10);
    
    JLabel lblMName = new JLabel("Middle Name");
    lblMName.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(lblMName);
    lblMName.setForeground(Color.BLACK);
    lblMName.setFont(new Font("Open Sans Light", 0, 16));
    
    this.txtCheckInMName = new JTextField();
    this.txtCheckInMName.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(this.txtCheckInMName);
    this.txtCheckInMName.setEditable(false);
    this.txtCheckInMName.setFont(new Font("Open Sans", 0, 20));
    this.txtCheckInMName.setColumns(10);
    
    JLabel lblLName = new JLabel("Last Name");
    lblLName.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(lblLName);
    lblLName.setForeground(Color.BLACK);
    lblLName.setFont(new Font("Open Sans Light", 0, 16));
    
    this.txtCheckInLName = new JTextField();
    this.txtCheckInLName.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(this.txtCheckInLName);
    this.txtCheckInLName.setEditable(false);
    this.txtCheckInLName.setFont(new Font("Open Sans", 0, 20));
    this.txtCheckInLName.setColumns(10);
    
    this.lblCheckInCountry = new JLabel("Country");
    this.lblCheckInCountry.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(this.lblCheckInCountry);
    this.lblCheckInCountry.setForeground(Color.BLACK);
    this.lblCheckInCountry.setFont(new Font("Open Sans Light", 0, 16));
    
    this.txtCheckInCountry = new JTextField();
    this.txtCheckInCountry.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(this.txtCheckInCountry);
    this.txtCheckInCountry.setEditable(false);
    this.txtCheckInCountry.setFont(new Font("Open Sans", 0, 20));
    this.txtCheckInCountry.setColumns(10);
    
    JLabel lblCenter = new JLabel("Center");
    lblCenter.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(lblCenter);
    lblCenter.setForeground(Color.BLACK);
    lblCenter.setFont(new Font("Open Sans Light", 0, 16));
    
    this.txtCheckInCenter = new JTextField();
    this.txtCheckInCenter.setHorizontalAlignment(0);
    this.pnlBasicInfo.add(this.txtCheckInCenter);
    this.txtCheckInCenter.setEditable(false);
    this.txtCheckInCenter.setFont(new Font("Open Sans", 0, 20));
    this.txtCheckInCenter.setColumns(10);
    
    this.pnlMainInfo = new JPanel();
    this.pnlMainInfo.setLayout(new GridLayout(6, 1, 0, 0));
    
    this.lblCheckInSize = new JLabel("Shirt Size");
    this.lblCheckInSize.setHorizontalAlignment(0);
    this.pnlMainInfo.add(this.lblCheckInSize);
    this.lblCheckInSize.setForeground(Color.BLACK);
    this.lblCheckInSize.setFont(new Font("Open Sans Light", 0, 45));
    
    this.lblCheckInTshirtSize = new JLabel("", 0);
    this.pnlMainInfo.add(this.lblCheckInTshirtSize);
    this.lblCheckInTshirtSize.setForeground(new Color(255, 0, 0));
    this.lblCheckInTshirtSize.setFont(new Font("Open Sans Semibold", 0, 60));
    
    this.lblCheckInBaggage = new JLabel("Baggage Tag");
    this.lblCheckInBaggage.setHorizontalAlignment(0);
    this.pnlMainInfo.add(this.lblCheckInBaggage);
    this.lblCheckInBaggage.setForeground(Color.BLACK);
    this.lblCheckInBaggage.setFont(new Font("Open Sans Light", 0, 45));
    
    this.lblCheckInBaggageTag = new JLabel("", 0);
    this.pnlMainInfo.add(this.lblCheckInBaggageTag);
    this.lblCheckInBaggageTag.setForeground(new Color(255, 140, 0));
    this.lblCheckInBaggageTag.setFont(new Font("Open Sans Semibold", 0, 60));
    
    JLabel lblAccomo = new JLabel("Accomodation");
    lblAccomo.setHorizontalAlignment(0);
    this.pnlMainInfo.add(lblAccomo);
    lblAccomo.setForeground(Color.BLACK);
    lblAccomo.setFont(new Font("Open Sans Light", 0, 45));
    
    spnCheckinInfo = new JSplitPane(1, this.pnlBasicInfo, this.pnlMainInfo);
    spnCheckinInfo.setOneTouchExpandable(true);
    pnlInfo.add(spnCheckinInfo, "Center");
    
    this.lblAcc = new JLabel("", 0);
    this.lblAcc.setForeground(Color.BLACK);
    this.lblAcc.setFont(new Font("Open Sans Semibold", 0, 30));
    this.pnlMainInfo.add(this.lblAcc);
    
    this.lblcheckinlogo = new JLabel();
    this.lblcheckinlogo.setIcon(this.icon);
    this.checkIn.add(this.lblcheckinlogo, "West");
    
    this.pnlInput = new JPanel();
    this.checkIn.add(this.pnlInput, "North");
    
    JLabel lblId = new JLabel("ID:");
    this.pnlInput.add(lblId);
    lblId.setForeground(Color.BLACK);
    lblId.setFont(new Font("Open Sans", 0, 16));
    
    this.txtCheckInID = new JTextField();
    this.pnlInput.add(this.txtCheckInID);
    this.txtCheckInID.setFont(new Font("Open Sans", 0, 16));
    this.txtCheckInID.setColumns(10);
    
    this.txtCheckInSuccess = new JTextField();
    this.txtCheckInSuccess.setEditable(false);
    this.pnlInput.add(this.txtCheckInSuccess);
    this.txtCheckInSuccess.setFont(new Font("Open Sans", 0, 16));
    this.txtCheckInSuccess.setColumns(20);
    
    this.pnlUncheckin = new JPanel();
    this.checkIn.add(this.pnlUncheckin, "South");
    
    this.btnUncheckin = new JButton("Uncheck In");
    this.btnUncheckin.setFont(new Font("Open Sans", 0, 16));
    this.pnlUncheckin.add(this.btnUncheckin);
    
    this.btnUncheckin.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        String ID = JOptionPane.showInputDialog("Enter ID for atendee you would like to uncheck in: ");
        try
        {
          Statement s = MainFrame.con.createStatement();
          String sql = "SELECT Country, Center, FirstName, MiddleName, Surname, GroupNumber, GroupName FROM CheckedIn WHERE ID LIKE '" + ID + "'";
          ResultSet rs = s.executeQuery(sql);
          if (rs.next())
          {
            int result = JOptionPane.showConfirmDialog(MainFrame.this.checkIn, "Are you sure you want to uncheck in " + rs.getString("FirstName") + " " + 
              rs.getString("MiddleName") + " " + rs.getString("Surname") + " From " + 
              rs.getString("Center") + ", " + rs.getString("Country"));
            if (result == 0)
            {
              sql = "DELETE FROM CheckedIn WHERE ID LIKE '" + ID + "'";
              s.executeUpdate(sql);
              JOptionPane.showMessageDialog(MainFrame.this.checkIn, "Removed " + ID + " from checked in list");
            }
          }
          else
          {
            JOptionPane.showMessageDialog(MainFrame.this.checkIn, "No such attendee found");
          }
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
      }
    });
    this.sessionRegister = new JPanel();
    this.sessionRegister.setBackground(UIManager.getColor("Button.light"));
    this.sessionRegister.setForeground(UIManager.getColor("Button.light"));
    this.sessionRegister.setBounds(0, 0, 782, 553);
    this.tabbedPane.addTab("Session Register", this.sessionRegister);
    this.sessionRegister.setLayout(new BorderLayout(0, 0));
    
    JScrollPane scpSessions = new JScrollPane();
    scpSessions.setHorizontalScrollBarPolicy(30);
    scpSessions.setVerticalScrollBarPolicy(20);
    
    this.tblSessions = new JTable();
    this.tblSessions.setFont(new Font("Open Sans", 0, 16));
    this.tblSessions.setModel(this.tablemodel);
    this.tblSessions.setAutoResizeMode(0);
    scpSessions.setViewportView(this.tblSessions);
    this.tblSessions.setRowHeight(30);
    this.tblSessions.getColumnModel().getColumn(0).setPreferredWidth(100);
    this.tblSessions.getColumnModel().getColumn(1).setPreferredWidth(300);
    this.tblSessions.getColumnModel().getColumn(2).setPreferredWidth(300);
    this.tblSessions.getColumnModel().getColumn(3).setPreferredWidth(300);
    this.tblSessions.getColumnModel().getColumn(4).setPreferredWidth(100);
    
    this.lblsessionLogo = new JLabel();
    this.lblsessionLogo.setIcon(this.icon);
    this.sessionRegister.add(this.lblsessionLogo, "West");
    
    JPanel pnlSessionSelection = new JPanel();
    
    pnlSessionSelection.setLayout(new BorderLayout(0, 0));
    
    this.btnGetsessions = new JButton("GetSessions");
    this.btnGetsessions.setFont(new Font("Open Sans", 0, 16));
    pnlSessionSelection.add(this.btnGetsessions, "West");
    
    this.btnSelectsession = new JButton("Select Session");
    this.btnSelectsession.setFont(new Font("Open Sans", 0, 16));
    pnlSessionSelection.add(this.btnSelectsession, "East");
    
    this.lstSessions = new JList(this.listmodel);
    this.lstSessions.setFont(new Font("Open Sans", 0, 16));
    pnlSessionSelection.add(new JScrollPane(this.lstSessions), "Center");
    
    JSplitPane spnSessionMain = new JSplitPane(0, pnlSessionSelection, scpSessions);
    this.sessionRegister.add(spnSessionMain, "Center");
    
    JPanel pnlSessionInfo = new JPanel();
    this.sessionRegister.add(pnlSessionInfo, "South");
    
    this.txtSession = new JTextField();
    pnlSessionInfo.add(this.txtSession);
    this.txtSession.setFont(new Font("Open Sans", 0, 30));
    this.txtSession.setColumns(10);
    
    this.txtSessionPresent = new JTextField();
    pnlSessionInfo.add(this.txtSessionPresent);
    this.txtSessionPresent.setFont(new Font("Open Sans", 0, 30));
    this.txtSessionPresent.setColumns(10);
    
    this.txtSessionAbsent = new JTextField();
    pnlSessionInfo.add(this.txtSessionAbsent);
    this.txtSessionAbsent.setFont(new Font("Open Sans", 0, 30));
    this.txtSessionAbsent.setColumns(10);
    
    JPanel pnlSessionRegister = new JPanel();
    this.sessionRegister.add(pnlSessionRegister, "East");
    pnlSessionRegister.setLayout(new GridBagLayout());
    
    /*
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = 2;
    gbc.insets = new Insets(5, 5, 5, 5);
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.lblSessionID = new JLabel("Enter ID ");
    pnlSessionRegister.add(this.lblSessionID, gbc);
    this.lblSessionID.setFont(new Font("Open Sans", 0, 16));
    
    gbc.gridx = 1;
    gbc.gridy = 0;
    this.txtsessionID = new JTextField();
    pnlSessionRegister.add(this.txtsessionID, gbc);
    this.txtsessionID.setFont(new Font("Open Sans", 0, 16));
    this.txtsessionID.setHorizontalAlignment(0);
    this.txtsessionID.setColumns(10);
    
    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.txtSessionRegistered = new JLabel("");
    pnlSessionRegister.add(this.txtSessionRegistered, gbc);
    this.txtSessionRegistered.setFont(new Font("Open Sans", 0, 20));
    */
    
    this.addNewAttendee = new JPanel();
    this.addNewAttendee.setBackground(UIManager.getColor("Button.light"));
    this.addNewAttendee.setForeground(UIManager.getColor("Button.light"));
    this.addNewAttendee.setBounds(0, 0, 782, 553);
    this.tabbedPane.addTab("Add New Attendee", this.addNewAttendee);
    this.addNewAttendee.setLayout(new BorderLayout(0, 0));
    
    this.lbladdnewLogo = new JLabel();
    this.lbladdnewLogo.setIcon(this.icon);
    this.addNewAttendee.add(this.lbladdnewLogo, "West");
    
    this.pnlAddNew = new JPanel();
    this.pnlAddNew.setLayout(new GridLayout(0, 4, 7, 7));
    this.addNewAttendee.add(this.pnlAddNew);
    
    JLabel addGroupName = new JLabel("Group Name");
    addGroupName.setHorizontalAlignment(0);
    addGroupName.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(addGroupName);
    
    this.cmbAddGroupName = new JComboBox();
    this.cmbAddGroupName.setModel(this.groupNameModel);
    this.cmbAddGroupName.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.cmbAddGroupName);
    
    this.lblAddFName = new JLabel("First Name");
    
    this.pnlAddNew.add(this.lblAddFName);
    this.lblAddFName.setFont(new Font("Open Sans", 0, 16));
    this.lblAddFName.setHorizontalAlignment(0);
    
    this.txtAddFName = new JTextField();
    
    this.pnlAddNew.add(this.txtAddFName);
    this.txtAddFName.setFont(new Font("Open Sans", 0, 16));
    this.txtAddFName.setColumns(10);
    
    this.lblAddCountry = new JLabel("Country");
    this.pnlAddNew.add(this.lblAddCountry);
    this.lblAddCountry.setFont(new Font("Open Sans", 0, 16));
    this.lblAddCountry.setHorizontalAlignment(0);
    
    this.cmbAddCountry = new JComboBox(this.cmbCountriesModel);
    this.cmbAddCountry.setSize(200, 25);
    this.cmbAddCountry.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.cmbAddCountry);
    
    this.lblAddMName = new JLabel("MiddleName");
    
    this.pnlAddNew.add(this.lblAddMName);
    this.lblAddMName.setFont(new Font("Open Sans", 0, 16));
    this.lblAddMName.setHorizontalAlignment(0);
    
    this.txtAddMName = new JTextField();
    
    this.pnlAddNew.add(this.txtAddMName);
    this.txtAddMName.setFont(new Font("Open Sans", 0, 16));
    this.txtAddMName.setColumns(10);
    
    this.lblAddCenter = new JLabel("Center");
    
    this.pnlAddNew.add(this.lblAddCenter);
    this.lblAddCenter.setFont(new Font("Open Sans", 0, 16));
    this.lblAddCenter.setHorizontalAlignment(0);
    
    this.cmbAddCenter = new JComboBox(this.cmbCentersModel);
    this.cmbAddCenter.setEnabled(false);
    this.cmbAddCenter.setFont(new Font("Open Sans", 0, 16));
    this.cmbAddCenter.setSize(200, 25);
    this.pnlAddNew.add(this.cmbAddCenter);
    
    this.lblAddSName = new JLabel("Surname");
    
    this.pnlAddNew.add(this.lblAddSName);
    this.lblAddSName.setHorizontalAlignment(0);
    this.lblAddSName.setFont(new Font("Open Sans", 0, 16));
    
    this.txtAddSName = new JTextField();
    
    this.pnlAddNew.add(this.txtAddSName);
    this.txtAddSName.setFont(new Font("Open Sans", 0, 16));
    this.txtAddSName.setColumns(10);
    
    this.lblBGNumber = new JLabel("BG Number");
    this.lblBGNumber.setHorizontalAlignment(0);
    this.lblBGNumber.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.lblBGNumber);
    
    this.spnAddBGNumber = new JSpinner();
    this.spnAddBGNumber.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
    this.spnAddBGNumber.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.spnAddBGNumber);
    
    this.lbladdEmail = new JLabel("Email Address");
    
    this.pnlAddNew.add(this.lbladdEmail);
    this.lbladdEmail.setFont(new Font("Open Sans", 0, 16));
    this.lbladdEmail.setHorizontalAlignment(0);
    
    this.txtAddEmail = new JTextField();
    
    this.pnlAddNew.add(this.txtAddEmail);
    this.txtAddEmail.setFont(new Font("Open Sans", 0, 16));
    this.txtAddEmail.setColumns(10);
    
    JLabel lblAddAccomodation = new JLabel("Accomodation");
    
    this.pnlAddNew.add(lblAddAccomodation);
    lblAddAccomodation.setFont(new Font("Open Sans", 0, 16));
    lblAddAccomodation.setHorizontalAlignment(0);
    
    this.txtAddAccomodation = new JTextField();
    
    this.pnlAddNew.add(this.txtAddAccomodation);
    this.txtAddAccomodation.setFont(new Font("Open Sans", 0, 16));
    this.txtAddAccomodation.setColumns(10);
    
    this.lblAddDateOfBirth = new JLabel("Date of Birth");
    
    this.pnlAddNew.add(this.lblAddDateOfBirth);
    this.lblAddDateOfBirth.setFont(new Font("Open Sans", 0, 16));
    this.lblAddDateOfBirth.setHorizontalAlignment(0);
    
    JPanel pnlAddDateOfBirth = new JPanel();
    pnlAddDateOfBirth.setLayout(new FlowLayout());
    this.cmbAddDOBDay = new JComboBox();
    this.cmbAddDOBDay.setModel(this.dayModel);
    this.cmbAddDOBDay.setSelectedIndex(0);
    this.cmbAddDOBDay.setFont(new Font("Open Sans", 0, 16));
    pnlAddDateOfBirth.add(this.cmbAddDOBDay);
    this.cmbAddDOBMonth = new JComboBox();
    this.cmbAddDOBMonth.setModel(this.monthModel);
    this.cmbAddDOBMonth.setSelectedItem(Integer.valueOf(0));
    this.cmbAddDOBMonth.setFont(new Font("Open Sans", 0, 16));
    pnlAddDateOfBirth.add(this.cmbAddDOBMonth);
    this.cmbAddDOBYear = new JComboBox();
    this.cmbAddDOBYear.setModel(this.yearModel);
    this.cmbAddDOBYear.setSelectedIndex(0);
    this.cmbAddDOBYear.setFont(new Font("Open Sans", 0, 16));
    pnlAddDateOfBirth.add(this.cmbAddDOBYear);
    
    this.pnlAddNew.add(pnlAddDateOfBirth);
    
    this.lblAddBaggageTag = new JLabel("Baggage Tag");
    
    this.pnlAddNew.add(this.lblAddBaggageTag);
    this.lblAddBaggageTag.setFont(new Font("Open Sans", 0, 16));
    this.lblAddBaggageTag.setHorizontalAlignment(0);
    
    this.txtAddBaggageTag = new JTextField();
    
    this.pnlAddNew.add(this.txtAddBaggageTag);
    this.txtAddBaggageTag.setFont(new Font("Open Sans", 0, 16));
    this.txtAddBaggageTag.setColumns(10);
    
    this.lblAddTShirtSize = new JLabel("T-Shirt Size");
    
    this.pnlAddNew.add(this.lblAddTShirtSize);
    this.lblAddTShirtSize.setFont(new Font("Open Sans", 0, 16));
    this.lblAddTShirtSize.setHorizontalAlignment(0);
    
    this.cmbAddSize = new JComboBox();
    this.cmbAddSize.setFont(new Font("Open Sans", 0, 16));
    this.cmbAddSize.setModel(new DefaultComboBoxModel(new String[] { "XS", "S", "M", "L", "XL", "XXL", "XXXL" }));
    
    this.pnlAddNew.add(this.cmbAddSize);
    
    this.lblAddRegistrationFee = new JLabel("Registration Fee");
    
    this.pnlAddNew.add(this.lblAddRegistrationFee);
    this.lblAddRegistrationFee.setFont(new Font("Open Sans", 0, 16));
    this.lblAddRegistrationFee.setHorizontalAlignment(0);
    
    this.cmbAddRegistrationFee = new JComboBox();
    this.cmbAddRegistrationFee.setModel(new DefaultComboBoxModel(new String[] { "Paid", "Not Paid" }));
    this.cmbAddRegistrationFee.setSelectedIndex(1);
    this.cmbAddRegistrationFee.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.cmbAddRegistrationFee);
    
    this.lblAge = new JLabel("Age");
    this.lblAge.setHorizontalAlignment(0);
    this.lblAge.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.lblAge);
    
    this.spnAddAge = new JSpinner();
    this.spnAddAge.setModel(new SpinnerNumberModel(new Integer(18), new Integer(0), null, new Integer(1)));
    this.spnAddAge.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.spnAddAge);
    
    this.lblAddLiabilityForm = new JLabel("Liability Form");
    
    this.pnlAddNew.add(this.lblAddLiabilityForm);
    this.lblAddLiabilityForm.setFont(new Font("Open Sans", 0, 16));
    this.lblAddLiabilityForm.setHorizontalAlignment(0);
    
    this.cmbAddLiabilityForm = new JComboBox();
    this.cmbAddLiabilityForm.setFont(new Font("Open Sans", 0, 16));
    this.cmbAddLiabilityForm.setModel(new DefaultComboBoxModel(new String[] { "YES", "NO" }));
    this.cmbAddLiabilityForm.setSelectedIndex(1);
    
    this.pnlAddNew.add(this.cmbAddLiabilityForm);
    
    this.label = new JLabel("");
    this.label.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.label);
    
    this.label_1 = new JLabel("");
    this.label_1.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.label_1);
    
    this.lblAddTransport = new JLabel("Transport");
    
    this.pnlAddNew.add(this.lblAddTransport);
    this.lblAddTransport.setFont(new Font("Open Sans", 0, 16));
    this.lblAddTransport.setHorizontalAlignment(0);
    
    this.txtAddTransport = new JTextField();
    
    this.pnlAddNew.add(this.txtAddTransport);
    this.txtAddTransport.setFont(new Font("Open Sans", 0, 16));
    this.txtAddTransport.setColumns(10);
    
    this.label_2 = new JLabel("");
    this.label_2.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.label_2);
    
    this.label_3 = new JLabel("");
    this.label_3.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddNew.add(this.label_3);
    
    JLabel lblAddArrivalDate = new JLabel("Arrival Date");
    lblAddArrivalDate.setFont(new Font("Open Sans", 0, 16));
    lblAddArrivalDate.setHorizontalAlignment(0);
    this.pnlAddNew.add(lblAddArrivalDate);
    
    JPanel pnlAddArrivalDate = new JPanel();
    pnlAddArrivalDate.setLayout(new FlowLayout());
    this.cmbAddADDay = new JComboBox();
    this.cmbAddADDay.setModel(this.dayModel);
    this.cmbAddADDay.setSelectedIndex(0);
    this.cmbAddADDay.setFont(new Font("Open Sans", 0, 16));
    pnlAddArrivalDate.add(this.cmbAddADDay);
    this.cmbAddADMonth = new JComboBox();
    this.cmbAddADMonth.setModel(this.monthModel);
    this.cmbAddADMonth.setSelectedIndex(0);
    this.cmbAddADMonth.setFont(new Font("Open Sans", 0, 16));
    pnlAddArrivalDate.add(this.cmbAddADMonth);
    this.cmbAddADYear = new JComboBox();
    this.cmbAddADYear.setModel(this.yearModel);
    this.cmbAddADYear.setSelectedIndex(0);
    this.cmbAddADYear.setFont(new Font("Open Sans", 0, 16));
    pnlAddArrivalDate.add(this.cmbAddADYear);
    
    this.pnlAddNew.add(pnlAddArrivalDate);
    
    this.lblAddDepartureDate = new JLabel("Departure Date");
    
    this.pnlAddNew.add(this.lblAddDepartureDate);
    this.lblAddDepartureDate.setFont(new Font("Open Sans", 0, 16));
    this.lblAddDepartureDate.setHorizontalAlignment(0);
    
    JPanel pnlAddDepartureDate = new JPanel();
    pnlAddDepartureDate.setLayout(new FlowLayout());
    this.cmbAddDDDay = new JComboBox();
    this.cmbAddDDDay.setModel(this.dayModel);
    this.cmbAddDDDay.setSelectedIndex(0);
    this.cmbAddDDDay.setFont(new Font("Open Sans", 0, 16));
    pnlAddDepartureDate.add(this.cmbAddDDDay);
    this.cmbAddDDMonth = new JComboBox();
    this.cmbAddDDMonth.setModel(this.monthModel);
    this.cmbAddDDMonth.setSelectedItem(Integer.valueOf(0));
    this.cmbAddDDMonth.setFont(new Font("Open Sans", 0, 16));
    pnlAddDepartureDate.add(this.cmbAddDDMonth);
    this.cmbAddDDYear = new JComboBox();
    this.cmbAddDDYear.setModel(this.yearModel);
    this.cmbAddDDYear.setSelectedIndex(0);
    this.cmbAddDDYear.setFont(new Font("Open Sans", 0, 16));
    pnlAddDepartureDate.add(this.cmbAddDDYear);
    
    this.pnlAddNew.add(pnlAddDepartureDate);
    
    this.lblAddArrivalTime = new JLabel("Arrival Time");
    
    this.pnlAddNew.add(this.lblAddArrivalTime);
    this.lblAddArrivalTime.setFont(new Font("Open Sans", 0, 16));
    this.lblAddArrivalTime.setHorizontalAlignment(0);
    
    JPanel pnlAddArrivalTime = new JPanel();
    pnlAddArrivalTime.setLayout(new GridLayout(1, 3, 1, 1));
    this.pnlAddNew.add(pnlAddArrivalTime);
    
    this.spnAddATHour = new JSpinner();
    this.spnAddATHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
    this.spnAddATHour.setFont(new Font("Open Sans", 0, 16));
    pnlAddArrivalTime.add(this.spnAddATHour);
    
    this.label_4 = new JLabel(":");
    this.label_4.setHorizontalAlignment(0);
    pnlAddArrivalTime.add(this.label_4);
    
    this.spnAddATMinute = new JSpinner();
    this.spnAddATMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
    this.spnAddATMinute.setFont(new Font("Open Sans", 0, 16));
    pnlAddArrivalTime.add(this.spnAddATMinute);
    
    this.lblAddDepartureTime = new JLabel("Departure Time");
    
    this.pnlAddNew.add(this.lblAddDepartureTime);
    this.lblAddDepartureTime.setFont(new Font("Open Sans", 0, 16));
    this.lblAddDepartureTime.setHorizontalAlignment(0);
    
    this.pnlAddDepartureTime = new JPanel();
    this.pnlAddDepartureTime.setLayout(new GridLayout(1, 3, 1, 1));
    this.pnlAddNew.add(this.pnlAddDepartureTime);
    
    this.spnAddDTHour = new JSpinner();
    this.spnAddDTHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
    this.spnAddDTHour.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddDepartureTime.add(this.spnAddDTHour);
    
    JLabel label_5 = new JLabel(":");
    label_5.setHorizontalAlignment(0);
    this.pnlAddDepartureTime.add(label_5);
    
    this.spnAddDTMinute = new JSpinner();
    this.spnAddDTMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
    this.spnAddDTMinute.setFont(new Font("Open Sans", 0, 16));
    this.pnlAddDepartureTime.add(this.spnAddDTMinute);
    
    this.lblAddArrivalAirline = new JLabel("Arrival Airline");
    
    this.pnlAddNew.add(this.lblAddArrivalAirline);
    this.lblAddArrivalAirline.setFont(new Font("Open Sans", 0, 16));
    this.lblAddArrivalAirline.setHorizontalAlignment(0);
    
    this.txtAddArrivalAirline = new JTextField();
    
    this.pnlAddNew.add(this.txtAddArrivalAirline);
    this.txtAddArrivalAirline.setFont(new Font("Open Sans", 0, 16));
    this.txtAddArrivalAirline.setColumns(10);
    
    this.lblAddDepartureAirline = new JLabel("Departure Airline");
    this.lblAddDepartureAirline.setBounds(512, 495, 150, 25);
    this.pnlAddNew.add(this.lblAddDepartureAirline);
    this.lblAddDepartureAirline.setFont(new Font("Open Sans", 0, 16));
    this.lblAddDepartureAirline.setHorizontalAlignment(0);
    
    this.txtAddDepartureAirline = new JTextField();
    this.txtAddDepartureAirline.setBounds(687, 495, 200, 25);
    this.pnlAddNew.add(this.txtAddDepartureAirline);
    this.txtAddDepartureAirline.setFont(new Font("Open Sans", 0, 16));
    this.txtAddDepartureAirline.setColumns(10);
    
    this.lblAddArrivalsection = new JLabel("Arrival Section");
    
    this.pnlAddNew.add(this.lblAddArrivalsection);
    this.lblAddArrivalsection.setFont(new Font("Open Sans", 0, 16));
    this.lblAddArrivalsection.setHorizontalAlignment(0);
    
    this.txtAddArrivalSection = new JTextField();
    
    this.pnlAddNew.add(this.txtAddArrivalSection);
    this.txtAddArrivalSection.setFont(new Font("Open Sans", 0, 16));
    this.txtAddArrivalSection.setColumns(10);
    
    this.lblAddDepartureSection = new JLabel("Departure Section");
    
    this.pnlAddNew.add(this.lblAddDepartureSection);
    this.lblAddDepartureSection.setFont(new Font("Open Sans", 0, 16));
    this.lblAddDepartureSection.setHorizontalAlignment(0);
    
    this.txtAddDepartureSection = new JTextField();
    
    this.pnlAddNew.add(this.txtAddDepartureSection);
    this.txtAddDepartureSection.setFont(new Font("Open Sans", 0, 16));
    this.txtAddDepartureSection.setColumns(10);
    
    this.pnlAddNew.add(new JLabel());
    this.pnlAddNew.add(new JLabel());
    this.pnlAddNew.add(new JLabel());
    
    this.btnAddNewAttendee = new JButton("Add New Attendee");
    this.btnAddNewAttendee.setFont(new Font("Open Sans", 0, 16));
    
    this.pnlAddNew.add(this.btnAddNewAttendee);
    
    this.database = new JPanel();
    this.database.setBackground(UIManager.getColor("Button.light"));
    this.database.setBounds(0, 0, 782, 553);
    this.tabbedPane.addTab("Database", this.database);
    this.database.setLayout(new BorderLayout(0, 0));
    
    JPanel pnlFilters = new JPanel();
    this.database.add(pnlFilters, "North");
    pnlFilters.setLayout(new GridLayout(3, 2, 5, 5));
    
    this.lblFilterCenter = new JLabel("Filter Center");
    this.lblFilterCenter.setFont(new Font("Open Sans", 0, 16));
    pnlFilters.add(this.lblFilterCenter);
    
    this.txtFilterCenter = new JTextField();
    this.txtFilterCenter.setFont(new Font("Open Sans", 0, 16));
    pnlFilters.add(this.txtFilterCenter);
    this.txtFilterCenter.setColumns(20);
    
    this.lblFilterName = new JLabel("Filter Name");
    this.lblFilterName.setFont(new Font("Open Sans", 0, 16));
    pnlFilters.add(this.lblFilterName);
    
    this.txtFilterName = new JTextField();
    this.txtFilterName.setFont(new Font("Open Sans", 0, 16));
    this.txtFilterName.setColumns(20);
    pnlFilters.add(this.txtFilterName);
    
    this.btnShowAttendees = new JButton("Show Attendees");
    this.btnShowAttendees.setFont(new Font("Open Sans", 0, 16));
    pnlFilters.add(this.btnShowAttendees);
    
    this.btnShowCheckIn = new JButton("Show Check In");
    this.btnShowCheckIn.setFont(new Font("Open Sans", 0, 16));
    pnlFilters.add(this.btnShowCheckIn);
    
    this.scpDatabase = new JScrollPane();
    this.scpDatabase.setVerticalScrollBarPolicy(22);
    this.scpDatabase.setHorizontalScrollBarPolicy(32);
    this.database.add(this.scpDatabase);
    
    this.tblData = new JTable();
    this.scpDatabase.setViewportView(this.tblData);
    this.tblData.setFont(new Font("Open Sans", 0, 16));
    this.tblData.setModel(this.DatabaseModel);
    this.tblData.setVisible(true);
    this.tblData.setPreferredScrollableViewportSize(new Dimension(300, 200));
    this.tblData.setAutoResizeMode(0);
    
    this.tblData.setRowHeight(30);
    this.tblData.getColumnModel().getColumn(0).setPreferredWidth(100);
    this.tblData.getColumnModel().getColumn(1).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(2).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(3).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(4).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(5).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(6).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(7).setPreferredWidth(500);
    this.tblData.getColumnModel().getColumn(8).setPreferredWidth(50);
    this.tblData.getColumnModel().getColumn(9).setPreferredWidth(100);
    this.tblData.getColumnModel().getColumn(10).setPreferredWidth(100);
    this.tblData.getColumnModel().getColumn(11).setPreferredWidth(100);
    this.tblData.getColumnModel().getColumn(12).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(13).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(14).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(15).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(16).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(17).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(18).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(19).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(20).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(21).setPreferredWidth(100);
    this.tblData.getColumnModel().getColumn(22).setPreferredWidth(200);
    this.tblData.getColumnModel().getColumn(23).setPreferredWidth(50);
    this.tblData.getColumnModel().getColumn(24).setPreferredWidth(50);
    this.tblData.getTableHeader().setResizingAllowed(true);
    
    this.lblDatabaseLogo = new JLabel();
    this.lblDatabaseLogo.setBackground(UIManager.getColor("Button.light"));
    this.lblDatabaseLogo.setIcon(this.icon);
    this.database.add(this.lblDatabaseLogo, "West");
  }
  
  private void createEvents()
  {
    try
    {
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
      JFileChooser fc = new JFileChooser("D:/Documents/Workspace/DMS");
      fc.setDialogTitle("Select a Database to use");
      fc.showOpenDialog(null);
      if (fc.getSelectedFile() == null) {
        System.exit(0);
      }
      String filename = fc.getSelectedFile().getAbsolutePath();
      
      String database = "jdbc:ucanaccess://";
      con = DriverManager.getConnection(database + filename, "", "");
      DatabaseMetaData meta = con.getMetaData();
      ResultSet rs = meta.getTables(null, null, "CheckedIn", null);
      if (!rs.next())
      {
        Statement s = con.createStatement();
        s.execute("CREATE TABLE CheckedIn (ID text PRIMARY KEY,GroupName text, Country text,Center text,FirstName text,MiddleName text,Surname text,Email text,TshirtSize text,RegistrationFee text,LiabilityForm text,Transport text,ArrivalDate text,ArrivalTime text,ArrivalAirline text,ArrivalSection text,DepartureDate text,DepartureTime text,DepartureAirline text,DepartureSection text,DateOfBirth text,BaggageTag text,Accomodation text,Age text, BGNumber text)");
      }
      rs.close();
      this.txtCheckInID.requestFocus();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "Error: " + e);
    }
    populateCountries();
    populateGroupNames();
    
    this.txtCheckInID.addKeyListener(new KeyAdapter()
    {
      public void keyReleased(KeyEvent e)
      {
        String ID = MainFrame.this.txtCheckInID.getText();
        if (ID.length() == 6)
        {
          try
          {
            Statement s = MainFrame.con.createStatement();
            
            ResultSet r = s.executeQuery("select * FROM Attendees WHERE ID LIKE '" + ID + "'");
            if (r.next())
            {
              MainFrame.this.txtCheckInCountry.setText(r.getString("Country"));
              MainFrame.this.txtCheckInCenter.setText(r.getString("Center"));
              MainFrame.this.txtCheckInFName.setText(r.getString("FirstName"));
              MainFrame.this.txtCheckInMName.setText(r.getString("MiddleName"));
              MainFrame.this.txtCheckInLName.setText(r.getString("Surname"));
              MainFrame.this.lblCheckInTshirtSize.setText(r.getString("TShirtSize"));
              MainFrame.this.lblCheckInBaggageTag.setText(r.getString("BaggageTag"));
              MainFrame.this.lblAcc.setText(r.getString("Accomodation"));
              
              s.execute("select * FROM CheckedIn WHERE ID LIKE '" + ID + "'");
              ResultSet q = s.getResultSet();
              if (q.next())
              {
                MainFrame.this.txtCheckInSuccess.setText(ID + " already checked in");
              }
              else
              {
                String sql = "INSERT INTO CheckedIn VALUES('" + 
                  r.getString("ID") + "'," + 
                  "'" + r.getString("GroupName") + "'," + 
                  "'" + r.getString("Country") + "'," + 
                  "'" + r.getString("Center") + "'," + 
                  "'" + r.getString("FirstName") + "'," + 
                  "'" + r.getString("MiddleName") + "'," + 
                  "'" + r.getString("Surname") + "'," + 
                  "'" + r.getString("Email") + "'," + 
                  "'" + r.getString("TShirtSize") + "'," + 
                  "'" + r.getString("RegistrationFee") + "'," + 
                  "'" + r.getString("LiabilityForm") + "'," + 
                  "'" + r.getString("Transport") + "'," + 
                  "'" + r.getString("ArrivalDate") + "'," + 
                  "'" + r.getString("ArrivalTime") + "'," + 
                  "'" + r.getString("ArrivalAirline") + "'," + 
                  "'" + r.getString("ArrivalSection") + "'," + 
                  "'" + r.getString("DepartureDate") + "'," + 
                  "'" + r.getString("DepartureTime") + "'," + 
                  "'" + r.getString("DepartureAirline") + "'," + 
                  "'" + r.getString("DepartureSection") + "'," + 
                  "'" + r.getString("DateOfBirth") + "'," + 
                  "'" + r.getString("BaggageTag") + "'," + 
                  "'" + r.getString("Accomodation") + "'," + 
                  "'" + r.getString("Age") + "'," + 
                  "'" + r.getString("BGNumber") + "')";
                s.executeUpdate(sql);
                MainFrame.this.txtCheckInSuccess.setText(ID + " checked in");
              }
            }
            else
            {
              MainFrame.this.txtCheckInSuccess.setText("ID not found");
              MainFrame.this.txtCheckInFName.setText("");
              MainFrame.this.txtCheckInMName.setText("");
              MainFrame.this.txtCheckInLName.setText("");
              MainFrame.this.txtCheckInCenter.setText("");
              MainFrame.this.txtCheckInCountry.setText("");
              MainFrame.this.lblCheckInTshirtSize.setText("");
              MainFrame.this.lblCheckInBaggageTag.setText("");
            }
          }
          catch (Exception e1)
          {
            JOptionPane.showMessageDialog(null, "Error: " + e1);
          }
          MainFrame.this.txtCheckInID.setText("");
        }
      }
    });
    this.btnGetsessions.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.getSessions();
      }
    });
    this.btnSelectsession.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        int sessionIndex = MainFrame.this.lstSessions.getSelectedIndex();
        MainFrame.this.tablemodel.setRowCount(0);
        if (sessionIndex == MainFrame.this.listmodel.getSize() - 1) {
          try
          {
            String name = JOptionPane.showInputDialog("Enter name of new session: ");
            MainFrame.this.sessionTable = ("Session_" + name);
            Statement s = MainFrame.con.createStatement();
            String sql = "CREATE TABLE " + MainFrame.this.sessionTable + "(ID text PRIMARY KEY, FirstName text, MiddleName text, Surname text,  Time text)";
            s.executeUpdate(sql);
            
            MainFrame.this.getSessions();
          }
          catch (SQLException e1)
          {
            e1.printStackTrace();
          }
        } else {
          MainFrame.this.sessionTable = ((String)MainFrame.this.lstSessions.getSelectedValue()).toString();
        }
        MainFrame.this.txtSession.setText(MainFrame.this.sessionTable);
        try
        {
          Statement s = MainFrame.con.createStatement();
          String sql = "SELECT * FROM " + MainFrame.this.sessionTable;
          ResultSet rs = s.executeQuery(sql);
          while (rs.next())
          {
            String[] newRow = { rs.getString("ID"), rs.getString("FirstName"), rs.getString("MiddleName"), rs.getString("Surname"), rs.getString("Time") };
            MainFrame.this.tablemodel.addRow(newRow);
          }
        }
        catch (SQLException e1)
        {
          e1.printStackTrace();
        }
        MainFrame.this.txtSessionPresent.setText(MainFrame.this.getSessionPresent(MainFrame.this.sessionTable));
        MainFrame.this.txtSessionAbsent.setText(MainFrame.this.getSessionAbsent(MainFrame.this.sessionTable));
        
        MainFrame.this.txtsessionID.requestFocus();
      }
    });
    this.txtsessionID.addKeyListener(new KeyAdapter()
    {
      public void keyReleased(KeyEvent arg0)
      {
        if (MainFrame.this.txtsessionID.getText().length() == 6)
        {
          String ID = MainFrame.this.txtsessionID.getText();
          try
          {
            Statement s = MainFrame.con.createStatement();
            String sql = "SELECT * FROM " + MainFrame.this.sessionTable + " WHERE ID LIKE '" + ID + "'";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next())
            {
              MainFrame.this.txtSessionRegistered.setText(ID + " already checked in");
              MainFrame.this.txtsessionID.setText("");
            }
            else
            {
              Statement s1 = MainFrame.con.createStatement();
              String sql1 = "SELECT ID, FirstName, MiddleName, Surname  FROM CheckedIn WHERE ID LIKE '" + ID + "'";
              ResultSet rs1 = s1.executeQuery(sql1);
              
              DateFormat dateFormat = new SimpleDateFormat("HH:mm");
              String datestr = null;
              if (rs1.next())
              {
                Date date = new Date();
                datestr = dateFormat.format(date);
                
                sql1 = "INSERT INTO " + MainFrame.this.sessionTable + " VALUES(" + "'" + rs1.getString("ID") + "'," + 
                  "'" + rs1.getString("FirstName") + "'," + 
                  "'" + rs1.getString("MiddleName") + "'," + 
                  "'" + rs1.getString("Surname") + "'," + 
                  "'" + datestr + "'" + 
                  ")";
                s1.executeUpdate(sql1);
                MainFrame.this.tablemodel.setRowCount(0);
                sql1 = "SELECT * FROM " + MainFrame.this.sessionTable;
                ResultSet rs2 = s1.executeQuery(sql1);
                while (rs2.next())
                {
                  String[] newRow1 = { rs2.getString("ID"), rs2.getString("FirstName"), rs2.getString("MiddleName"), rs2.getString("Surname"), rs2.getString("Time") };
                  MainFrame.this.tablemodel.addRow(newRow1);
                }
                MainFrame.this.txtSessionPresent.setText(MainFrame.this.getSessionPresent(MainFrame.this.sessionTable));
                MainFrame.this.txtSessionAbsent.setText(MainFrame.this.getSessionAbsent(MainFrame.this.sessionTable));
                MainFrame.this.txtsessionID.setText("");
                MainFrame.this.txtSessionRegistered.setText(ID + " checked in");
                MainFrame.this.txtsessionID.requestFocus();
              }
              else
              {
                JOptionPane.showMessageDialog(null, ID + " not found");
                Toolkit.getDefaultToolkit().beep();
                MainFrame.this.txtsessionID.setText("");
              }
            }
          }
          catch (SQLException e)
          {
            e.printStackTrace();
          }
        }
      }
    });
    this.cmbAddCountry.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent arg0)
      {
        String country = MainFrame.this.cmbAddCountry.getSelectedItem().toString();
        MainFrame.this.populateCenters(country);
      }
    });
    this.btnAddNewAttendee.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        try
        {
          Statement s = MainFrame.con.createStatement();
          String sql = "SELECT ID FROM Attendees WHERE Center like '" + MainFrame.this.cmbAddCenter.getSelectedItem().toString() + "'";
          ResultSet rs = s.executeQuery(sql);
          String id = null;
          while (rs.next()) {
            id = rs.getString("ID");
          }
          String centercode = id.substring(0, 2);
          String indcode = id.substring(2, 6);
          
          int ind = Integer.parseInt(indcode) + 1;
          indcode = Integer.toString(ind);
          while (indcode.length() != 4) {
            indcode = '0' + indcode;
          }
          String ID = centercode + indcode;
          
          String birthDate = "";
          String arrivalDate = "";
          String departureDate = "";
          String arrivalTime = "";
          String departureTime = "";
          
          birthDate = (String)MainFrame.this.dayModel.getElementAt(MainFrame.this.cmbAddDOBDay.getSelectedIndex()) + "-" + 
            (String)MainFrame.this.monthModel.getElementAt(MainFrame.this.cmbAddDOBMonth.getSelectedIndex()) + "-" + 
            (String)MainFrame.this.yearModel.getElementAt(MainFrame.this.cmbAddDOBYear.getSelectedIndex());
          
          arrivalDate = (String)MainFrame.this.dayModel.getElementAt(MainFrame.this.cmbAddADDay.getSelectedIndex()) + "-" + 
            (String)MainFrame.this.monthModel.getElementAt(MainFrame.this.cmbAddADMonth.getSelectedIndex()) + "-" + 
            (String)MainFrame.this.yearModel.getElementAt(MainFrame.this.cmbAddADYear.getSelectedIndex());
          
          departureDate = (String)MainFrame.this.dayModel.getElementAt(MainFrame.this.cmbAddDDDay.getSelectedIndex()) + "-" + 
            (String)MainFrame.this.monthModel.getElementAt(MainFrame.this.cmbAddDDMonth.getSelectedIndex()) + "-" + 
            (String)MainFrame.this.yearModel.getElementAt(MainFrame.this.cmbAddDDYear.getSelectedIndex());
          
          int minute = ((Integer)MainFrame.this.spnAddATMinute.getModel().getValue()).intValue();
          if (minute > 10) {
            arrivalTime = MainFrame.this.spnAddATHour.getValue().toString() + ":" + Integer.toString(minute);
          } else {
            arrivalTime = MainFrame.this.spnAddATHour.getValue().toString() + ":0" + Integer.toString(minute);
          }
          minute = ((Integer)MainFrame.this.spnAddDTMinute.getModel().getValue()).intValue();
          if (minute > 10) {
            departureTime = MainFrame.this.spnAddDTHour.getValue().toString() + ":" + Integer.toString(minute);
          } else {
            departureTime = MainFrame.this.spnAddDTHour.getValue().toString() + ":0" + Integer.toString(minute);
          }
          sql = 
          
            "INSERT INTO Attendees(ID, GroupName, Country, Center, FirstName, MiddleName, Surname, Email, TShirtSize, RegistrationFee, LiabilityForm, Transport, ArrivalDate, ArrivalTime, ArrivalAirline, ArrivalSection, DepartureDate, DepartureTime, DepartureAirline, DepartureSection, DateofBirth, BaggageTag, Accomodation, Age, BGNumber) VALUES ( '" + ID + "',  " + "'" + MainFrame.this.cmbAddGroupName.getSelectedItem().toString() + "',  " + "'" + MainFrame.this.cmbAddCountry.getSelectedItem().toString() + "',  " + "'" + MainFrame.this.cmbAddCenter.getSelectedItem().toString() + "',  " + "'" + MainFrame.this.txtAddFName.getText() + "',  " + "'" + MainFrame.this.txtAddMName.getText() + "',  " + "'" + MainFrame.this.txtAddSName.getText() + "',  " + "'" + MainFrame.this.txtAddEmail.getText() + "',  " + "'" + MainFrame.this.cmbAddSize.getSelectedItem().toString() + "',  " + "'" + MainFrame.this.cmbAddRegistrationFee.getSelectedItem().toString() + "',  " + "'" + MainFrame.this.cmbAddLiabilityForm.getSelectedItem().toString() + "',  " + "'" + MainFrame.this.txtAddTransport.getText() + "',  " + "'" + arrivalDate + "',  " + "'" + arrivalTime + "',  " + "'" + MainFrame.this.txtAddArrivalAirline.getText() + "',  " + "'" + MainFrame.this.txtAddArrivalSection.getText() + "',  " + "'" + departureDate + "',  " + "'" + departureTime + "',  " + "'" + MainFrame.this.txtAddDepartureAirline.getText() + "',  " + "'" + MainFrame.this.txtAddDepartureSection.getText() + "',  " + "'" + birthDate + "',  " + "'" + MainFrame.this.txtAddBaggageTag.getText() + "', " + "'" + MainFrame.this.txtAddAccomodation.getText() + "', " + "'" + MainFrame.this.spnAddAge.getValue().toString() + "', " + "'" + MainFrame.this.spnAddBGNumber.getValue().toString() + "'" + ")";
          
          s.executeUpdate(sql);
          JOptionPane.showMessageDialog(MainFrame.this.addNewAttendee, MainFrame.this.txtAddFName.getText() + " added. NB Has not been checked in");
          MainFrame.this.txtAddFName.setText("");
          MainFrame.this.txtAddMName.setText("");
          MainFrame.this.txtAddSName.setText("");
          MainFrame.this.txtAddEmail.setText("");
          MainFrame.this.cmbAddLiabilityForm.setSelectedIndex(1);
          MainFrame.this.txtAddTransport.setText("");
          MainFrame.this.cmbAddDOBDay.setSelectedIndex(0);
          MainFrame.this.cmbAddDOBMonth.setSelectedIndex(0);
          MainFrame.this.cmbAddDOBYear.setSelectedIndex(0);
          MainFrame.this.txtAddArrivalAirline.setText("");
          MainFrame.this.txtAddArrivalSection.setText("");
          MainFrame.this.txtAddDepartureAirline.setText("");
          MainFrame.this.txtAddDepartureSection.setText("");
          MainFrame.this.txtAddBaggageTag.setText("");
          MainFrame.this.txtAddAccomodation.setText("");
          MainFrame.this.cmbAddSize.setSelectedIndex(1);
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
      }
    });
    this.btnShowAttendees.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        MainFrame.this.DatabaseModel.setRowCount(0);
        MainFrame.this.populateTable("Attendees");
      }
    });
    this.btnShowCheckIn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        MainFrame.this.DatabaseModel.setRowCount(0);
        MainFrame.this.populateTable("CheckedIn");
      }
    });
  }
  
  private void getSessions()
  {
    try
    {
      this.listmodel.removeAllElements();
      DatabaseMetaData meta = con.getMetaData();
      ResultSet rs = meta.getTables(null, null, "Session_%", null);
      while (rs.next()) {
        this.listmodel.addElement(rs.getString("TABLE_NAME"));
      }
      this.listmodel.addElement("Add New Session");
    }
    catch (SQLException e1)
    {
      e1.printStackTrace();
    }
  }
  
  private String getFilter()
  {
    String filter = "";
    if ((!this.txtFilterCenter.getText().equals("")) && (!this.txtFilterName.getText().equals(""))) {
      filter = "Center LIKE '%" + this.txtFilterCenter.getText() + "%' AND FirstName LIKE '%" + this.txtFilterName.getText() + "%'";
    } else if (!this.txtFilterCenter.getText().equals("")) {
      filter = "Center LIKE '%" + this.txtFilterCenter.getText() + "%'";
    } else if (!this.txtFilterName.getText().equals("")) {
      filter = "FirstName LIKE '%" + this.txtFilterName.getText() + "%'";
    }
    return filter;
  }
  
  private String getSessionPresent(String sessionName)
  {
    String present = "";
    String sql = "SELECT COUNT(*) FROM " + sessionName;
    try
    {
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery(sql);
      if (rs.next()) {
        present = rs.getString(1) + " Present";
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    if (present.equals("")) {
      return "0 Present";
    }
    return present;
  }
  
  private String getSessionAbsent(String sessionName)
  {
    String absent = "";
    String sql = "SELECT COUNT(*) FROM CheckedIn";
    try
    {
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery(sql);
      if (rs.next())
      {
        int total = rs.getInt(1);
        int present = this.tablemodel.getRowCount();
        
        int numAbsent = total - present;
        absent = numAbsent + " Absent";
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    if (absent.equals("")) {
      return "0 Absent";
    }
    return absent;
  }
  
  private void populateTable(String table)
  {
    try
    {
      Statement s = con.createStatement();
      String sql = "SELECT * FROM " + table;
      String filter = getFilter();
      if (!filter.equals("")) {
        sql = sql + " WHERE " + filter;
      }
      ResultSet rs = s.executeQuery(sql);
      while (rs.next())
      {
        String[] rowData = { rs.getString("ID"), rs.getString("GroupName"), rs.getString("Country"), rs.getString("Center"), rs.getString("FirstName"), 
          rs.getString("MiddleName"), rs.getString("Surname"), rs.getString("Email"), rs.getString("TShirtSize"), 
          rs.getString("RegistrationFee"), rs.getString("LiabilityForm"), rs.getString("Transport"), rs.getString("ArrivalDate"), 
          rs.getString("ArrivalTime"), rs.getString("ArrivalAirline"), rs.getString("ArrivalSection"), rs.getString("DepartureDate"), 
          rs.getString("DepartureTime"), rs.getString("DepartureAirline"), rs.getString("DepartureSection"), rs.getString("DateOfBirth"), 
          rs.getString("BaggageTag"), rs.getString("Accomodation"), rs.getString("Age"), rs.getString("BGNumber") };
        
        this.DatabaseModel.addRow(rowData);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  private void populateCountries()
  {
    this.cmbCountriesModel.removeAllElements();
    try
    {
      Statement s = con.createStatement();
      String sql = "SELECT DISTINCT Country FROM Attendees ORDER BY Country";
      ResultSet rs = s.executeQuery(sql);
      while (rs.next()) {
        this.cmbCountriesModel.addElement(rs.getString("Country"));
      }
    }
    catch (SQLException e2)
    {
      e2.printStackTrace();
    }
    this.cmbCountriesModel.setSelectedItem(null);
  }
  
  private void populateCenters(String country)
  {
    this.cmbCentersModel.removeAllElements();
    try
    {
      Statement s = con.createStatement();
      String sql = "SELECT DISTINCT Center FROM Attendees WHERE Country LIKE '" + country + "' ORDER BY Center";
      ResultSet rs = s.executeQuery(sql);
      while (rs.next()) {
        this.cmbCentersModel.addElement(rs.getString("Center"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    this.cmbAddCenter.setEnabled(true);
  }
  
  private void populateGroupNames()
  {
    this.groupNameModel.removeAllElements();
    try
    {
      Statement s = con.createStatement();
      String sql = "SELECT DISTINCT GroupName FROM Attendees ORDER BY GroupName";
      ResultSet rs = s.executeQuery(sql);
      while (rs.next()) {
        this.groupNameModel.addElement(rs.getString("GroupName"));
      }
    }
    catch (SQLException e2)
    {
      e2.printStackTrace();
    }
    this.groupNameModel.setSelectedItem(null);
  }
}
