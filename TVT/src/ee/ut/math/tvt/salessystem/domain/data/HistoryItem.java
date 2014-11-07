package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryItem implements Cloneable, DisplayableItem{

	private String date;
	private String time;
	private double price;
	
	public HistoryItem(Date now,
			double price) {
		super();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		this.date = date.format(now);
		this.time = time.format(now);
		this.price = price;
	}

	@Override
	public Long getId() {
		return null;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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
