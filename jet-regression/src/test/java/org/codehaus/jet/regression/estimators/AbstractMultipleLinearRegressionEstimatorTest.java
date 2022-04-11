package org.codehaus.jet.regression.estimators;

import org.codehaus.jet.regression.MultipleLinearRegressionEstimator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 
 * @author Mauro Talevi
 */
public abstract class AbstractMultipleLinearRegressionEstimatorTest {

    private MultipleLinearRegressionEstimator regression;

    @BeforeEach
    public void setUp(){
        regression = createRegressionEstimator();
    }

    protected abstract MultipleLinearRegressionEstimator createRegressionEstimator();
    
    protected abstract int getNumberOfRegressors();
    
    protected abstract int getSampleSize();

    @Test
    public void canEstimateRegressionParameters(){
        double[] beta = regression.estimateRegressionParameters();        
        assertEquals(getNumberOfRegressors(), beta.length);
    }

    @Test
    public void canEstimateResiduals(){
        double[] e = regression.estimateResiduals();
        assertEquals(getSampleSize(), e.length);
    }
    
    @Test
    public void canEstimateRegressionParametersVariance(){
        double[][] variance = regression.estimateRegressionParametersVariance();
        assertEquals(getNumberOfRegressors(), variance.length);
    }

    @Test
    public void canEstimateRegressandVariance(){
        double variance = regression.estimateRegressandVariance();
        assertTrue(variance > 0.0);
    }   

}
