package kvbdev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.*;

class RandomsTest {

    Randoms sut;
    int min = 10;
    int max = 20;

    @BeforeEach
    void setUp() {
        sut = new Randoms(min, max);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    void iterator_returns_iterator() {
        assertThat(sut.iterator(), isA(Iterator.class));
    }

    @Test
    void iterator_is_infinite() {
        int count = 10_000;
        Iterator<Integer> iter = sut.iterator();

        for (int i = 0; i< count; i++) {
            if (!iter.hasNext()) throw new IllegalStateException("Iterator is not infinite");
        }
    }

    @Test
    void iterator_generate_min_value() {
        int count = 10_000;
        Iterator<Integer> iter = sut.iterator();

        for (int i = 0; i< count; i++) {
            if (iter.next()==min) return;
        }
        throw new IllegalStateException("iterator doesn't generate min value");
    }

    @Test
    void iterator_generate_max_value() {
        int count = 10_000;
        Iterator<Integer> iter = sut.iterator();

        for (int i = 0; i< count; i++) {
            if (iter.next()==max) return;
        }
        throw new IllegalStateException("iterator doesn't generate maxn value");
    }


}