package pojo;

public class AllEmployyPojo {
	int id,salary;
	String ep,type,department;
	
	public int getId() {
		return id;
	}

	public int getSalary() {
		return salary;
	}

	public String getEp() {
		return ep;
	}



	public String getType() {
		return type;
	}

	public String getDepartment() {
		return department;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setEp(String ep) {
		this.ep = ep;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	

	public AllEmployyPojo(int id, int salary, String ep, String type, String department) {
		super();
		this.id = id;
		this.salary = salary;
		this.ep = ep;
		this.type = type;
		this.department = department;
	}

	public AllEmployyPojo() {
		super();
	}
	

	

}
