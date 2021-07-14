package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.dto.CreateComCodeInfoParams
import kr.socar.code101.codebook.dto.GetComCodeInfoParams
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ComCodeInfoServiceTest {
    @Autowired
    lateinit var comCodeInfoService: ComCodeService

    @Autowired
    lateinit var comCodeInfoRepository: ComCodeInfoRepository

    @Test
    @DisplayName("createComCodeInfo - description 이 null - 성공")
    fun createComCodeInfoParamsWithDescriptionIsNull() {
        val codeName = "테스트"
        val createComCodeInfoParamsWithDescriptionIsNull = CreateComCodeInfoParams(codeName = codeName)
        comCodeInfoService.createComCodeInfo(createComCodeInfoParamsWithDescriptionIsNull)
        val result = comCodeInfoRepository.findByCodeName(codeName)
        assertThat(result).isNotNull
        assertThat(result!!.codeName).isEqualTo(codeName)
        assertThat(result.description).isNull()
    }

    @Test
    @DisplayName("createComCodeInfo - description 이 존재 - 성공")
    fun createComCodeInfoParamsWithDescriptionExist() {
        val codeName = "테스트"
        val description = "테스트 설명"
        val createComCodeInfoParamsWithDescriptionExist = CreateComCodeInfoParams(codeName = codeName, description = description)
        comCodeInfoService.createComCodeInfo(createComCodeInfoParamsWithDescriptionExist)
        val result = comCodeInfoRepository.findByCodeName(codeName)
        assertThat(result).isNotNull
        assertThat(result!!.codeName).isEqualTo(codeName)
        assertThat(result.description).isEqualTo(description)
    }

    @Test
    @DisplayName("getComCodeInfo - 성공")
    fun getComCodeInfoTest() {
        val codeName = "테스트"
        val createComCodeInfoParams = CreateComCodeInfoParams(codeName = codeName)
        comCodeInfoService.createComCodeInfo(createComCodeInfoParams)

        val getComCodeInfoParams = GetComCodeInfoParams(codeName = codeName)
        val result = comCodeInfoService.getComCodeInfo(getComCodeInfoParams)
        assertThat(result).isNotNull
        assertThat(result!!.codeName).isEqualTo(codeName)
    }

    @Test
    @DisplayName("getComCodeInfo - 존재 하지 않아서 null 리턴")
    fun getComCodeInfoReturnNull() {
        val codeName = "테스트"
        val createComCodeInfoParams = CreateComCodeInfoParams(codeName = codeName)
        comCodeInfoService.createComCodeInfo(createComCodeInfoParams)

        val newCodeName = "새로운 테스트"
        val getComCodeInfoParams = GetComCodeInfoParams(codeName = newCodeName)
        val result = comCodeInfoService.getComCodeInfo(getComCodeInfoParams)
        assertThat(result).isNull()
    }
}
