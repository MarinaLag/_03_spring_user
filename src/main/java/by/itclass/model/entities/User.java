package by.itclass.model.entities;


import jakarta.persistence.*;

@Entity // это класс который mapping  на таблицу
@Table(name = "user") // имя таблицы
public class User {
    // @Column // используем, если есть поля которые не входят в таблицу -ставим над теми, которые входят
    @Id  //AUTO_INCREMENT - PRIMARY KEY в таблице
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
