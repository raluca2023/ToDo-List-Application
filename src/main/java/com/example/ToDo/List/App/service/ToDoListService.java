package com.example.ToDo.List.App.service;

import com.example.ToDo.List.App.entity.ToDoList;
import com.example.ToDo.List.App.mapper.ToDoListMapper;
import com.example.ToDo.List.App.model.ToDoListModel;
import com.example.ToDo.List.App.repository.ToDoListRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;

    public List<ToDoListModel> getAll() {
        return toDoListRepository.findAll().stream()
                .map(toDoList -> ToDoListMapper.entityToModel(toDoList))
                .collect(Collectors.toList());
    }

    public void save(ToDoListModel toDoListModel) {
        ToDoList toDoList = ToDoListMapper.modelToEntity(toDoListModel);
        toDoListRepository.save(toDoList);
    }

    public void update(Long id, ToDoListModel toDoListModel) {
        ToDoList existingDoList = toDoListRepository.findById(id).orElse(null);
        if (existingDoList != null) {
            existingDoList.setId(toDoListModel.getId());
            existingDoList.setDescription(toDoListModel.getDescription());
            toDoListRepository.save(existingDoList);
        }
    }

    public ToDoListModel getOne(Long id) {
        return toDoListRepository.findById(id)
                .map(ToDoListMapper::entityToModel)
                .orElseThrow(() -> new EntityNotFoundException("The item with" + id + "not found"));
    }

    public void deleteById(Long id) {
        toDoListRepository.deleteById(id);
    }
}
