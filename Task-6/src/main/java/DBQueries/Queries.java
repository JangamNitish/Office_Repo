package DBQueries;

public class Queries {
	
	public String jsonquery()
	{
		return "SELECT * FROM alldetails";
		
	}
	public String searchid()
	{
		return "SELECT * FROM alldetails WHERE id=?";
		
	}
	public String add()
	{
		
		return "INSERT INTO alldetails VALUES(?,?,?,?,?)";

	}
    public String condelContract()
	{
		return "DELETE FROM contract WHERE id=?";
		
	}
    public String consearchid()
	{
		return "DELETE FROM contract WHERE id=?";
		
	}
    public String conaddContract()
   	{
   		return "INSERT INTO contract VALUES(?,?,?,?)";
   		
   	}
    public String conallContract()
   	{
   		return "SELECT * FROM contract";
   		
   	}
    public String conallDet()
   	{
   		return "INSERT INTO alldetails VALUES (?,?,?,?,?)";   		
   	}
    public String condelall()
   	{
   		return "DELETE FROM alldetails WHERE id=?";
   	}
    public String pardelContract()
	{
		return "DELETE FROM parttime WHERE id=?";
		
	}
    public String parsearchid()
	{
		return "DELETE FROM parttime WHERE id=?";
		
	}
    public String paraddContract()
   	{
   		return "INSERT INTO parttime VALUES(?,?,?,?)";
   		
   	}
    public String parallContract()
   	{
   		return "SELECT * FROM parttime";
   		
   	}
    public String parallDet()
   	{
   		return "INSERT INTO alldetails VALUES (?,?,?,?,?)";   		
   	}
    public String pardelall()
   	{
   		return "DELETE FROM alldetails WHERE id=?";
   	}
    public String perdelContract()
	{
		return "DELETE FROM permanent WHERE id=?";
		
	}
    public String persearchid()
	{
		return "DELETE FROM permanent WHERE id=?";
		
	}
    public String peraddContract()
   	{
   		return "INSERT INTO permanent VALUES(?,?,?,?)";
   		
   	}
    public String perallContract()
   	{
   		return "SELECT * FROM permanent";
   		
   	}
    public String perallDet()
   	{
   		return "INSERT INTO alldetails VALUES (?,?,?,?,?)";   		
   	}
    public String perdelall()
   	{
   		return "DELETE FROM alldetails WHERE id=?";
   	}

	
}
