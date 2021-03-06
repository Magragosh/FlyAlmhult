import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EtchedBorder;
import classes.*;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

public class MainWindow {

	private JFrame frame;
	private JTextField textAirportName;
	private JTextField textAddCity;
	private JTextField textFieldDepartureTime;
	private JTextField textFieldArrivalTime;
	private JTextField textUsername;
	private List<JPanel> Panels = new ArrayList<JPanel>();
	private boolean loggedIn = false;
	
	DefaultListModel listModelAirports = new DefaultListModel();
	DefaultListModel listModelCities = new DefaultListModel();
	DefaultListModel listModelRoutes = new DefaultListModel();
	DefaultListModel listModelFlights = new DefaultListModel();
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAdress;
	private JTextField textZipCode;
	private JTextField textEmail;
	private JTextField textTelephone;
	private JTextField textUserName;
	private JTextField textPass;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panelLogIn = new JPanel();
		panelLogIn.setBounds(65, 39, 313, 503);
		frame.getContentPane().add(panelLogIn);
		panelLogIn.setLayout(null);
		Panels.add(panelLogIn);
		
		textUsername = new JTextField();
		textUsername.setBounds(26, 64, 215, 20);
		panelLogIn.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblLoggaIn = new JLabel("Logga in");
		lblLoggaIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoggaIn.setBounds(10, 11, 82, 20);
		panelLogIn.add(lblLoggaIn);
		
		JLabel lblAnvndarnamn = new JLabel("Anv\u00E4ndarnamn:");
		lblAnvndarnamn.setBounds(26, 49, 104, 14);
		panelLogIn.add(lblAnvndarnamn);
		
		JLabel lblLsenord = new JLabel("L\u00F6senord:");
		lblLsenord.setBounds(26, 95, 92, 14);
		panelLogIn.add(lblLsenord);
		
		JButton btnLoggaIn = new JButton("Logga in");
		btnLoggaIn.setBounds(152, 136, 89, 23);
		panelLogIn.add(btnLoggaIn);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(26, 108, 215, 20);
		panelLogIn.add(textPassword);
		//		btnSaveRoute.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e)
		//            {
		//				Route tempRoute;
		//				tempRoute.setArriveAirport(arriveAirport);
		//				tempRoute.setDepartAirport(departAirport);
		//                DbFactory.insertRoute(tempRoute);
		//            }
		//		});
		//		btnAddCity.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e)
		//          {
		//				City tempCity;
		//				tempCity.setCountry(country);
		//				tempCity.setName(name);
		//              DbFactory.insertCity(tempCity);
		//          }
		//		});
		//		btnAddAirport.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e)
		//          {
		//				Airport tempAirport;
		//				tempAirport.setCity(city);
		//				tempAirport.setName(name);
		//              DbFactory.insertAirport(tempAirport);
		//          }
		//		});
		//		btnSparaFlight.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e)
		//          {
		//				Flight tempFlight;
		//				tempFlight.setArrival(arrival);
		//				tempFlight.setDeparture(departure);
		//				tempFlight.setPlane(plane);
		//				tempFlight.setRoute(route);
		//              DbFactory.insertFlight(tempFlight);
		//          }
		//		});
				btnLoggaIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						if(DbFactory.checkPassword(textUsername.getText(), textPassword.getText())){
							loggedIn = true;
							hideAllPanels();
						}
					}
				});
		
		final JPanel panelAirports = new JPanel();
		panelAirports.setBounds(65, 40, 276, 502);
		frame.getContentPane().add(panelAirports);
		panelAirports.setLayout(null);
		panelAirports.setVisible(false);
		Panels.add(panelAirports);
		
		JLabel lblHanteraFlygplatser = new JLabel("Hantera flygplatser");
		lblHanteraFlygplatser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHanteraFlygplatser.setBounds(10, 11, 162, 28);
		panelAirports.add(lblHanteraFlygplatser);
		
		JLabel lblFlygplats = new JLabel("Flygplats:");
		lblFlygplats.setBounds(10, 50, 56, 14);
		panelAirports.add(lblFlygplats);
		
		JLabel lblStad = new JLabel("Stad:");
		lblStad.setBounds(10, 75, 46, 14);
		panelAirports.add(lblStad);
		
		textAirportName = new JTextField();
		textAirportName.setBounds(61, 47, 205, 20);
		panelAirports.add(textAirportName);
		textAirportName.setColumns(10);
		
		JComboBox comboBoxCity = new JComboBox();
		comboBoxCity.setBounds(61, 72, 205, 20);
		panelAirports.add(comboBoxCity);
		
		JButton btnAddAirport = new JButton("L\u00E4gg till/\u00C4ndra");
		btnAddAirport.setBounds(145, 100, 121, 23);
		panelAirports.add(btnAddAirport);
		
		JButton btnDeleteAirport = new JButton("Ta bort flygplats");
		btnDeleteAirport.setBounds(145, 134, 121, 23);
		panelAirports.add(btnDeleteAirport);
		
		JLabel lblTillgngligaFlygplatser = new JLabel("Tillg\u00E4ngliga flygplatser");
		lblTillgngligaFlygplatser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaFlygplatser.setBounds(10, 168, 162, 14);
		panelAirports.add(lblTillgngligaFlygplatser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 256, 94);
		panelAirports.add(scrollPane);
		
		JList listAirports = new JList(listModelAirports);
		scrollPane.setViewportView(listAirports);
		listAirports.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblLggTillStder = new JLabel("L\u00E4gg till st\u00E4der");
		lblLggTillStder.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLggTillStder.setBounds(10, 312, 127, 14);
		panelAirports.add(lblLggTillStder);
		
		textAddCity = new JTextField();
		textAddCity.setBounds(10, 331, 144, 20);
		panelAirports.add(textAddCity);
		textAddCity.setColumns(10);
		
		JButton btnAddCity = new JButton("L\u00E4gg till/\u00C4ndra");
		btnAddCity.setBounds(155, 330, 111, 23);
		panelAirports.add(btnAddCity);
		
		JButton btnTaBortStad = new JButton("Ta bort stad");
		btnTaBortStad.setBounds(166, 354, 100, 23);
		panelAirports.add(btnTaBortStad);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 399, 256, 92);
		panelAirports.add(scrollPane_1);
		
		JList listCities = new JList(listModelCities);
		scrollPane_1.setViewportView(listCities);
		listCities.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblTillgngligaStder = new JLabel("Tillg\u00E4ngliga st\u00E4der");
		lblTillgngligaStder.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaStder.setBounds(10, 374, 152, 14);
		panelAirports.add(lblTillgngligaStder);
		
		final JPanel panelManageUsers = new JPanel();
		panelManageUsers.setBounds(65, 40, 313, 502);
		frame.getContentPane().add(panelManageUsers);
		panelManageUsers.setLayout(null);
		Panels.add(panelManageUsers);
		
		JLabel lblHanteraAnvndare = new JLabel("Hantera anv\u00E4ndare");
		lblHanteraAnvndare.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHanteraAnvndare.setBounds(6, 17, 183, 27);
		panelManageUsers.add(lblHanteraAnvndare);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(139, 75, 134, 28);
		panelManageUsers.add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setBounds(139, 109, 134, 28);
		panelManageUsers.add(textLastName);
		textLastName.setColumns(10);
		
		JLabel lblFrnamn = new JLabel("F\u00F6rnamn");
		lblFrnamn.setBounds(40, 81, 61, 16);
		panelManageUsers.add(lblFrnamn);
		
		JLabel lblEfternamn = new JLabel("Efternamn");
		lblEfternamn.setBounds(40, 115, 87, 16);
		panelManageUsers.add(lblEfternamn);
		
		textAdress = new JTextField();
		textAdress.setBounds(139, 137, 134, 28);
		panelManageUsers.add(textAdress);
		textAdress.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(40, 143, 61, 16);
		panelManageUsers.add(lblAdress);
		
		textZipCode = new JTextField();
		textZipCode.setBounds(139, 168, 134, 28);
		panelManageUsers.add(textZipCode);
		textZipCode.setColumns(10);
		
		JLabel lblPostnummer = new JLabel("Postadress");
		lblPostnummer.setBounds(40, 174, 87, 16);
		panelManageUsers.add(lblPostnummer);
		
		textEmail = new JTextField();
		textEmail.setBounds(139, 196, 134, 28);
		panelManageUsers.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 202, 61, 16);
		panelManageUsers.add(lblEmail);
		
		textTelephone = new JTextField();
		textTelephone.setBounds(139, 232, 134, 28);
		panelManageUsers.add(textTelephone);
		textTelephone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefon");
		lblNewLabel.setBounds(40, 230, 61, 33);
		panelManageUsers.add(lblNewLabel);
		
		textUserName = new JTextField();
		textUserName.setBounds(139, 259, 134, 28);
		panelManageUsers.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblAnvndarnamn_1 = new JLabel("Anv\u00E4ndarnamn");
		lblAnvndarnamn_1.setBounds(40, 265, 94, 16);
		panelManageUsers.add(lblAnvndarnamn_1);
		
		textPass = new JTextField();
		textPass.setBounds(139, 285, 134, 28);
		panelManageUsers.add(textPass);
		textPass.setColumns(10);
		
		JLabel lblLsenord_1 = new JLabel("L\u00F6senord");
		lblLsenord_1.setBounds(40, 291, 61, 16);
		panelManageUsers.add(lblLsenord_1);
		
		JComboBox comboBoxClearance = new JComboBox();
		comboBoxClearance.setBounds(139, 315, 134, 27);
		panelManageUsers.add(comboBoxClearance);
		
		JLabel lblBehrighet = new JLabel("Beh\u00F6righet");
		lblBehrighet.setBounds(40, 319, 94, 16);
		panelManageUsers.add(lblBehrighet);
		
		JButton btnSaveUser = new JButton("Spara ");
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveUser.setBounds(139, 350, 117, 29);
		panelManageUsers.add(btnSaveUser);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(40, 407, 233, 84);
		panelManageUsers.add(scrollPane_4);
		
		JList list = new JList();
		scrollPane_4.setViewportView(list);
		
		JLabel lblTillgngligaAnvndare = new JLabel("Tillg\u00E4ngliga anv\u00E4ndare");
		lblTillgngligaAnvndare.setBounds(40, 388, 233, 16);
		panelManageUsers.add(lblTillgngligaAnvndare);
		
		
		
		//----------
		final JPanel panelRoute = new JPanel();
		panelRoute.setBounds(65, 40, 302, 502);
		frame.getContentPane().add(panelRoute);
		panelRoute.setLayout(null);
		Panels.add(panelRoute);
		
		JLabel lblFlightRoute = new JLabel("Flight Route");
		lblFlightRoute.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlightRoute.setBounds(10, 11, 113, 26);
		panelRoute.add(lblFlightRoute);
		
		JLabel lblFlighter = new JLabel("Flight");
		lblFlighter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlighter.setBounds(10, 257, 97, 20);
		panelRoute.add(lblFlighter);
		
		JComboBox comboBoxRouteFrom = new JComboBox();
		comboBoxRouteFrom.setBounds(10, 59, 139, 20);
		panelRoute.add(comboBoxRouteFrom);
		
		JComboBox comboBoxRouteTo = new JComboBox();
		comboBoxRouteTo.setBounds(153, 59, 139, 20);
		panelRoute.add(comboBoxRouteTo);
		
		JLabel lblFrn = new JLabel("Fr\u00E5n:");
		lblFrn.setBounds(10, 41, 46, 17);
		panelRoute.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till:");
		lblTill.setBounds(153, 42, 46, 14);
		panelRoute.add(lblTill);
		
		JButton btnSaveRoute = new JButton("Spara");
		btnSaveRoute.setBounds(216, 90, 76, 23);
		panelRoute.add(btnSaveRoute);
		
		JComboBox comboBoxRoute = new JComboBox();
		comboBoxRoute.setBounds(66, 288, 226, 20);
		panelRoute.add(comboBoxRoute);
		
		JLabel lblFlygrutt = new JLabel("Flygrutt:");
		lblFlygrutt.setBounds(10, 291, 46, 14);
		panelRoute.add(lblFlygrutt);
		
		JComboBox comboBoxPlane = new JComboBox();
		comboBoxPlane.setBounds(66, 313, 226, 20);
		panelRoute.add(comboBoxPlane);
		
		JLabel lblFlygplan = new JLabel("Flygplan:");
		lblFlygplan.setBounds(10, 316, 46, 14);
		panelRoute.add(lblFlygplan);
		
		JLabel lblAvgng = new JLabel("Avg\u00E5ng:");
		lblAvgng.setBounds(10, 341, 46, 14);
		panelRoute.add(lblAvgng);
		
		JLabel lblAnkomst = new JLabel("Ankomst:");
		lblAnkomst.setBounds(163, 341, 63, 14);
		panelRoute.add(lblAnkomst);
		
		JButton btnSparaFlight = new JButton("Spara");
		btnSparaFlight.setBounds(203, 364, 89, 23);
		panelRoute.add(btnSparaFlight);
		
		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.setBounds(66, 338, 57, 20);
		panelRoute.add(textFieldDepartureTime);
		textFieldDepartureTime.setColumns(10);
		
		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.setBounds(236, 338, 56, 20);
		panelRoute.add(textFieldArrivalTime);
		textFieldArrivalTime.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 139, 282, 87);
		panelRoute.add(scrollPane_2);
		JList listRoutes = new JList(listModelRoutes);
		scrollPane_2.setViewportView(listRoutes);
		listRoutes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 418, 282, 73);
		panelRoute.add(scrollPane_3);
		JList listFlights = new JList(listModelFlights);
		scrollPane_3.setViewportView(listFlights);
		listFlights.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnDeleteFlight = new JButton("Ta bort");
		btnDeleteFlight.setBounds(110, 364, 89, 23);
		panelRoute.add(btnDeleteFlight);
		
		JButton btnDeleteRoute = new JButton("Ta bort");
		btnDeleteRoute.setBounds(117, 90, 89, 23);
		panelRoute.add(btnDeleteRoute);
		
		JLabel lblTillgngligaRoutes = new JLabel("Tillg\u00E4ngliga Routes");
		lblTillgngligaRoutes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaRoutes.setBounds(10, 122, 113, 14);
		panelRoute.add(lblTillgngligaRoutes);
		
		JLabel lblTillgngligaFlights = new JLabel("Tillg\u00E4ngliga Flights");
		lblTillgngligaFlights.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaFlights.setBounds(10, 398, 123, 14);
		panelRoute.add(lblTillgngligaFlights);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 93, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnMeny = new JMenu("Meny");
		menuBar.add(mnMeny);
		
		JMenuItem mntmHanteraFlygplatser = new JMenuItem("Hantera flygplatser");
		mntmHanteraFlygplatser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loggedIn == true) {
					hideAllPanels();
					panelAirports.setVisible(true);
				}
			}
		});
		
		JMenuItem mntmHanteraFlygrutter = new JMenuItem("Hantera flygrutter");
		mntmHanteraFlygrutter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loggedIn == true) {
					hideAllPanels();
					panelRoute.setVisible(true);
				}
			}
		});
		mnMeny.add(mntmHanteraFlygrutter);
		mnMeny.add(mntmHanteraFlygplatser);
		
		JMenuItem mntmLoggaUt = new JMenuItem("Logga ut");
		mntmLoggaUt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loggedIn = false;
				hideAllPanels();
				panelLogIn.setVisible(true);
				textUsername.setText("");
				textPassword.setText("");
			}
		});
		
		JMenuItem mntmHanteraAnvndare = new JMenuItem("Hantera anv\u00E4ndare");
		mntmHanteraAnvndare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelManageUsers.setVisible(true);
			}
		});
		mnMeny.add(mntmHanteraAnvndare);
		mnMeny.add(mntmLoggaUt);
		panelRoute.setVisible(false);
		
	
	
		DbFactory.initiateSystem();
		
		for(Airport a : DbFactory.airports){
			listModelAirports.add(0, a.getName());
		}
		for(City c : DbFactory.cities){
			listModelCities.add(0, c.getName());
		}
		for(Route r : DbFactory.routes){
			listModelRoutes.add(0, r.getDepartAirport().getName() + " till " + r.getArriveAirport().getName());
		}
		for(Flight f : DbFactory.flights){
			listModelFlights.add(0, f.getDeparture());
		}
	}
	public void hideAllPanels(){
		for (int i = 0; i < Panels.size(); i++) {
			Panels.get(i).setVisible(false);
		}
	}
}
