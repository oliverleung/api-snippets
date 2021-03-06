// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.video.v1.room.participant.SubscribeRules;
import com.twilio.rest.video.v1.Room.Participants;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateRules{

  // Find your credentials at twilio.com/console
  public static final String ACCOUNT_SID = "ACXXXX";
  public static final String API_KEY_SID = "SKXXXX";
  public static final String API_KEY_SECRET = "your_api_key_secret";

  public static void main( String[] args ) throws IOException{
      // Initialize the client
      Twilio.init(API_KEY_SID, API_KEY_SECRET, ACCOUNT_SID);

      SubscribeRulesUpdate rules = new SubscribeRulesUpdate(Lists.newArrayList(

              SubscribeRule.builder()
              .withType(SubscribeRule.Type.INCLUDE).withAll()
              .build(),

              SubscribeRule.builder()
              .withType(SubscribeRule.Type.EXCLUDE).withPublisher("Supervisor")
              .build()
          ));

      SubscribeRules result = SubscribeRules
      .updater("RMXXXX", "Customer")
      .setRules(new ObjectMapper().convertValue(rules, Map.class))
      .update();

      System.out.println("Subscribe Rules updated successfully");



  }
}
