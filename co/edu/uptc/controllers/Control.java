package co.edu.uptc.controllers;

import co.edu.uptc.component.SimpleList;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import co.edu.uptc.component.Book;
import co.edu.uptc.component.Car;
import co.edu.uptc.component.Enterprise;
import co.edu.uptc.component.ExcelReader;
import co.edu.uptc.component.Person;

public class Control {
    private SimpleList<Object> simple;
    private ExcelReader excelReader;


    public Control() throws Exception {
        excelReader = new ExcelReader();
        simple = new SimpleList<Object>();
        arrayToList();
    }

    public SimpleList<Object> getSimple() {
        return simple;
    }
    public void arrayToList() throws Exception{
        ArrayList<Object> objects = excelReader.readExcel();
        for (int i = 0; i < objects.size(); i++) {
            simple.add(objects.get(i));
        }
    }

    private SimpleList<Person> filterByPerson(){
        SimpleList<Person> toOrder = new SimpleList<>();
        for (int i = 1; i <= simple.getSize(); i++) {
            if(simple.getNodePos(i).getInformation().getClass().equals(Person.class))
                toOrder.add((Person)simple.getNodePos(i).getInformation());
        }
        return toOrder;
    }
    private SimpleList<Car> filterByCar(){
        SimpleList<Car> toOrder = new SimpleList<>();
        for (int i = 1; i <= simple.getSize(); i++) {
            if(simple.getNodePos(i).getInformation().getClass().equals(Car.class))
                toOrder.add((Car)simple.getNodePos(i).getInformation());
            }
        return toOrder;
    }
    private SimpleList<Book> filterByBook(){
        SimpleList<Book> toOrder = new SimpleList<>();
        for (int i = 1; i <= simple.getSize(); i++) {
            if(simple.getNodePos(i).getInformation().getClass().equals(Book.class))
                toOrder.add((Book) simple.getNodePos(i).getInformation());
        }
        return toOrder;
    }
    private SimpleList<Enterprise> filterByEnterprise(){
        SimpleList<Enterprise> toOrder = new SimpleList<>();
        for (int i = 1; i <= simple.getSize(); i++) {
            if(simple.getNodePos(i).getInformation().getClass().equals(Enterprise.class))
                toOrder.add((Enterprise) simple.getNodePos(i).getInformation());
        }
        return toOrder;
    }

    private SimpleList<String> getDataList(){
        SimpleList<String> data = new SimpleList<>();
        data.add("Cantidad personas: "+filterByPerson().getSize());
        data.add("Cantidad vehiculos: "+filterByCar().getSize());
        data.add("Cantidad empresas: "+filterByEnterprise().getSize()+"");
        data.add("Capital: "+"$"+ NumberFormat.getInstance().format(enterpriseCapital(filterByEnterprise())));
        return data;
    }
    private long enterpriseCapital(SimpleList<Enterprise> entList){
        long capital=0;
        for (int i = 1; i <= entList.getSize(); i++) {
            capital+=entList.getNodePos(i).getInformation().getCapital();
        }return capital;
    }

    public void clasificate() throws IOException{
            excelReader.writeCars(simple.sortCars(filterByCar()));
            excelReader.writePersons(simple.sortPerson(filterByPerson()));
            // excelReader.writeBooks(filterByBook());
            excelReader.writeSumary(getDataList());
            System.out.println("\t"+"Done :D"+"\n");
    }

    //Main
    public static void main(String[] args) {
        Control control;
        try {
            control = new Control();
            control.clasificate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
