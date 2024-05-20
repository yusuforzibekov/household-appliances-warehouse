package edu.itpu.fopjava_course_work;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.itpu.fopjava_course_work.dao.OvenDAO;
import edu.itpu.fopjava_course_work.dao.implementation.OvenDAOImpl;
import edu.itpu.fopjava_course_work.entity.Oven;
import java.util.List;
import java.io.IOException;

public class OvenDAOTest {
    @Test
    void shouldFindAll() {
        // arrange
        OvenDAO dao = new OvenDAOImpl(); // Using the actual implementation
        Oven[] expected = new Oven[] {
                new Oven(1, 1500, 32, 10, 59.5, 45.5, 60, 12000),
                new Oven(2, 1500, 33, 12, 68, 45, 60, 14500),
                new Oven(3, 2000, 33, 11, 70, 40, 60, 18000)
        };

        try {
            // action
            List<Oven> ovensList = dao.getOvensList();

            // assert
            assertNotNull(ovensList);
            Oven[] ovensArray = ovensList.toArray(new Oven[0]);
            assertArrayEquals(expected, ovensArray);
        } catch (IOException e) {
            fail("IOException occurred: %s".formatted(e.getMessage()));
        }
    }
}
