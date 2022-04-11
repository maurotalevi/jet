package org.codehaus.jet.hypothesis.rejection.evaluators;

import org.codehaus.jet.hypothesis.rejection.ResponseSurfaceEvaluator;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 
 * @author Mauro Talevi
 */
public abstract class AbstractResponseSurfaceEvaluatorTest {
    
    private ResponseSurfaceEvaluator evaluator;
    
    @BeforeEach
    public void setUp() throws Exception {
        evaluator = createResponseSurfaceEvaluator();
    }

    protected abstract ResponseSurfaceEvaluator createResponseSurfaceEvaluator();

    protected void assertSurface(double expected, double[] beta, int T, int[] params) {
        assertEquals(expected, evaluator.evaluate(beta, T, params), 1e-6);
    }

    protected void assertInvalidParams(String message, double[] beta, int T, int[] params) {
        try {
            evaluator.evaluate(beta, T, params);        
            fail("Expected IAE");
        } catch ( IllegalArgumentException e ){
            assertEquals(message, e.getMessage());
        }
    }

}

