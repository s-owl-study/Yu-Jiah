package com.todolist.todolist_jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.todolist.todolist_jpa.domain.entity.ListEntity;
import com.todolist.todolist_jpa.dto.ListDto;
import com.todolist.todolist_jpa.service.ListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
public class ListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListService listService; //service mock 객체

    private ListEntity expected;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.expected = ListEntity.builder()
            .listId(111L)
            .listTitle("투두 리스트 테스트")
            .listCompleted("미완료")
            .build();
    }

    @Test
    @DisplayName("create() : SUCCESS 경우")
    public void create() throws Exception {
        //todoService.add 매서드 호출 시 정해진 TodoEntity 객체 return
        when(this.listService.add(any(ListDto.class)))
            .then((i) -> {
                ListDto request = i.getArgument(0, ListDto.class);
                return ListEntity.builder()
                    .listId(this.expected.getListId())
                    .listTitle(request.getListTitle())
                    .listCompleted(this.expected.getListCompleted())
                    .build();
            });

        ListDto request = ListDto.builder()
            .listTitle("Test Title")
            .build();

        //request 객체를 JSON String 으로 변환
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(request);

        //POST '/' 요청을 보내고 200 status 인지와 response로 온 JSON 객체의 title이 실제로 정상적인 응답인지 확인
        this.mockMvc.perform(post("/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value(request.getListTitle()));
    }

    @Test
    @DisplayName("readOne() : SUCCESS 경우")
    public void readOne() throws Exception {
        when(this.listService.searchById(eq(this.expected.getListId())))
            .thenReturn(this.expected);

        MvcResult mvcResult = this.mockMvc.perform(get("/" + this.expected.getListId())
            .accept(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8"))
            .andExpect(status().isOk())
            .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        ListDto actual = new Gson().fromJson(response, ListDto.class);

        assertEquals(this.expected.getListId(), actual.getListId());
        assertEquals(this.expected.getListTitle(), actual.getListTitle());
        assertEquals(this.expected.getListCompleted(), actual.getListCompleted());
    }


    @Test
    @DisplayName("readOne() : FAIL 경우")
    public void getNonExistentUserTest() throws Exception {
        final Long NOT_FOUND_TEST_ID = 113L;
        //todoService.searchById에 113L 파라미터가 오면, ResponseStatusException(404: NotFound) 발생.
        when(this.listService.searchById(eq(NOT_FOUND_TEST_ID)))
            .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        this.mockMvc.perform(get("/" + NOT_FOUND_TEST_ID)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8"))
            .andExpect(result -> assertTrue(
                result.getResolvedException() instanceof ResponseStatusException))
            .andExpect(status().isNotFound());
    }
}
