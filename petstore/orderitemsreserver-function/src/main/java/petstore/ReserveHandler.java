package petstore;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BlobOutput;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.StorageAccount;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ReserveHandler {

  @FunctionName("reserve")
  @StorageAccount("AzureWebJobsStorage")
  public HttpResponseMessage execute(
      @HttpTrigger(name = "request", methods = {HttpMethod.GET,
          HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS)
      HttpRequestMessage<Optional<String>> request,
      @BlobOutput(
          name = "target",
          path = "reservation/{Query.sessionId}.json")
      OutputBinding<String> outputItem,
      ExecutionContext context) {

    var content = request.getBody();
    var sessionId = request.getQueryParameters().get("sessionId");

    context.getLogger().info("Writing to file: " + sessionId + ".json");
    context.getLogger().info("Content: " + content);
    outputItem.setValue(request.getBody().orElse(null));

    return request.createResponseBuilder(HttpStatus.OK)
        .body("Success")
        .header("Content-Type", "application/text")
        .build();
  }
}