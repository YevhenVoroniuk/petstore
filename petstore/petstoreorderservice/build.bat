call az acr login --name greenteacr
call docker build -t petstoreorderservice .
call docker tag petstoreorderservice:latest greenteacr.azurecr.io/petstoreorderservice:latest
call docker push greenteacr.azurecr.io/petstoreorderservice:latest