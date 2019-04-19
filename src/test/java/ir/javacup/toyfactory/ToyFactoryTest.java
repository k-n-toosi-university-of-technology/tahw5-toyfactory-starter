package ir.javacup.toyfactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//60point
public class ToyFactoryTest {

    static boolean canTest = true;

    @BeforeClass
    public static void testStyles() {
        boolean testPMDInternal = CheckPMDTest.testPMDInternal();
        boolean testCheckStyleInternal = CheckStyleTest.testCheckStyleInternal();
        canTest = testCheckStyleInternal && testPMDInternal;
    }

    Toy toy;
    Car car;

    @Before
    public void onceBeforEachTest() {

        toy = new Toy(20000, ToySize.SMALL);
        car = new Car(20000, ToySize.SMALL);
    }

    @Test
    public void testCarGetPrice() {
        Assert.assertTrue(canTest);
        assertEquals(40000, car.getPrice(), 1e-15);
        car.size = ToySize.MEDIUM;
        assertEquals(50000, car.getPrice(), 1e-15);
        car.size = ToySize.LARGE;
        assertEquals(60000, car.getPrice(), 1e-15);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testCarGetPriceWithDiscount() {
        Assert.assertTrue(canTest);
        double price = car.getPrice(20);
        assertEquals(20000, car.getBasePrice(), 1e-15);
        assertEquals(32000, price, 1e-15);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testToyGetPrice() {
        Assert.assertTrue(canTest);
        assertEquals(20000, toy.getPrice(), 1e-15);
        toy.size = ToySize.MEDIUM;
        assertEquals(30000, toy.getPrice(), 1e-15);
        toy.size = ToySize.LARGE;
        assertEquals(40000, toy.getPrice(), 1e-15);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testNumberOfToyConstructors() {
        Assert.assertTrue(canTest);
        Constructor[] constructors = Toy.class.getConstructors();
        assertEquals(1, constructors.length);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testNumberOfCarContructors() {
        Assert.assertTrue(canTest);
        Constructor[] constructors = Car.class.getConstructors();
        assertEquals(1, constructors.length);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testNumberOfToyMethods() {
        Assert.assertTrue(canTest);
        Method[] methods = Toy.class.getDeclaredMethods();
        int i = countDeclaredMethods(methods);
        assertEquals(3, i);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    private int countDeclaredMethods(Method[] methods) {
        Assert.assertTrue(canTest);
        int i = 0;
        for (Method m : methods) {
            if (!m.getName().startsWith("$SWITCH_TABLE$")) {
                i++;
            }
        }
        return i;
    }

    @Test
    public void testNumberOfToyFields() {
        Assert.assertTrue(canTest);
        Field[] fields = Toy.class.getDeclaredFields();
        int i = countDeclaredFields(fields);
        assertEquals(2, i);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    private int countDeclaredFields(Field[] fields) {
        Assert.assertTrue(canTest);
        int i = 0;
        for (Field f : fields) {
            if (!f.getName().startsWith("$SWITCH_TABLE$")) {
                i++;
            }
        }
        return i;
    }

    @Test
    public void testNumberOfCarFields() {
        Assert.assertTrue(canTest);
        Field[] fields = Car.class.getDeclaredFields();
        int i = countDeclaredFields(fields);
        assertEquals(0, i);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testNumberOfCarMethods() {
        Assert.assertTrue(canTest);
        Method[] methods = Car.class.getDeclaredMethods();
        int i = countDeclaredMethods(methods);
        assertEquals(1, i);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testFieldsModifier() {
        Assert.assertTrue(canTest);
        Field[] fields = Toy.class.getDeclaredFields();
        assertTrue(Modifier.isPrivate(fields[0].getModifiers()));
        assertTrue(Modifier.isProtected(fields[1].getModifiers()));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testToyMethodsModifier() {
        Assert.assertTrue(canTest);
        Method[] methods = Toy.class.getDeclaredMethods();
        for (Method m : methods) {
            if (!m.getName().startsWith("$SWITCH_TABLE$")) {
                assertTrue(Modifier.isPublic(m.getModifiers()));
            }
        }
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

    @Test
    public void testCarMethodsModifier() {
        Assert.assertTrue(canTest);
        Method[] methods = Car.class.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getName().startsWith("$SWITCH_TABLE$")) {
                assertTrue(Modifier.isPublic(method.getModifiers()));
            }
        }
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:5 , reason:\"Passed.\" } | $$$GRADER$$$");
    }

}
