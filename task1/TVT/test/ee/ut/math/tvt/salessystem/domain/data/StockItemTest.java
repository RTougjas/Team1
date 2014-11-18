package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {
	
	private StockItem item1;
	
	@Before
	public void setUp(){
		item1 = new StockItem((long) 10, "Test", "StockItem for testing", 10.0, 10);
	}
	
	@Test
	public void testClone(){
		assertEquals(item1.clone().toString(), item1.toString());
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetColumn(){
		assertEquals(item1.getColumn(0), item1.getId());
		assertEquals(item1.getColumn(1), item1.getName());
		assertEquals(item1.getColumn(2), item1.getPrice());
		assertEquals(item1.getColumn(3), item1.getQuantity());
		item1.getColumn(4);
	}
}
