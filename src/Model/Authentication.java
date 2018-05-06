package Model;

public class Authentication {
    private boolean exist;
    Employee employee;
    
    
	public Authentication(String userName, String password) {
		
		/*search in database exist = true if both match*/
		Sqlconnection sp = new Sqlconnection();
		try {
			this.employee =sp.getEmployee(userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	
	public boolean exists() {
		return exist;
	}
	
}
