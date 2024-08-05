package kr.res.work.fire.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FireResponseDto {
    private Long infoId;                //key
    private String title;
    private String content;
}
