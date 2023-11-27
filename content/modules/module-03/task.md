# Module 3: App Services

## Task

In this and the upcoming modules, you'll work with the [PetStore](../../../README.md), a web application that consists of:

- **Web:** PetStoreApp
- **Public APIs:** PetService, ProductService, OrderService

The source code is available [here](../../../petstore).

**Please complete the following task:**

1. Deploy on Azure App Services using Docker deployment from Azure Container Registry:
   - Web (PetStoreApp) in two different regions
   - Public API Services (PetService, ProductService, and OrderService) in one region
2. Update the configuration of the Web (PetStoreApp) to point to the URLs of the respective Public APIs.
3. Configure the Public API Services (PetService, ProductService, OrderService) for auto-scaling based on CPU load increase.
4. Verify the scalability by testing with tools like k6 to generate a load on the Public APIs.
5. Set up deployment slots for the Web project (PetStoreApp).
6. Configure Traffic Manager to direct traffic to the two Web App Services.
7. (Optional) Utilize Azure CLI to automate resource deployment.

>**IMPORTANT:** Avoid using Kubernetes for this course, as it is not included in the curriculum and could potentially lead to unnecessary expenses.

**Useful links:**

- [Step-by-Step Guide](guides/step-by-step-guide/step-by-step-guide.md)
- [Testing Using k6 Tool](guides/using-k6/using-k6.md)

**Definition of Done:**

1. Web deployed in two separate regions using Docker deployment from Azure Container Registry.
2. Public API Services deployed in one region using Docker deployment from Azure Container Registry.
3. Web app configuration is updated to link correctly with Public API URLs.
4. Deployment slots for the Web project in one of the regions are created.
5. Public APIs are set up to scale automatically based on the CPU load increases.
6. Autoscaling is tested, potentially with k6 tool.
7. The Traffic Manager directs traffic between both Web App instances.
8. Users can access the application via the Traffic Manager URL.

<img src="images/scheme.png" width="450" style="margin: 20px 0; display: inline-block;"/>

<hr>

**Consider providing the following screenshots as evidence of your task execution:**

1. *Set Up Azure Resources*
   - Screenshot of the Azure portal displaying the creation of the resource group for the PetStoreApp.
   - Screenshot of the successful creation of the Azure Container Registry (ACR).
   - Screenshots documenting the Docker image build and push process to the ACR.

2. *Deploy Services to Azure App Services*
   - Screenshots of the Azure portal:
      - Creation of App Service Plans for PetStoreApp (Web) and Public API Services.
      - Deployment of PetStoreApp (Web) to two different regions.
      - Configuration of environment variables for services communication.
      - Successful navigation between pages without errors.

3. *Configure Auto-Scaling*
   - Screenshots of the Azure portal:
      - Configuration of rules-based autoscaling for public API services.
      - Setup of custom autoscale settings, including CPU usage thresholds.
      - Verification of autoscaling settings and rules.

4. *Test Autoscaling using k6 Tool*
   - Screenshots of the k6 tool in use for testing autoscaling.
   - Screenshots of Swagger endpoints utilized for testing autoscaling.

5. *Set Up Deployment Slots for PetStoreApp*
   - Screenshots of the Azure portal:
      - Creation of a deployment slot for PetStoreApp.
      - Configuration of slot settings, including continuous deployment.
      - Successful push of an updated Docker image to the Azure Container Registry.
      - Testing of the deployment slot and verification of changes.
      - Screenshot of initiating the slot swap process.

6. *Configure Traffic Manager*
   - Screenshots of the Azure portal:
      - Creation of a Traffic Manager profile.
      - Addition of endpoints representing different PetStoreApp instances.
      - Configuration of health checks for endpoint availability.
      - Use of Traffic Manager URL to access the application.
      - Testing of main application features through the Traffic Manager URL.

7. A screenshot showing the list of Azure resources that correspond to the diagram.

<hr>

<div style="border: 1px solid #ccc; background-color: #eee;">
  <ul>
    <li>When presenting the results of the practical tasks, please <a href="../common/presenting-results/presenting-results.md">follow these guidelines</a>.</li>
    <li><strong>When you have completed the task, attach the file(s) to the "Result" field. Files should include a PDF/DOCX file with screenshots (optionally, you can also add a GIF file). Please add a link to the updated Pet Store solution in a public Git repository to your PDF/DOCX file. Update the status to "Done."</strong></li>
    <li>Delete unnecessary resources.</li>
  </ul>
</div>
<hr>

>**IMPORTANT:** Leaving resources running can result in additional costs. Either delete resources individually or remove the entire set of resources by deleting the resource group.