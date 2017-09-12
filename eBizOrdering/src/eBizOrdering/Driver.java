package eBizOrdering;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class Driver {

	@Test
	
	public static void testDriver() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		TesteBiz.initilize();
        TesteBiz.login();
        TesteBiz.managePage();
        TesteBiz.addNewLocation();
        TesteBiz.serviceLocationDetails1();
        TesteBiz.serviceLocationDetails2();
        TesteBiz.serviceLocationDetails3();
        TesteBiz.localContact();
        TesteBiz.additionalContact();
        TesteBiz.billingContact();
        TesteBiz.technicalContact();
        TesteBiz.configureAccessPPP();
        TesteBiz.configurePortPPP();
	}

}
