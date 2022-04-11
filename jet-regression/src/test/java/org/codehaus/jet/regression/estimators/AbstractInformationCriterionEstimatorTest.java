package org.codehaus.jet.regression.estimators;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 
 * @author Mauro Talevi
 */
public abstract class AbstractInformationCriterionEstimatorTest {

    protected AbstractInformationCriterionEstimator estimator;
    protected double[] y;
    protected int T = 20;
    protected int p = 5;
    
    @BeforeEach
    public void setUp(){
        estimator = createInformationCriterionEstimator();
        y = new double[T];
        Random random = new Random();
        for (int i = 0; i < T; i++) {
            y[i] = 1.0 + random.nextDouble()*T;
        }
        estimator.addData(y);
    }

    protected abstract AbstractInformationCriterionEstimator createInformationCriterionEstimator();

    @Test
    public void canEstimateIC(){
        double ic = estimator.estimateIC(p);
        assertTrue(ic != 0.0d);
    }

    @Test
    public void canMinimiseIC(){
        int min = estimator.minimiseIC(p-2,p+3);
        assertTrue( p-2 <= min && min <= p + 3);
    }
    
}
