package com.todolist.todolist_jpa;

        import com.todolist.todolist_jpa.domain.entity.ListEntity;
        import com.todolist.todolist_jpa.dto.ListDto;
        import com.todolist.todolist_jpa.repository.ListRepository;
        import com.todolist.todolist_jpa.service.ListService;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
        import org.mockito.AdditionalAnswers;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.web.server.ResponseStatusException;

        import javax.transaction.Transactional;

        import java.util.Optional;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertThrows;
        import static org.mockito.ArgumentMatchers.any;
        import static org.mockito.ArgumentMatchers.anyLong;
        import static org.mockito.BDDMockito.given;
        import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class ListServiceTest {

    @Mock
    private ListRepository listRepository;

    @InjectMocks
    private ListService listService;

    @Test
    @DisplayName("add() : SUCCESS 경우")
    public void add() {
        when(this.listRepository.save(any(ListEntity.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        ListDto expected = ListDto.builder();
                .listId(123L)
                .listTitle("오늘 할 일")
                .listCompleted("완료")
                .build();

        ListEntity actual = this.listService.add(expected);

        assertEquals(expected.getListId(), actual.getListId());
        assertEquals(expected.getListTitle(), actual.getListTitle());
        assertEquals(expected.getListCompleted(), actual.getListCompleted());
    }

    @Test
    @DisplayName("searchById() : SUCCESS 경우")
    public void searchById() {
        final Long TEST_ID = 111L;
        ListEntity expected = ListEntity.builder()
                .listId(TEST_ID)
                .listTitle("내일 할 일")
                .listCompleted("미완료")
                .build();

        Optional<ListEntity> expectedOpt = Optional.of(expected);
        given(this.listRepository.findById(anyLong()))
                .willReturn(expectedOpt);

        ListEntity actual = this.listService.searchById(TEST_ID);

        assertEquals(expected.getListId(), actual.getListId());
        assertEquals(expected.getListTitle(), actual.getListTitle());
        assertEquals(expected.getListCompleted(), actual.getListCompleted());
    }

    @Test
    @DisplayName("searchById() : FAIL 경우")
    public void searchByIdFailed() {
        given(this.listRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> this.listService.searchById(123L));
    }
}
