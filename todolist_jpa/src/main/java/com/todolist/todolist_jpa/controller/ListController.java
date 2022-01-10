

package com.todolist.todolist_jpa.controller;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import com.todolist.todolist_jpa.dto.ListDto;
import com.todolist.todolist_jpa.service.ListServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ListController {
    private final ListServiceImpl listService;

    @GetMapping(path = "")
    public String index() {
        List<ListEntity> lists = listService.searchAll();
        return "index";
    }

    @GetMapping(path = "/todolist") //전체 목록 불러오기
    public ResponseEntity<List<ListEntity>> searchAll() {
        List<ListEntity> result = listService.searchAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/todo") //저장하기
    public ResponseEntity<?> add(@RequestBody ListDto body) {
        ListEntity result = listService.add(body);
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/todo/{id}") //아이디로 찾아서 지우기
    public ListEntity searchById(Long listId){
        return this.listService.searchById(listId);
    }

    @DeleteMapping(path = "/todolist") //전체 삭제하기
    public void deleteAll() {
        this.listService.deleteAll();
    }

    @DeleteMapping(path = "/todo/{id}") //아이디로 삭제하기
    public ResponseEntity<List<ListEntity>> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(listService.deleteById(id));
    }

    @PatchMapping(path = "/todo/{id}") //아이디로 업데이트하기
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ListDto body){
        List<ListEntity> result = listService.updateById(id, body);
        return ResponseEntity.ok(result);
    }


  /*  @DeleteMapping(path = "deletetest")
    public ResponseEntity<?> deletetest(@RequestBody ListDto body) {
        ListDto result = ListDto.builder()
                .listId(body.getListId())
                .listTitle(body.getListTitle())
                .listCompleted(body.isListCompleted())
                .build();

        listService.deleteAll(body);
        return ResponseEntity.ok(result);
    }
*/


//    @PostMapping
//    public ResponseEntity<ListEntity> create(@RequestBody ListDto listDto) {
//        if (ObjectUtils.isEmpty(listDto.getListId())) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        if (ObjectUtils.isEmpty(listDto.getListTitle())) {
//            listDto.setListTitle("");
//        }
//
//        if (ObjectUtils.isEmpty(listDto.getListCompleted())) {
//            listDto.setListCompleted("");
//        }
//
//        ListEntity result = this.listService.add(listDto);
//
//        return ResponseEntity.ok(result);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<ListEntity> readOne(@PathVariable Long listId) {
//        ListEntity result = this.listService.searchById(listId);
//        return ResponseEntity.ok(result);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ListDto>> readAll() {
//        List<ListEntity> resultList = this.listService.searchAll();
//        List<ListDto> response = resultList
//                .stream()
//                .map( result -> new ListDto(result) )
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(response);
//    }
//
//    @PatchMapping("{id}")
//    public ResponseEntity<ListDto> update(@PathVariable Long listId, @RequestBody ListDto listDto) {
//        ListEntity result = this.listService.updateById(listId, listDto);
//        ListDto response = new ListDto(result);
//
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> removeOne(@PathVariable Long listId) {
//        this.listService.deleteById(listId);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping
//    public ResponseEntity<?> removeAll() {
//        this.listService.deleteAll();
//        return ResponseEntity.ok().build();
//    }
}
