clear
mysql -u root --protocol=tcp -pexamly < src/main/resources/setup.db
mvn clean install -DskipTests
mvn tomcat7:run