Simple Test Automation Framework for SauceDemo.com
<a href="https://www.saucedemo.com/">
    <img src="https://res.cloudinary.com/duauoz75o/image/upload/c_scale,w_135/v1620137689/Login_Bot_graphic.20658452_vymtmk.png" align="right" height="80" />
</a>

# Checklist for Saucedemo

---------------------

### **Log In**
- Field UserName
- Field Password
### **Products Page**
- Button ADD TO CART
- Sorting Dropdown
- Button CART
- Left top BURGER BUTTON
- Product Page
### **Product Page**
- Button ADD TO CART
- Button BACK TO PRODUCTS
### **Cart Page**
- Button REMOVE
- Button CONTINUE SHOPPING
- Button CHECKOUT
### **Checkout Page 1**
- Field First Name
- Field Last Name
- Field Zip/Postal Code
- Button CANCEL
- Button CONTINUE
### **Checkout Page 2**
- Button CANCEL
- Button FINISH
- Item and quantity count
### **Checkout Page 3**
- Button BACK HOME

### *Build requirements:*
+ Java 8
+ Maven 3
+ Chrome browser

### *Used Technologies:*
+ Selenium
+ Maven
+ TestNG

### *Test info:*
 - Dependencies version [  mvn versions:display-dependency-updates ] 
 - Update all dependencies [ mvn versions:use-latest-versions ]
 - Run only one test suite [ mvn clean test -Dtest=BurgerMenuTest ]
 - Run only one test case [ mvn clean test -Dtest=ProductsTest#productShouldBeAddedIntoCartFromProductsPage ]
 - To set default XML file for tests  [ mvn clean test -DsuiteXmlFile=src/test/resources/name.xml ]
 - Run default test XML [ mvn clean test ]
 - Test results [ target/surefire-reports/emailable-report.html ]
