package com.mx.edu.j2se.GarciaSantamaria.ImpDao;

import com.mx.edu.j2se.GarciaSantamaria.ApiDao.EmployeeDao;
import com.mx.edu.j2se.GarciaSantamaria.RowMappers.EmployeeMap;
import com.mx.edu.j2se.GarciaSantamaria.Objects.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmployee(int employeeId) {
        String sql = String.format("SELECT * FROM employee WHERE Id_employee = %d", employeeId);

        try{
            return jdbcTemplate.queryForObject(sql, new Object[] {}, new EmployeeMap());
        }catch(Exception e){
            logger.info("THERE ARE NO EXISTING EMPLOYEE FOR THE ID ENTERED, HANDLING EXCEPTION IN EmployeeDaoImpl(getEmployee)");
        }
        return null;
    }

    @Override
    public void save(Employee employeePOJO) {
        String sql = String.format("INSERT INTO employee (Name, Last_name, Mothers_last_name, Phone_Number, Email, Id_address) VALUES (%s, %s, %s, %f, %s, %d)",
                employeePOJO.getName(), employeePOJO.getLastName(), employeePOJO.getMothersLastName(),
                employeePOJO.getPhoneNumber(), employeePOJO.getEmail(), employeePOJO.getIdAddress());
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE SAVE OF EMPLOYEE, HANDLING EXCEPTION IN EmployeeDaoImpl(save)");
        }

    }

    @Override
    public void delete(int employeeId) {
        String sql = String.format("DELETE FROM employee WHERE Id_employee = %d", employeeId);
        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE DELETE OF EMPLOYEE, HANDLING EXCEPTION IN EmployeeDaoImpl(delete)");
        }
    }

    @Override
    public void update(Employee employeePOJO) {
        String sql = String.format("UPDATE employee SET Phone_number=%f, Email=%s, Id_address=%d WHERE Id_employee=%d",
                employeePOJO.getPhoneNumber(), employeePOJO.getEmail(), employeePOJO.getIdAddress(),
                employeePOJO.getIdEmployee());

        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            logger.info("THERE WAS AN ERROR DURING THE UPDATE OF EMPLOYEE, HANDLING EXCEPTION IN EmployeeDaoImpl(update)");
        }
    }
}
