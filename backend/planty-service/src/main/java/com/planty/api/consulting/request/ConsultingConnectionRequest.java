package com.planty.api.consulting.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConsultingConnectionRequest {

    Long cid;
    String sessionId;

}
