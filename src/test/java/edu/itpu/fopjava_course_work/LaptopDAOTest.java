package edu.itpu.fopjava_course_work;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.itpu.fopjava_course_work.dao.LaptopDAO;
import edu.itpu.fopjava_course_work.dao.implementation.LaptopDAOImpl;
import edu.itpu.fopjava_course_work.entity.Laptop;
import java.util.List;
import java.io.IOException;

public class LaptopDAOTest {
    @Test
    void shouldFindAll() {
        // arrange
        LaptopDAO dao = new LaptopDAOImpl(); // Using the actual implementation
        Laptop[] expected = new Laptop[] {
                new Laptop(1, 1, "Windows", 4000, 1000, 1.2, 18, 3, 15, 2, 12, 10000),
                new Laptop(2, 1.5, "Linux", 8000, 1000, 2.2, 19, 3, 15, 2, 12, 20000),
                new Laptop(3, 3, "Windows", 8000, 1500, 3.2, 22, 3, 15, 2, 12, 30000)
        };

        try {
            // action
            List<Laptop> laptopsList = dao.getLaptopList();

            // assert
            assertNotNull(laptopsList);
            Laptop[] laptopsArray = laptopsList.toArray(new Laptop[0]);
            assertArrayEquals(expected, laptopsArray);
        } catch (IOException e) {
            fail("IOException occurred: %s".formatted(e.getMessage()));
        }
    }
}
