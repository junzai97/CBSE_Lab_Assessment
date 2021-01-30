# CBSE_Lab_Assessment

In this Assessment, a Virtual Coffee Shop program will be created and componentized using EJB, Spring and OSGi.


## EJB
### JDK version
The application must be able to function as intended in JDK 7

### Dev Environment Setup
#### Intellij
1. Go to `File > Project Structure` 
2. All subsequent actions are perfomed in the pop up appeared
3. go to `project` tab
    - configure `Project SDK` as 1.7
    - configure `Project Language level` as 7
    - configure `Project complier output` as `out` directory
4. go to `modules` tab
    - select the `src` folder, mark it as `Sources` (blue in color)
    - select the `out` folder, mark it as `Excluded` (orange in color)
5. go to `libraries` tab
    - click the `+` (add icon), then select `Java`
    - in the pop up, select `javax.ejb-api-3.2.jar` & `javax.transaction-api-1.2.jar` in `lib` folder

