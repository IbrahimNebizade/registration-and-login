package com.company.model;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
public class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String surname;
        private Date birthdate;
        private Date createTime;

        @Column(unique = true)
        private String nickName;

        private int age;

        @Column(unique = true)
        private String phoneNumber;


}
