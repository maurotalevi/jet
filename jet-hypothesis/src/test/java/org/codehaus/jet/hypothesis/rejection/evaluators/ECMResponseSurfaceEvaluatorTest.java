package org.codehaus.jet.hypothesis.rejection.evaluators;

import org.codehaus.jet.hypothesis.rejection.ResponseSurfaceEvaluator;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Mauro Talevi
 */
public class ECMResponseSurfaceEvaluatorTest extends AbstractResponseSurfaceEvaluatorTest {
    
    @Test
    public void testCanEvaluateSurface(){
        assertSurface(1.0, new double[]{1.0, 0.9, 0.8, 0.7}, 0, new int[]{2, 3, 4});
        assertSurface(1.0183200, new double[]{1.0, 0.9, 0.8, 0.7}, 50, new int[]{2, 3, 4});
        assertSurface(1.0183256, new double[]{1.0, 0.9, 0.8, 0.7}, 50, new int[]{3, 3, 4});
        assertSurface(1.0195111, new double[]{1.0, 0.9, 0.8, 0.7}, 50, new int[]{4, 3, 4});
        assertSurface(1.0195178, new double[]{1.0, 0.9, 0.8, 0.7}, 50, new int[]{5, 3, 4});
        assertSurface(1.0218821, new double[]{1.0, 0.9, 0.8, 0.7}, 50, new int[]{6, 3, 4});
        assertSurface(1.0218915, new double[]{1.0, 0.9, 0.8, 0.7}, 50, new int[]{7, 3, 4});
    }

    @Test
    public void testCanValidateParameters(){
        assertInvalidParams("beta must be have at least 3 coefficients", 
                new double[]{1.0, 0.9}, 0, new int[]{2, 3, 4});
        assertInvalidParams("sample size must be a non-negative integer", 
                new double[]{1.0, 0.9, 0.8, 0.7}, -1, new int[]{2, 3, 4});
        assertInvalidParams("params must contain at least 3 parameters", 
                new double[]{1.0, 0.9, 0.8, 0.7}, 100, new int[]{2, 3});
        assertInvalidParams("first parameter must be an integer between 2 and 7", 
                new double[]{1.0, 0.9, 0.8, 0.7}, 100, new int[]{1, 3, 4});
    }    
        

    @Override
    protected ResponseSurfaceEvaluator createResponseSurfaceEvaluator() {
        return new ECMResponseSurfaceEvaluator();
    }    

}
