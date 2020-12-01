package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "Gosho"),
            new Person(2, "Pesho"),
            new Person(3, "Mariya")};

    @Before
    public void createDatabaseObject() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorShouldConstructCorrectObject() {
        Assert.assertEquals(3, database.getElements().length);

        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i], PEOPLE[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPeopleCountShouldNotBeMoreThan16()
            throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPeopleCountShouldBeMoreThanZero()
            throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementShouldThrowEx() throws OperationNotSupportedException {
        database.add(null);
    }

    /*@Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWhenTryAddPersonWithNullId()
            throws OperationNotSupportedException {
        database.add(new Person(0, "Emo"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWhenTryAddPersonWithNegativeId()
            throws OperationNotSupportedException {
        database.add(new Person(-1, "Emil"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWhenTryAddPersonWithSameId()
            throws OperationNotSupportedException {
        database.add(new Person(1, "Mariika"));
    }
     */

    @Test
    public void testAddShouldAddCorrectPerson() throws OperationNotSupportedException {
        database.add(new Person(4, "Ivan"));
        Person[] people = database.getElements();
        Assert.assertEquals(4, people.length);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1],
                people[people.length - 1]);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Person[] people = database.getElements();
        Assert.assertEquals(2, database.getElements().length);
        Assert.assertEquals(2, people[people.length - 1].getId());
        Assert.assertEquals("Pesho", people[people.length - 1].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWhenIndexIsOutOfBounds()
            throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowExWhenPersonWithThisIdIsNotPresent()
            throws OperationNotSupportedException {
        database.findById(10);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowExIfSizeIsNotEqualsToOne()
            throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }

    @Test
    public void testFindByIdShouldReturnPersonWithThisId()
            throws OperationNotSupportedException {
        Person person = database.findById(1);
        Assert.assertEquals(person, database.getElements()[0]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowExWhenThereIsNoUserWithThatUsername()
            throws OperationNotSupportedException {
        database.findByUsername("Velin");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowExWhenUsernameIsNull()
            throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowExIfSizeIsNotEqualsToOne()
            throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("Pesho");
    }

    @Test
    public void testFindByUsernameShouldReturnPersonWithThisUsername()
            throws OperationNotSupportedException {
        Person person = database.findByUsername("Gosho");
        Assert.assertEquals(person, database.getElements()[0]);
    }
}
