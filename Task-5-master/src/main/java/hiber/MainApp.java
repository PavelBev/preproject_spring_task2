package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car();
      car1.setModel("Hyundai");
      car1.setSeries(2021);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      userService.addUserWithCar(user1, car1);

      Car car2 = new Car();
      car2.setModel("BMW");
      car2.setSeries(2023);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      userService.addUserWithCar(user2, car2);

      Car car3 = new Car();
      car3.setModel("Mercedes");
      car3.setSeries(2007);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      userService.addUserWithCar(user3, car3);

      Car car4 = new Car();
      car4.setModel("Hyundai");
      car4.setSeries(2007);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      userService.addUserWithCar(user4, car4);



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car Model = "+user.getCar().getModel());
            System.out.println("Car Series = "+user.getCar().getSeries());
         }
         System.out.println();
      }

      context.close();
   }
}
