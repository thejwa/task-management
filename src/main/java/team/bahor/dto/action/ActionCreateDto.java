package team.bahor.dto.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionCreateDto implements BaseGenericDto {
    private String title;

    private Long taskId;

}
