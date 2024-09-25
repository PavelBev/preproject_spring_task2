package hiber.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="car_id")
   private Car car;

   public User(String user1, String lastname1, String mail) {
      this.firstName = user1;
      this.lastName = lastname1;
      this.email = mail;
   }
   public User() {}
}
