package user;

import static org.assertj.core.api.Assertions.*;

import baseball.User;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class UserTest {

    private final User user = new User();

    @Test
    void 입력된_값은_세자리이어야_합니다() {
        String testInput = "1234";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(user::receiveThreeNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값은_숫자이어야_합니다() {
        String testInput = "1a3";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(user::receiveThreeNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값은_서로_다른_숫자이어야_합니다() {
        String testInput = "122";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(user::receiveThreeNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}