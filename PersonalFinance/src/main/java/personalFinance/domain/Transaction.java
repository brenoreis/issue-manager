package personalFinance.domain;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Transaction {

	@Id
	private String id;

	private Date date;
	private String description;
	private Category category;
	private Double amount;
	
	
	public Transaction() {}

    public Transaction(Date date, String description, Category category, Double amount) {
        this.date = date;
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

	public String getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String toString() {
		return String.format("Transaction[id=%s, Date='%s', Description='%s', Category='%s', Amount='%s']",
				id, DateFormat.getInstance().format(date), description, category.getName(), amount.toString());
	}

}
