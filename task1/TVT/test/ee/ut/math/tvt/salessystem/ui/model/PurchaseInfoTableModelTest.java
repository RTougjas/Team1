package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.InsufficientAmountException;

public class PurchaseInfoTableModelTest {
	
	List<SoldItem> dataset;
	PurchaseInfoTableModel model;
	StockItem chips;
	StockItem chupaChups;
	StockItem beer;
	
	@Before
	public void setUp(){
		model = new PurchaseInfoTableModel();
		dataset = new ArrayList<SoldItem>();

		chips = new StockItem(1l, "Lays chips", "Potato chips", 11.0, 5);
		chupaChups = new StockItem(2l, "Chupa-chups", "Sweets", 8.0, 8);
	    beer = new StockItem(4l, "Free Beer", "Student's delight", 0.0, 100);
	    
		dataset.add(new SoldItem(chips, 6));
		dataset.add(new SoldItem(chupaChups, 3));
		dataset.add(new SoldItem(beer, 3));
	}
	
	@Test
	public void addItemWithZeroPrice() throws InsufficientAmountException{
		model.addItem(dataset.get(2));
	}
	
	@Test(expected=InsufficientAmountException.class)
	public void addItemWithTooMuchQuanitity() throws InsufficientAmountException{
		model.addItem(dataset.get(0));
	}
	
	@Test
	public void addAlreadyExistingItem() throws InsufficientAmountException{
		model.addItem(dataset.get(1));
		model.addItem(new SoldItem(chupaChups, 2));
		assertEquals((int)model.getItemById(chupaChups.getId()).getQuantity(), 5);
	}
}
