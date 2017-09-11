# DataNucleus-JDO-Examples
DataNucleus JDO Examples 

Procedure to run application
1. mvn clean compile
2. mvn -e datanucleus:enhance
3. mvn spring-boot:run

Test Rest Calls 
1. Add Product - 
curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/Product/save -d '{ "category" : "Electronics", "name" : "TV", "description" : "LG LED Smart TV", "price" : 41000 }'

2. See Products - 
curl http://localhost:8080/Product/findAll
curl http://localhost:8080/Product/findById/1

3. Add Product to Shopping Cart 
curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/ShoppingCart/save -d '{"customerId":"Customer1","items":[{"productId":1,"quantity":1},{"productId":2,"quantity":2}]}'

4. See Shopping Cart
curl http://localhost:8080/ShoppingCart/findAll
curl http://localhost:8080/ShoppingCart/findById/e4b0e87f-7678-490b-838c-cc64bca3c2c8
