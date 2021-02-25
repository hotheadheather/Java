package user;

public class UserData {
    private String username;
    private String email;
	private String inventoryid;
	private int kg;
    private String color;
	private int physicalform;
	private String reducingprop;
	private String strikingprop;
	private String colortransparency;
	private String adventurinetype; 
	private int costperkg;
    private int age;

    public UserData() {
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public void setEmail(String value) {
        this.email = value;
    }
	
	public void setInventoryid(String value) {
        this.inventoryid = value;
    }
	
	public void setKg(int value) {
        this.kg = value;
    }

    public void setColor(String value) {
        this.color = value;
    }
	
	public void setPhysicalform(int value) {
        this.physicalform = value;
    }
	
	public void setReducingprop(String value) {
        this.reducingprop = value;
    }
	
	public void setStrikingprop(String value) {
        this.strikingprop = value;
    }
	
	public void setColortransparency(String value) {
        this.colortransparency = value;
    }

	public void setAdventurinetype(String value) {
        this.adventurinetype = value;
    }

	public void setCostperkg(int value) {
        this.costperkg = value;
    }

	
    public void setAge(int value) {
        this.age = value;
    }	
	
    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }
	
	public String getInventoryid() {
        return this.inventoryid;
    }
		
    public int getKg() {
        return this.kg;
    }
	
    public String getColor() {
        return this.color;
    }
	
    public int getPhysicalform() {
        return this.physicalform;
    }
	
    public String getReducingprop() {
        return this.reducingprop;
    }
	
    public String getStrikingprop() {
        return this.strikingprop;
    }
	
    public String getColortransparency() {
        return this.colortransparency;
    }
	
    public String getAdventurinetype() {
        return this.adventurinetype;
    }
	
    public int getCostperkg() {
        return this.costperkg;
    }

    public int getAge() {
        return this.age;
    }
}

