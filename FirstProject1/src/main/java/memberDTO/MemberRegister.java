package memberDTO;

public class MemberRegister {
	private String name;
	private String	email;
	private String	password;
	private String	address;
	private String	detail_address;
	private String	city;
	private String	postcode;
	
	public MemberRegister() {
		
	}

	public MemberRegister(String name, String email, String password, String address, String detail_address,
			String city, String postcode) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.detail_address = detail_address;
		this.city = city;
		this.postcode = postcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
}
