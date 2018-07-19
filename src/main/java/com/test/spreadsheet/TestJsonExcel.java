package com.test.spreadsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;


/*
 * 
 *  <dependencies>
  	<dependency>
  		<groupId>org.apache.poi</groupId>
  		<artifactId>poi</artifactId>
  		<version>3.13</version>
  	</dependency>
  	<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>3.13</version>
</dependency>
  	<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
  </dependencies>
 * 
 */


public class TestJsonExcel {

/*public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub

		FileInputStream inp = new FileInputStream( new File("C://Users//Dharmic//Downloads//HCM-LCF.xlsx") );
		Workbook workbook = WorkbookFactory.create( inp );

		// Get the first Sheet.
		Sheet sheet = workbook.getSheetAt( 0 );

		    // Start constructing JSON.
		    JSONObject json = new JSONObject();

		    // Iterate through the rows.
		    JSONArray rows = new JSONArray();
		    for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); )
		    {
		        Row row = rowsIT.next();
		        JSONObject jRow = new JSONObject();

		        // Iterate through the cells.
		        JSONArray cells = new JSONArray();
		        for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); )
		        {
		            Cell cell = cellsIT.next();
		            cell.setCellType(Cell.CELL_TYPE_STRING);
		            cells.add(cell.getStringCellValue());
		        }
		        jRow.put( "cell", cells );
		        rows.add( jRow );
		    }

		    // Create the JSON.
		    json.put( "rows", rows );

		    System.out.println(json);
		    
		// Get the JSON text.
		//return json.toString();
		
		
	}*/

}
