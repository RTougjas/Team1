package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="HISTORYITEM")
public class HistoryItem implements Cloneable, DisplayableItem{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DATE")
	private String date;
	
	@Column(name="TIME")
	private String time;
	
	@Column(name="PRICE")
	private double price;
	
	@ManyToMany
	@JoinTable(name="SoldItem",
			joinColumns={ @JoinColumn(name="SALE_ID", referencedColumnName="ID")},
			inverseJoinColumns={ @JoinColumn(name="STOCKITEM_ID", referencedColumnName="ID")}
	)
	private List<SoldItem> list;
	
	public HistoryItem(){
		
	}

	public HistoryItem(Date now,
			List<SoldItem> list) {
		super();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		this.date = date.format(now);
		this.time = time.format(now);
		this.price = getSum();
		this.list = list;
	}

	
	public List<SoldItem> getList() {
		return list;
	}

	public void setList(List<SoldItem> list) {
		this.list = list;
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
    
    public void addSoldItem(SoldItem solditem){
    	list.add(solditem);
    }
    
    public Double getSum(){
    	try{
	    	Double sum = 0.0;
	    	for(SoldItem elem : this.list){
	    		sum += elem.getSum();
	    	}
	    	return sum;
    	}catch(NullPointerException e){
    		return 0.0;
    	}
    }
	
}
