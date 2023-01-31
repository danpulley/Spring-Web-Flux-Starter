package pulley.da.webclient.pulleydaweb.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    private String name;
    @Builder.Default
    private Long base_experience = 0L;
    private String image;
}
