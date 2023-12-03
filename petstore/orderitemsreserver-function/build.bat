call mvn clean package
call mvn azure-functions:package
call docker build -t orderitemsreserver-function .
call docker tag orderitemsreserver-function:latest greenteacr.azurecr.io/orderitemsreserver-function:latest
call docker push greenteacr.azurecr.io/orderitemsreserver-function:latest