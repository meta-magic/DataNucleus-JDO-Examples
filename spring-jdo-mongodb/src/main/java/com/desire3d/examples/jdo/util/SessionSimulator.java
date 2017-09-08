/**
* 
*/
package com.desire3d.examples.jdo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author mahesh
 *
 */
public abstract class SessionSimulator {

	private static final List<String> customers = new ArrayList<>(Arrays.asList("Customer1", "Customer2","Customer3", "Customer4", "Customer5" ));

	public static String getLoggedInCustomer() {
		return customers.get(new Random().nextInt(customers.size()));
	}
}