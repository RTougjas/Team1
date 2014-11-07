package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;

public class HistoryItem implements Cloneable, DisplayableItem{

	private SimpleDateFormat date;
	private SimpleDateFormat time;
	private double price;
	
	public HistoryItem(SimpleDateFormat date, SimpleDateFormat time,
			double price) {
		super();
		this.date = date;
		this.time = time;
		this.price = price;
	}

	@Override
	public Long getId() {
		return null;
	}

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}

	public SimpleDateFormat getTime() {
		return time;
	}

	public void setTime(SimpleDateFormat time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
    public Object getColumn(int columnIndex) {
        switch(columnIndex) {
            case 0: return date;
            case 1: return time;
            case 2: return new Double(price);
            default: throw new RuntimeException("invalid column!");
        }
    }
	
}
