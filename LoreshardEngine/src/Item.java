import java.util.*;

public abstract class Item
	{
	private int value;
	private String itemName;
	static ArrayList <Item> items = new ArrayList<Item>();
	
	public int getValue()
		{
		return value;
		}
	
	public void setValue(int value)
		{
		this.value = value;
		}
	
	public String getItemName()
		{
		return itemName;
		}
	
	public void setItemName(String itemName)
		{
		this.itemName = itemName;
		}
	}