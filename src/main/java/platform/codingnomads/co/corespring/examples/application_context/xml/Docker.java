package platform.codingnomads.co.corespring.examples.application_context.xml;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class Docker {
    private String name;
    private String version;
}
