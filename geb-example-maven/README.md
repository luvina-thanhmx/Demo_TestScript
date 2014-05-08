This is a simple example project for using Geb with Maven.  

Change url is path to file "login.html" at line code "go("file:///path/to/login.html")"  

Just check it out and run…  
    mvn test  

Please see the `src/test/resources/GebConfig.groovy` file for how to run the tests with different browsers.  
Note: if run projects have error ass "failed to create driver from callback ..."  
  => Fix: change value of seleniumVersion from default to number as "2.40.0" (maybe corresponding with other version)
