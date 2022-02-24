package team.bahor.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public abstract class GenericDto implements BaseGenericDto {
    private Long id;
}
