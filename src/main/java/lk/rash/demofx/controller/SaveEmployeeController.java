package lk.rash.demofx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.rash.demofx.dto.EmployeeDto;
import lk.rash.demofx.service.EmployeeService;
import lk.rash.demofx.service.impl.EmployeeServiceImpl;

public class SaveEmployeeController {

    @FXML
    private TextField txtAdress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPosition;

    @FXML
    void delete(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());
        EmployeeService service = new EmployeeServiceImpl();
        boolean deleted = service.deleteEmployee(id);

        if (deleted) {
            System.out.println("Deleted Successfully!");
        } else {
            System.out.println("Delete Failed! Employee Not Found.");
            System.out.println("Done");
        }

    }

    @FXML
    void getall(ActionEvent event) {
        EmployeeService service = new EmployeeServiceImpl();
        service.getAllEmployees().forEach(emp -> {
            System.out.println(emp.getIdNo() + " | " + emp.getName() + " | " + emp.getAdress() + " | " + emp.getPosition());
        });

    }

    @FXML
    void save(ActionEvent event) {

//        System.out.println("01.Delete");
//        System.out.println("02.Update");
//        System.out.println("03.GetAll");
//        System.out.println("04.Search");
//        System.out.println("05.Saved");

        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String adress = txtAdress.getText();
        String position = txtPosition.getText();

        EmployeeService service = new EmployeeServiceImpl();
        boolean saved = service.saveEmployee(new EmployeeDto(id, name, adress, position));

        if (saved) {
            System.out.println("Saved Successfully!...");
        } else {
            System.out.println("Saved Faild!...");
        }

    }

    @FXML
    void search(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        EmployeeService service = new EmployeeServiceImpl();
        EmployeeDto emp = service.searchEmployee(id);

        if (emp != null) {
            txtName.setText(emp.getName());
            txtAdress.setText(emp.getAdress());
            txtPosition.setText(emp.getPosition());
            System.out.println("Employee Found: " + emp.getName());
        } else {
            System.out.println("Employee Not Found!");
        }

    }

    @FXML
    void update(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String adress = txtAdress.getText();
        String position = txtPosition.getText();

        EmployeeService service = new EmployeeServiceImpl();
        boolean updated = service.updateEmployee(new EmployeeDto(id, name, adress, position));

        if (updated) {
            System.out.println("Updated Successfully!");
        } else {
            System.out.println("Update Failed! Employee Not Found.");
        }

    }
}
