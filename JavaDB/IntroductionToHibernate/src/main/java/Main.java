import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManager em = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();

        System.out.println("Please enter exercise number:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        switch (num) {
            case 2:
                changeCasing(em);
                break;
            case 3:
                containsEmployee(em, bufferedReader);
                break;
            case 4:
                employeesWithSalaryOver(em, bufferedReader);
                break;
            case 5:
                employeesFromDepartment(em);
                break;
            case 6:
                addingNewAddressAndUpdatingEmployee(em, bufferedReader);
                break;
            case 7:
                addressesWithEmployeeCount(em);
                break;
            case 8:
                getEmployeeWithProject(em, bufferedReader);
                break;
            case 9:
                findLatest10Projects(em);
                break;
            case 10:
                increaseSalaries(em);
                break;
            case 11:
                findEmployeesByFirstName(em, bufferedReader);
                break;
            case 12:
                employeesMaximumSalaries(em);
                break;
            case 13:
                removeTowns(em, bufferedReader);
                break;
        }
    }

    private static void removeTowns(EntityManager em, BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter town name:");
        String town = bufferedReader.readLine();

        Town t = em.createQuery("SELECT t FROM Town t WHERE t.name = :town", Town.class)
                .setParameter("town", town)
                .getSingleResult();

        em.getTransaction().begin();
        List<Address> addresses = em.createQuery("SELECT a FROM Address a WHERE a.town.id = :id", Address.class)
                        .setParameter("id", t.getId()).getResultList();
        addresses.forEach(em::remove);
        System.out.printf("%d address in %s deleted", addresses.size(), t.getName());
        em.getTransaction().commit();
    }

    private static void employeesMaximumSalaries(EntityManager em) {
        List<Object[]> rows = em.createNativeQuery("SELECT d.name, MAX(e.salary) AS `salary`" +
                " FROM soft_uni.departments d JOIN soft_uni.employees e on d.department_id = e.department_id" +
                " GROUP BY d.name HAVING salary NOT BETWEEN 30000 AND 70000")
                .getResultList();
        rows.forEach(o -> System.out.printf("%s %.2f\n", o[0], o[1]));
    }

    private static void findEmployeesByFirstName(EntityManager em, BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter first letters of the first name:");
        String part = bufferedReader.readLine();

        em.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :part", Employee.class)
                .setParameter("part", part + "%")
                .getResultList().forEach(e -> System.out.printf("%s %s - %s - ($%.2f)\n",
                        e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
    }

    private static void increaseSalaries(EntityManager em) {
        em.getTransaction().begin();
        em.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.2 WHERE e.department.id IN (1, 2, 4, 11)")
                                .executeUpdate();
        em.createQuery("SELECT e FROM Employee e WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                                .getResultList().forEach(e -> System.out.printf("%s %s ($%.2f)\n", e.getFirstName(), e.getLastName(), e.getSalary()));
        em.getTransaction().commit();
    }

    private static void findLatest10Projects(EntityManager em) {
        em.createQuery("SELECT p FROM Project p WHERE p.endDate IS NULL ORDER BY p.name", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(project -> System.out.printf("Project name: %s\n" +
                        " \tProject Description: %s\n" +
                        " \tProject Start Date:%s\n" +
                        " \tProject End Date: %s\n",
                        project.getName(), project.getDescription(), project.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.S")), project.getEndDate()));
    }

    private static void getEmployeeWithProject(EntityManager em, BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter employee id:");
        int id = Integer.parseInt(bufferedReader.readLine());

        List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class)
                .setParameter("id", id)
                .getResultList();
        employees.forEach(employee -> {
            System.out.printf("%s %s - %s\n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
            employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(pr ->System.out.printf("\t%s\n", pr.getName()));
        });
    }

    private static void addressesWithEmployeeCount(EntityManager em) {
        em.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .getResultList()
                .stream().limit(10).forEach(address -> System.out.printf("%s, %s - %d employees\n",
                        address.getText(), address.getTown() == null ? "Unknown" : address.getTown().getName(), address.getEmployees().size()));
    }

    private static void addingNewAddressAndUpdatingEmployee(EntityManager em, BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter employee last name:");
        String lastName = bufferedReader.readLine();

        Address address = new Address();
        address.setText("Vitoshka 15");

        em.getTransaction().begin();
        em.persist(address);
        em.createQuery("UPDATE Employee e SET e.address = :addr WHERE e.lastName = :l_name")
                .setParameter("addr", address)
                .setParameter("l_name", lastName)
                .executeUpdate();
        em.getTransaction().commit();
    }

    private static void employeesFromDepartment(EntityManager em) {
        em.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = 'Research and Development'" +
                        "ORDER BY e.salary ASC, e.id ASC", Employee.class)
                .getResultList().forEach(employee -> System.out.printf("%s %s from Research and Development - $%.2f\n",
                        employee.getFirstName(), employee.getLastName(), employee.getSalary()));
    }

    private static void employeesWithSalaryOver(EntityManager em, BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter employee salary to search for:");
        int salary = Integer.parseInt(bufferedReader.readLine());

        em.createQuery("SELECT e.firstName FROM Employee e " +
                        "WHERE e.salary > :salary", String.class)
                .setParameter("salary", BigDecimal.valueOf(salary))
                .getResultList().forEach(System.out::println);
    }

    private static void containsEmployee(EntityManager em, BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter employee full name:");
        String fullName = bufferedReader.readLine();
        String firstName = fullName.split("\\s+")[0];
        String lastName = fullName.split("\\s+")[1];

        Long employees = em
                .createQuery("SELECT count(e) FROM Employee e " +
                        "WHERE e.firstName = :f_name AND e.lastName = :l_name", Long.class)
                        .setParameter("f_name", firstName)
                        .setParameter("l_name", lastName)
                        .getSingleResult();

        em.getTransaction().begin();
        System.out.println(employees != 0 ? "Yes" : "No");
        em.getTransaction().commit();
    }

    private static void changeCasing(EntityManager em) {
        Query query = em.createQuery("UPDATE Town t SET t.name = UPPER(t.name) WHERE length(t.name) <= 5");
        em.getTransaction().begin();
        int executeUpdate = query.executeUpdate();
        System.out.printf("Updated: %d", executeUpdate);
        em.getTransaction().commit();
    }
}
