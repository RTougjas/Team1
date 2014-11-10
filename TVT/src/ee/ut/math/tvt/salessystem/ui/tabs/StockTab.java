package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import org.apache.log4j.Logger;


public class StockTab {

  private static final Logger log = Logger.getLogger(StockTab.class);
	
  private JButton addItem;

  private SalesSystemModel model;

  public StockTab(SalesSystemModel model) {
    this.model = model;
  }

  // warehouse stock tab - consists of a menu and a table
  public Component draw() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    panel.setLayout(gb);

    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 0d;

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }
  
  
  // warehouse menu
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel();

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    panel.setLayout(gb);

    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 0;
    
    // Initialize the button
    addItem = createAddButton();

    //addItem = new JButton("Add");
    gc.gridwidth = GridBagConstraints.RELATIVE;
    gc.weightx = 1.0;
    panel.add(addItem, gc);

    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return panel;
  }
  // Creates the "Add" button.
  private JButton createAddButton() {
	    JButton b = new JButton("Add");
	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        newAddItemButtonClicked();
	      }
	    });

	    return b;
	  }
  
  /** Event handler for the <code>Add Item</code> event. */
  protected void newAddItemButtonClicked() {
    log.info("New item adding started");
    final JFrame adding = new JFrame("Insert new item");
    adding.getContentPane().setLayout(new FlowLayout());
    
    final JTextField id = new JTextField("Id");
    final JTextField name = new JTextField("Name");
    final JTextField price = new JTextField("Price");
    final JTextField quantity = new JTextField("Quantity");
    final JTextField description = new JTextField("Description");
    
    adding.getContentPane().add(id);
    adding.getContentPane().add(name);
    adding.getContentPane().add(description);
    adding.getContentPane().add(price);
    adding.getContentPane().add(quantity);
    
    JButton add2 = new JButton("Add");
    
    add2.addActionListener(new ActionListener(){
    	
    	public void actionPerformed(ActionEvent e)
    	{
    	try {
    	StockItem newItem = new StockItem(Long.valueOf(id.getText()),name.getText(),description.getText(), 
    			Double.valueOf(price.getText()),Integer.valueOf(quantity.getText()));
    	model.getWarehouseTableModel().addItem(newItem);
    	adding.dispose();
    	} catch (Exception z){
    		log.error(z);
    		adding.dispose();
    	}
    	}
    });
    
    adding.getContentPane().add(add2);
    adding.setVisible(true);
    adding.pack();
    
    model.getWarehouseTableModel().fireTableDataChanged();
  }

  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());

    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);

    JScrollPane scrollPane = new JScrollPane(table);

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();
    gc.fill = GridBagConstraints.BOTH;
    gc.weightx = 1.0;
    gc.weighty = 1.0;

    panel.setLayout(gb);
    panel.add(scrollPane, gc);

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

}
