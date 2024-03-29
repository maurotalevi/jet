package org.codehaus.jet.regression.estimators;

import org.junit.jupiter.api.Test;

import static java.lang.Math.E;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 * @author Mauro Talevi
 */
public class HannanQuinnInformationCriterionEstimatorTest extends AbstractInformationCriterionEstimatorTest {

    @Test
    public void canCalculateIC(){
        assertEquals(0, estimator.calculateIC(0, 100, 1.0), 1e-6);
        assertEquals(1.0305435925161581, estimator.calculateIC(1, 100, E), 1e-6);
    }
    
    protected AbstractInformationCriterionEstimator createInformationCriterionEstimator() {
        return new HannanQuinnInformationCriterionEstimator();
    }

}
