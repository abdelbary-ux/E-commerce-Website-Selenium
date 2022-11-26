package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.clear-list")
	WebElement ClearListBtn;
	
	@FindBy(css = "div.no-data")
	WebElement noDatalbl;
	
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName = "tr")
	List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	List<WebElement> allCols;
	
	public void clearCompareList() {
		clickButton(ClearListBtn);
	}
	
	public void compareProducts() {
		//Get All Rows
		System.out.println(allRows.size());
		
		//Get Data from each Row
		for(WebElement row: allRows)
		{
			System.out.println(row.getText() + "\t");
			for(WebElement col : allCols)
			{
				System.out.println(col.getText() + "\t");
			}
		}
		
	}

}
