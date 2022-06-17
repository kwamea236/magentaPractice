/*
* Author Ato Kwamena
* Date: 31st May, 2022
* */


package losartan.pharmacyProject.controller;

import losartan.pharmacyProject.Repository.EmployeeRepository;
import losartan.pharmacyProject.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeRestApi {
    private EmployeeRepository employeeRepository;

    public EmployeeRestApi(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /*
     *   GET REQUEST
     * */
    @GetMapping
    Iterable<Employee> getAllEmployees() throws Exception {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Employee> getEmployeeById(@PathVariable Long id) throws Exception {
        return employeeRepository.findById(id);
    }

    /*
     * POST REQUEST
     * */

    @PostMapping
    Employee postEmployee(@RequestBody Employee employee) throws Exception {
        return employeeRepository.save(employee);
    }

    /*
     * Delete Request
     *
     * With delete request but no return value
     * */

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) throws Exception {
        employeeRepository.deleteById(id);
    }

    /*
     * PUT MAPPING
     * does data exist if it doesn't create a new one
     * */

    @PutMapping("/{id}")
    ResponseEntity<Employee> putEmployee(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        return (employeeRepository.existsById(id))?
                new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK) :
                new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

}
