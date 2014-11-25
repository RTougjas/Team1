package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.InsufficientAmountException;

public class StockTableModelTest {
	
	
	List<StockItem> dataset;
	StockTableModel model;
	
	@Before
	public void setUp(){
		model = new StockTableModel();
		dataset = new ArrayList<StockItem>();

		StockItem chips = new StockItem(1l, "Lays chips", "Potato chips", 11.0, 5);
		StockItem chupaChups = new StockItem(2l, "Chupa-chups", "Sweets", 8.0, 8);
	    StockItem frankfurters = new StockItem(3l, "Frankfurters", "Beer sauseges", 15.0, 12);
	    StockItem beer = new StockItem(4l, "Free Beer", "Student's delight", 0.0, 100);
	    
		dataset.add(chips);
		dataset.add(chupaChups);
		dataset.add(frankfurters);
		dataset.add(beer);
		
		model.populateWithData(dataset);
	}
	
	@Test
	public void testValidateNameUniqueness() throws Exception{
		List<String> used = new ArrayList<String>();
		for (StockItem elem : dataset){
			if(used.contains(elem.getName())){
				throw new Exception();
			}
			used.add(elem.getName());
		}
	}
	
	@Test(expected=InsufficientAmountException.class)
	public void testHasEnoughInStock() throws InsufficientAmountException{
		SoldItem solditem = new SoldItem(dataset.get(0), 6);
		model.removeItem(solditem);
	}
	
	@Test
	public void testGetItemByIdWhenItemExists(){
		assertEquals(model.getItemById(dataset.get(0).getId()), dataset.get(0));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException(){
		model.getItemById(200);
	}
}
