package petstore;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.BlobOutput;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;
import com.microsoft.azure.functions.annotation.StorageAccount;
import org.springframework.stereotype.Component;

@Component
public class ReserveHandler {

  @FunctionName("reserve")
  @StorageAccount("reservationStorage")
  public void execute(
      @ServiceBusQueueTrigger(name = "msg",
          queueName = "order-placed-sbq",
          connection = "serviceBusConnection")
      String content,
      @BindingName("Label")
      String sessionId,
      @BlobOutput(
          name = "target",
          path = "reservation/{Label}.json")
      OutputBinding<String> outputItem,
      ExecutionContext context) {

    var logger = context.getLogger();
    var fileName = sessionId + ".json";
    logger.info("Writing to file: " + fileName);
    logger.info("Content: " + content);
    outputItem.setValue(content);
  }
}