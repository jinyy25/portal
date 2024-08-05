package kr.res.work.fire.service;



import kr.res.work.fire.dto.FireRequestDto;
import kr.res.work.fire.dto.FireResponseDto;
import kr.res.work.fire.repository.FireSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("FireSearchService")
public class FireSearchService {

    @Autowired
    private FireSearchRepository fireSearchRepository;

    public List<FireResponseDto> getInfoList(FireRequestDto fireRequestDto) {
            return fireSearchRepository.getInfoList(fireRequestDto);
    }
}
