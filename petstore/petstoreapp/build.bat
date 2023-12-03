call az acr login --name greenteacr
call docker build -t petstoreapp .
call docker tag petstoreapp:latest greenteacr.azurecr.io/petstoreapp:latest
call docker push greenteacr.azurecr.io/petstoreapp:latest