package personalFinance.domain;

import org.springframework.data.annotation.Id;

public class Account {

	@Id
	private String id;

	private String name;
	private String description;
	private Double balance;
	
	public Account() {}

    public Account(String name, String description) {
        this.name = name;
        this.description = description;
        this.balance = 0.0;
    }
    
    public String getId() {
		return id;
	}
    
	public void setId(String name) {
		this.name = name;
	}    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBalance() {
		return balance;
	}

	/* control balance */
	public void setBalance(Double balance) {
		this.balance += balance;
	}
	
	public String toString() {
		return String.format("Acount[id=%s, Name='%s', Description='%s', Balance=%s]",
				id, name, description, balance);
	}

}

