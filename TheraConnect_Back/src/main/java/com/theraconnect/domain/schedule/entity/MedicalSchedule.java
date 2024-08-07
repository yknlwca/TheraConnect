package com.theraconnect.domain.schedule.entity;

import com.theraconnect.domain.member.entity.Patient;
import com.theraconnect.domain.member.entity.Therapist;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalScheduleId;

    private LocalDateTime reservationTime;

    private String memo;

    private String patientRequest;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    private String roomNum;

    // 진료 일정 N : 환자 1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // 진료 일정 N : 치료사 1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapist_id")
    private Therapist therapist;

    // 진료 일정 1 : EMR detail 1
    @OneToOne
    @JoinColumn(name = "emr_detail_id", nullable = false)
    private EmrDetail emrDetail;

    // 필요한 Setter만 추가
    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}

