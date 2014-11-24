package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SoldItemTest {
	
	StockItem stockitem;
	
	@Before
	public void setUp(){
		stockitem = new StockItem((long) 10, "Test", "StockItem for testing", 10.0, 10);
	}
	
	@Test
	public void testGetSum(){
		SoldItem item1 = new SoldItem(stockitem, 5);
		assertEquals(item1.getSum(), item1.getPrice()*item1.getQuantity(), 0.0001);
	}
	
	@Test
	public void testGetSumWithZeroQuantity(){
		SoldItem item1 = new SoldItem(stockitem, 0);
		assertEquals(item1.getSum(), 0.0, 0.0001);
	}
}
