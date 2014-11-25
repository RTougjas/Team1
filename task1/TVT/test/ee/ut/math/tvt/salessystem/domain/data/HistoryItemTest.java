package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HistoryItemTest {
	
	private SoldItem solditem;
	private StockItem stockitem;
	
	@Before
	public void setUp(){
		stockitem = new StockItem((long) 10, "Test", "StockItem for testing", 10.0, 10);
		solditem = new SoldItem(stockitem, 5);
	}
	
	@Test
	public void testAddSoldItem(){
		List<SoldItem> list = new ArrayList<SoldItem>();
		Date now = new Date();
		HistoryItem his = new HistoryItem(now, list);
		his.addSoldItem(solditem);
	}
	
	@Test
	public void testGetSumWithNoItems(){
		List<SoldItem> list = new ArrayList<SoldItem>();
		Date now = new Date();
		HistoryItem his = new HistoryItem(now, list);
		assertEquals(his.getSum(), 0.0, 0.0001);
	}
	
	@Test
	public void testGetSumWithOneItem(){
		List<SoldItem> list = new ArrayList<SoldItem>();
		Date now = new Date();
		list.add(solditem);
		HistoryItem his = new HistoryItem(now, list);
		assertEquals(his.getSum(), solditem.getSum(), 0.0001);
	}
	
	@Test
	public void testGetSumWithMultipleItems(){
		SoldItem solditem2 = new SoldItem(stockitem, 10);
		List<SoldItem> list = new ArrayList<SoldItem>();
		Date now = new Date();
		list.add(solditem);
		list.add(solditem2);
		HistoryItem his = new HistoryItem(now, list);
		assertEquals(his.getSum(), solditem.getSum() + solditem2.getSum(), 0.0001);
	}
}
