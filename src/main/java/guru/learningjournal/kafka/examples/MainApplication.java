package guru.learningjournal.kafka.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

  @Autowired
  private HelloProducer producer;

  @Autowired
  private HelloStreams consumer;

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class,args);
  }



  @Override public void run(String... args) throws Exception {
    //producer.send(getProperties());
    consumer.load();
  }
}
