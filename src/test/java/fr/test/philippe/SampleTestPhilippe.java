/**
 * 
 */
package fr.test.philippe;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * 
 */
public class SampleTestPhilippe {
	  @Test
	    public void testFailure() {
	        fail("Ce test échoue systématiquement");
	    }

	    @Test
	    public void testSuccess() {
	        assertTrue(true);
	    }

}
