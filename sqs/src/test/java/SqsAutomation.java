import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.services.sqs.SqsClient;

public class SqsAutomation {
    private static SqsClient sqsClient;

    @ParameterizedTest
    @CsvSource({
            "''",                       // Empty message
            "'Valid Message'",          // Test with a normal valid message
            "'12345'",                  // Test with a message that contains numbers
            "'!@#$%^&*()'",             // Test with a message that contains special characters
    })
        public void testQueue(String messageBody) {

            // Initialize SQS client
            QueueService.initializeSqsClient();
            try {
                // Send and receive a message using corresponding test methods
                QueueService.sendMessage(messageBody);
                String receivedMessage = QueueService.receiveMessage();
                // Verify the message
                QueueService.verifyMessage(messageBody, receivedMessage);
            } catch (IllegalArgumentException e) {
                System.out.println("Expected exception: " + e.getMessage());
            } catch (SdkException e) {
                e.printStackTrace();
                System.out.println("Error occurred: " + e.getMessage());
            } finally {
                QueueService.tearDown();
                }
            }
        }


