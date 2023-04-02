package assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(2, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isThisFour() {
        Box box = new Box(4, 10);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(4);
    }

    @Test
    void whenNumOfVertIsZero() {
        Box box = new Box(0, 10);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isZero();
    }

    @Test
    void whenObjExist() {
        Box box = new Box(0, 10);
        boolean rsl = box.isExist();
        assertThat(rsl).isTrue();
    }

    @Test
    void whenObjIsNotExist() {
        Box box = new Box(10, 2);
        boolean rsl = box.isExist();
        assertThat(rsl).isFalse();
    }

    @Test
    void whenAreaIsCube() {
        Box box = new Box(8, 2);
        double rsl = box.getArea();
        assertThat(rsl).isEqualTo(24d);
    }

    @Test
    void whenAreaIsZero() {
        Box box = new Box(0, 0);
        double rsl = box.getArea();
        assertThat(rsl).isZero();
    }

}