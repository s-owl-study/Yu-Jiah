package com.todolist.todolist_jpa;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import com.todolist.todolist_jpa.repository.ListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class ListRepositoryTest{
        @Autowired
        private ListRepository listRepository;

        private ListEntity insertedEntity;

        @BeforeEach
        @Test
        @DisplayName("save(): 데이터 삽입 테스트")
        public void save() {
            ListEntity expected = insertedEntity.builder()
                    .listId(0L)
                    .listTitle("오늘 할 일")
                    .listCompleted("완료함")
                    .build();
            this.insertedEntity = this.listRepository.save(expected);

            assertEquals(expected.getListId(), this.insertedEntity.getListId());
            assertEquals(expected.getListTitle(), this.insertedEntity.getListTitle());
            assertEquals(expected.getListCompleted(), this.insertedEntity.getListCompleted());
        }

        @Test
        @DisplayName("findById() : 삽입한 데이터 찾기 테스트")
        public void findById() {
            Optional<ListEntity> actualOpt = this.listRepository.findById(this.insertedEntity.getListId());
            assertTrue(actualOpt.isPresent());

            ListEntity actual = actualOpt.get();

            assertEquals(this.insertedEntity.getListId(), actual.getListId());
            assertEquals(this.insertedEntity.getListTitle(), actual.getListTitle());
            assertEquals(this.insertedEntity.getListCompleted(), actual.getListCompleted());
        }

        @Test
        @DisplayName("deleteById() : 삽입한 데이터 삭제 테스트")
        public void deleteById() {
            final Long entityId = this.insertedEntity.getListId();

            assertTrue(this.listRepository.findById(entityId).isPresent());

            this.listRepository.deleteById(this.insertedEntity.getListId());

            assertFalse(this.listRepository.findById(entityId).isPresent());
        }
    }
