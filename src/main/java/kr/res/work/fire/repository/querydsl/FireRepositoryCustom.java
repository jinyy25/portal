package kr.res.work.fire.repository.querydsl;


import kr.res.work.fire.dto.FireRequestDto;
import kr.res.work.fire.dto.FireResponseDto;

import java.util.List;

public interface FireRepositoryCustom {
    List<FireResponseDto> getInfoList(FireRequestDto bookRequestDto);
}
