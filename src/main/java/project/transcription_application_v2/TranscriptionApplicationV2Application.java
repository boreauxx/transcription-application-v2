package project.transcription_application_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranscriptionApplicationV2Application {

  public static void main(String[] args) {
    SpringApplication.run(TranscriptionApplicationV2Application.class, args);
  }

  /* TODO:
      5. add testing
      6. improve the dropbox and assemblyAI services (make it more readable)
      8. add previous features from the previous version
      9. put flyway in the project changing spring.jpa.hibernate.ddl-auto=update to spring.jpa.hibernate.ddl-auto=validate
   */
}
