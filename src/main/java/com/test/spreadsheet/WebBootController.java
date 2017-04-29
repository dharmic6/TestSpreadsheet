package com.test.spreadsheet;

import java.util.Iterator;
import java.util.Map;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;






import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebBootController {

	
	@RequestMapping("/web")
	public String welcome() {
		System.out.println("Inside WebBootContorller");
		//model.put("message", this.message);
		return "welcome";
	}
	
	/*@RequestMapping("/fileupload")
	public String fileupload() {
		System.out.println("Inside WebBootContorller fileupload");
		//model.put("message", this.message);
		return "welcome";
	}
	*/
//	@PostMapping("/fileupload") // //new annotation since 4.3
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, HttpServletRequest request, Map<String, Object> model) {

		
		System.out.println("Uploading >> "+file.getName());
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "uploadStatus";
        }

        try {

        	// Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(System.getProperty("user.home") + System.getProperty("file.separator") + file.getOriginalFilename());
            Files.write(path, bytes);

            System.out.println("Available at >>"+path.toFile().getAbsolutePath());
        
            request.getSession().setAttribute("file", path.toFile().getAbsolutePath());
            
            
            String modelData = "<table border=\"1\"><tr><th>Question No</th><th>Question</th><th>Option1</th><th>Option2</th><th>Option3</th><th>Option4</th><th>Option5</th><th>Solution</th></tr>";
            
            
            
            modelData += getData(path.toFile())+"</table>";
            
            model.put("message", modelData);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        return "uploadStatus";
    }
	
	
	
	public String getData(File file){
	 try {

		 String modelData = "";
         FileInputStream excelFile = new FileInputStream(file);
         Workbook workbook = new XSSFWorkbook(excelFile);
         Sheet datatypeSheet = workbook.getSheetAt(0);
         Iterator<Row> iterator = datatypeSheet.iterator();

         iterator.next();
         int i = 1;
         
         while (iterator.hasNext()) {
        	 
        	 modelData += "<tr><th>"+(i++)+"</th>";
        	 
             Row currentRow = iterator.next();
             Iterator<Cell> cellIterator = currentRow.iterator();

             while (cellIterator.hasNext()) {

                 Cell currentCell = cellIterator.next();
                 //getCellTypeEnum shown as deprecated for version 3.15
                 //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                 if (currentCell.getCellTypeEnum() == CellType.STRING) {
                	 
                	 String data = 	currentCell.getRichStringCellValue().getString().trim();//.replaceAll(" ", ",");//.replaceAll("$$", "");
                	 
                	 //data = data.replaceAll(" ", ",").replaceAll("\\$\\$", "").replaceAll(";", "<br/>");
                	 
                	 data = data.replaceAll(";", "&nbsp;");
                	 
                	 
                	 modelData += "<td>"+data+"</td>";
                	 /*
                	 if(data.contains("$$")){
                		 modelData += "<td>\\[\\table"+data+"\\]</td>";
                	 }else{
                		 
                	 }*/
                	 
                	 
                	 System.out.println(">>"+data);
                	 
                	 
                     System.out.print(currentCell.getRichStringCellValue().getString() + "--");
                 } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                	 //String data = 	currentCell.getRichStringCellValue().getString().trim().replace(" ", "&nbsp;");
                	 modelData += "<td>"+currentCell.getNumericCellValue()+"</td>";
                	 System.out.print(currentCell.getNumericCellValue() + "--");
                 }

             }
             System.out.println();
             modelData += "</tr>";

         }
         
         return modelData;
         
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
	 
	 return null;
	}
	

}