package ee.ut.math.tvt.salessystem.ui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class HistoryTableModelTest {
	
	StockItem stockitem;
	SoldItem solditem;
	HistoryItem historyitem;
	HistoryTableModel hismod;
	
	@Before
	public void setUp(){
		stockitem = new StockItem((long) 10, "Test", "StockItem for testing", 10.0, 10);
		solditem = new SoldItem(stockitem, 5);
		List<SoldItem> list = new ArrayList<SoldItem>();
		Date now = new Date();
		list.add(solditem);
		historyitem = new HistoryItem(now, list);
		hismod = new HistoryTableModel();
	}
	
	@Test
	public void addHistoryItem(){
		hismod.addItem(historyitem);
		assertEquals(hismod.getValueAt(0, 0),historyitem.getDate());
		assertEquals(hismod.getValueAt(0, 1),historyitem.getTime());
		assertEquals(hismod.getValueAt(0, 2),historyitem.getPrice());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getColumnValue(){
		hismod.addItem(historyitem);
		assertEquals(hismod.getColumnValue(historyitem, 0), historyitem.getDate());
		assertEquals(hismod.getColumnValue(historyitem, 1), historyitem.getTime());
		assertEquals(hismod.getColumnValue(historyitem, 2), historyitem.getPrice());
		hismod.getColumnValue(historyitem, 3);
	}
}
