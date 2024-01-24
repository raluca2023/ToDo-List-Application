package com.example.ToDo.List.App.mapper;

import com.example.ToDo.List.App.entity.ToDoList;
import com.example.ToDo.List.App.model.ToDoListModel;

public class ToDoListMapper {

    public static ToDoList modelToEntity (ToDoListModel toDoListModel) {
        ToDoList toDoList1 = new ToDoList();
        toDoList1.setId(toDoList1.getId());
        toDoList1.setDescription(toDoListModel.getDescription());
        return toDoList1;
    }

    public static ToDoListModel entityToModel (ToDoList toDoList) {
        ToDoListModel toDoListModel = new ToDoListModel();
        toDoListModel.setId(toDoList.getId());
        toDoListModel.setDescription(toDoList.getDescription());
        return toDoListModel;
    }
}
