package ee.ut.math.tvt.salessystem.ui.model;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class HistoryTableModel extends SalesSystemTableModel<HistoryItem>{
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(HistoryTableModel.class);
	
	public HistoryTableModel(){
		super(new String[] {"Date", "Time", "Total Price"});
	}

	@Override
	protected Object getColumnValue(HistoryItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getDate();
		case 1:
			return item.getTime();
		case 2:
			return item.getPrice();
		}
		throw new IllegalArgumentException("Column index out of range");
	}
	
	public void addItem(final HistoryItem historyItem) {
		HistoryItem item = getItemById(historyItem.getId());
		rows.add(historyItem);
		log.debug("Added new item to history");
		fireTableDataChanged();
	}
	
	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final HistoryItem stockItem : rows) {
			buffer.append(stockItem.getDate() + "\t");
			buffer.append(stockItem.getTime() + "\t");
			buffer.append(stockItem.getPrice() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}

}
