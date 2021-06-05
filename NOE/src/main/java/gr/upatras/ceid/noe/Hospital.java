package gr.upatras.ceid.noe;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Hospital {
    private String name;
    private String address;
    private ArrayList<Employee> employees;
    private ArrayList<String> departments;
    private Manager manager;
    private BoardOfDirectors bod;
    private int availableRooms;
    private int availableBeds;
    private HashMap<Integer, Date> deaths;
    private HashMap<String, Integer> expenses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<String> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<String> departments) {
        this.departments = departments;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public BoardOfDirectors getBod() {
        return bod;
    }

    public void setBod(BoardOfDirectors bod) {
        this.bod = bod;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public HashMap<Integer, Date> getDeaths() {
        return deaths;
    }

    public void setDeaths(HashMap<Integer, Date> deaths) {
        this.deaths = deaths;
    }

    public HashMap<String, Integer> getExpenses() {
        return expenses;
    }

    public void setExpenses(HashMap<String, Integer> expenses) {
        this.expenses = expenses;
    }
}
