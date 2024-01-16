package by.itclass.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // это класс который mapping  на таблицу
@Table(name = "user") // имя таблицы
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    // @Column // используем, если есть поля которые не входят в таблицу -ставим над теми, которые входят
    @Id  //AUTO_INCREMENT - PRIMARY KEY в таблице
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;



}
