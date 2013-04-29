import classes.User;
import classes.Airport;


public class Main {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DbFactory.initiateSystem();


		//System.out.println(DbFactory.getCity(1).getName());
		//System.out.println(DbFactory.getRoute(1).getId());
		//System.out.println(DbFactory.getAirport(1).getName());
		
		User user = new User(1, "Emil", "Svensson", "Test", "02555", 3);
		user.setUsername("Svempa");
		user.setPassword("123");
		
		//DbFactory.insertUser(user);
		//System.out.println(DbFactory.getUser(1).getUsername());
		/*
		for(User user1 : DbFactory.users){
			System.out.println(user1.getUsername());
		}
		*/
		
		for(Airport airport : DbFactory.getAllCityAirports(21)){
			System.out.println(airport.getName());
		}
		//testa att alla listor funkar och hämtar rätt id etc.
	}

}
