package by.itclass.model.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity // это класс который mapping  на таблицу
@Table(name = "user") // имя таблицы
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
    // @Column // используем, если есть поля которые не входят в таблицу -ставим над теми, которые входят
    @Id  //AUTO_INCREMENT - PRIMARY KEY в таблице
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private  int id;
    @NonNull
    private String name;
    @NonNull
    private int age;

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


}
