package Model;

public class Authentication {
    private boolean exist;
    Employee employee;
    
    
	public Authentication(String userName, String password) {
		
		/*search in database exist = true if both match*/
		Sqlconnection sp = new Sqlconnection();
		try {
			System.out.println(userName+password+" fdsf ");
			this.employee =sp.getEmployee(userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(employee == null)
			System.out.println("here");
		
		
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	
	public boolean exists() {
		return exist;
	}
	
}
