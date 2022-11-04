package computer;

import static org.assertj.core.api.Assertions.*;

import baseball.Computer;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    private static List<Integer> computerNumber;

    @BeforeAll
    public static void beforeAll() {
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumber();
    }


    @Test
    void 각_숫자는_1에서_9입니다() {
        for (Integer number : computerNumber) {
            boolean result = number >= 1 && number <= 9;
            assertThat(result).isEqualTo(true);
        }
    }

    @Test
    void 각_숫자는_서로_다른_숫자입니다() {
        Integer number1 = computerNumber.get(0);
        Integer number2 = computerNumber.get(1);
        Integer number3 = computerNumber.get(2);

        int count = 0;
        if (!number1.equals(number2)) {
            count++;
        }
        if (!number2.equals(number3)) {
            count++;
        }
        if (!number3.equals(number1)) {
            count++;
        }
        assertThat(count).isEqualTo(3);

    }

    @Test
    void 컴퓨터가_들고있는_숫자의_개수는_3개입니다() {
        boolean result = computerNumber.size() == 3;

        assertThat(result).isEqualTo(true);
    }


}
