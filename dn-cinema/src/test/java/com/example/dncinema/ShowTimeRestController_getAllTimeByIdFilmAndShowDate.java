package com.example.dncinema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShowTimeRestController_getAllTimeByIdFilmAndShowDate {
    @Autowired
    private MockMvc mockMvc;
    /**
     * @Author HaiPH
     * This method is used to check the return list which param = null
     * @throws Exception
     */
    @Test
    public void getAllTimeByIdFilmAndShowDate_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/showtime/null/null")).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * @Author HaiPh
     * This method is used to check the return list which param = ""
     * @throws Exception
     */
    @Test
    public void getAllTimeByIdFilmAndShowDate_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/showtime/''/''")).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * @Author HaiPh
     * This method is used to check the return list which param does not exist
     * @throws Exception
     */
    @Test
    public void getAllTimeByIdFilmAndShowDate_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/showtime/1o/2023-10-12")).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * @Author HaiPH
     * This method is used to check the return list has size > 0 which param exist
     * @throws Exception
     */
    @Test
    public void getAllTimeByIdFilmAndShowDate_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/showtime/1/2022-10-11"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].idShowTime").value(1))
                .andExpect(jsonPath("[0].showDate").value("2022-10-11"))
                .andExpect(jsonPath("[0].showTime").value("09:00"))
                .andExpect(jsonPath("[0].showRoom.idShowRoom").value("1"))
                .andExpect(jsonPath("[0].showRoom.nameShowRoom").value("Phong 1"))
                .andExpect(jsonPath("[0].showRoom.quantitySeat").value(40))
                .andExpect(jsonPath("[0].seat.idSeat").value(1))
                .andExpect(jsonPath("[0].seat.nameSeat").value("A1"))
                .andExpect(jsonPath("[0].film.idFilm").value("1"))
                .andExpect(jsonPath("[0].film.nameFilm").value("Nha Ba Nu"));
    }
}
