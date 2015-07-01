package personalFinance.domain;

import org.springframework.data.annotation.Id;

public class Currency {
	
	@Id
	private String id;

	private String symbol;
	private String description;
	
	public Currency() {}

    public Currency(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }
    
    public String getId() {
		return id;
	}
    
	public void setId(String name) {
		this.symbol = name;
	}    

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return String.format("Currency[id=%s, Symbol='%s', Description='%s']",
				id, symbol, description);
	}

}

