package org.codehaus.jet.hypothesis.io.readers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 
 * @author Mauro Talevi
 */
public class DefaultReaderProviderTest {

    @Test
    public void canHandleReaderNotFound(){
        DefaultReaderProvider provider = new DefaultReaderProvider();
        String name = "non-existent";
        try {
            provider.getBetaReader(name);
            fail("IllegalArgumentException expected");
        } catch ( IllegalArgumentException e) {
            assertEquals("Reader not found for test name "+name, e.getMessage());
        }
    }
    
}
