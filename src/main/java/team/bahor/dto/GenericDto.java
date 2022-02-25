package team.bahor.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public abstract class GenericDto implements BaseGenericDto {
        private Long id;
}
