package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

interface BaseApiResponse {
    val resultCode: String
    val resultMessage: String
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApiResponse<TResult> (
    @JsonProperty("result_code")
    override val resultCode: String = ResultCode.SUCCESS.code,
    @JsonProperty("result_message")
    override val resultMessage: String = ResultCode.SUCCESS.message,
    val result: TResult
) : BaseApiResponse

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApiEmptyResponse (
    @JsonProperty("result_code")
    override val resultCode: String = ResultCode.SUCCESS.code,
    @JsonProperty("result_message")
    override val resultMessage: String = ResultCode.SUCCESS.message
) : BaseApiResponse
