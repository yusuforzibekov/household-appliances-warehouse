package edu.itpu.fopjava_course_work;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.itpu.fopjava_course_work.dao.RefrigeratorDAO;
import edu.itpu.fopjava_course_work.dao.implementation.RefrigeratorDAOImpl;
import edu.itpu.fopjava_course_work.entity.Refrigerator;
import java.util.List;
import java.io.IOException;

public class RefrigeratorDAOTest {
    @Test
    void shouldFindAll() {
        // arrange
        RefrigeratorDAO dao = new RefrigeratorDAOImpl(); // Using the actual implementation
        Refrigerator[] expected = new Refrigerator[] {
                new Refrigerator(1, 4000, 15, 300, 85, 80, 180, 80, 15000),
                new Refrigerator(2, 6000, 50, 500, 110, 120, 190, 90, 35000)
        };

        try {
            // action
            List<Refrigerator> refrigeratorsList = dao.getRefrigeratorsList();

            // assert
            assertNotNull(refrigeratorsList);
            Refrigerator[] refrigeratorsArray = refrigeratorsList.toArray(new Refrigerator[0]);
            assertArrayEquals(expected, refrigeratorsArray);
        } catch (IOException e) {
            fail("IOException occurred: %s".formatted(e.getMessage()));
        }
    }
}