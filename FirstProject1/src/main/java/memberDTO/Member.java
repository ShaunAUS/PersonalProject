package memberDTO;

public class Member {
	
	private int memberIdx;	
	private String name;	 
	private String password;
	private String email;
	private String contact;
	private String contact_phone;
	private String address;
	
	
	public Member() {
		
	}


	public Member(int memberIdx, String name, String password, String email, String contact, String contact_phone,
			String address) {
		super();
		this.memberIdx = memberIdx;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.contact_phone = contact_phone;
		this.address = address;
	}


	public int getMemberIdx() {
		return memberIdx;
	}


	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getContact_phone() {
		return contact_phone;
	}


	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
