package com.example.ToDo.List.App.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "list_item")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_list_item_generator")
    @SequenceGenerator(name =  "seq_list_item_generator", sequenceName = "seq_list_item", allocationSize = 1, initialValue = 1)

    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;

}
