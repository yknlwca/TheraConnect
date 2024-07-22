package com.theraconnect.domain.schedule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalScheduleRequestDTO {

    private LocalDateTime reservationTime;
    private String memo;
    private String patientRequest;
    private String reservationStatus;
    private String roomNum;
    private Long patientId;
    private Long therapistId;
    private Long EmrDetailId;
}