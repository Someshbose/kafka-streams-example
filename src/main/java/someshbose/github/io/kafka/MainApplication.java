package someshbose.github.io.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import someshbose.github.io.kafka.config.MessageProducer;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

//  @Autowired
//  private MessageProducer producer;
//
//  @Autowired
//  private HelloStreams consumer;

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class,args);
  }



  @Override public void run(String... args) throws Exception {
    //producer.send(getProperties());
    //consumer.load();
  }
}
