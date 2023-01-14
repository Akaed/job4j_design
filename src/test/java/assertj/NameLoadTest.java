package assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkNameLength() {
        NameLoad nameLoad = new NameLoad();
        String[] name = {};
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("array is empty");
    }

}