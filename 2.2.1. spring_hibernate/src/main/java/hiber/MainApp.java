package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

//      carService.add(new Car("VAZ", 2107));
//      carService.add(new Car("BMW", 330));
//      carService.add(new Car("GAZ", 3110));

      List<Car> cars = carService.listCars();
      for(Car car : cars){
         System.out.println("Id = "+car.getId());
         System.out.println("Model = "+car.getModel());
         System.out.println("Series = "+car.getSeries());
         System.out.println();
      }

//      userService.add(new User("User1", "Lastname1", "user2131@mail.ru", cars.get(0)));
//      userService.add(new User("User2", "Lastname2", "use5243r2@mail.ru", cars.get(1)));
//      userService.add(new User("User3", "Lastname3", "user233@mail.ru", cars.get(2)));
//      userService.add(new User("User4", "Lastname4", "user454@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      User user = userService.find("VAZ", 2107);
      System.out.println(user);
      context.close();
   }
}
