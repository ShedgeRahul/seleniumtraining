package webelementsassignments;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class WebTable 
{
	WebElement element;
	
	public WebTable(WebElement element)
	{
		String tagName = element.getTagName();
		if(null == tagName || !"table".equals(tagName.toLowerCase()))
		{
			throw new UnexpectedTagNameException("table", "tagName");
		}
		
		this.element = element;
	}
	
	public List<WebElement> getAllDataRows()
	{
		WebElement tBody = element.findElement(By.tagName("tbody"));
		List <WebElement> allRows = tBody.findElements(By.tagName("tr"));
		return allRows;
	}
	
	public List<WebElement> getAllDataColumns()
	{
		WebElement tHead = element.findElement(By.tagName("thead"));
		List<WebElement> headers = tHead.findElements(By.tagName("th"));
		
	//	List<WebElement> headers = element.findElements(By.xpath("//thead//th"));
		
		return headers;
	}
	 
	public boolean deleteRow(String columnName, String searchValue)
	{
		int columnNumber = 0;
		int rowNumber = 0;
		int actionColumnPosition = 0;
	
		WebElement tHead = element.findElement(By.tagName("thead"));
		List<WebElement> headers = tHead.findElements(By.tagName("th"));
		
		for(WebElement oneColumn: headers)
		{
	//		System.out.println("Table Headers -  "+oneColumn.getText());
			++columnNumber;
			if(oneColumn.getText().equals(columnName))
			break;
		}
		System.out.println("coloumnNumber - "+columnNumber);
		List <WebElement> allRows = element.findElements(By.xpath("//tbody/tr//td["+columnNumber+"]"));
		
		for(WebElement eachRow: allRows)
		{
		//	System.out.println("Column data -  "+eachRow.getText());
			++rowNumber;
			if(eachRow.getText().contains(searchValue))
			break;
		}
		System.out.println("rowNumber - "+rowNumber);
		
		for(WebElement oneColumn: headers)
		{
	//		System.out.println("Headers - "+oneColumn.getText());
			actionColumnPosition++;
			if(oneColumn.getText().equals("Action"))
				break;
		}
	
		System.out.println("actionColumnPosition - "+actionColumnPosition);
	
		//String getText = element.findElement(By.xpath("//tbody/tr["+deleteRow+"]//td["+actionColumnPosition+"]//a[text()='delete']")).getText();
		//System.out.println(" "+getText);
	try
	{
	element.findElement(By.xpath("//tbody/tr["+rowNumber+"]//td["+actionColumnPosition+"]//a[text()='delete']")).click();
	}
	catch (NoSuchElementException e) 
	{
	fail("Delete link is not available ");
	}

	return true;
	}	
		
	public boolean deleteRow(String searchValue)
	{
		WebElement eachCell;
		int i,j = 0;
		int k=0;
		int detailsColumnPosition = 0;
		boolean flag = false;
		List <WebElement> allRows = element.findElements(By.xpath("//tbody//tr")); //getting all rows from tbody
	int	rowSize = allRows.size();
	System.out.println("rowSize "+rowSize);	
	
	WebElement tHead = element.findElement(By.tagName("thead"));
	
	List<WebElement> allColumns = tHead.findElements(By.tagName("th"));  // Getting table headers from thead
	int columnSize = allColumns.size();
	//columnSize = columnSize-1;
		System.out.println("columnSize - "+columnSize);
		
		for(i=1; i<=rowSize; i++)
		{
			for(j=1; j<columnSize; j++)
			{
			eachCell = element.findElement(By.xpath("tbody//tr["+i+"]//td["+j+"]"));	
			String cellData = eachCell.getText();
			if(cellData.equals(searchValue))
				{
				flag = true;
				break;
				}
			}
		if(flag==true)
				break;
		}
		
		
		System.out.println("i value - "+i);
		
		System.out.println("j value - "+j);
		
		
		List<WebElement> allCellsOfOneRow = element.findElements(By.xpath("//tbody//tr["+i+"]//td"));
		System.out.println("allCellsOfOneRow - "+allCellsOfOneRow.size());
		
		
		for(WebElement specificColumn: allColumns)
		{
			detailsColumnPosition = detailsColumnPosition+1;
			if(specificColumn.getText().equals("details"))
				break;
		}
		
		element.findElement(By.xpath("//tbody//tr["+i+"]//td["+(detailsColumnPosition-1)+"]")).click();
		
		
		
		/*	for(k=1 ; k<=allCellsOfOneRow.size(); k++)
		{
			String text = element.findElement(By.xpath("//tbody//tr["+i+"]//td["+k+"]")).getText();
			if(text.equals("details"));
			{
				System.out.println(" "+text);
				element.findElement(By.xpath("//tbody//tr["+i+"]//td["+k+"]")).click();
				break;
			}
		}
		
		
		*/
		
		
		
		
		
		
		
		
		
		
/*		boolean flag = false;
		int rowNumber = 0;
		int actionColumnPosition = 0;
		
		List <WebElement> allRows = element.findElements(By.xpath("//tbody//tr")); //getting all rows from tbody
		System.out.println("allRows count - "+allRows.size());
		List <WebElement> allCell = allRows.findElements(By.xpath("//tbody//tr//td"));  //getting all cells of all rows
		System.out.println("allCell count - "+allCell.size());
		
		for(WebElement eachRow: allRows)
		{
			rowNumber=rowNumber+1;  	
			for(WebElement eachCell: allCell)
			{
				System.out.println(" "+eachCell.getText());   
			if(eachCell.getText().contains(searchValue))
			flag = true;
			break;
			}
			if(flag==true)
			break;
		}
		
		WebElement tHead = element.findElement(By.tagName("thead"));
		List<WebElement> headers = tHead.findElements(By.tagName("th"));  // Getting tablr headers to compare with column "…"
		
		for(WebElement oneColumn: headers)
		{
			System.out.println("Table Headers - "+oneColumn.getText());
			actionColumnPosition=actionColumnPosition+1;
			if(oneColumn.getText().equals("…"))
				break;
		}
	
			
		System.out.println("rowNumber - "+rowNumber);
		System.out.println("actionColumnPosition - "+actionColumnPosition);

try {
	element.findElement(By.xpath("//tbody/tr["+rowNumber+"]//td["+(actionColumnPosition-1)+"]//a[text()='details']")).click();
}
catch (NoSuchElementException e) {
	fail("Details link is not available ");
}
*/
	return true;
	


	
	
	
	
	
	/*		
	List<WebElement> allCellsOfOneRow = element.findElements(By.xpath("//tbody//tr["+rowNumber+"]//td"));
	
	for(WebElement oneCellOfOneRow : allCellsOfOneRow)
	{
		String text = oneCellOfOneRow.getText();
		if(text.matches("details"));
		{
			System.out.println(" "+oneCellOfOneRow.getText());
			oneCellOfOneRow.click();
			break;
		}
	}

	return true;
*/
	
	}
}

























