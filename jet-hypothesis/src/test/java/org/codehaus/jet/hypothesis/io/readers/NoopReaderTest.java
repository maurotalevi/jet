package org.codehaus.jet.hypothesis.io.readers;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class NoopReaderTest {

    private NoopReader reader = new NoopReader();

    @Test
    public void canGetNonContextClassLaader() throws Exception {
        Thread.currentThread().setContextClassLoader(null);
        assertEquals(AbstractReader.class.getClassLoader(), reader.getClassLoader());
    }

    @Test
    public void canHandleNotFindingResource() throws Exception {
        try {
            reader.getReader("/non/existent/resource", reader.getClassLoader());
            fail("NoSuchElementException expected");
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    static class NoopReader extends AbstractReader {

    }
}
