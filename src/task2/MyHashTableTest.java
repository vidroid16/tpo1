package task2;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@DisplayName("Tests for MyHashTable")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyHashTableTest extends Assertions {
    private MyHashTable table;
    @BeforeAll
    public void init(){
        System.out.println("Init");
        table = new MyHashTable();
    }
    @ParameterizedTest(name = "Test item can be added and finded")
    @CsvFileSource(resources = "../testunique.csv")
    void addAndFindTest(String item) {
       // table = new MyHashTable();
        table.add(item);

        String expected = item;
        String actual = table.find(item).getSecond();
        System.out.println("Item = "+ item);
        System.out.println("Expected = "+ expected);
        System.out.println("Actual = "+ actual);
        assertEquals(expected,actual);
//        table.delete(item);
//        actual = table.find(item).getSecond();
//        assertNull(actual);
    }
    @ParameterizedTest(name = "Test item can be deleted")
    @CsvFileSource(resources = "../testunique.csv")
    void deleteTest(String item) {
            table.delete(item);
            String actual = table.find(item).getSecond();
            assertNull(actual);
    }
    @Test
    @DisplayName("Test for collisions number on unique strings")
    void collisionTest() {
        table = new MyHashTable();
        int COLLISIONS_MAX = 3000;
        int totalStrings = 0;
        try (Scanner scanner = new Scanner(new File("src/testunique.csv"));) {
            while (scanner.hasNextLine()) {
                table.add(scanner.nextLine());
                totalStrings++;
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        int collisions = 0;
        //System.out.println(table.size());
        for (int i = 0; i < table.size(); i++) {
            //System.out.println(i);
            int count = 0;
            LinkedList<String> l = table.getValuesByKey(i);
            Iterator<String> it = l.iterator();
            while (it.hasNext()){
                count++;
                it.next();
            }
            if (count>1) collisions++;
        }
        System.out.println("Всего элементов: " + totalStrings);
        System.out.println("Коллизий: " + collisions);
        assertTrue(collisions<COLLISIONS_MAX);
    }

}