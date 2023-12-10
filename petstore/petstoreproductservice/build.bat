call az acr login --name greenteacr
call docker build -t petstoreproductservice .
call docker tag petstoreproductservice:latest greenteacr.azurecr.io/petstoreproductservice:latest
call docker push greenteacr.azurecr.io/petstoreproductservice:latest