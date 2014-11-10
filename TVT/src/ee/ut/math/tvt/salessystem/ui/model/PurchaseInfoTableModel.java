<<<<<<< HEAD
package ee.ut.math.tvt.salessystem.ui.model;

import java.util.List;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.exception.InsufficientAmountException;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

/**
 * Purchase history details model.
 */
public class PurchaseInfoTableModel extends SalesSystemTableModel<SoldItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(PurchaseInfoTableModel.class);
	
	public PurchaseInfoTableModel() {
		super(new String[] { "Id", "Name", "Price", "Quantity", "Sum"});
	}

	@Override
	protected Object getColumnValue(SoldItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		case 4:
			return item.getSum();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final SoldItem item : rows) {
			buffer.append(item.getId() + "\t");
			buffer.append(item.getName() + "\t");
			buffer.append(item.getPrice() + "\t");
			buffer.append(item.getQuantity() + "\t");
			buffer.append(item.getSum() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}
	
    /**
     * Add new StockItem to table.
     * @throws InsufficientAmountException 
     */
    public void addItem(final SoldItem item) throws InsufficientAmountException {
        /**
         * XXX In case such stockItem already exists increase the quantity of the
         * existing stock.
         */
    	
    	int soldItemQuantity = item.getQuantity();
    	int stockItemQuantity = item.getStockItem().getQuantity();
    	
    	int tempStockItemQuantity;
   
    	
    	if(rows.size() == 0) {
    		if(soldItemQuantity <= stockItemQuantity) {
    			rows.add(item);
    			tempStockItemQuantity = stockItemQuantity - soldItemQuantity;
    			System.out.println(tempStockItemQuantity);
    		}
    		else {throw new InsufficientAmountException();}
    	}
    	else {
    		boolean isInCart = false;
			int indeks = 0;
			for(int i = 0; i < rows.size(); i++) {
				if(item.getId().equals(rows.get(i).getId())) {
					isInCart = true;
					indeks = i;
					continue;
				}
			}
		
			if(isInCart) {
				rows.get(indeks).setQuantity(rows.get(indeks).getQuantity() + item.getQuantity());
				tempStockItemQuantity = rows.get(indeks).getQuantity();
				if(tempStockItemQuantity > stockItemQuantity) {
					throw new InsufficientAmountException();
				}
				System.out.println(tempStockItemQuantity);
			}
			else {
				rows.add(item);
			}
    	}
    	
    	fireTableDataChanged();
    	
    	/*
    	if(soldItemQuantity <= stockItemQuantity) {
    		if(rows.size() == 0) {
    			
    			rows.add(item);
    		}
    		else {
    			boolean isInCart = false;
    			int indeks = 0;
    			for(int i = 0; i < rows.size(); i++) {
    				if(item.getId().equals(rows.get(i).getId())) {
    					isInCart = true;
    					indeks = i;
    					continue;
    				}
    			}
    		
    			if(isInCart) {
    				rows.get(indeks).setQuantity(rows.get(indeks).getQuantity() + item.getQuantity());
    			}
    			else {
    				rows.add(item);
    			}
    		}
    		fireTableDataChanged();
    	}
    	else {
    		throw new InsufficientAmountException();
    	}
    	*/
    }

	public void setRows(List<SoldItem> list) {
		rows = list;
		fireTableDataChanged();
		
	}
}
=======
package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.exception.InsufficientAmountException;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

/**
 * Purchase history details model.
 */
public class PurchaseInfoTableModel extends SalesSystemTableModel<SoldItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(PurchaseInfoTableModel.class);
	
	public PurchaseInfoTableModel() {
		super(new String[] { "Id", "Name", "Price", "Quantity", "Sum"});
	}

	@Override
	protected Object getColumnValue(SoldItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		case 4:
			return item.getSum();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final SoldItem item : rows) {
			buffer.append(item.getId() + "\t");
			buffer.append(item.getName() + "\t");
			buffer.append(item.getPrice() + "\t");
			buffer.append(item.getQuantity() + "\t");
			buffer.append(item.getSum() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}
	
    /**
     * Add new StockItem to table.
     * @throws InsufficientAmountException 
     */
    public void addItem(final SoldItem item) throws InsufficientAmountException {
        /**
         * XXX In case such stockItem already exists increase the quantity of the
         * existing stock.
         */
    	
    	//See on seal text fieldis
    	int soldItemQuantity = item.getQuantity();
    	//See näitab kui palju laos on.
    	int stockItemQuantity = item.getStockItem().getQuantity();
    	
    	if(rows.size() == 0) {
    		if(soldItemQuantity <= stockItemQuantity) {
    			rows.add(item);
    		}
    		else {
    			throw new InsufficientAmountException();
    		}
    	}
    	else {
    		if(soldItemQuantity > stockItemQuantity) {
    			throw new InsufficientAmountException();
    		}
    		boolean inCart = false;
        	int index = 0; 
        	for(int i = 0; i < rows.size(); i++) {
        		if(item.getId().equals(rows.get(i).getId())) {
        			index = i;
        			
        			inCart = true;
        			break;
        		}
        	}
        	if(inCart) {
        		if(rows.get(index).getQuantity() >= stockItemQuantity) {
        			throw new InsufficientAmountException();
        		}
        		else {
        			rows.get(index).setQuantity(rows.get(index).getQuantity() + item.getQuantity());
        		}
        	}
        	else {
        		rows.add(item);
        	}
    	}
    	
    	fireTableDataChanged();
    
    }
}
>>>>>>> Dropdown_parandused

