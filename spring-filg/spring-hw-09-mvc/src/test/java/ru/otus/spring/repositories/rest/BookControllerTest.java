package ru.otus.spring.repositories.rest;

//@WebMvcTest(PersonController.class)
class BookControllerTest {

    public static final String ERROR_STRING = "Таких тут нет!";

//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @MockBean
//    private BookRepository repository;

/*


    @Test
    void shouldReturnCorrectPersonsList() throws Exception {
        List<Person> persons = List.of(new Person(1, "Person1"), new Person(2, "Person2"));
        given(repository.findAll()).willReturn(persons);

        List<PersonDto> expectedResult = persons.stream()
                .map(PersonDto::toDto).collect(Collectors.toList());

        mvc.perform(get("/persons/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @Test
    void shouldReturnCorrectPersonByIdInRequest() throws Exception {
        Person person = new Person(1, "Person1");
        given(repository.findById(1L)).willReturn(Optional.of(person));
        PersonDto expectedResult = PersonDto.toDto(person);

        mvc.perform(get("/persons").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @Test
    void shouldReturnCorrectPersonByIdInPath() throws Exception {
        Person person = new Person(1, "Person1");
        given(repository.findById(1L)).willReturn(Optional.of(person));
        PersonDto expectedResult = PersonDto.toDto(person);

        mvc.perform(get("/persons/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @Test
    void shouldReturnExpectedErrorWhenPersonNotFound() throws Exception {
        given(repository.findById(1L)).willReturn(Optional.empty());

        mvc.perform(get("/persons").param("id", "1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(ERROR_STRING));

        mvc.perform(get("/persons/1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(ERROR_STRING));
    }

    @Test
    void shouldCorrectSaveNewPerson() throws Exception {
        Person person = new Person(1, "Person1");
        given(repository.save(any())).willReturn(person);
        String expectedResult = mapper.writeValueAsString(PersonDto.toDto(person));

        mvc.perform(post("/persons").contentType(APPLICATION_JSON)
                .content(expectedResult))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }

    @Test
    void shouldCorrectUpdatePersonName() throws Exception {
        Person person = new Person(1, "Person1");
        given(repository.findById(1L)).willReturn(Optional.of(person));
        given(repository.save(any())).willAnswer(invocation -> invocation.getArgument(0));

        Person expectedPerson = new Person(1, "Person2");
        String expectedResult = mapper.writeValueAsString(PersonDto.toDto(expectedPerson));

        mvc.perform(patch("/persons/{id}/name", 1).param("name", expectedPerson.getName())
                .content(expectedResult))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }

    @Test
    void shouldCorrectDeletePerson() throws Exception {
        mvc.perform(delete("/persons/1"))
                .andExpect(status().isOk());
        verify(repository, times(1)).deleteById(1L);
    }

*/

}