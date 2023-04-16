package co.edu.uptc.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private final String PATH="resources/Record.xlsx";
    private final String SHEETNAME="Hoja1";

    public ArrayList<Object> readExcel() throws Exception{
        ArrayList<Object> objects = new ArrayList<>();
        FileInputStream fileIS = new FileInputStream(new File(PATH));
        XSSFWorkbook wb = new XSSFWorkbook(fileIS);
        XSSFSheet sheet = wb.getSheet(SHEETNAME);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row r = sheet.getRow(i);
            ArrayList<String> tempObjects = new ArrayList<>();
            for (int j = 0; j < r.getLastCellNum(); j++) {
                if(r.getCell(0).getStringCellValue()!="Tipo")
                    tempObjects.add(getCellValue(r.getCell(j)));                 
            }objects.add(initObjects(tempObjects));
        }wb.close();
        return objects;
    }
    
    private String getCellValue(Cell cell){
        String toAdd="";
        if(cell.getCellType().toString()=="NUMERIC"){
            toAdd = (int)cell.getNumericCellValue()+"";
        }else
            toAdd = cell.getStringCellValue();
        return toAdd;
    }
    
    public Object initObjects(ArrayList<String> tempObjects){
        Object obj = new Object();
        switch(tempObjects.get(0)){                
            case "Persona": obj = new Person(tempObjects.get(1), tempObjects.get(2),tempObjects.get(3), Integer.parseInt(tempObjects.get(4)));
                        break;
            case "Vehículo": obj = new Car(tempObjects.get(1), Integer.parseInt(tempObjects.get(2)),tempObjects.get(3),tempObjects.get(4));
                        break;
            case "Libro": obj = new Book(tempObjects.get(1), tempObjects.get(2),Integer.parseInt(tempObjects.get(3)),Integer.parseInt(tempObjects.get(4)));
                        break;
            case "Empresa": obj = new Enterprise(Long.parseLong(tempObjects.get(1)), tempObjects.get(2), tempObjects.get(3), Long.parseLong(ignoreSymbol(tempObjects.get(4))));
                        break;
        }return obj;
    }
    private String ignoreSymbol(String cell){
        String newCell = cell.replace("$", "");
        String x =newCell.replace(".", "");
        return x.replace("\n", "");
    }
    
    public void writePersons(SimpleList<Person> p) throws IOException{
        for (int i = 1; i <= p.getSize(); i++) {
            fileWriter("resources/PersonsSorted.txt", p.getNodePos(i).getInformation());
        }
    }
    public void writeCars(SimpleList<Car> c) throws IOException{
        for (int i = 1; i <= c.getSize(); i++) {
            fileWriter("resources/CarsSorted.txt", c.getNodePos(i).getInformation());
        }
    }
    public void writeBooks(SimpleList<Book> b) throws IOException{
        for (int i = 1; i <= b.getSize(); i++) {
            fileWriter("resources/Books.txt", b.getNodePos(i).getInformation());
        }
    }
    public void writeSumary(SimpleList<String> data) throws IOException{
        for (int i = 1; i <=data.getSize()  ; i++) {
            fileWriter("resources/Resumen.txt", data.getNodePos(i).getInformation());
        }   
    }


    private void fileWriter(String path, Object o) throws IOException{
        FileWriter file = new FileWriter(new File(path).getAbsolutePath(),true);  
        file.write("\n");
        file.write(""+ o);
        file.close();
    }
}