package kr.res.work.fire.controller;



import kr.res.work.fire.dto.FireRequestDto;
import kr.res.work.fire.dto.FireResponseDto;
import kr.res.work.fire.service.FireApiService;
import kr.res.work.fire.service.FireSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/search")
public class PortalSearchController {

    @Autowired
    private FireSearchService fireSearchService;

    @Autowired
    private FireApiService fireApiService;

    private static final Logger log = LoggerFactory.getLogger(PortalSearchController.class);

    @PostMapping("/list")
    public List<FireResponseDto> getInfoList(@RequestBody FireRequestDto fireRequestDto) {
        log.info("List:::::::::::::::::::");
        List<FireResponseDto> result = fireSearchService.getInfoList(fireRequestDto);

        return result;
//        if (result > 0) {
//            return ResponseEntity.ok("OK");
//        } else {
//            return ResponseEntity.status(500).body("Failed to add book");
//        }
    }


    @PostMapping("/add")
    public ResponseEntity<String> addInfo(@RequestBody FireRequestDto fireRequestDto) {
        log.info("Add:::::::::::::::::::");
        String result = fireApiService.addInfo(fireRequestDto);
        return ResponseEntity.ok("OK");
    }


}
