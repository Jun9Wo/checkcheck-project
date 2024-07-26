package com.example.checkcheck.lecture.dto

import com.example.checkcheck.common.annotation.ValidEnum
import com.example.checkcheck.common.enums.WeekDay
import com.example.checkcheck.lecture.entity.LectureSchedule
import com.example.checkcheck.lecture.entity.RegisterPeriod
import com.example.checkcheck.member.entity.Member
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class LectureRequestDto(
    @field:NotBlank(message = "강의명을 입력해주세요.")
    @JsonProperty("title")
    private var _title: String?,

    @field:NotBlank(message = "강의 시작일을 입력해주세요.")
    @field:Pattern(
        regexp = "^([0-9]{2})-([0-9]{2})-([0-9]{2})\$",
        message = "기간 형식을 확인해주세요! yy-MM-dd"
    )
    @JsonProperty("lectureStartDate")
    private var _lectureStartDate: String?,

    @field:NotBlank(message = "강의 종료일을 입력해주세요.")
    @field:Pattern(
        regexp = "^([0-9]{2})-([0-9]{2})-([0-9]{2})\$",
        message = "기간 형식을 확인해주세요! yy-MM-dd"
    )
    @JsonProperty("lectureEndDate")
    private var _lectureEndDate: String?,

    @field:NotBlank(message = "강의 시작시간을 입력해주세요.")
    @field:Pattern(
        regexp = "^([01]\\d|2[0-3]):([0-5]\\d)\$",
        message = "시간 형식을 확인해주세요! HH:mm"
    )
    @JsonProperty("lectureStartAt")
    private var _lectureStartAt: String?,

    @field:NotBlank(message = "강의 종료시간을 입력해 주세요.")
    @field:Pattern(
        regexp = "^([01]\\d|2[0-3]):([0-5]\\d)\$",
        message = "시간 형식을 확인해주세요! HH:mm"
    )
    @JsonProperty("lectureEndAt")
    private var _lectureEndAt: String?,

    @field:NotBlank(message = "강의요일을 입력해 주세요.")
    @field:ValidEnum(
        enumClass = WeekDay::class,
        message = "MON, TUE, WED, THU, FRI, SAT, SUN 중 하나를 입력해주세요."
    )
    @JsonProperty("lectureWeekDay")
    private var _lectureWeekDay: String?,

    @field:NotBlank(message = "강의장소를 입력해 주세요.")
    @JsonProperty("lecturePlace")
    private var _lecturePlace: String?,

    @field:NotBlank(message = "수강신청 시작일을 입력해주세요.")
    @field:Pattern(
        regexp = "^([0-9]{2})-([0-9]{2})-([0-9]{2})\$",
        message = "기간 형식을 확인해주세요! yy-MM-dd"
    )
    @JsonProperty("registerStartDate")
    private var _registerStartDate: String?,

    @field:NotBlank(message = "수강신청 종료일을 입력해주세요.")
    @field:Pattern(
        regexp = "^([0-9]{2})-([0-9]{2})-([0-9]{2})\$",
        message = "기간 형식을 확인해주세요! yy-MM-dd"
    )
    @JsonProperty("registerEndDate")
    private var _registerEndDate: String?,

    @field:NotBlank(message = "수강신청 시작시간을 입력해주세요.")
    @field:Pattern(
        regexp = "^([01]\\d|2[0-3]):([0-5]\\d)\$",
        message = "시간 형식을 확인해주세요! HH:mm"
    )
    @JsonProperty("registerStartAt")
    private var _registerStartAt: String?,

    @field:NotBlank(message = "수강신청 종료시간을 입력해주세요.")
    @field:Pattern(
        regexp = "^([01]\\d|2[0-3]):([0-5]\\d)\$",
        message = "시간 형식을 확인해주세요! HH:mm"
    )
    @JsonProperty("registerEndAt")
    private var _registerEndAt: String?,

    @field:Size(max = 300, message = "강의 정보는 최대 300글자 이내로 작성해 주세요.")
    @JsonProperty("lectureInfo")
    private var _lectureInfo: String? = null
) {
    val title: String
        get() = _title!!

    val lectureStartDate: String
        get() = _lectureStartDate!!

    val lectureEndDate: String
        get() = _lectureEndDate!!

    val lectureStartAt: String
        get() = _lectureStartAt!!

    val lectureEndAt: String
        get() = _lectureEndAt!!

    val lectureWeekDay: WeekDay
        get() = WeekDay.valueOf(_lectureWeekDay!!)

    val lecturePlace: String
        get() = _lecturePlace!!

    val registerStartDate: String
        get() = _registerStartDate!!

    val registerEndDate: String
        get() = _registerEndDate!!

    val registerStartAt: String
        get() = _registerStartAt!!

    val registerEndAt: String
        get() = _registerEndAt!!

    val lectureInfo: String?
        get() = _lectureInfo
}

data class LectureResponseDto(
    var title: String,
    var registerPeriod: RegisterPeriod?,
    var lectureSchedule: List<LectureSchedule>?,
    var member: Member?,
)