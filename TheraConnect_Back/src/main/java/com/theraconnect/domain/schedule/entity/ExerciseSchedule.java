package com.theraconnect.domain.schedule.entity;


import com.theraconnect.domain.member.entity.Patient;
import com.theraconnect.domain.video.entity.ExerciseVideo;
import com.theraconnect.domain.video.entity.PatientVideo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
public class ExerciseSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseScheduleId;

    @OneToMany
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime exerciseDate;

    @OneToMany(mappedBy = "PatientVideo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<PatientVideo> patientVideos = new ArrayList<>();

    @OneToMany(mappedBy = "ExerciseVideo", cascade = CascadeType.PERSIST, orphanRemoval = false)
    @Builder.Default
    private List<ExerciseVideo> exerciseVideos = new ArrayList<>();

}
