/*
 * Author Ato Kwamena
 * Date: 31st May, 2022
 * */

package losartan.pharmacyProject.Repository;

import losartan.pharmacyProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
