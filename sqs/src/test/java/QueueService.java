
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

public class QueueService {

//    Update your SQS URL
    private static final String QUEUE_URL = "https://sqs.eu-north-1.amazonaws.com/**********/Sample1";
    private static SqsClient sqsClient;

//    initialise sqs client
    public static void initializeSqsClient() {

        String accessKeyId = "********"; //Enter your access key
        String secretAccessKey = "*********"; //Enter your secret key

        sqsClient = SqsClient.builder()
                .region(Region.EU_NORTH_1) // Update your region where your sqs located
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId,secretAccessKey)))
                .build();
    }

//    send msg to the queue
    public static void sendMessage(String messageBody) {
    // Validate message body
        if (messageBody == null || messageBody.trim().isEmpty()) {
            throw new IllegalArgumentException("Message body cannot be empty.");
        }
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .messageBody(messageBody)
                .build();
        SendMessageResponse sendMsgResponse = sqsClient.sendMessage(sendMsgRequest);
        System.out.println("Message sent with ID: " + sendMsgResponse.messageId());
    }

//    receive msg response
    public static String receiveMessage() {
        ReceiveMessageRequest receiveMsgRequest = ReceiveMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .maxNumberOfMessages(1)
                .build();
        ReceiveMessageResponse receiveMsgResponse = sqsClient.receiveMessage(receiveMsgRequest);

        if (!receiveMsgResponse.messages().isEmpty()) {
            String receivedMessage = receiveMsgResponse.messages().get(0).body();
            System.out.println("Received message: " + receivedMessage);
            return receivedMessage;
        } else {
            throw new RuntimeException("No messages received.");
        }
    }

//     assert the sent and received messages
    public static void verifyMessage(String sentMessage, String receivedMessage) {
        if (!sentMessage.equals(receivedMessage)) {
            throw new AssertionError("Failed: Sent and received messages do not match.");
        } else {
            System.out.println("Message verification successful.");
        }
    }

//    closes sql client
    public static void tearDown(){
        if (sqsClient != null) {
            sqsClient.close();
        }

    }
}
