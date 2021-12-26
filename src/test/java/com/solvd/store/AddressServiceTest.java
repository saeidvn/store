package com.solvd.store;

import com.solvd.store.domain.Address;
import com.solvd.store.service.AddressService;
import com.solvd.store.service.impl.AddressServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AddressServiceTest {

    private final AddressServiceImpl addressService;
    private final Address address;

    public AddressServiceTest() {
        this.addressService = new AddressServiceImpl();
        this.address = new Address();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute before the suite.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This will execute before the test.");
    }

    @BeforeClass
    public void createAddressTest() {
        address.setCountry("Belarus");
        address.setCity("Minsk");
        address.setStreet("Zhukovskogo");
        address.setEntrance("4");
        System.out.println("This will execute before the class.");
    }

    @Test
    public void testCreateAddress() {
        addressService.create(address);
        Address testCreateAddress = addressService.get(address.getCountry());
        Assert.assertNotNull(testCreateAddress, "Address not created.");
    }

    @Test
    public void testUpdateAddress() {
        Address address1 = new Address();
        address1.setCountry("Belarus");
        address1.setCity("Brest");
        address1.setStreet("Main");
        address1.setEntrance("1");
        addressService.update(address1);
        Address addressUpdate = addressService.get("Belarus");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addressUpdate.getCountry(), "Belarus");
    }

    @DataProvider(name = "createAddressDataProvider")
    public Object[][] fillAddressFields() {
        Address address2 = new Address();
        address2.setCountry("Belarus");
        address2.setCity("Grodno");
        address2.setStreet("Main");
        address2.setEntrance("2");
        Address address3 = new Address();
        address3.setCountry("Belarus");
        address3.setCity("Minsk");
        address3.setStreet("Main");
        address3.setEntrance("3");
        Address address4 = new Address();
        address4.setCountry("Belarus");
        address4.setCity("Minsk");
        address4.setStreet("Main");
        address4.setEntrance("4");
        Address address5 = new Address();
        address5.setCountry("Belarus");
        address5.setCity("Brest");
        address5.setStreet("Main");
        address5.setEntrance("5");
        return new Object[][]{{address2}, {address3}, {address4}, {address5}};
    }

    @Test(dataProvider = "createAddressDataProvider")
    public void testAddressCreateDataProvider(Address dataProviderAddress) {
        Address testAddress = addressService.create(dataProviderAddress);
        Long testId = testAddress.getId();
        Assert.assertNotNull(testId, "Address wasn't created");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This will execute after the class.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This will execute after the test.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This will execute after the suite.");
    }
}
