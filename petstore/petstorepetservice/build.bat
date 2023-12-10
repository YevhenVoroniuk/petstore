call az acr login --name greenteacr
call docker build -t petstorepetservice .
call docker tag petstorepetservice:latest greenteacr.azurecr.io/petstorepetservice:latest
call docker push greenteacr.azurecr.io/petstorepetservice:latest