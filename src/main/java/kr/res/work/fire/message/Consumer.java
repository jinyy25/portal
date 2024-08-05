package kr.res.work.fire.message;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.res.work.fire.dto.FireRequestDto;
import kr.res.work.fire.repository.FireSearchRepository;
import kr.res.work.fire.service.FireApiService;
import kr.res.work.fire.serviceImpl.FireApiServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FireApiService fireApiService;

    @RabbitListener(queues = "Isaac")
    public void handler(String message) throws JsonProcessingException{

        FireRequestDto fireRequestDto = objectMapper.readValue(message,FireRequestDto.class);
        fireApiService.addInfo(fireRequestDto);
    }


}
